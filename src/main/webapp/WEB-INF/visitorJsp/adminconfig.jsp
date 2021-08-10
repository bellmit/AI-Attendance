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
<title>权限管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>
</head>
<body>
<div class="page-container">
	<div style="margin-left: 100px;">
	<button  id="insertUser"  style="background-color: #4AC451;" class="layui-btn">新增管理员</button>
<table class="layui-table">
    <colgroup>
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="100">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>用户名</th>
        <th>账号描述</th>
        <th>公司机构</th>
        <th>权限范围</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody id="deviceTr">
    <%-- <c:forEach  var="lu"  items="${lu}">
      <tr>
        <td>${lu.username}</td>
        <td>${lu.description }</td>
        <td>${lu.scope }</td>
        <td> <button id="${lu.username}" onclick="updateCom(this)" class="layui-btn layui-btn-sm">编辑</button> 
        <button id="${lu.username}" onclick="deleteUser(this)" class = "layui-btn layui-btn-sm  layui-btn-danger">删除</button>
        </td>
      </tr>
      </c:forEach> --%>
    </tbody>
  </table>
  <div id="demo7"></div>
  </div>
</div>
	<c:if test="${msg !=null }">
	<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>

</body>
<script type="text/javascript">
    function  deleteUser(obj){
    	var userName="<%=session.getAttribute("user")%>";
    	if(obj.id  == userName){
    		layer.alert('您好像是在删除自己？别这样玩')
    	}else{
    		$.ajax({
        		type:'POST',
        		url:'<%=basePath%>user/deleteUser?userName='+obj.id,
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
    }
    
    
    function updateAdmin(obj){
    	var userName="<%=session.getAttribute("user")%>";
    	if(obj.id  == userName){
    		layer.alert('不能编辑自己')
    	}else{
    		var index = layer.open({
    	  		  type: 2,
    	  		  content: '<%=basePath%>user/updateAdmin/'+obj.id,
    	  		  area: ['500px', '600px'],
    	  		  maxmin: false,
    	  		  title:'编辑管理员',
    	  		  cancel:function(){
    	  			  window.location.reload();
    	  		  }
    	  		});
    	}
    	
    }
    
    
    $('#insertUser').on('click', function(){
    	var index = layer.open({
    		  type: 2,
    		  content: '<%=basePath%>user/addUser',
    		  area: ['500px', '600px'],
    		  maxmin: false,
    		  title:'添加管理员',
    		  cancel:function(){
    			  window.location.reload();
    		  }
    		});
    	
      });
</script>
<script>
var  countd ;
$.ajax({
	   type:'GET',
	   url:'<%=basePath%>user/getUserRoleCount',
	   async:false,
	   dataType:'json',
	   success:function(data){
		   countd = data.count;
		   
	   },
	   error:function(data){
		   layer.msg('服务器响应失败了')
	   }
});

layui.use(['laypage', 'layer'], function(){
	var laypage = layui.laypage
  ,layer = layui.layer;
  //完整功能
  laypage.render({
    elem: 'demo7'
    ,count: countd
    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
    ,jump: function(obj){
    /* 	console.log(obj) */
       /* alert(obj.curr);  */
      $.ajax({
    	 type:'GET',
    	 url:'<%=basePath%>user/adminconfig',
    	 data:{"limit":obj.limit ,"page":obj.curr},
  	   dataType:'json',
  	   success:function(data){
  		  console.log(data);  
  		  if(data.lu.length == 0){
  			layer.msg("暂无下属角色")
  		  }
  		$("#deviceTr").empty();
  		   for(var i= 0; i<data.lu.length ; i++){
  			  /* alert(data.ld[i].deviceid) */
  			  $("#deviceTr").append("<tr>"+
  	        "<td>"+data.lu[i].username+"</td>"+
  	      "<td>"+data.lu[i].description+"</td>"+
  	    "<td>"+data.lu[i].company.description+"</td>"+
  	        "<td>"+data.lu[i].scope+"</td>"+
  	        "<td>"+ 
  	       "<button id="+data.lu[i].username+" onclick='deleteUser(this)' class = 'layui-btn layui-btn-sm  layui-btn-danger'>删除</button>"+
  	     "<button id="+data.lu[i].username+" style=\"background-color: #4AC451;\" onclick='updateAdmin(this)' class = 'layui-btn layui-btn-sm  '>编辑</button>"+
  	       "</td>"+
  	      "</tr>"); 
  			
  		   }
  		   
  	   },
  	   error:function(data){
  		   layer.msg('服务器响应失败了')
  	   }
      });
    }
  
  });
  

  
  
});
</script>
</html>