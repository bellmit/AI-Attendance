<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加会议</title>
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="../layer/theme/default/layer.css">
<link rel="stylesheet" href="../css/attdence.css">
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script src="../js/jquery.webcam.js"></script>
<script src="../layer/layer.js"></script>
</head>
<body>
	<article class="page-container">
	<form class="layui-form" action="" method="post" style="">
		<div class="layui-form-item">
			<label class="layui-form-label">会议名称：</label>
			<div class="layui-input-block">
				<input id="name" name="mettingName" lay-verify="required"
					placeholder="请输入" autocomplete="off"
					class="layui-input layui-inputPersonadd" type="text">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">开始时间：</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="startDate" id="startDate"
						placeholder="年-月-日" type="text">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">结束时间：</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="endDate" id="endDate"
						placeholder="年-月-日" type="text">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block" style="margin-top: 20px;">
				<button class="layui-btn" lay-submit="" lay-filter="insertEmp">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	</article>
</body>

<script>
layui.use(['form','laydate'], function(){
	  var form = layui.form 
    ,laydate = layui.laydate
	  
	  //日期时间选择器
	  laydate.render({
	    elem: '#startDate'
	    ,type:'datetime'
	    ,format: 'yyyy-MM-dd HH:mm:ss'
	  });
	  //日期时间选择器
	  laydate.render({
	    elem: '#endDate'
	   ,type:'datetime'
	   ,format: 'yyyy-MM-dd HH:mm:ss'
	  });
	  //监听提交
	  form.on('submit(insertEmp)', function(data){
		  var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
		  
		  var dataobj = JSON.parse(JSON.stringify(data.field));
//	 	  alert(dataobj.canvas)
	      /* layer.alert(JSON.stringify(data.field), {
	      title: '最终的提交信息'
	    })   */ 
	   
			  $.ajax({
					 type:'post',
					 url:'<%=basePath%>attence/addmetting',
					 data:{'data':JSON.stringify(data.field)},
					 dataType:"json",
					 success:function(data_re){
						 top.layer.close(index);
					    	/* layer.alert(JSON.stringify(data_re))  */
					    	var  re_value = JSON.parse(JSON.stringify(data_re));
					    	layer.msg(re_value.msg)
					    },
					    error:function(msg){
					    	top.layer.close(index);
					    	layer.msg("提交出错了")
					    }
				  });
	    
	    return false;
	  });
	  
	  
	});
 
</script>
</script>
</html>