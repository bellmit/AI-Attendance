package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Department;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.DepartmentService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.department.DepartmentAuthServiceGrpc.DepartmentAuthServiceImplBase;
import com.ljzn.grpc.department.DepartmentDataApplyRequest;
import com.ljzn.grpc.department.DepartmentDataApplyResponse;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class DepartmentGrpcImpl extends DepartmentAuthServiceImplBase {
	private static DepartmentService ds;
	private static VersionDao vd;

	@Autowired
	public void department(DepartmentService departmentservice, VersionDao vd) {
		this.ds = departmentservice;
		this.vd = vd;
	}

	@Override
	public void departmentDataApply(DepartmentDataApplyRequest request,
			StreamObserver<DepartmentDataApplyResponse> responseObserver) {
		responseObserver.onNext(getdepartment(request));
		responseObserver.onCompleted();
	}

	public DepartmentDataApplyResponse getdepartment(DepartmentDataApplyRequest request) {
		Version version = vd.selectVerson("department",request.getBelongId());
		DepartmentDataApplyResponse.Builder ddr = DepartmentDataApplyResponse.newBuilder();
		String clientid = request.getClientId();
		MD5Util md5 = new MD5Util();
		String client_md5 = null;
		String  server_md5 = null;
		try {
			client_md5 = md5.md5(clientid + GrpcSecret.clientSecret, "utf-8");
			server_md5 = md5.md5(request.getClientId()+GrpcSecret.serverSecret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (client_md5.equals(request.getClientSecret())) {
			if (version != null) {
				long ver = version.getVersion();
				if (!String.valueOf(ver).equals(String.valueOf(request.getVersion()))) {
					List<Department> ld = ds.selectDepens(request.getBelongId());
					if (ld.size() != 0) {
						for (int i = 0; i < ld.size(); i++) {
							ddr.addDepartmentMessagesBuilder().setDepartmentId(ld.get(i).getDepartmentId())
									.setDepartmentName(ld.get(i).getDepartmentName()).setBelongId(ld.get(i).getBelongid());
						}
						ddr.setCode(0);
						ddr.setMessage("成功");
						ddr.setServerVersion(version.getVersion());
						ddr.setServerSecret(server_md5);

					} else {
						ddr.setCode(1);
						ddr.setMessage("数据库不存在数据");
						ddr.setServerSecret(server_md5);
					}
				} else {
					ddr.setCode(1);
					ddr.setMessage("版本信息还未更新");
					ddr.setServerSecret(server_md5);
				}
			} else {
				ddr.setCode(1);
				ddr.setMessage("版本信息不存在");
				ddr.setServerSecret(server_md5);
			}
		} else {
			ddr.setCode(1);
			ddr.setMessage("加密盐值不正确");
			ddr.setServerSecret(server_md5);
		}

		return ddr.build();
	}
}
