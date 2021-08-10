package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.employee.EmployeeAuthServiceGrpc.EmployeeAuthServiceImplBase;
import com.ljzn.grpc.employee.EmployeeDataApplyRequest;
import com.ljzn.grpc.employee.EmployeeDataApplyResponse;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class EmployeeGrpcImpl extends EmployeeAuthServiceImplBase {
	private static EmployeeService es;
	private static VersionDao vd;

	@Autowired
	public void employee(EmployeeService empservice, VersionDao vd) {
		this.es = empservice;
		this.vd = vd;
	}

	@Override
	public void employeeDataApply(EmployeeDataApplyRequest request,
			StreamObserver<EmployeeDataApplyResponse> responseObserver) {
		responseObserver.onNext(getEmp(request));
		responseObserver.onCompleted();
	}

	public EmployeeDataApplyResponse getEmp(EmployeeDataApplyRequest request) {
		String client_md5 = null;
		String server_md5 = null;
		EmployeeDataApplyResponse.Builder edr = EmployeeDataApplyResponse.newBuilder();
		MD5Util md5 = new MD5Util();
		try {
			client_md5 = md5.md5(request.getClientId() + GrpcSecret.clientSecret, "utf-8");
			server_md5 = md5.md5(request.getClientId() + GrpcSecret.serverSecret, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (client_md5.equals(request.getClientSecret())) {
			Version version = vd.selectVerson("employee",request.getBelongId());
			if (version != null) {
				if (!String.valueOf(version.getVersion()).equals(String.valueOf(request.getVersion()))) {
					List<Employee> le = es.selectEmp(request.getBelongId());
					if (le.size() != 0) {
						for (int i = 0; i < le.size(); i++) {
							edr.addEmployeeMessagesBuilder().setDepartmentId(le.get(i).getDepartmentid())
									.setId(le.get(i).getZeId()).setName(le.get(i).getName())
									.setPhone(le.get(i).getPhone()).setBelongId(le.get(i).getBelongid());
						}
						edr.setCode(0);
						edr.setServerSecret(server_md5);
						edr.setServerVersion(version.getVersion());
						edr.setMessage("成功");
					} else {
						edr.setCode(1);
						edr.setServerSecret(server_md5);
						edr.setMessage("数据库不存在员工");
					}
				} else {
					edr.setCode(1);
					edr.setServerSecret(server_md5);
					edr.setMessage("版本信息未更新");
				}
			}
		} else {
			edr.setCode(1);
			edr.setServerSecret(server_md5);
			edr.setMessage("盐值加密不正确");
		}

		return edr.build();
	}

}
