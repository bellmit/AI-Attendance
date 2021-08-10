<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看详情</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>layui/layui.js"></script>
</head>
<body>

  <div style="">
    <p  style="margin-left: 60px;font-size: 20px;">访客基本信息</p>
   <img alt="" width="300" height="200" src="<%=basePath%>img/idcard.png">
   <img alt="身份证照" src="<%=basePath%>vistor/getIdPhoto?visitorId=${vi.visitorid}" style="margin-left: -90px;margin-top: -95px;width: 70px;">	
    <div style="margin-top: -180px;margin-left: 20px;">姓名：${vi.visitorname }</div>
    <div style="margin-left: 20px;margin-top: 10px;">性别：${vi.visitor.sex}</div>
    <div style="margin-left: 100px;margin-top: -18px;">民族：${vi.visitor.nation}</div>
    <div style="margin-left: 20px;margin-top: 10px;">出生：${vi.visitor.birthday}</div>
    <div style="width:200px; margin-left: 20px;margin-top: 10px;word-break: break-all; word-wrap:break-word;">住址：${vi.visitor.address}</div>
    <div style="margin-left: 20px;margin-top: 20px;">公民身份证号码：${vi.visitorid}</div>
   </div>
   <div style="margin-top: 50px;margin-left: 20px;">
   <p>现场照片：</p>
   <img alt="现场照片" style="margin-left: 100px;margin-top: -20px;width: 102px;height: 126px;" src="<%=basePath%>vistor/getCamPhoto?visitId=${vi.visitid}">
   </div>
   <div style="margin-left: 20px;margin-top: 20px;">备注：${vi.comment }</div>
    <div style="margin-left: 350px;margin-top: -260px;">
    <img alt="访问" width="200" height="100" src="<%=basePath%>img/timg.png">
    </div>
    <div style="margin-left: 600px;margin-top: -228px;">
      <p  style="margin-left: 60px;font-size: 20px;">被访人基本信息</p>
      <div style="margin-top: 20px;margin-left: 20px;">
      <div style="line-height: 3;">姓名：${vi.employee.name}</div>
      <div style="line-height: 3;">部门：${vi.department.departmentName }</div>
      <div style="line-height: 3;">电话：${vi.employee.phone }</div>
      <div>照片：<img alt="" src="${vi.employee.photo_base }"></div>
      </div>
    </div>
	<c:if test="${msg !=null}">
		<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
</body>
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>
<script type="text/javascript">
var index = top.layer.msg('数据加载中，请稍候',{icon:16,time:false,shade:0.8});
if("${vi.visitorname }"!=null){
	top.layer.close(index)
}
</script>
 <script type="text/javascript" src="<%=basePath%>js/nocode.js"></script> 
</html>