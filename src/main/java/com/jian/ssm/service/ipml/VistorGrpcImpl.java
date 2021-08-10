package com.jian.ssm.service.ipml;


import java.io.UnsupportedEncodingException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.protobuf.ByteString;
import com.jian.ssm.entity.Ajax;
import com.jian.ssm.entity.CheckOut;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.VisitInfo;
import com.jian.ssm.entity.Vistor;
import com.jian.ssm.service.BlackListService;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.VisitInfoService;
import com.jian.ssm.service.VistorService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.visitor.VisitorAuthServiceGrpc.VisitorAuthServiceImplBase;
import com.ljzn.grpc.visitor.CheckOutRequest;
import com.ljzn.grpc.visitor.CheckOutResponce;
import com.ljzn.grpc.visitor.VisitInfoDownloadRequest;
import com.ljzn.grpc.visitor.VisitInfoDownloadResponce;
import com.ljzn.grpc.visitor.VisitInfoUploadRequest;
import com.ljzn.grpc.visitor.VisitInfoUploadResponce;
import com.ljzn.grpc.visitor.VisitorUploadRequest;
import com.ljzn.grpc.visitor.VisitorUploadResponce;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class VistorGrpcImpl extends VisitorAuthServiceImplBase {
private  static VistorService  vs ;
private static VisitInfoService vis;
private static BlackListService  bs;
private static EmployeeService  es ;

@Autowired
public  void vistor(VistorService  vistorservice ,VisitInfoService visi ,BlackListService bls,EmployeeService  es){
	this.vs = vistorservice;
	this.vis = visi ;
	this.bs = bls;
	this.es = es ;
}
	
	@Override
	public  void  visitorUpload(VisitorUploadRequest request,StreamObserver<VisitorUploadResponce> responseObserver){
		responseObserver.onNext(upload(request));
		responseObserver.onCompleted();
		
	}
	public  VisitorUploadResponce  upload(VisitorUploadRequest request){
		MD5Util  md5  =new  MD5Util();
		String client_secret = null ;
		String server_secret = null;
		try {
			client_secret =	md5.md5(request.getClientId()+GrpcSecret.clientSecret, "utf-8");
		    server_secret = md5.md5(request.getClientId()+GrpcSecret.serverSecret, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		VisitorUploadResponce.Builder  vur = VisitorUploadResponce.newBuilder();
		if(client_secret.equals(request.getClientSecret())){
		    Vistor  vistor = new Vistor();
		    vistor.setVisitorid(request.getVisitor().getVisitorId());
		    vistor.setIdtype(request.getVisitor().getIdType());
		    vistor.setVisitorname(request.getVisitor().getVisitorName());
		    vistor.setSex(request.getVisitor().getSex());
		    vistor.setNation(request.getVisitor().getNation());
		    vistor.setBirthday(request.getVisitor().getBirthday());
		    vistor.setAddress(request.getVisitor().getAddress());
		    vistor.setDepart(request.getVisitor().getDepart());
		    vistor.setValiditybegin(request.getVisitor().getValidityBegin());
		    vistor.setValidityend(request.getVisitor().getValidityEnd());
		    vistor.setIdphoto(request.getVisitor().getIdPhoto().toByteArray());
		    vistor.setCameraphoto(request.getVisitor().getCameraPhoto().toByteArray());
		    vistor.setCamerafeature(request.getVisitor().getCameraFeature().toByteArray());
		    vistor.setFingerfeature(request.getVisitor().getFingerFeature().toByteArray());
			vistor.setAction(request.getVisitor().getAction());
			vistor.setVersion(request.getVisitor().getVersion());
			vistor.setBelongid(request.getVisitor().getBelongId());
			Vistor  v = vs.selectVisitorById(vistor.getVisitorid() ,vistor.getBelongid());
			if(v == null){
				 int x  = vs.insertVistor(vistor);
				   if(x == 1){
					   vur.setCode(0);
					   vur.setMessage("成功");
					   vur.setServerSecret(server_secret);
					  
					   
				   }else if(x == 2){
					   vur.setCode(2);
					   vur.setMessage("不能重复添加");
					   vur.setServerSecret(server_secret);
				   }else{
					   vur.setCode(1);
					   vur.setMessage("添加失败");
					   vur.setServerSecret(server_secret);  
				   }
			}else{
				if(vistor.getIdtype()==-1){
					int y  = vs.updateVisitor(vistor);
					if(y == 1){
						   vur.setCode(0);
						   vur.setMessage("成功");
						   vur.setServerSecret(server_secret);
					   }else{
						   vur.setCode(-1);
						   vur.setMessage("添加失败");
						   vur.setServerSecret(server_secret);  
					   }
				}
				 vs.updateVisitor(vistor);
			}
		}else{
			vur.setCode(1);
			vur.setMessage("盐值加密不匹配");
			vur.setServerSecret(server_secret);
		}
		
		return vur.build() ;
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
				Employee  e   =es.selectEmpByZeId(vi.getEmployeeid());
				vi.setEmployeeName(e.getName());
				vi.setBelongid(request.getVisitInfo().getBelongId());
				int x  = vis.insertVisitInfo(vi);
				if(x == 1){
					Ajax.ajax = 1;
					vur.setCode(0);
					vur.setMessage("成功");
					vur.setServerSecret(server_secret);
					 int blackList  = bs.getBlackListPeo(vi.getVisitorid(),request.getBelongId());
					   if(blackList > 0){
						   Ajax.blackList = 1 ;
						   Ajax.visitor  = vs.selectVisitorById(vi.getVisitorid(),vi.getBelongid());
					   }
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
				List<VisitInfo>  lv  = vis.selectViditInfos(request.getVersion(),request.getClientId() ,request.getBelongId());
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
		/**
		 * checkOut
		 */
		
		@Override
		public  void checkOut(CheckOutRequest request,StreamObserver<CheckOutResponce> responseObserver){
			responseObserver.onNext(checkOutRes(request));
			responseObserver.onCompleted();
			
		}
	    public  CheckOutResponce  checkOutRes(CheckOutRequest  request){
	    	CheckOutResponce.Builder   cb  = CheckOutResponce.newBuilder();
	    	MD5Util md5 = new MD5Util();
			String client_secret = null;
			String server_secret = null;
			try {
				client_secret = md5.md5(request.getClientId() + GrpcSecret.clientSecret, "utf-8");
				server_secret = md5.md5(request.getClientId() + GrpcSecret.serverSecret, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (client_secret.equals(request.getClientSecret())) {
				CheckOut  co  = new CheckOut();
				co.setVisitid(request.getCheckOutMessage().getVisitId());
				co.setCheckOutDeviceId(request.getCheckOutMessage().getCheckOutDeviceId());
				co.setCheckOutTime(request.getCheckOutMessage().getCheckOutTime());
				co.setBelongId(request.getCheckOutMessage().getBelongId());
			int checkout =	vis.CheckOutUpdate(co);
				if(checkout == 1){
					Ajax.ajax = 1;
					cb.setCode(0);
					cb.setMessage("成功");
					cb.setServerSecret(server_secret);
				}else{
					cb.setCode(-1);
					cb.setMessage("不成功");
					cb.setServerSecret(server_secret);
				}
				
			}else{
				cb.setCode(1);
				cb.setMessage("盐值加密不匹配");
				cb.setServerSecret(server_secret);
			}
	    	
	    	return  cb.build() ;
	    }
}
