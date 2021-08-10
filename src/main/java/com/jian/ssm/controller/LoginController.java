package com.jian.ssm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biology.face.FaceApi;
import com.biology.face.FaceApiImpl;
import com.jian.ssm.entity.Ajax;
import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.UserRole;

import com.jian.ssm.service.AttenceService;

import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.UserRoleService;
import com.jian.ssm.service.ipml.AttenceGrpcImpl;
import com.jian.ssm.service.ipml.ClientImpl;
import com.jian.ssm.service.ipml.CompanyGrpcImpl;
import com.jian.ssm.service.ipml.DepartmentGrpcImpl;
import com.jian.ssm.service.ipml.EmployeeGrpcImpl;
import com.jian.ssm.service.ipml.EmployeeImpl;
import com.jian.ssm.service.ipml.ReasonGrpcImpl;
import com.jian.ssm.service.ipml.VistorGrpcImpl;
import com.jian.ssm.util.MD5Util;
import com.jian.ssm.util.ReadICcardThread;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * 
 * @ClassName: LoginController
 * @Description:�����̨��½
 * @author: jianlinwei
 * @date: 2018��4��26�� ����11:21:36
 *
 */
@SuppressWarnings(value = { "unused" })
@Controller
@RequestMapping("/sys_login")
public class LoginController {

	@Autowired
	UserRoleService ur;
	@Autowired
	EmployeeService es;
	@Autowired
	AttenceService as;

	/**
	 * 
	 * @Title: sys_login @Description: get login.jsp @param: @return @author:
	 *         jianlinwei @return: String @throws
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sys_login(HttpServletRequest request, Model model) {

		String sysAdmin_session = (String) request.getSession().getAttribute("user");
		UserRole userRole = (UserRole) request.getSession().getAttribute("UserRole");
		if (sysAdmin_session == null || userRole == null) {
			return "login";
		} else {
			List<UserRole> lu = ur.selectMenus(userRole.getRoleId(), userRole.getUsername());
			for (int i = 0; i < lu.size(); i++) {
				model.addAttribute("lu" + lu.get(i).getMenusId(), lu.get(i).getMenusId());
			}
			UserRole user = new UserRole();
			user.setUsername(sysAdmin_session);
			model.addAttribute("user", user);
			return "index";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String syslogin(HttpServletRequest request, Model model) {

		String sysAdmin_session = (String) request.getSession().getAttribute("user");
		UserRole user = new UserRole();
		if (sysAdmin_session == null) {
			String sysAdmin = request.getParameter("sysAdmin");
			String msg = null;
			String password = request.getParameter("password");

			try {
				user = ur.selectUser(sysAdmin);
			} catch (Exception e) {
				e.printStackTrace();
				msg = "链接数据库异常";
				model.addAttribute("msg", msg);
				return "login";
			}
			if (user != null) {
				MD5Util md5 = new MD5Util();
				String change_after = null;
				try {
					change_after = md5.md5(password, "UTF-8");
				} catch (UnsupportedEncodingException e) {

					e.printStackTrace();
				}
				if (!change_after.equals(user.getPassword())) {
					msg = "密码错误";
					model.addAttribute("msg", msg);
					return "login";
				} else {
					request.getSession().setAttribute("user", sysAdmin);
					request.getSession().setAttribute("UserRole", user);
					model.addAttribute("user", user);
					List<UserRole> lu = ur.selectMenus(user.getRoleId(), user.getUsername());
					for (int i = 0; i < lu.size(); i++) {
						model.addAttribute("lu" + lu.get(i).getMenusId(), lu.get(i).getMenusId());
					}
					return "index";
				}

			} else {
				msg = "用户不存在";
				model.addAttribute("msg", msg);
				return "login";
			}

		} else {
			user = ur.selectUser(sysAdmin_session);
			List<UserRole> lu = ur.selectMenus(user.getRoleId(), user.getUsername());
			for (int i = 0; i < lu.size(); i++) {
				model.addAttribute("lu" + lu.get(i).getMenusId(), lu.get(i).getMenusId());
			}
			model.addAttribute("user", user);
			request.getSession().setAttribute("UserRole", user);
			return "index";
		}

	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "visitorJsp/welcome";
	}

	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public String out(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	@ResponseBody
	public String changePwd(HttpServletRequest reqeust) {
		UserRole uro = (UserRole) reqeust.getSession().getAttribute("UserRole");
		String pwd = reqeust.getParameter("pwd");
		MD5Util md5 = new MD5Util();
		int x = 0;
		try {
			x = ur.changePwd(uro.getUsername(), md5.md5(pwd, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		if (x == 1) {
			json.put("msg", "修改成功");
		}
		return json.toString();
	}

	/**
	 * 
	 * @Title: grpcmainserver @Description: TODO @param: @author:
	 *         jianlinwei @return: void @throws
	 */
	@Value("${grpcPort}")
	public int grpcPort;
	@Value("${readCard}")
	public int redcard;

