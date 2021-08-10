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
<title>设备列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
</head>
<body>
<div class="page-container">
<div class="demoTable">
 <div class="layui-inline">
    关键字搜索：
        <select style="width: 100px;height: 36px;" id="visitInfoSereach" lay-verify="required">
          <option value="visitorId">设备编号</option>
          <option value="visitorName">设备名称</option>
          <option value="visitorName">所属机构</option>
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload">搜索</button>
  <div style="margin-left: 800px;margin-top: -34px;">
          <button id="option" class="layui-btn layui-btn-primary">重新设置开门延时</button>
    </div>
     <div style="margin-left: 990px;margin-top: -38px;">
          <button id="optionPassword" class="layui-btn layui-btn-primary">设置开门密码</button>
    </div> 
</div>
	<div >
	<!-- <button  id="insertDepartment" class="layui-btn">增加部门</button> -->
<table class="layui-table">
    <colgroup>
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="160">
   
    </colgroup>
    <thead>
      <tr>
        <th>设备编号</th>
        <th>授权状态</th>
        <th>设备名称</th>
        <th>设备地点</th>
        <th>所属机构</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody id="deviceTr">
    <%-- <c:forEach  var="ld"  items="${ld}">
      <tr>
        <td>${ld.departmentId}</td>
        <td>${ld.departmentName}</td>
        <td> 
        <button id="${ld.departmentId}" onclick="deleteDepartment(this)" class = "layui-btn layui-btn-sm  layui-btn-danger">删除</button>
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
<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>	
<script>

layui.use(['laypage', 'layer'], function(){
	var laypage = layui.laypage
  ,layer = layui.layer;
	var  countd ;
	$.ajax({
		   type:'GET',
		   url:'<%=basePath%>device/getdevicecount',
		   async:false ,
		   dataType:'json',
		   success:function(data){
			   countd = data.count;
			   
		   },
		   error:function(data){
			   layer.msg('服务器响应失败了')
		   }
	});
	
  //完整功能
  laypage.render({
    elem: 'demo7'
    ,count: countd
    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
    ,jump: function(obj){
     	console.log(obj) 
       /* alert(obj.curr);  */
      $.ajax({
    	 type:'GET',
    	 url:'<%=basePath%>device/getdevices',
    	 data:{"limit":obj.limit ,"page":obj.curr},
  	   dataType:'json',
  	   success:function(data){
  		  /*  console.log(data); */
  		  if(data.ld.length == 0){
  			layer.msg("暂无设备")
  		  }
  		$("#deviceTr").empty();
  		   for(var i= 0; i<data.ld.length ; i++){
  			   var key ;
  			   if(data.ld[i].keyStatus == 1){
  				   key ="取消授权";
  			   }else{
  				   key="授权";
  			   }
  			  /* alert(data.ld[i].deviceid) */
  			  $("#deviceTr").append("<tr>"+
  	        "<td>"+data.ld[i].deviceid+"</td>"+
  	      "<td>"+data.ld[i].key+"</td>"+
  	        "<td>"+data.ld[i].description+"</td>"+
  	      "<td>"+data.ld[i].address+"</td>"+
  	    "<td>"+data.ld[i].company+"</td>"+
  	        "<td>"+ 
  	       "<button id="+data.ld[i].deviceid+" onclick='deleteDevice(this)' class = 'layui-btn layui-btn-sm  layui-btn-danger'>删除</button>"+
  	     /* "<button id="+data.ld[i].deviceid+" onclick='editDevice(this)' class = 'layui-btn layui-btn-sm' lay-event='edit'>编辑</button>"+ */
  	     "<button id="+data.ld[i].deviceid+" onclick='updateDevice(this)' class = 'layui-btn layui-btn-sm  '>"+key+"</button>"+
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


function  deleteDevice(obj){
	
	$.ajax({
		type:'POST',
		url:'<%=basePath%>device/deleteDevice',
		data:{"deviceId":obj.id},
		dataType:"text",
	    success:function(data){
	    	layer.msg('删除成功', {time:1000}, function(){
	    		window.location.reload();
	    		});
	    
	    },
		error:function(msg){
			layer.msg("失败了,不能删除他家机构设备")
		}
	});
}

function  updateDevice(obj){
	
	$.ajax({
		type:'POST',
		url:'<%=basePath%>device/updateDevice',
		data:{"deviceId":obj.id},
		dataType:"text",
	    success:function(data){
	    	layer.msg('成功', {time:1000}, function(){
	    		window.location.reload();
	    		});
	    
	    },
		error:function(msg){
			layer.msg("失败了")
		}
	});
}

function editDevice(obj){
	
}
</script>
<script>
$(document).ready(function(){
  $("#option").click(function(){
	  layer.prompt({title: '输入开门延时时间（秒），并确认', formType: 3}, function(attenceTime, index){
	  	  var x = parseInt(attenceTime)
	  	  if(isNaN(x)){
	  		layer.msg("非数字");
	  	  }else{
	  		 /* layer.msg(attenceTime);  */ 
	  		 $.ajax({
	  			 type:"post",
	  			 url:"<%=basePath%>index/SetDoorDelay",
	  			 data:{'test':attenceTime},
	  			success:function(data){
	  				 var data_re = JSON.parse(JSON.stringify(data));
	  				 layer.close(index);
	  				 if(data_re.msg == 1){
	  					 layer.msg("设置成功")
	  				 }
	  				
	  			 },
	  			 error:function(data){
	  				 layer.msg("出错了")
	  			 }
	  		 });
	  	  }
	  	});
  });
  
  
  $("#optionPassword").click(function(){
	  layer.prompt({title: '输入开门密码，并确认', formType: 3}, function(attenceTime, index){
	  	  var x = parseInt(attenceTime)
	  	  if(isNaN(x)){
	  		layer.msg("非数字");
	  	  }else{
	  		 /* layer.msg(attenceTime);  */ 
	  		 $.ajax({
	  			 type:"post",
	  			 url:"<%=basePath%>index/SetDoorPassWord",
	  			 data:{'test':attenceTime},
	  			success:function(data){
	  				 var data_re = JSON.parse(JSON.stringify(data));
	  				 layer.close(index);
	  				 if(data_re.msg == 1){
	  					 layer.msg("设置成功")
	  				 }
	  				
	  			 },
	  			 error:function(data){
	  				 layer.msg("出错了")
	  			 }
	  		 });
	  	  }
	  	});
  });
  
});

</script>
</html>