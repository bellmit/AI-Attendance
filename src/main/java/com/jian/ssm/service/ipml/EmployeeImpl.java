package com.jian.ssm.service.ipml;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biology.entity.LjFace;
import com.biology.entity.LjFeature;
import com.biology.entity.LjImageType;
import com.biology.face.FaceApi;
import com.biology.face.FaceApiImpl;
import com.jian.ssm.dao.DepartmentDao;
import com.jian.ssm.dao.EmployeeDao;
import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.util.ExcelUtil;
import com.jian.ssm.util.ReadICcardThread;
import com.ygwit.DoorController.IController;
import com.ygwit.DoorController.Privilige;


/**
 * 
 * @ClassName: EmployeeImpl
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018年5月7日 上午11:20:35
 *
 */
@Service
@SuppressWarnings("unused")
public class EmployeeImpl implements EmployeeService {
	public static int handle;
	public static int handle_ver;
	@Resource
	EmployeeDao ed;
	@Resource
	VersionDao vd;
	@Resource
	DepartmentDao dd;

	@Override
	public int seleteEmp(String name, int belongId) {

		return ed.seleteEmp(name, belongId);
	}

	@Override
	public List<Employee> seleteLemp(int befor, int after, int belongId) {
		List<Employee> le;
		try {
			le = ed.seleteLemp(befor, after, belongId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return le;
	}

	@Override
	public String insertEmp(String id, int departmentid, String name, String phone, String email, String photo_base,
			String sex, int belongId, HttpServletRequest request, String ICcard) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String tom_path = System.getProperty("catalina.home");
		String msg = "";
		Base64.Decoder basede = Base64.getDecoder();
		try {
			byte[] photo_byte = null;
			try{
				photo_byte = basede.decode(photo_base);
			}catch(Exception e){
				System.out.println("图片过大");
				msg = "图片过大";
				return msg;
			}
			String tmp_path = tom_path + "\\temp\\cq_photo.jpg";
			FileOutputStream fost = new FileOutputStream(tmp_path);
			fost.write(photo_byte);
			fost.flush();
			fost.close();

			Mat mat = Imgcodecs.imread(tmp_path);

			byte[] imgdata = new byte[(int) (mat.total() * mat.channels())];
			mat.convertTo(mat, CvType.CV_8UC3);
			mat.get(0, 0, imgdata);
			/*
			 * int x = (int) mat.total(); int y = mat.width(); int z =
			 * mat.height(); System.out.println(x+y);
			 */
			FaceApi fa = new FaceApiImpl();
			List<LjFace> ljface = fa.LjDetect(handle, LjImageType.LJ_IMAGE_BGR8UC3.getValue(), imgdata, mat.width(),
					mat.height());
			System.out.println("face："+ ljface.size());
			if (ljface.size() == 0) {
				msg = "照片中没有人脸，请重新上传,请正视并靠近摄像头";
			} else if (ljface.size() > 1) {
				msg = "照片中存在多张人脸";
			} else {
				/*
				 * CutImageUtil ciu = new CutImageUtil(); byte[] photo_cut =
				 * ciu.cutimg(photo_byte , ljface.get(0).rect.left ,
				 * ljface.get(0).rect.top); if(photo_cut == null){ msg
				 * ="照片不合格，请重拍"; }else{
				 */
				/*
				 * String path =
				 * request.getSession().getServletContext().getRealPath(
				 * "/empimages"); long filename = System.currentTimeMillis();
				 * File file = new File(path+"/"+filename+".jpg");
				 * System.out.println(path); if(!file.exists()){ try{
				 * file.createNewFile(); }catch(Exception e){ msg="系统找不到指定的路径";
				 * } } FileOutputStream fos = new FileOutputStream(file);
				 * fos.write(photo_byte); fos.flush(); fos.close(); String
				 * img_path = filename+".jpg";
				 */
				/* 提取特征 */
				LjFeature ljFeature = new LjFeature();
				byte[] ljFeature_byte = null;
				ljFeature = fa.LjExtractFeature(handle_ver, LjImageType.LJ_IMAGE_BGR8UC3.getValue(), imgdata,
						mat.width(), mat.height(), ljface.get(0));
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
					objectOutputStream.writeObject(ljFeature);
					objectOutputStream.flush();
					ljFeature_byte = byteArrayOutputStream.toByteArray();
					objectOutputStream.flush();
					objectOutputStream.close();
					byteArrayOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				long version_time = System.currentTimeMillis();
				/*
				 * ByteArrayInputStream intputStream = new
				 * ByteArrayInputStream(photo_byte); ByteArrayOutputStream baos
				 * = new ByteArrayOutputStream();
				 * Thumbnails.of(intputStream).scale(0.5f).outputQuality(0.5f).
				 * toOutputStream(baos);
				 */
				int xi = ed.insertEmp(id, departmentid, name, phone, email, ljFeature_byte, photo_byte, sex,
						ur.getBelongid(), version_time, ICcard);
				if (xi == 1) {
					msg = "添加成功";
					ReadICcardThread.ICAecss(ICcard);
					Version version = vd.selectVerson("employee", ur.getBelongid());
					if (version == null) {
						vd.insertVersion("employee", version_time, ur.getBelongid());
					} else {
						vd.updateVersion("employee", version_time, ur.getBelongid());
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public int seleteEmpCount(int belongId) {

		return ed.seleteEmpCount(belongId);
	}

	@Override
	public int deleteEmp(String id, int belongId) {
		int x = ed.deleteEmp(id, belongId);

		if (x == 1) {
			vd.updateVersion("employee", System.currentTimeMillis(), belongId);
		}

		return x;
	}

	@Override
	public byte[] selectEmpPhoto(String id, int belongId) {

		return ed.seleteEmpPhoto(id, belongId);
	}

	@Override
	public List<Employee> selectEmp(int belongId) {

		return ed.selectEmp(belongId);
	}

	@Override
	public String selectEmpName(int id, int belongId) {

		return ed.selectEmpName(id, belongId);
	}

	@Override
	public List<Employee> selectEmpByName(String name, int belongId) {

		return ed.selectEmpByName(name, belongId);
	}

	@Override
	public List<Employee> selectEmpByDepartmentname(String departmentName, int belongId) {

		return ed.selectEmpByDepartmentname(departmentName, belongId);
	}

	@Override
	public List<Employee> selectEmpByWorkId(String workId, int belongId) {

		return ed.selectEmpByWorkId(workId, belongId);
	}

	@Override
	public int updateEmp(Employee employee, String id, HttpServletRequest request) {
		String tom_path = System.getProperty("catalina.home");
		int xi = 0;
		Base64.Decoder basede = Base64.getDecoder();
		byte[] photo_byte = basede.decode(employee.getPhoto_base());
		try {

			String tmp_path = tom_path + "\\temp\\cq_photo.jpg";
			FileOutputStream fost = new FileOutputStream(tmp_path);
			fost.write(photo_byte);
			fost.flush();
			fost.close();

			Mat mat = Imgcodecs.imread(tmp_path);

			byte[] imgdata = new byte[(int) (mat.total() * mat.channels())];
			mat.convertTo(mat, CvType.CV_8UC3);
			mat.get(0, 0, imgdata);

			FaceApi fa = new FaceApiImpl();
			List<LjFace> ljface = fa.LjDetect(handle, LjImageType.LJ_IMAGE_BGR8UC3.getValue(), imgdata, mat.width(),
					mat.height());
			if (ljface.size() == 0) {
				/* msg = "照片中没有人脸，请重新上传,请正视并靠近摄像头"; */
				xi = -1;
			} else if (ljface.size() > 1) {
				/* msg ="照片中存在多张人脸"; */
				xi = 2;
			} else {
				String path = request.getSession().getServletContext().getRealPath("/empimages");
				long filename = System.currentTimeMillis();
				File file = new File(path + "/" + filename + ".jpg");
				System.out.println(path);
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (Exception e) {
						/* msg="系统找不到指定的路径"; */
						xi = 3;
					}
				}
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(photo_byte);
				fos.flush();
				fos.close();
				
				String img_path = filename + ".jpg";
				/* 提取特征 */
				LjFeature ljFeature = new LjFeature();
				byte[] ljFeature_byte = null;
				ljFeature = fa.LjExtractFeature(handle_ver, LjImageType.LJ_IMAGE_BGR8UC3.getValue(), imgdata,
						mat.width(), mat.height(), ljface.get(0));
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
					objectOutputStream.writeObject(ljFeature);
					objectOutputStream.flush();
					ljFeature_byte = byteArrayOutputStream.toByteArray();
					objectOutputStream.flush();
					objectOutputStream.close();
					byteArrayOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				employee.setPhotofeature(ljFeature_byte);
				employee.setPhoto(photo_byte);
				/*
				 * ByteArrayInputStream intputStream = new
				 * ByteArrayInputStream(photo_byte); ByteArrayOutputStream baos
				 * = new ByteArrayOutputStream();
				 * Thumbnails.of(intputStream).scale(0.5f).outputQuality(0.5f).
				 * toOutputStream(baos); employee.setPhoto(baos.toByteArray());
				 */
				xi = ed.updateEmp(employee, id);
				if (xi == 1) {
					ReadICcardThread.ICAecss(employee.getICcard());
					System.out.println("更新门禁卡");
					Version version = vd.selectVerson("employee", employee.getBelongid());
					if (version == null) {
						vd.insertVersion("employee", System.currentTimeMillis(), employee.getBelongid());
					} else {
						vd.updateVersion("employee", System.currentTimeMillis(), employee.getBelongid());
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return xi;
	}

	@Override
	public List<Employee> selectEmpByVersion(long version) {

		return ed.selectEmpByVersion(version);
	}

	@Override
	public Employee selectEmpById(String employeeId, int belongId) {

		return ed.selectEmpById(employeeId, belongId);
	}

	@Override
	public List<Employee> selectEmpByIdList(String employeeId, int belongId) {

		return ed.selectEmpByIdList(employeeId, belongId);
	}

	@Override
	public int importExcelInfo(InputStream in, MultipartFile file, UserRole ur) {
		int x = 0;
		try {
			List<List<Object>> listob = ExcelUtil.getBankListByExcel(in, file.getOriginalFilename());
			/* List<Employee> le = new ArrayList<Employee>(); */
			// 遍历listob数据，把数据放到List中
			for (int i = 0; i < listob.size(); i++) {
				List<Object> ob = listob.get(i);
				Employee employee = new Employee();
				employee.setId(String.valueOf(ob.get(0)));
				employee.setName(String.valueOf(ob.get(1)));
				employee.setSex(String.valueOf(ob.get(2)));
				employee.setDepartmentid(dd.selectDepen(String.valueOf(ob.get(3)), ur.getBelongid()).getDepartmentId());
				employee.setPhone(String.valueOf(ob.get(4)));
				employee.setEmail(String.valueOf(ob.get(5)));
				employee.setICcard(String.valueOf(ob.get(6)));
				x = ed.insertEmp(employee.getId(), employee.getDepartmentid(), employee.getName(), employee.getPhone(),
						employee.getEmail(), employee.getPhotofeature(), employee.getPhoto(), employee.getSex(),
						ur.getBelongid(), System.currentTimeMillis(), employee.getICcard());
				ReadICcardThread.ICAecss(employee.getICcard());

			}

		} catch (Exception e) {
			e.printStackTrace();
			x = -1;
		}
		return x;
	}

	@Override
	public Employee selectEmpByZeId(int id) {
		System.out.println();
		return ed.selectEmpByZeId(id);
	}

	@Override
	public Employee selectEmpByICcard(String ICcard) {

		return ed.selectEmpByICcard(ICcard);
	}

	@Override
	public List<Employee> selectEmpByICcardList(String ICcard, int belongId) {
		
		return ed.selectEmpByICcardList(ICcard, belongId);
	}

	@Override
	public List<Employee> selectEmpByRowbounds(int belongId, int befor, int after) {
		
		return null;
	}

	/**
	 * 
	 * @Title: ICAecss @Description: TODO @param: @author: jianlinwei @return:
	 * void @throws
	 */
	

}
