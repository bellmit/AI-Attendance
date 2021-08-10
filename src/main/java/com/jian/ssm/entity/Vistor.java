package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Vistor   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月16日 下午1:55:20   
 *
 */
public class Vistor {
	      private String id ;
          public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		private  String  visitorid ;
          private  int   idtype;
          private  String visitorname;
          private  String  sex ;
          private  String nation;
          private  String birthday ;
          private  String address;
          private  String depart ;
          private  String validitybegin;
          private  String validityend;
          private  byte[]  idphoto;
          private  byte[]  cameraphoto;
          private  String  idphotoBase;
          private  String  cameraphotoBase;
          private  byte[]  fingerfeature ;
          private  int     action;//0没任何操作，-1删除 。-2加入黑名单
          private  long  version;
          
          private  float  faceVerifyScore ;
          private  String  faceVerifyResult ;
          private  long   dataTime ;
          private  int    belongid;
          private  String contact ;
          
          public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public int getBelongid() {
			return belongid;
		}
		public void setBelongid(int belongid) {
			this.belongid = belongid;
		}
		public String getIdphotoBase() {
			return idphotoBase;
		}
		public void setIdphotoBase(String idphotoBase) {
			this.idphotoBase = idphotoBase;
		}
		public String getCameraphotoBase() {
			return cameraphotoBase;
		}
		public void setCameraphotoBase(String cameraphotoBase) {
			this.cameraphotoBase = cameraphotoBase;
		}
		private  byte[]  camerafeature;
      
		
		public float getFaceVerifyScore() {
			return faceVerifyScore;
		}
		public void setFaceVerifyScore(float faceVerifyScore) {
			this.faceVerifyScore = faceVerifyScore;
		}
		public String getFaceVerifyResult() {
			return faceVerifyResult;
		}
		public void setFaceVerifyResult(String faceVerifyResult) {
			this.faceVerifyResult = faceVerifyResult;
		}
		public long getDataTime() {
			return dataTime;
		}
		public void setDataTime(long dataTime) {
			this.dataTime = dataTime;
		}
		public int getIdtype() {
			return idtype;
		}
		public void setIdtype(int idtype) {
			this.idtype = idtype;
		}
		
		
		public String getVisitorid() {
			return visitorid;
		}
		public void setVisitorid(String visitorid) {
			this.visitorid = visitorid;
		}
		public String getVisitorname() {
			return visitorname;
		}
		public void setVisitorname(String visitorname) {
			this.visitorname = visitorname;
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
		
	
		
		public byte[] getIdphoto() {
			return idphoto;
		}
		public void setIdphoto(byte[] idphoto) {
			this.idphoto = idphoto;
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
		public byte[] getCameraphoto() {
			return cameraphoto;
		}
		public void setCameraphoto(byte[] cameraphoto) {
			this.cameraphoto = cameraphoto;
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
		public long getVersion() {
			return version;
		}
		public void setVersion(long version) {
			this.version = version;
		}
          
          
}
