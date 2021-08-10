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
	<div style="margin-left: 100px;">
	<button  id="insertDepartment" style="background-color: #4AC451;" class="layui-btn">新增部门</button>
<table class="layui-table">
    <colgroup>
      <col width="100">
      <col width="100">
      <col width="100">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody>
    <c:forEach  var="ld"  items="${ld}">
      <tr>
        <td>${ld.departmentId}</td>
        <td>${ld.departmentName}</td>
        <td> 
        <button id="${ld.departmentId}" onclick="deleteDepartment(this)" class = "layui-btn layui-btn-sm  layui-btn-danger">删除</button>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
</div>
	<c:if test="${msg !=null }">
	<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
	<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>	
<script>

$('#insertDepartment').on('click', function(){
	
	layer.prompt({title: '输入部门名称，并确认', formType: 3}, function(departmentName, index){
		$.ajax({
			type:"POST",
			url:"<%=basePath%>index/insertDepartment",
			data:{"departmentName":departmentName},
			dataType:"text",
		    success:function(data){
		    	layer.close(index);
		    	layer.msg('提交成功^_^' , {time:1000}, function(){
		    		window.location.href="<%=basePath%>index/department";
		    		});
		    	
		    },
		    error:function(msg){
		    	layer.msg("提交失败了-_-!")
		    }
		});
	});
	
  });

function deleteDepartment(obj){

	var departmentId = obj.id ;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>index/deleteDepartment",
		data:{"departmentId":departmentId},
		dataType:"text",
	    success:function(data){
	    	layer.msg('删除成功', {time:1000}, function(){
	    		window.location.reload();
	    		});
	    
	    },
		error:function(msg){
			layer.msg("失败了")
		}
	});
}

</script>
</html>