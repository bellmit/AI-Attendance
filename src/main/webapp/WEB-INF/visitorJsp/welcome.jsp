<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>我的桌面</title>
<style>

* {

	margin: 0;

	padding: 0;

	list-style: none;

	border: none;
}

#zzsc {

	width: 920px;

	margin: 100px auto;

}

</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>

<%-- <script type="text/javascript" src="<%=basePath%>js/zzsc.js"></script> --%>
</head>
<body>
<div  style="position:absolute; left:0px; top:0px; width:100%; height:100%  ; background-size:contain ;background-image: url(../img/login-back-1.49789fa.jpg)">

 <img style="margin-left: 46%;margin-top: 10%;" width="100"  height="120" alt="四川领军智能科技有限公司" src="<%=basePath%>img\logo.png">
      
      <p style="text-align: center;margin-top: 20px;">四川领军智能科技有限公司</p>
 
</div>

     


<%--         <img alt="" width="100%"  height="100%" src="<%=basePath%>img/welcome.jpg"> --%>

<%-- <div id="zzsc">

  <canvas id="canvas" width="920" height="400"></canvas>

</div> --%>
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
</html>