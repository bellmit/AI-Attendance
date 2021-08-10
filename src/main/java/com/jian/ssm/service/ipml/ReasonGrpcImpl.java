package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.Reason;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.ReasonService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.reason.ReasonAuthServiceGrpc.ReasonAuthServiceImplBase;
import com.ljzn.grpc.reason.ReasonDataApplyRequest;
import com.ljzn.grpc.reason.ReasonDataApplyResponse;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class ReasonGrpcImpl extends ReasonAuthServiceImplBase {
	private static ReasonService rs;
	private static VersionDao vd;

	@Autowired
	public void reason(ReasonService rs, VersionDao vd) {
		this.rs = rs;
		this.vd = vd;
	}

	@Override
	public void reasonDataApply(ReasonDataApplyRequest request,
			StreamObserver<ReasonDataApplyResponse> responseObserver) {
		responseObserver.onNext(getreason(request));
		responseObserver.onCompleted();
	}

	public ReasonDataApplyResponse getreason(ReasonDataApplyRequest request) {
		ReasonDataApplyResponse.Builder rdr = ReasonDataApplyResponse.newBuilder();
		String client_md5 = null;
		String server_md5 = null;
		MD5Util md5 = new MD5Util();
		try {
			client_md5 = md5.md5(request.getClientId() + GrpcSecret.clientSecret, "utf-8");
			server_md5 = md5.md5(request.getClientId() + GrpcSecret.serverSecret, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (client_md5.equals(request.getClientSecret())) {
			Version version = vd.selectVerson("reason",request.getBelongId());
			if (version != null) {
				if (!String.valueOf(version.getVersion()).equals(String.valueOf(request.getVersion()))) {
					List<Reason> lr = rs.sleteReason(request.getBelongId());
					if (lr.size() != 0) {
						for (int i = 0; i < lr.size(); i++) {
							rdr.addReasonMessagesBuilder().setReasonId(lr.get(i).getReasonid())
									.setReasonName(lr.get(i).getReasonname()).setBelongId(lr.get(i).getBelongid());
						}
						rdr.setCode(0);
						rdr.setMessage("成功");
						rdr.setServerVersion(version.getVersion());
						rdr.setServerSecret(server_md5);
					} else {
						rdr.setCode(1);
						rdr.setServerSecret(server_md5);
						rdr.setMessage("数据库不存在事由");
					}
				}else{
					rdr.setCode(1);
					rdr.setServerSecret(server_md5);
					rdr.setMessage("版本信息未更新");
				}
			}
		} else {
			rdr.setCode(1);
			rdr.setServerSecret(server_md5);
			rdr.setMessage("盐值加密不正确");
		}
		return rdr.build();
	}
}
