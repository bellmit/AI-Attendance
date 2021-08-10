<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<c:set var="user" value="${sessionScope.UserRole}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
</head>
<body>
<div class="page-container">
	<div style="margin-left: 10px;">
	<div class="demoTable">
	 <div class="layui-inline">
    关键字搜索：
        <select style="width: 100px;height: 36px;" id="EmpSereach" lay-verify="required">
          <option value="name">姓名</option>
          <option value="idcard">身份证号</option>
        <!--   <option value="deviceId">设备号</option> -->
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
</div>
</div>

<table class="layui-table" lay-data="{width:1340,url:'<%=basePath%>peopleIdentity/GetPeopleIdentityS', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr >
      <th lay-data="{field:'idcard', width:130, sort: true}">身份证</th>
      <th lay-data="{field:'idphoto_s', width:110}">身份证照片</th>
      <th lay-data="{field:'cameraphoto_s', width:110}">现场照片</th>
      <th lay-data="{field:'compareResult', width:100}">比对结果</th>
      <th lay-data="{field:'name', width:90}">姓名</th>
      <th lay-data="{field:'sex', width:80}">性别</th>
      <th lay-data="{field:'nation', width:80}">民族</th>
      <th lay-data="{field:'birthday', width:110}">生日</th>
      <th lay-data="{field:'address', width:120}">户籍地</th>
      <th lay-data="{field:'identityDate', width:120}">核验时间</th>
      <th lay-data="{field:'deviceId', width:110}">设备号</th>
       <th lay-data="{width:160, align:'center', toolbar: '#barDemo'}"></th>
      
    </tr>
  </thead>

  </div>
  </div>
  
</div>
	<c:if test="${msg !=null }">
	<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
</body>
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>	
<script type="text/html" id="barDemo">
<c:if test="${query ==1 }">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>
</c:if>
<c:if test="${delete ==1 }">
 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</c:if>
</script>

<script>
layui.use('table', function(){
  var table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    	sessionStorage.setItem("data", JSON.stringify(data))
    	var index = layer.open({
 		   type: 2,
 		   content: '<%=basePath%>html/peoleIdentity.html',
 		   area: ['500px', '500px'],
 		   maxmin: false,
 		   title:'查看详情',
 		   cancel: function(){
 			 <%--   window.location.href="<%=basePath%>attence/getAttenceJsp" --%>
 			  }
 		 });
      
    } else if(obj.event === 'del'){
      layer.confirm('确认删除该员工么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
        	type:"POST",
			url:"<%=basePath%>index/deleteEmp",
			data:{"id":data.id},
			dataType:"text",
		    success:function(data){
		    	layer.close(index);
		    	layer.msg('删除成功' , {time:2000}, function(){
		    		window.location.href="<%=basePath%>index/employee";
		    		});
		    	
		    },
		    error:function(msg){
		    	layer.msg("提交失败了-_-!")
		    }
        });
        
      });
    } else if(obj.event === 'edit'){
      /* layer.alert('编辑行：<br>'+ JSON.stringify(data)) */
     /*  console.log(data) */
      sessionStorage.setItem("data_emp", JSON.stringify(data))
    	var index = layer.open({
    		  type: 2,
    		  title:'编辑',
    		  content: '<%=basePath%>html/editEmp.html',
    		  area: ['500px', '600px'],
    		  maxmin: false,
    		  cancel: function(){ 
  			    //右上角关闭回调
  			     window.location.href="<%=basePath%>index/employee";
  			    //return false 开启该代码可禁止点击该按钮关闭
  			  }
    		});
    }
  });
  
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#demoReload');
		      
		     var EmpSereach  = document.getElementById("EmpSereach").value;
		     if(EmpSereach == 'name'){
		    	
		      //执行重载
		      table.reload('idTest', {
		    	 
		        page: {
		          curr: 1 //重新从第 1 页开始
		        },
		        url:'<%=basePath%>peopleIdentity/GetPeopleIdentityReload'
		         ,where: {
		        	 name :  demoReload.val(),
		        	 idcard : null ,
		        	 deviceId : null
		        } 
		       
		      });
		      EmpSereach = "";
		     }else if(EmpSereach == 'idcard'){
		    	
		    	//执行重载
		         table.reload('idTest', {
		       	 
		           page: {
		             curr: 1 //重新从第 1 页开始
		           },
		           url:'<%=basePath%>peopleIdentity/GetPeopleIdentityReload'
		            ,where: {
		            	 name :  null,
			        	 idcard : demoReload.val() ,
			        	 deviceId : null
		           } 
		           
		         });
		         EmpSereach = "";
		     }else if(EmpSereach == 'deviceId'){
		    	
		    	//执行重载
		         table.reload('idTest', {
		       	 
		           page: {
		             curr: 1 //重新从第 1 页开始
		           },
		           url:'<%=basePath%>index/selectEmpByWorkId'
		            ,where: {
		            	 name :  null,
			        	 idcard : null ,
			        	 deviceId : demoReload.val()
		           } 
		           
		         });
		         EmpSereach = "";
		     }
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
  
});
</script>
</html>