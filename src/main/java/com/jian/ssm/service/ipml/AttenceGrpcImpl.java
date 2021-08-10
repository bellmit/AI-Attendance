package com.jian.ssm.service.ipml;

import com.ljzn.grpc.attence.AttenceAuthServiceGrpc.AttenceAuthServiceImplBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.protobuf.ByteString;
import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.Metting;
import com.jian.ssm.entity.MettingEmp;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.AttenceService;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.MettingService;
import com.jian.ssm.service.VersionService;

import com.ljzn.grpc.attence.AttenceUploadDataRequest;
import com.ljzn.grpc.attence.AttenceUploadDataResponse;
import com.ljzn.grpc.attence.EmployeeInfoRequest;
import com.ljzn.grpc.attence.EmployeeInfoResponse;
import com.ljzn.grpc.attence.EmployeeVersionRequest;
import com.ljzn.grpc.attence.EmployeeVersionResponse;
import com.ljzn.grpc.attence.getPhotoRequest;
import com.ljzn.grpc.attence.getPhotoResponse;

import io.grpc.stub.StreamObserver;

@Component
public class AttenceGrpcImpl extends AttenceAuthServiceImplBase {
	private static AttenceService as;
	private static EmployeeService es;
	private static VersionService vs;
	private static MettingService ms;

	@SuppressWarnings("static-access")
	@Autowired
	public void attenservice(AttenceService astt, EmployeeService emps, VersionService vss, MettingService ms) {
		this.as = astt;
		this.es = emps;
		this.vs = vss;
		this.ms = ms;
	}

	/**
	 * 考勤数据上传
	 */

	@Override
	public void attenceUpload(AttenceUploadDataRequest request,
			StreamObserver<AttenceUploadDataResponse> responseObserver) {
		responseObserver.onNext(insertAttence(request));
		responseObserver.onCompleted();
	}

	public AttenceUploadDataResponse insertAttence(AttenceUploadDataRequest request) {
		AttenceUploadDataResponse.Builder ab = AttenceUploadDataResponse.newBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 验证后插入数据库
		Attence attence = new Attence();
		attence.setEmployeeId(request.getAttence().getEmployeeId());
		attence.setName(request.getAttence().getName());
		try {
			attence.setWorkDate(sdf.parse(request.getAttence().getWorkDate()));
		} catch (ParseException e) {
			System.out.println(this.getClass().getName() + "不是时间格式");
			ab.setCode(0);
			ab.setMessage("不是时间格式");
			return ab.build();
		}
		attence.setCamreaPhoto(request.getAttence().getCamreaPhoto().toByteArray());
		int re_att = as.insertAttence(attence);
		ab.setCode(re_att);
		if (re_att == 1) {
			ab.setMessage("考勤成功");
		} else {
			ab.setMessage("考勤未成功");
		}
		
		if(MettingSign(attence)!=0){
			ab.setCode(1);
			ab.setMessage("会议签到成功");
		}
		return ab.build();
	}

	public  int MettingSign(Attence  at){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Metting>  lm  = ms.selectMetting();
		int x =0 ;
		try {
		for(int i = 0 ;i< lm.size() ;i++){
			if(at.getWorkDate().compareTo(sdf.parse(lm.get(i).getStartDate())) > 0 
					&&  at.getWorkDate().compareTo(sdf.parse(lm.get(i).getEndDate()))<0){
			  MettingEmp  me  = new MettingEmp();
			  me.setEmployeeId(at.getEmployeeId());
			  me.setMettingId(lm.get(i).getMettingId());
			  me.setSignDate(sdf.format(at.getWorkDate()));
			  me.setSignPhoto(at.getCamreaPhoto());
			x =  ms.insertMettingEmp(me);
			}
		}
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return x;
	}

	/**
	 * 获取员工INfo
	 */

	@Override
	public void getEmployeeInfo(EmployeeInfoRequest request, StreamObserver<EmployeeInfoResponse> responseObserver) {
		responseObserver.onNext(getEmpInfo(request));
		responseObserver.onCompleted();
	}

	public EmployeeInfoResponse getEmpInfo(EmployeeInfoRequest request) {
		EmployeeInfoResponse.Builder eb = EmployeeInfoResponse.newBuilder();
		int empcount = es.seleteEmpCount(0);
		int pageall = 0;
		if ((empcount % 100) == 0) {
			pageall = (empcount / 100);
		} else {
			pageall = (empcount / 100) + 1;
		}
		// 程序刚启动时
		List<Employee> le_all = new ArrayList<>();
		if (request.getVersion() == 0) {
			for (int i = 1; i <= pageall; i++) {
				int befor = 100 * (i - 1) + 1;
				int after = 100 * i;
				List<Employee> le = es.seleteLemp(befor, after, 0);
				le_all.addAll(le);
			}
			if (le_all.size() == empcount) {
				for (int i = 0; i < le_all.size(); i++) {
					if (le_all.get(i).getPhotofeature() == null) {
						continue;
					}
					if(StringUtils.isEmpty(le_all.get(i).getICcard())){
						le_all.get(i).setICcard("");
					}
					eb.addEmployeeInfoBuilder().setEmployeeId(le_all.get(i).getId()).setName(le_all.get(i).getName())
							.setPhotoFeature(ByteString.copyFrom(le_all.get(i).getPhotofeature()))
							.setVersion(le_all.get(i).getVersion()).setICcard(le_all.get(i).getICcard());
				}
			}
		} else {
			le_all = es.selectEmpByVersion(request.getVersion());
			for (int i = 0; i < le_all.size(); i++) {
				if (le_all.get(i).getPhotofeature() == null) {
					continue;
				}
				eb.addEmployeeInfoBuilder().setEmployeeId(le_all.get(i).getId()).setName(le_all.get(i).getName())
						.setPhotoFeature(ByteString.copyFrom(le_all.get(i).getPhotofeature()))
						.setVersion(le_all.get(i).getVersion()).setICcard(le_all.get(i).getICcard());
			}
		}
		eb.setCode(1);
		eb.setMessage("成功");
		return eb.build();
	}

	/**
	 * 轮询的接口
	 */

	@Override
	public void getEmployeeVersion(EmployeeVersionRequest request,
			StreamObserver<EmployeeVersionResponse> responseObserver) {
		responseObserver.onNext(getEv(request));
		responseObserver.onCompleted();
	}

	public EmployeeVersionResponse getEv(EmployeeVersionRequest request) {
		EmployeeVersionResponse.Builder evr = EmployeeVersionResponse.newBuilder();
		Version version = vs.selectVerson("employee", 0);
		evr.setVersion(version.getVersion());
		return evr.build();
	}

	/**
	 * 获取头像
	 */

	@Override
	public void getPhoto(getPhotoRequest request, StreamObserver<getPhotoResponse> responseObserver) {
		responseObserver.onNext(getEmpPhoto(request));
		responseObserver.onCompleted();
	}

	public getPhotoResponse getEmpPhoto(getPhotoRequest request) {
		getPhotoResponse.Builder gb = getPhotoResponse.newBuilder();
		Employee emp = es.selectEmpById(request.getEmployeeId(), 0);
		gb.setPhoto(ByteString.copyFrom(emp.getPhoto()));
		return gb.build();
	}
}
