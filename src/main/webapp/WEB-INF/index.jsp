<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/attdence.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>${user.username}</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<img style="height: 30px; margin-top: 10px;" alt="领军智能"
					src="<%=basePath%>img/lingjunLogo.png"> <span
					class="logo navbar-slogan f-l mr-10 hidden-xs"></span> <a
					aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
					href="javascript:;">&#xe667;</a>
				<!--  	<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
							<li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
							<li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
							<li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
					</ul>
				</li>
			</ul>
		</nav>-->
		 
				<nav id="Hui-userbar"
					class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li>超级管理员</li>
						<li class="dropDown dropDown_hover"><a href="#"
							class="dropDown">${user.username} <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
							<c:if test="${user.username == 'admin' }"><li><a onclick="changePwd()">修改密码</a></li></c:if>
								<li><a href="<%=basePath%>sys_login/out">退出</a></li>

							</ul></li>
						<!-- <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li> -->
						<!-- <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
						
					</ul>
				</li> -->
					</ul>
				</nav>
				<!--  <a>四川领军智能科技有限公司</a> -->
			</div>
		</div>
	</header>
	<aside class="Hui-aside">
		<div class="menu_dropdown bk_2">

			<dl id="menu-admin">
				<c:if test="${lu1 == 1}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/1.png">
						<!-- <i class="Hui-iconfont">&#xe62d;</i> -->
						管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu2 == 2}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>user/getadminconfig" data-title="角色管理"
								href="javascript:void(0)"> <img alt="" width="20"
									src="<%=basePath%>img/icon/2.png">&nbsp;&nbsp;角色管理
							</a></li>
						</c:if>
						<%-- <c:if test="${lu2 == 2}"><li><a data-href="<%=basePath%>user/getCompany" data-title="公司机构" href="javascript:void(0)">公司机构</a></li></c:if> --%>
					</ul>
				</dd>
			</dl>
			<dl id="menu-live" style="margin-top: 4px;">
				<c:if test="${lu3 == 3}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/3.png">
						访客平台<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu4 == 4}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>vistor/vistormanage" data-title="访客记录"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/4.png">&nbsp;&nbsp;访问记录</a></li>
						</c:if>
						<c:if test="${lu5 == 5}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>vistor/getvisitor" data-title="访客管理"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/5.png">&nbsp;&nbsp;访客管理</a></li>
						</c:if>
						<c:if test="${lu6 == 6}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>vistor/blacklist" data-title="黑名单管理"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/6.png">&nbsp;&nbsp;黑名单管理</a></li>
						</c:if>
						<c:if test="${lu7 == 7}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>vistor/reason" data-title="访问事由字典"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/7.png">&nbsp;&nbsp;访问事由字典</a></li>
						</c:if>
						<c:if test="${lu8 == 8}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>index/department" data-title="部门管理"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/8.png">&nbsp;&nbsp;部门管理</a></li>
						</c:if>
						<c:if test="${lu9 == 9}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>index/employee" data-title="员工管理"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/9.png">&nbsp;&nbsp;员工管理</a></li>
						</c:if>
					</ul>
				</dd>

			</dl>
			<dl id="menu-live" style="margin-top: 4px;">
				<c:if test="${lu10 == 10}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/12.png">
						考勤平台<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu11 == 11}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>attence/getAttenceJsp" data-title="考勤记录"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/4.png">&nbsp;&nbsp;考勤记录</a></li>
						</c:if>
						<c:if test="${lu17 == 17}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>attence/getattenceReport" data-title="考勤报表"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/4.png">&nbsp;&nbsp;考勤报表</a></li>
						</c:if>
						<%-- <c:if test="${lu11 == 11}"><li><a style="border: 1px solid #C8C8C8;border-radius: 10px;"  data-href="<%=basePath%>attence/getAttenceOption" data-title="考勤策略" href="javascript:void(0)"><img alt="" width="20" src="<%=basePath%>img/icon/4.png">&nbsp;&nbsp;考勤策略</a></li></c:if> --%>
					</ul>
				</dd>
			</dl>
			<dl id="menu-live" style="margin-top: 4px;">
				<c:if test="${lu10 == 10}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/13.png">
						签到平台<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu11 == 11}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>attence/getSignInfo" data-title="创建会议"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/14.png">&nbsp;&nbsp;创建会议</a></li>
						</c:if>
						<c:if test="${lu11 == 11}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>attence/mettingSign" data-title="签到记录"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/4.png">&nbsp;&nbsp;会议签到记录</a></li>
						</c:if>

					</ul>
				</dd>
			</dl>
			<%-- <dl id="menu-live" style="margin-top: 4px;">
				<c:if test="${lu18 == 18}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/16.png">
						人证合一<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu19 == 19}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>peopleIdentity/GetPeopleIdentity" data-title="人证核验"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/17.png">&nbsp;&nbsp;人证核验</a></li>
						</c:if>
					</ul>
				</dd>
			</dl> --%>
			<dl id="menu-live" style="margin-top: 4px;">
				<c:if test="${lu10 == 10}">
					<dt>
						<img width="20" alt="" src="<%=basePath%>img/icon/10.png">
						设备管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
				</c:if>
				<dd>
					<ul>
						<c:if test="${lu11 == 11}">
							<li><a
								style="border: 1px solid #C8C8C8; border-radius: 10px;"
								data-href="<%=basePath%>device/getdevice" data-title="设备列表"
								href="javascript:void(0)"><img alt="" width="20"
									src="<%=basePath%>img/icon/11.png">设备列表</a></li>
						</c:if>
						<%-- <c:if test="${lu12 == 12}"><li><a data-href="<%=basePath%>device/devicetactful" data-title="策略设置" href="javascript:void(0)">策略设置</a></li></c:if> --%>
					</ul>
				</dd>
			</dl>
			<%-- <dl id="menu-live">
			<c:if test="${lu10 == 10}"><dt><i class="Hui-iconfont">&#xe64f;</i> 闸机头<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt></c:if>
			<dd>
				<ul>
					<c:if test="${lu11 == 11}"><li><a data-href="<%=basePath%>device/getdevice" data-title="闸机头设备列表" href="javascript:void(0)">闸机头设备列表</a></li></c:if>
					<c:if test="${lu12 == 12}"><li><a data-href="http://localhost:8086/ManageWeb/registerFace" data-title="闸机头人脸注册" href="javascript:void(0)">闸机头人脸注册</a></li></c:if>
			</ul>
		</dd>
	</dl> --%>
			<%-- <dl id="menu-live">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 用户中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="<%=basePath%>index/department" data-title="用户中心" href="javascript:void(0)">用户资料</a></li>
			</ul>
		</dd>
	</dl> --%>

		</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="" data-href="welcome.html">首页</span>
						<em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0"
					src="<%=basePath%>sys_login/welcome"></iframe>
			</div>
		</div>
	</section>

	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=basePath%>lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>

	<%-- <c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if> --%>
</body>
<script>
function changePwd(){
	  layer.prompt({title: '输入新密码，并确认' , formType: 1},function(val, index){
		 
		 $.ajax({
			 type:'post',
			 url:'<%=basePath%>sys_login/changePwd',
			 data:{"pwd":val},
			  dataType:'json',
		  	   success:function(data){
		  		   layer.msg(data.msg)
		  	   }
		 });
		  layer.close(index);
		});
}
</script> 
</html>