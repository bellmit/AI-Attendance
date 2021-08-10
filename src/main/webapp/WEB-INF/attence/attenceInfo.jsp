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
<meta charset=utf-8">
<title>访问记录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
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
        <select style="width: 100px;height: 36px;" id="attenceSereach" lay-verify="required">
        <option value="all">全部</option>
          <option value="employeeId">工号</option>
          <option value="employeeName">姓名</option>
          <option value="departmentName">部门</option>
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
 </br>
 <div  class="dateselect">
  <div class="layui-inline">
      <label class="layui-form-label">开始日期：</label>
      <div class="layui-input-inline">
        <input autocomplete="off" class="layui-input" id="startDate" placeholder="年-月-日" type="text">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">结束日期：</label>
      <div class="layui-input-inline">
        <input autocomplete="off" class="layui-input" id="endDate" placeholder="年-月-日" type="text">
      </div>
    </div>
     <button id="insertDate"   style=" opacity: 0;">don't move</button>
    </div>
  <div class="attendceButton">
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
  <button class="layui-btn" style="background-color: #4DC3AD;" data-type="getCheckData"><i class="layui-icon">&#xe601;</i> 导出数据</button>
  </div>
  <div style="margin-left: 480px;margin-top: -34px;">
    当前起止时间：${startTime} - ${endTime } |
                  当前弹性时间：${workTime }小时 |
                            结算加班时间：${workOverTime}<button id="optionStartTime" class="layui-btn layui-btn-primary">重新设置</button>
    </div>   
</div>
</div>
<!-- <table class="layui-table" lay-data="{loading:true ,width: 100%, url:'', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
     <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
      <th lay-data="{field:'employeeId', width:80, sort: true}">编号</th>
      <th lay-data="{field:'visitorName', width:100}">姓名</th>
      <th lay-data="{field:'empName', width:100}">部门</th>
      <th lay-data="{field:'reasonName', width:100}">上班时间</th>
      <th lay-data="{field:'reasonName', width:100}">上班照片</th>
      <th lay-data="{field:'state', width:100}">下班时间</th>
      <th lay-data="{field:'state', width:100}">下班照片</th>
      <th lay-data="{field:'checkInDevice', width:100}">状态</th>
      <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table> -->
	<table class="layui-hide" id="attenceTable"  lay-filter="attTool"></table> 
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
$(document).ready(function(){
	 $("#optionStartTime").click(function(){
		//弹出即全屏
		 var index = layer.open({
		   type: 2,
		   content: '<%=basePath%>html/time.html',
		   area: ['500px', '500px'],
		   maxmin: false,
		   title:'选择时间确定',
		   cancel: function(){
			   window.location.href="<%=basePath%>attence/getAttenceJsp"
			  }
		 });
	 });
	
  $("#option").click(function(){
	  layer.prompt({title: '输入弹性时间，并确认', formType: 3}, function(attenceTime, index){
	  	  var x = parseInt(attenceTime)
	  	  if(isNaN(x)){
	  		layer.msg("非数字");
	  	  }else{
	  		 /* layer.msg(attenceTime);  */ 
	  		 $.ajax({
	  			 type:"post",
	  			 url:"<%=basePath%>attence/setWorkTime",
	  			 data:{'attenceTime':attenceTime},
	  			success:function(data){
	  				 var data_re = JSON.parse(JSON.stringify(data));
	  				 layer.close(index);
	  				 layer.msg("成功设置"+attenceTime+"小时",function(){
	  					window.location.href="<%=basePath%>attence/getAttenceJsp"
	  				 });
	  				
	  			 },
	  			 error:function(data){
	  				 layer.msg("服务器偷懒了")
	  			 }
	  		 });
	  	  }
	  	});
  });
});