	@PostConstruct
	public void grpcmainserver() {
		int port = grpcPort;
		System.out.println("开始发布");
		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(new ClientImpl()).addService(new DepartmentGrpcImpl())
					.addService(new EmployeeGrpcImpl()).addService(new ReasonGrpcImpl())
					.addService(new VistorGrpcImpl()).addService(new CompanyGrpcImpl())
					.addService(new AttenceGrpcImpl()).build().start();

			System.out.println("服务发布ok");

			Runtime.getRuntime().addShutdownHook(new Thread() {

				@Override
				public void run() {
					if (server != null) {
						server.shutdown();
						try {
							server.awaitTermination();
						} catch (InterruptedException e) {

						}
					}
				}
			});

		} catch (IOException e) {
			System.out.println("grpc服务发布失败");
			/* e.printStackTrace(); */
		}

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		FaceApi fa = new FaceApiImpl();
		System.out.println("加载模板。。。。。。。");
		String tom_dllpath = System.getProperty("catalina.home") + "/dllmodels";
		int handle = fa.LjCreateDetector(tom_dllpath);
		int handle_verify = fa.LjCreateVerifier(tom_dllpath);
		EmployeeImpl.handle = handle;
		EmployeeImpl.handle_ver = handle_verify;
		System.out.println("检测：" + handle + ":::: 比对：" + handle_verify);

		ReadICcardThread ric = new ReadICcardThread(as, es);
		Thread t = new Thread(ric);
		t.setPriority(Thread.MAX_PRIORITY);
		if (redcard == 1) {
			t.start();
		}

	}

	/*
	 * 获取刷新页面
	 */
	@RequestMapping(value = "/getajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Integer> getajax(HttpServletRequest request) {
		Map<String, Integer> map = new HashMap<>();
		if (Ajax.ajax == 1) {
			map.put("ajax", 1);
			Ajax.ajax = 0;
		} else {
			map.put("ajax", 0);
		}
		return map;
	}

	/**
	 * 
	 * @Title: getblack @Description: 黑名单请求 @param: @param
	 *         request @param: @return @author: jianlinwei @return:
	 *         String @throws
	 */
	@RequestMapping(value = "getblack", method = RequestMethod.GET)
	@ResponseBody
	public String getblack(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		JSONObject json = new JSONObject();
		if (Ajax.blackList == 1) {
			/*
			 * map.put("black", Ajax.visitor.getVisitorid());
			 */
			json.put("id", Ajax.visitor.getVisitorid());
			Ajax.blackList = 0;
			System.out.println(Ajax.blackList);
		} else {
			json.put("id", "");
		}
		/* System.out.println(map.get("black")); */
		return json.toString();

	}

	/**
	 * 每年三月的星期三的下午2:44触发 cron= "0 0,44 14 ? 3 WED" @Title: Time @Description:
	 * TODO @param: @author: jianlinwei @return: void @throws
	 */
	@Scheduled(cron = "0 32 14 * * ?")
	public void Time() {
		Logger logger = Logger.getLogger(this.getClass());
		logger.info("执行清理过时数据》》》》》》》》》》》》》》》》》" + new Date());
		int count = as.selectAttenceCount();
		int page = 1;
		if (count % 500 == 0) {
			page = count / 500;
		} else {
			page = count / 500 + 2;
		}
		for (int i = 1; i < page; i++) {
			int befor = 500 * (i - 1) + 1;
			int after = i * 500;
			List<Attence> la = as.getAllInfo(befor, after);
			for (int j = 0; j < la.size(); j++) {
				SimpleDateFormat sd = new SimpleDateFormat("yyyy");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date_1 = sd.format(la.get(j).getWorkDate());
		        String date_2 = sd.format(new Date());
		         int x  = Integer.valueOf(date_1) - Integer.valueOf(date_2);
		        if(x<0){
		        	as.deleteAttenceByAttenceID(la.get(j).getAttenceId());
		        	logger.info("清理》》》工号："+la.get(j).getEmployeeId() +"姓名："+la.get(j).getName()+"打卡时间："+sdf.format(la.get(j).getWorkDate()));
		        }
			}

		}
	}

}
