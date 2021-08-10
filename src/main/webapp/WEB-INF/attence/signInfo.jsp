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
	<div style="margin-left: 10px;">
	<button  id="insertMetting" style="background-color: #4AC451;" class="layui-btn">创建会议</button>
<table class="layui-table" lay-data="{width: 800,url:'<%=basePath%>attence/queryMetting', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr >
       <!-- <th lay-data="{type:'checkbox'}"></th> -->
      <th lay-data="{field:'mettingId', width:110, sort: true}">会议编号</th>
<!--       <th lay-data="{field:'photo', width:210}">照片</th> -->
      <th lay-data="{field:'mettingName', width:110}">名称</th>
      <th lay-data="{field:'startDate', width:180}">开始时间</th>
      <th lay-data="{field:'endDate', width:180}">结束时间</th>
      <th lay-data="{fixed: 'right', width:210, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
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

$('#insertMetting').on('click', function(){
	
	var index = layer.open({
		  type: 2,
		  content: '<%=basePath%>attence/insertMetting',
		  area: ['500px', '500px'],
		  maxmin: false ,
		 title:'创建会议',
		 cancel: function(){ 
			    //右上角关闭回调
			     window.location.href="<%=basePath%>attence/getSignInfo";
			    //return false 开启该代码可禁止点击该按钮关闭
			  }
	
		});
	
  });



</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a  class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
    	var photoPath ;
    	 $.ajax({
         	type:"GET",
 			url:"<%=basePath%>index/selectEmpPhoto",
 			data:{"id":data.id},
 			dataType:"text",
 		    success:function(result){
 		    	var photo = JSON.parse(result);
 		    	photoPath = photo.data;
 		    	layer.open({
 		    		  type: 1,
 		    		  title: false,
 		    		  closeBtn: 0,
 		    		  area: '320px',
 		    		  skin: 'layui-layer-nobg', //没有背景色
 		    		  shadeClose: true,
 		    		  content: photoPath,
 		    		});
 		    },
 		    error:function(msg){
 		    	layer.msg("提交失败了-_-!")
 		    }
         });
    	
      
    } else if(obj.event === 'del'){
      layer.confirm('确认删除么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
        	type:"POST",
			url:"<%=basePath%>attence/deleteMet",
			data:{"mettingId":data.mettingId},
			dataType:"json",
		    success:function(data){
		    	var   data  = JSON.parse(JSON.stringify(data));
		    	layer.close(index);
		    	if(data.msg == 1){
		    	layer.msg('删除成功' , {time:1000}, function(){
		    		window.location.href="<%=basePath%>attence/getSignInfo";
		    		});
		    	}
		    },
		    error:function(msg){
		    	layer.msg("提交失败了-_-!")
		    }
        });
        
      });
    } else if(obj.event === 'edit'){
      /* layer.alert('编辑行：<br>'+ JSON.stringify(data)) */
      sessionStorage.setItem("metting", JSON.stringify(data));
     var index = layer.open({
		  type: 2,
		  title:'编辑',
		  content: '<%=basePath%>html/editMetting.html',
		  area: ['500px', '500px'],
		  maxmin: false,
		  cancel: function(){ 
			    //右上角关闭回调
			     window.location.href="<%=basePath%>attence/getSignInfo";
			    //return false 开启该代码可禁止点击该按钮关闭
			  }
		}); 
     
    }
  });
  
});
</script>
</html>