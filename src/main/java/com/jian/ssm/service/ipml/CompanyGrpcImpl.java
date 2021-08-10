package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.ssm.entity.Company;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.service.CompanyService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.company.CompanyAuthServiceGrpc.CompanyAuthServiceImplBase;
import com.ljzn.grpc.company.CompanyDataApplyRequest;
import com.ljzn.grpc.company.CompanyDataApplyResponse;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class CompanyGrpcImpl  extends  CompanyAuthServiceImplBase {
  private static  CompanyService  CS;
	@Autowired
	public  void  company(CompanyService comapmyservice){
		this.CS  = comapmyservice;
	}
  
	@Override
	public  void  companyDataApply(CompanyDataApplyRequest request,StreamObserver<com.ljzn.grpc.company.CompanyDataApplyResponse> responseObserver){
		responseObserver.onNext(getCompany(request));
		responseObserver.onCompleted();
	}
	
	public  CompanyDataApplyResponse  getCompany(CompanyDataApplyRequest request){
		List<Company>  lc  = CS.selectCompany();
		CompanyDataApplyResponse.Builder cda = CompanyDataApplyResponse.newBuilder();
		String device_id  = request.getClientId();
		 String clientSecret = GrpcSecret.clientSecret ;
		  String serverSecret = GrpcSecret.serverSecret;
		  MD5Util md5  = new MD5Util();
		  String md5_secret = null ;
		  String md5_secret_server  = null;
		  try {
			  md5_secret=	md5.md5(device_id+clientSecret, "utf-8");
			  md5_secret_server = md5.md5(device_id+serverSecret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(request.getClientSecret().equals(md5_secret)){
			for (int i = 0; i < lc.size(); i++) {
				cda.addCompanyMessagesBuilder().setBelongId(lc.get(i).getBelongid())
				                                   .setDescription(lc.get(i).getDescription())
				                                   .setParentId(lc.get(i).getParentid())
				                                   .build();
			}
			cda.setCode(0);
			cda.setMessage("获取company成功");
			cda.setServerSecret(md5_secret_server);
			
		}else{
			   cda.setCode(1);
			   cda.setServerSecret(md5_secret_server);
			   cda.setMessage("盐值约定不正确");
		}
		
		return cda.build();
	}
	
}
