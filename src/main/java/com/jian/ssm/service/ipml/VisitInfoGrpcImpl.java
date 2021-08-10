package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.google.protobuf.ByteString;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.VisitInfo;
import com.jian.ssm.service.VisitInfoService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.visitor.VisitInfoDownloadRequest;
import com.ljzn.grpc.visitor.VisitInfoDownloadResponce;
import com.ljzn.grpc.visitor.VisitInfoUploadRequest;
import com.ljzn.grpc.visitor.VisitInfoUploadResponce;

import com.ljzn.grpc.visitor.VisitorAuthServiceGrpc.VisitorAuthServiceImplBase;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class VisitInfoGrpcImpl extends VisitorAuthServiceImplBase {
	private static VisitInfoService vis;

	@Autowired
	public void visitinfo(VisitInfoService v) {
		this.vis = v;
	}
/**
 * upload
 */
	@Override
	public void visitInfoUpload(VisitInfoUploadRequest request,
			StreamObserver<VisitInfoUploadResponce> responseObserver) {
		responseObserver.onNext(visitinfoup(request));
		responseObserver.onCompleted();
	}

	public VisitInfoUploadResponce visitinfoup(VisitInfoUploadRequest request) {
		MD5Util md5 = new MD5Util();
		String client_secret = null;
		String server_secret = null;
		try {
			client_secret = md5.md5(request.getClientId() + GrpcSecret.clientSecret, "utf-8");
			server_secret = md5.md5(request.getClientId() + GrpcSecret.serverSecret, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		VisitInfoUploadResponce.Builder vur = VisitInfoUploadResponce.newBuilder();
		if (client_secret.equals(request.getClientSecret())) {
            VisitInfo  vi  = new VisitInfo();
            vi.setVisitid(request.getVisitInfo().getVisitId());
            vi.setEmployeeid(request.getVisitInfo().getEmployeeId());
            vi.setVisitorid(request.getVisitInfo().getVisitorId());
            vi.setVisitorname(request.getVisitInfo().getVisitorName());
            vi.setReasonid(request.getVisitInfo().getReasonId());
            vi.setCameraphoto(request.getVisitInfo().getCameraPhoto().toByteArray());
            vi.setCheckindeviceid(request.getVisitInfo().getCheckInDeviceId());
            vi.setCheckintime(request.getVisitInfo().getCheckInTime());
            vi.setCheckoutdeviceid(request.getVisitInfo().getCheckOutDeviceId());
            vi.setCheckouttime(request.getVisitInfo().getCheckOutTime());
            vi.setState(request.getVisitInfo().getState());
            vi.setComment(request.getVisitInfo().getComment());
            vi.setAction(request.getVisitInfo().getAction());
			vi.setVersion(System.currentTimeMillis());
			int x  = vis.insertVisitInfo(vi);
			if(x == 1){
				vur.setCode(0);
				vur.setMessage("成功");
				vur.setServerSecret(server_secret);
			}else{
				vur.setCode(x);
				vur.setMessage("失败");
				vur.setServerSecret(server_secret);
			}
			
		} else {
			vur.setCode(1);
			vur.setMessage("盐值加密不匹配");
			vur.setServerSecret(server_secret);
		}

		return vur.build();
	}
	
	
	/**
	 * download
	 */
	@Override
	public  void  visitInfoDownload(VisitInfoDownloadRequest request,StreamObserver<VisitInfoDownloadResponce> responseObserver){
		responseObserver.onNext(downloadVi(request));
		responseObserver.onCompleted();
	}
	
	public  VisitInfoDownloadResponce downloadVi(VisitInfoDownloadRequest request){
		MD5Util md5 = new MD5Util();
		String client_secret = null;
		String server_secret = null;
		try {
			client_secret = md5.md5(request.getClientId() + GrpcSecret.clientSecret, "utf-8");
			server_secret = md5.md5(request.getClientId() + GrpcSecret.serverSecret, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		VisitInfoDownloadResponce.Builder  vdr = VisitInfoDownloadResponce.newBuilder();
		if (client_secret.equals(request.getClientSecret())) {
			List<VisitInfo>  lv  = vis.selectViditInfos(request.getVersion(),request.getClientId(),request.getBelongId());
			if(lv.size() != 0){
				for(int i = 0 ; i< lv.size() ; i++){
					
					vdr.addVisitInfoMessagesBuilder().setVisitId(lv.get(i).getVisitid()).setEmployeeId(lv.get(i).getEmployeeid())
					                                  .setVisitorId(lv.get(i).getVisitorid()).setVisitorName(lv.get(i).getVisitorname())
					                                  .setReasonId(lv.get(i).getReasonid()).setCameraPhoto(ByteString.copyFrom(lv.get(i).getCameraphoto()))
					                                  .setCheckInDeviceId(lv.get(i).getCheckindeviceid())
					                                  .setCheckInTime(lv.get(i).getCheckintime()).setState(lv.get(i).getState()).setComment(lv.get(i).getComment())
					                                  .setVersion(lv.get(i).getVersion());
					                                  
					                                  
				}
				vdr.setCode(0);
				vdr.setMessage("成功");
				vdr.setServerSecret(server_secret);
				
			}else{
				vdr.setCode(1);
				vdr.setMessage("数据库不存在数据");
				vdr.setServerSecret(server_secret);
			}
			
		} else {
			vdr.setCode(1);
			vdr.setMessage("盐值加密不匹配");
			vdr.setServerSecret(server_secret);
		}
		return vdr.build();
	}
}