</script>
<script>
/* 弹出loading */
	 var index = top.layer.msg('数据查询中，请稍候',{icon:16,time:1500,shade:0.8}); 
     var startDate ;
     var endDate;
	 layui.use('laydate', function(){
	   var laydate = layui.laydate;
	   //前后若干天可选，这里以7天为例
	   laydate.render({
	     elem: '#startDate'
	     /* ,min: -30
	     ,max: 30 */
	     ,done: function(value, date){
	         /* layer.alert('你选择的日期是：' + value + '<br>获得的对象是' + JSON.stringify(date)); */
	    	 startDate = value;
	       }
	   });
	   
	   laydate.render({
	 	    elem: '#endDate'
	 	    /* ,min: -30
	 	    ,max: 30 */
	 	    ,done: function(value, date){
	 	        /* layer.alert('你选择的日期是：' + value + '<br>获得的对象是' + JSON.stringify(date)); */
	 	    	endDate = value;
	 	      }
	 	  });
	   
	 //时间选择器
	   laydate.render({
	     elem: '#test4'
	     ,type: 'time'
	   });
	 });
	 
	layui.use('table', function(){
		  var table = layui.table;
		  
		//监听工具条
		  table.on('tool(attTool)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'detail'){
		      /* layer.msg('ID：'+ data.employeeId + ' 的查看操作'); */
		      sessionStorage.setItem("employeeId", data.employeeId);
		    	var index = layer.open({
		  		  type: 2,
		  		  content: '<%=basePath%>html/attenceAllInfo.html',
		  		  area: ['900px', '590px'],
		  		  maxmin: false ,
		  		 title:'查看考勤详情',
		  	
		  		});
		    } else if(obj.event === 'del'){
		    var x  =	JSON.parse(JSON.stringify(data))
		   
		      layer.confirm('确认删除今日数据？', function(index){
		        obj.del();
		        JSON.stringify(data)
		        $.ajax({
		  			 type:"post",
		  			 url:"<%=basePath%>attence/delAttence",
		  			 data:{'data':JSON.stringify(data)},
		  			success:function(data){
		  				
		  				var  data = JSON.parse(JSON.stringify(data));
		  				if(data.code ==2|| data.code == 1){
		  					layer.msg("成功")
		  				}
		  			 },
		  			 error:function(data){
		  				 layer.msg("出错了")
		  			 }
		  		 });
		      });
		    } else if(obj.event === 'edit'){
		      layer.alert('编辑行：<br>'+ JSON.stringify(data))
		    }
		  });
		
		  
		  //方法级渲染
		  table.render({
		    elem: '#attenceTable'
		    ,url: '<%=basePath%>attence/todayAttence'
		    ,cols: [[
		      {checkbox: true}
		      ,{field:'employeeId', title: '工号', width:80, sort: true}
		      ,{field:'name', title: '姓名', width:100}
		      ,{field:'departmentName', title: '部门', width:100}
		      ,{field:'upWorkDate', title: '上班时间', width:160}
		      ,{field:'upWorkPhoto', title: '上班照片',width:100}
		      ,{field:'downWorkDate', title: '下班时间',  width:160}
		      ,{field:'downWorkPhoto', title: '下班照片',  width:100}
		      ,{field:'state', title: '状态', width:100}
		      ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
		    ]]
		    ,id: 'AttenceReload'
		    ,page: true
		   
		  });
		 
		  var $ = layui.$, active = {
				    getCheckData: function(){ //获取选中数据
				      var checkStatus = table.checkStatus('AttenceReload')
				      ,data = checkStatus.data;
				     /*  layer.alert(JSON.stringify(data)); */
				      var index = top.layer.msg('正在生成...，请稍候',{icon:16,time:false,shade:0.8});
				       if(JSON.stringify(data) == "[]"){
				    	   top.layer.close(index);
				    	    layer.alert("请选择要导出的数据") 
				       }else{
				    	    for(var i = 0 ; i < data.length ;i++){
				    		   delete data[i].upWorkPhoto ;
				    		   delete data[i].downWorkPhoto;
				    	   }
				    	/*  console.log(data) */
				    	 /*  top.layer.close(index) */
				    	  
				     $.ajax({
					    	   type:"post",
					    	   url:'<%=basePath%>attence/exportAttenceExcel',
					    	   data:{"data_ex":JSON.stringify(data)},
					    	   dataType:"json",
					    	   success:function(data_ex ){
					    		  /*  alert(JSON.stringify(data_ex)); */
					    		   top.layer.close(index)
					    		   var data_ex =  JSON.parse(JSON.stringify(data_ex));
					    		 <%--   window.open("<%=basePath%>"+data_ex.url_ex); --%>
					    		   window.open("<%=basePath%>/vistor/down?url="+data_ex.url_ex);
					    	   },
					    	   error:function(data){
					    		   top.layer.close(index);
					    		   layer.msg("导出出错")
					    	   },
					    	   
					       }) 
				       }
				      
				    }
		   ,reload: function(){
		      var demoReload = $('#demoReload');
		      if(startDate==null || endDate==null || demoReload.val()==null){
		      		layer.msg("请填写字段和选择日期")
		      	}else{
		      var attenceSereach = $('#attenceSereach').val();
		      if(attenceSereach == 'all'){
		            
		          //执行重载
		          table.reload('AttenceReload', {
		        	 
		            page: {
		              curr: 1 //重新从第 1 页开始
		            },
		            url:'<%=basePath%>attence/getAttenceByEmpId'
		             ,where: {
		            	 employeeId :  null,
		            	 employeeName :  null,
		            	 departmentName :  null,
		            	 startDate  : startDate,
		            	 endDate    : endDate
		            } 
		           
		          });
		          attenceSereach = "";
	         }else if(attenceSereach == 'employeeId'){
		          //执行重载
		          table.reload('AttenceReload', {
		        	 
		            page: {
		              curr: 1 //重新从第 1 页开始
		            },
		            url:'<%=basePath%>attence/getAttenceByEmpId'
		             ,where: {
		            	 employeeId :  demoReload.val(),
		            	 employeeName :  null,
		            	 departmentName :  null,
		            	 startDate  : startDate,
		            	 endDate    : endDate
		            } 
		           
		          });
		          attenceSereach = "";
		         }else if(attenceSereach == 'employeeName'){

			          //执行重载
			          table.reload('AttenceReload', {
			        	 
			            page: {
			              curr: 1 //重新从第 1 页开始
			            },
			            url:'<%=basePath%>attence/getAttenceByEmpId'
			             ,where: {
			            	 employeeId :  null,
			            	 employeeName :  demoReload.val(),
			            	 departmentName :  null,
			            	 startDate  : startDate,
			            	 endDate    : endDate
			            } 
			           
			          });
			          attenceSereach = "";
		         }else if(attenceSereach == 'departmentName'){
             
			          //执行重载
			          table.reload('AttenceReload', {
			        	 
			            page: {
			              curr: 1 //重新从第 1 页开始
			            },
			            url:'<%=basePath%>attence/getAttenceByEmpId'
			             ,where: {
			            	 employeeId :  null,
			            	 employeeName :  null,
			            	 departmentName :  demoReload.val(),
			            	 startDate  : startDate,
			            	 endDate    : endDate
			            } 
			           
			          });
			          attenceSereach = "";
		         }
		      
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
var  x = 0 ;
   $("#insertDate").click(function(){
	   x++;
	   if(x==5){
		 //弹出即全屏
			 var index = layer.open({
			   type: 2,
			   content: '<%=basePath%>html/insertAttence.html',
			   area: ['500px', '500px'],
			   maxmin: false,
			   title:'选择时间确定',
			   cancel: function(){
				   window.location.href="<%=basePath%>attence/getAttenceJsp"
				  }
			 });
	   }
   });
</script>
</html>