package com.jian.ssm.service.ipml;

import java.io.UnsupportedEncodingException;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.ssm.entity.Device;
import com.jian.ssm.entity.GrpcSecret;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.DeviceService;
import com.jian.ssm.service.VersionService;
import com.jian.ssm.util.MD5Util;
import com.ljzn.grpc.client.ClientAuthServiceGrpc.ClientAuthServiceImplBase;
import com.ljzn.grpc.client.LoginRequest;
import com.ljzn.grpc.client.LoginResponse;

import io.grpc.stub.StreamObserver;
@SuppressWarnings(value = { "static-access" })  
@Component
public class ClientImpl extends ClientAuthServiceImplBase {
	private static DeviceService ds;
	private static VersionService vs;

	@Autowired
	public void deviceserver(DeviceService deviceservi, VersionService versionservice) {
		this.ds = deviceservi;
		this.vs = versionservice;
	}

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {

		responseObserver.onNext(checkLogin(request));
		responseObserver.onCompleted();

	}

	private LoginResponse checkLogin(LoginRequest login) {
		LoginResponse.Builder b = LoginResponse.newBuilder();
		String device_id = login.getClient().getDeviceId();
		String clientSecret = GrpcSecret.clientSecret;
		String serverSecret = GrpcSecret.serverSecret;
		MD5Util md5 = new MD5Util();
		String md5_secret = null;
		String md5_secret_server = null;
		try {
			md5_secret = md5.md5(device_id + clientSecret, "utf-8");
			md5_secret_server = md5.md5(device_id + serverSecret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (login.getClientSecret().equals(md5_secret)) {
			Device device = new Device();
			device.setDeviceid(login.getClient().getDeviceId());
			device.setIp(login.getClient().getIp());
			device.setParameter(login.getClient().getParameter());
			device.setType(login.getClient().getType());
			device.setAddress(login.getClient().getAddress());
			device.setDescription(login.getClient().getDescription());
			device.setPort(login.getClient().getPort());
			device.setBelongid(login.getClient().getBelongId());
			Device de = ds.selectDevice(device.getDeviceid());

			if (de != null) {
				int y = ds.updateDevice(device.getDeviceid(), device.getIp(), device.getParameter(), device.getType(),
						device.getAddress(), device.getDescription(), device.getPort(), device.getBelongid());
				System.out.println("update:" + y);
				if (de.getKeyStatus() != 1 || de.getBelongid() != login.getClient().getBelongId()) {
					b.setCode(-1);
					b.setServerSecret(md5_secret_server);
					b.setMessage("设备未授权");
					ds.updateDeviceKeystatus(de.getDeviceid(), -1);
					return b.build();
				}
			} else {
				device.setKeyStatus(-1);
				int x = ds.insertDevice(device.getDeviceid(), device.getIp(), device.getParameter(), device.getType(),
						device.getAddress(), device.getDescription(), device.getPort(), device.getBelongid(),
						device.getKeyStatus());
				System.out.println("insert:" + x);
				b.setCode(-1);
				b.setServerSecret(md5_secret_server);
				b.setMessage("设备未授权");
				return b.build();
			}
			List<Version> lv = vs.selectVersions(login.getBelongId());

			for (int i = 0; i < lv.size(); i++) {
				b.addVersionMessagesBuilder().setVersion(lv.get(i).getVersion()).setName(lv.get(i).getName()).build();
			}
			b.setCode(0);
			b.setServerSecret(md5_secret_server);
			b.setMessage("欢迎:" + login.getClient());
		} else {
			b.setCode(1);
			b.setServerSecret(md5_secret_server);
			b.setMessage("盐值约定不正确");
		}

		return b.build();
	}
}
