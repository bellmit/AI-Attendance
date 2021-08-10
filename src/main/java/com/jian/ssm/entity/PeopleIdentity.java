package com.jian.ssm.entity;

public class PeopleIdentity {
	private String uuid;

	private String idcard;

	private String name;

	private String sex;

	private String nation;

	private String birthday;

	private String address;

	private String depart;

	private String validitybegin;

	private String validityend;

	private byte[] idphoto;
	private String idphoto_s;

	private byte[] cameraphoto;
	private String cameraphoto_s;
	public String getIdphoto_s() {
		return idphoto_s;
	}

	public void setIdphoto_s(String idphoto_s) {
		this.idphoto_s = idphoto_s;
	}

	public String getCameraphoto_s() {
		return cameraphoto_s;
	}

	public void setCameraphoto_s(String cameraphoto_s) {
		this.cameraphoto_s = cameraphoto_s;
	}

	private byte[] cameraphotoleft;

	private byte[] cameraphotoright;
	private byte[] camerafeature;

	private byte[] fingerfeature;
	private int action;

	private int belongid;

	private String deviceId;

	private String identityDate;
	
	private String compareScore ;
	
	private String compareResult ;
	
	

	public String getCompareScore() {
		return compareScore;
	}

	public void setCompareScore(String compareScore) {
		this.compareScore = compareScore;
	}

	public String getCompareResult() {
		return compareResult;
	}

	public void setCompareResult(String compareResult) {
		this.compareResult = compareResult;
	}

	public String getIdentityDate() {
		return identityDate;
	}

	public void setIdentityDate(String identityDate) {
		this.identityDate = identityDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getValiditybegin() {
		return validitybegin;
	}

	public void setValiditybegin(String validitybegin) {
		this.validitybegin = validitybegin;
	}

	public String getValidityend() {
		return validityend;
	}

	public void setValidityend(String validityend) {
		this.validityend = validityend;
	}

	public byte[] getIdphoto() {
		return idphoto;
	}

	public void setIdphoto(byte[] idphoto) {
		this.idphoto = idphoto;
	}

	public byte[] getCameraphoto() {
		return cameraphoto;
	}

	public void setCameraphoto(byte[] cameraphoto) {
		this.cameraphoto = cameraphoto;
	}

	public byte[] getCameraphotoleft() {
		return cameraphotoleft;
	}

	public void setCameraphotoleft(byte[] cameraphotoleft) {
		this.cameraphotoleft = cameraphotoleft;
	}

	public byte[] getCameraphotoright() {
		return cameraphotoright;
	}

	public void setCameraphotoright(byte[] cameraphotoright) {
		this.cameraphotoright = cameraphotoright;
	}

	public byte[] getCamerafeature() {
		return camerafeature;
	}

	public void setCamerafeature(byte[] camerafeature) {
		this.camerafeature = camerafeature;
	}

	public byte[] getFingerfeature() {
		return fingerfeature;
	}

	public void setFingerfeature(byte[] fingerfeature) {
		this.fingerfeature = fingerfeature;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getBelongid() {
		return belongid;
	}

	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}

}