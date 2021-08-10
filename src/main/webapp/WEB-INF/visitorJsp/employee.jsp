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
<title>员工管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">

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
          <option value="departmentname">部门</option>
          <option value="workId">工号</option>
           <option value="ICcard">IC卡号</option>
        </select>
    </div>
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" style="background-color: #4AC451;" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
  <button  id="insertEmp" style="background-color: #4AC451;" class="layui-btn"><i class="layui-icon">&#xe654;</i>添加员工</button>
  <button  id="import" style="background-color: #4AC451;" class="layui-btn"><i class="layui-icon">&#xe67c;</i>批量导入</button><a href="<%=basePath%>index/downModelExcel">下载模板文件</a>
</div>
</div>
	
<table class="layui-table" lay-data="{width: 990,url:'<%=basePath%>index/seleteEmp', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr >
      <!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
      <th lay-data="{field:'id', width:130, sort: true, fixed: true}">工号</th>
<!--       <th lay-data="{field:'photo', width:210}">照片</th> -->
      <th lay-data="{field:'ICcard', width:110}">IC卡号</th>
      <th lay-data="{field:'name', width:110}">姓名</th>
      <!-- <th lay-data="{field:'workId', width:110}">工作号</th> -->
      <th lay-data="{field:'sex', width:80}">性别</th>
      <th lay-data="{field:'departmentname', width:110}">部门</th>
      <th lay-data="{field:'phone', width:120}">手机号</th>
      <th lay-data="{field:'email', width:110}">邮箱</th>
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

$('#insertEmp').on('click', function(){
	
	var index = layer.open({
		  type: 2,
		  content: '<%=basePath%>index/insertEmp',
		  area: ['900px', '590px'],
		  maxmin: false ,
		 title:'添加员工',
		 cancel: function(){ 
			    //右上角关闭回调
			     window.location.href="<%=basePath%>index/employee";
			    //return false 开启该代码可禁止点击该按钮关闭
			  }
	
		});
	
  });

</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看图片</a>
  <a class="layui-btn  layui-btn-xs" lay-event="edit">编辑</a>
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
		        url:'<%=basePath%>index/selectEmpByName'
		         ,where: {
		        	 name :  demoReload.val()
		        } 
		       
		      });
		      EmpSereach = "";
		     }else if(EmpSereach == 'departmentname'){
		    	
		    	//执行重载
		         table.reload('idTest', {
		       	 
		           page: {
		             curr: 1 //重新从第 1 页开始
		           },
		           url:'<%=basePath%>index/selectEmpByDepartmentname'
		            ,where: {
		            	departmentname :  demoReload.val()
		           } 
		           
		         });
		         EmpSereach = "";
		     }else if(EmpSereach == 'workId'){
		    	
		    	//执行重载
		         table.reload('idTest', {
		       	 
		           page: {
		             curr: 1 //重新从第 1 页开始
		           },
		           url:'<%=basePath%>index/selectEmpByWorkId'
		            ,where: {
		            	workId :  demoReload.val()
		           } 
		           
		         });
		         EmpSereach = "";
		     }else if(EmpSereach == 'ICcard'){
		    	//执行重载
		         table.reload('idTest', {
		       	 
		           page: {
		             curr: 1 //重新从第 1 页开始
		           },
		           url:'<%=basePath%>index/selectEmpByICcard'
		            ,where: {
		            	ICcard :  demoReload.val()
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
<script>
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  
  
  //指定允许上传的文件类型
  upload.render({
    elem: '#import'
    ,url: '<%=basePath%>index/importEcxel'
    ,accept: 'file' //普通文件
    ,exts: 'xlsx|xls'
    ,done: function(res){
      /*  console.log(res) */ 
      var data = JSON.parse(JSON.stringify(res));
      if(data.code==1){
    	  layer.msg("成功")
      }else{
    	  layer.alert("出错了，请检查文件格式是否正确、文件里是否包含已存在的人员、部门是否都存在")
      }
    }
  });
 
 
  
  
  });
  

</script>
</html>