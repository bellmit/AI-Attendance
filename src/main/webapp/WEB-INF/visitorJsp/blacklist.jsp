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
<title>黑名单管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
</head>
<body>
<div class="page-container">
	<c:if test="${msg !=null }">
	<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
	<div class="demoTable">
 <div class="layui-inline">
    关键字搜索：
        <select style="width: 100px;height: 36px;" id="visitInfoSereach" lay-verify="required">
          <option value="visitorId">身份证号</option>
          <option value="visitorName">姓名</option>
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload">搜索</button>
</div>
<div class="tabaleChange">
<table class="layui-table" lay-data="{width:1146 ,  url:'<%=basePath%>vistor/getblackList', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      
      <th lay-data="{field:'id', width:180, sort: true}">身份证号</th>
      <th lay-data="{field:'visitorname', width:100}">姓名</th>
      <th lay-data="{field:'idphotoBase', width:150}">证件照</th>
      <th lay-data="{field:'cameraphotoBase', width:150}">现场照</th>
      <th lay-data="{field:'birthday', width:150}">生日</th>
      <th lay-data="{field:'address', width:230}">家庭住址</th>
      <th lay-data="{width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
</div>	
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>

</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">撤销黑名单</a>
  </script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
     /* layer.msg('ID：'+ data.id + ' 的查看操作') */
     $.ajax({
    	 type:'POST',
    	 url:'<%=basePath%>vistor/setblack?visitorId='+data.id,
    	 dataType:"text",
 		 success:function(data){
 		   layer.msg('提交成功' , {time:1000}, function(){
 		    		window.location.href="<%=basePath%>vistor/blacklist";
 		    		});
 		    	
 		    },
 		    error:function(msg){
 		    	layer.msg("提交失败了-_-!")
 		    }
     });
    	
    } else if(obj.event === 'del'){
      layer.confirm('确认删除行？', function(index){
    	  $.ajax({
    		  type:'POST',
    		  url:'<%=basePath%>vistor/deleteVisitInfo?visitId='+data.id
    	  });
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
  var $ = layui.$, active = {
    reload: function(){
      var demoReload = $('#demoReload');
      
     var visitInfoSereach  = document.getElementById("visitInfoSereach").value;
     
     if(visitInfoSereach == 'visitorId'){
    	
      //执行重载
      table.reload('idTest', {
    	 
        page: {
          curr: 1 //重新从第 1 页开始
        },
        url:'<%=basePath%>vistor/getblackById'
         ,where: {
        	 visitorId :  demoReload.val()
        } 
       
      });
      visitInfoSereach = "";
     }else if(visitInfoSereach == 'visitorName'){
    	
    	//执行重载
         table.reload('idTest', {
       	 
           page: {
             curr: 1 //重新从第 1 页开始
           },
           url:'<%=basePath%>vistor/getblackByName'
            ,where: {
            	visitorName :  demoReload.val()
           } 
           
         });
         visitInfoSereach = "";
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