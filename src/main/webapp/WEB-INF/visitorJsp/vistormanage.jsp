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
<title>访问记录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
<script type="text/javascript"  src="<%=basePath%>js/downExls.js"></script>
</head>
<body >
<div class="page-container">
	<c:if test="${msg !=null }">
	<script> layer.alert('${msg}',{icon:7})</script>
	</c:if>
	<div class="demoTable">
 <div class="layui-inline">
    关键字搜索：
        <select style="width: 100px;height: 36px;" id="visitInfoSereach" lay-verify="required">
          <option value="visitorName">访问人</option>
          <option value="employeeName">被访问人</option>
          <option value="checkInDevice">签入设备</option>
          <option value="checkOutDevice">签出设备</option>
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="getCheckData"><i class="layui-icon">&#xe601;</i> 导出记录</button>
</div>
 
<table class="layui-table" lay-data="{loading:true ,width: 1330, url:'<%=basePath%>vistor/getvisitinfo', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
       <th lay-data="{type:'checkbox'}"></th>
      <th lay-data="{field:'id', width:80, sort: true}">编号</th>
      <th lay-data="{field:'visitorName', width:100}">访问人</th>
      <th lay-data="{field:'empName', width:100}">被访人</th>
      <th lay-data="{field:'reasonName', width:100}">访问事由</th>
      <th lay-data="{field:'state', width:100}">状态</th>
      <th lay-data="{field:'checkInDevice', width:100}">签入设备</th>
      <th lay-data="{field:'checkInTime', width:180}">签入时间</th>
      <th lay-data="{field:'checkOutDevice', width:100}">签离设备</th>
      <th lay-data="{field:'checkOutTime', width:180}">签离时间</th>
      <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
	<a download="" href="" target="blank" id="downPdf"></a>  
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
/* 弹出loading */
	var index = top.layer.msg('数据查询中，请稍候',{icon:16,time:false,shade:0.8});
	
layui.use('table', function(){
  var table = layui.table;
  if(table.index == 1){
	  top.layer.close(index);
  }
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      /* layer.msg('ID：'+ data.id + ' 的查看操作');  */
    	var index = layer.open({
    		  type: 2,
    		  content: '<%=basePath%>vistor/visiting?visitId='+data.id,
    		  area: ['900px', '500px'],
    		  maxmin: false,
    		  title:'查看详情'
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
     
     if(visitInfoSereach == 'visitorName'){
    	
      //执行重载
      table.reload('idTest', {
    	 
        page: {
          curr: 1 //重新从第 1 页开始
        },
        url:'<%=basePath%>vistor/getvisitInfoByVisitorName'
         ,where: {
        	 visitorName :  demoReload.val()
        } 
       
      });
      visitInfoSereach = "";
     }else if(visitInfoSereach == 'employeeName'){
    	
    	//执行重载
         table.reload('idTest', {
       	 
           page: {
             curr: 1 //重新从第 1 页开始
           },
           url:'<%=basePath%>vistor/getvisitInfoByEmployeeName'
            ,where: {
            	employeeName :  demoReload.val()
           } 
           
         });
         visitInfoSereach = "";
     }else if(visitInfoSereach == 'checkInDevice'){
    	
    	//执行重载
         table.reload('idTest', {
       	 
           page: {
             curr: 1 //重新从第 1 页开始
           },
           url:'<%=basePath%>vistor/getvisitInfoByCheckInDevice'
            ,where: {
            	checkInDevice :  demoReload.val()
           } 
           
         });
         visitInfoSereach = "";
     }else if(visitInfoSereach == 'checkOutDevice'){
    	//执行重载
         table.reload('idTest', {
       	 
           page: {
             curr: 1 //重新从第 1 页开始
           },
           url:'<%=basePath%>vistor/getvisitInfoByCheckOutDevice'
            ,where: {
            	checkOutTime :  demoReload.val()
           } 
           
         });
     }
      
      
    }
  };
  
  var $ = layui.$, active = {
		    getCheckData: function(){ //获取选中数据
		      var checkStatus = table.checkStatus('idTest')
		      ,data = checkStatus.data;
		      /*   layer.alert(JSON.stringify(data));  */
		       var index = top.layer.msg('正在生成...，请稍候',{icon:16,time:false,shade:0.8});
		       if(JSON.stringify(data) == "[]"){
		    	   top.layer.close(index);
		    	    layer.alert("请选择要导出的数据") 
		       }else{
		    	   
		    	  $.ajax({
			    	   type:"post",
			    	   url:'<%=basePath%>vistor/exportExcel',
			    	   data:{"data_ex":JSON.stringify(data)},
			    	   dataType:"json",
			    	   success:function(data_ex ){
			    		   top.layer.close(index)
			    		   var data_ex =  JSON.parse(JSON.stringify(data_ex));
			    		   <%-- window.open("<%=basePath%>"+data_ex.url_ex); --%>
			    		   window.open("<%=basePath%>/vistor/down?url="+data_ex.url_ex);
			    	   },
			    	   error:function(data){
			    		   top.layer.close(index);
			    		   layer.msg("导出出错")
			    	   },
			    	   
			       }) 
		       }
		      
		    }
		  };
  
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});


</script>

<script type="text/javascript">
if(!!window.ActiveXObject || "ActiveXObject" in window) {
  alert("检测到IE内核，关闭实时刷新")
}else{
            $(function () {
            	
                (function longPolling() {
                	
                    $.ajax({
                        url: "<%=basePath%>sys_login/getajax",
                       /*  data: {"timed": new Date().getTime()}, */
                        dataType: "json",
                        timeout: 5000,
                        error: function (data) {
                        	longPolling();
                        },
                        success: function (data) {
                       if(data.ajax == 1){
                    	   window.location.reload();
                    	   $.ajax({
                               url: "<%=basePath%>sys_login/getblack",
                              /*  data: {"timed": new Date().getTime()}, */
                               dataType: "text",
                               timeout: 5000,
                               error: function (data) {
                               	longPolling();
                               },
                               success: function (data) {
                               	var visitor  = JSON.parse(data);
                               	/* console.log(visitor) */
                               	
                                    if(visitor.id != ""){
                                   	 console.log(visitor.id)
                                   	 layer.alert("黑名单："+ visitorid)
                                   	 longPolling();
                                    }
                                    longPolling();
                               }

                           });
                    	   longPolling();
                       }
                       longPolling();
                         
                        }

                    });
                    

                })();


            });
}
        </script>
</html>