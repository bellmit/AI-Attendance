<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>

</head>
<body>
<div class="page-container">
<form class="layui-form" action="" method="POST">
	<div class="layui-form-item">
    <label class="layui-form-label">用户名：</label>
    <div class="layui-input-block">
      <input name="username"  value="${ur.username}"  readonly="readonly" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码：</label>
    <div class="layui-input-block">
      <input name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">账号描述：</label>
    <div class="layui-input-block">
      <input name="description" value="${ur.description}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">公司机构：</label>
    <div class="layui-input-block">
      <input name="company" value="${ur.company.description}"  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
    <div class="layui-form-item" pane="">
    <label class="layui-form-label">分配权限：</label>
  	<div id="xtree1" style="width:250px;margin-left: 100px">
  </div> 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
	<c:if test="${msg !=null }">
	<script> </script>
	</c:if>
	<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>
<script type="text/javascript"   src="<%=basePath%>js/layui-xtree.js"></script>
<script> 
var json = [
            {
                title: "管理员管理", value: "1", data: [
                  { title: "角色管理", value: "2", data: [] }
                ]
            }
            , {
                title: "访客平台", value: "3", data: [
                  { title: "访问记录", value: "4", data: [] }
                , { title: "访客管理", value: "5", data: [] }
                , { title: "黑名单管理", value: "6", data: [] }
                , { title: "访问事由字典", value: "7", data: [] }
                , { title: "部门管理", value: "8", data: [] }
                , { title: "员工管理", value: "9", data: [] }
                ]
            }
            , {
                title: "考勤平台", value: "10", data: [
                  { title: "考勤记录", value: "11", data: [] }
                  ,{ title: "考勤报表", value: "17", data: [] }
                ]
            }
            , {
                title: "签到平台", value: "12", data: [
                  { title: "创建会议", value: "13", data: [] }
                  , { title: "会议签到记录", value: "14", data: [] }
                ]
            }
            , {
                title: "人证合一", value: "18", data: [
                  { title: "人证核验", value: "19", data: [] }
                ]
            }
            , {
                title: "设备管理", value: "15", data: [
                  { title: "设备列表", value: "16", data: [] }
                ]
            }
    ];

layui.use(['form'], function(){
	 var form = layui.form
  
	 
	//1、最基础的用法 - 直接绑定json
     var xtree1 = new layuiXtree({
         elem: 'xtree1'   //(必填) 放置xtree的容器，样式参照 .xtree_contianer
         , form: form     //(必填) layui 的 from
         , data: json     //(必填) json数据
         , ckall: false   //启动全选功能，默认false
	      , ckallback: function () {}//全选框状态改变后执行的回调函数
     });
	 
  //监听提交
  form.on('submit(demo1)', function(data){
     /* layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })  */ 
      //获取选中val
          var oCks = xtree1.GetChecked();
          var menu ;
          for (var i = 0; i < oCks.length; i++) {
           /*  alert(oCks[i].value); */
           if(menu!=null){menu  =  menu  + ","+oCks[i].value ;}else{ menu = oCks[i].value ;}
          }
         /*  console.log(menu) */
         $.ajax({
          	type:'POST',
          	url:'<%=basePath%>user/updateAdmin',
          	data:{"data":JSON.stringify(data.field) ,"menu":menu},
          	dataType:'text',
          	success:function(data){
          		console.log(data)
      	    	layer.msg('提交成功', {time:1000});
      	    },
      	    error:function(msg){
      	    	layer.msg("失败了")
      			if(msg.status == 404){
      				layer.alert("该用户名已经被使用")
      			}
      		}	
          }); 
    
     
     
     
     
    return false;
  });
 
 
});
</script>
</html>