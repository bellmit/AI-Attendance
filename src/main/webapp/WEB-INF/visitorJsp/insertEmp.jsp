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
<title>添加员工</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>layer/theme/default/layer.css">
<link rel="stylesheet" href="<%=basePath%>css/attdence.css">
<script type="text/javascript"  src="<%=basePath%>layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script src="<%=basePath%>js/jquery.webcam.js" ></script>
<script src="<%=basePath%>layer/layer.js"></script>
</head>
<body>
<article class="page-container">
   <div class="webcams">
			<!--<button class="play">拍照</button>
			  <button class="save">保存</button>-->
			<div id="status"></div>
			<div id="webcam"></div>
			<button class="layui-btn-2  play">拍照</button>
			<div class="Scanvas" id="Scanvas"></div>
		</div>
		
<form class="layui-form"   action="<%=basePath%>index/insertEmp"  method="post" style="margin-left: 300px;margin-top: -520px;">
	<div class="layui-form-item">
	<div class="layui-form-item">
				<label class="layui-form-label"><span style="color:red">*</span> IC卡号：</label>
				<div class="layui-input-block">
					<input name="ICcard" lay-verify="required" placeholder="确保刷卡器连接"
						autocomplete="off" class="layui-input layui-inputPersonadd" type="text">
				</div>
			</div>
				<label class="layui-form-label"><span style="color:red">*</span> 姓名：</label>
				<div class="layui-input-block">
					<input name="name" lay-verify="required" placeholder="请输入姓名"
						autocomplete="off" class="layui-input layui-inputPersonadd" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span style="color:red">*</span> 工号：</label>
				<div class="layui-input-block">
					<input name="id" lay-verify="required" placeholder="请填写工号（无工号可写身份证号，电话号等）"
						autocomplete="off" class="layui-input layui-inputPersonadd" type="text">
				</div>
			</div>
			<div class="layui-form-item" pane="">
				<label class="layui-form-label"><span style="color:red">*</span> 性别：</label>
				<div class="layui-input-block">
					<input name="sex" value="男" title="男" checked="" type="radio">
					<input name="sex" value="女" title="女" type="radio">
				</div>
			</div>
		<div class="layui-form-item">
			<label class="layui-form-label"><span style="color:red">*</span> 部门 ：</label>
			<div class="layui-input-block">
				<select name="departmentId" lay-verify="required">
					<option value=""></option>
					<c:forEach var="ld" items="${ld}">
					<option  value="${ld.departmentId }">${ld.departmentName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label"><span style="color:red">*</span> 手机号：</label>
				<div class="layui-input-block">
					<input name="phone" lay-verify="required|phone" placeholder="请输入手机号"
						autocomplete="off" class="layui-input layui-inputPersonadd" type="text">
				</div>
			</div>
		<div class="layui-inline">
			<label class="layui-form-label">邮箱 :</label>
			<div class="layui-input-inline">
				<input name="email"  placeholder="非必填项" autocomplete="off"
					class="layui-input" type="text">
			</div>
		</div>
		<div class="layui-upload" style="margin-left: 50px;margin-top: 10px;">
			<button type="button" class="layui-btn" id="test8">选择图片</button>
			<div class="layui-upload-list">
				<img width="210" height="210" class="layui-upload-img" id="demo1">
			</div>
		</div>
          <input name="canvas" id = "canvasId" style="display: none">
		<div class="layui-form-item">
    <div class="layui-input-block" style="margin-top: 20px;">
      <button class="layui-btn" lay-submit="" lay-filter="insertEmp">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>	
	<c:if test="${msg != null }">
    <script>layer.alert('${msg}'); 
    </script>
</c:if>	
</article>
<c:if test="${user != 'admin' }">
  <script src="<%=basePath%>js/nocode.js" ></script>
</c:if>
</body>
<script>
layui.use(['form'], function(){
  var form = layui.form
  //监听提交
  form.on('submit(insertEmp)', function(data){
	  var index = top.layer.msg('数据提交中，正在进行人脸检测，请稍候',{icon: 16,time:2000,shade:0.8});
	  /* if(msg!=null){
		  top.layer.close(index);
	  } */
	  var dataobj = JSON.parse(JSON.stringify(data.field));
// 	  alert(dataobj.canvas)
	  if(dataobj.canvas == null || dataobj.canvas == "" ){
		 layer.alert("请拍照或者上传图片！");
	  }else{
     /* layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })  */
    
	  }
    return true;
  });
  
  
});
</script>
<script>
    var w = 320, h = 240;                                       //摄像头配置,创建canvas
    var pos = 0, ctx = null, saveCB, image = [];
    var canvas = document.createElement("canvas");
    $("#Scanvas").append(canvas);
    canvas.setAttribute('width', w);
    canvas.setAttribute('height', h);
    ctx = canvas.getContext("2d");
    image = ctx.getImageData(0, 0, w, h);

    $("#webcam").webcam({
        width: w,
        height: h,
        mode: "callback",                       //stream,save，回调模式,流模式和保存模式
        swffile: "<%=basePath%>js/jscam_canvas_only.swf",
        onTick: function(remain) { 
            if (0 == remain) {
                $("#status").text("拍照成功!");
            } else {
                $("#status").text("倒计时"+remain + "秒钟...");
            }
        },
        onSave: function(data){              //保存图像
            var col = data.split(";");
            var img = image;
            for(var i = 0; i < w; i++) {
                var tmp = parseInt(col[i]);
                img.data[pos + 0] = (tmp >> 16) & 0xff;
                img.data[pos + 1] = (tmp >> 8) & 0xff;
                img.data[pos + 2] = tmp & 0xff;
                img.data[pos + 3] = 0xff;
                pos+= 4;
            }
            if (pos >= 4 * w * h) {
                ctx.putImageData(img,0,0);      //转换图像数据，渲染canvas
                pos = 0;
                  
                //Imagedata=canvas.toDataURL().substring(22);  //上传给后台的图片数据
            }
        },
        onCapture: function () {               //捕获图像
            webcam.save();      
        },
        debug: function (type, string) {       //控制台信息
            console.log(type + ": " + string);
        },
        onLoad: function() {                   //flash 加载完毕执行
            console.log('加载完毕！')
            var cams = webcam.getCameraList();
            
        }
    });  

    $(".play").click(function(){
        webcam.capture(0);        //拍照，参数是倒计时
        
        var  images  = canvas.toDataURL("image/png");
//         alert(images)
      document.getElementById("canvasId").value = images;
        if(images != null){
        	document.getElementById("imagecanvas").value  = images;	
        }
    });
    $("#save").click(function(){
    	$.post("<%=basePath%>register/registerfaceinfo", {val: "data",w:w,h:h,image: canvas.toDataURL("image/png")},function(){  
            
        });
    });
</script>
<script>
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  
///选完文件后不自动上传
  upload.render({
	    elem: '#test8'
	    ,url: '/upload/'
	    ,auto: false
	    //,multiple: true
	    ,done: function(res){
	      console.log(res)
	    }
        ,choose: function(obj){
	    //将每次选择的文件追加到文件队列
	    var files = obj.pushFile();
	    //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
	    obj.preview(function(index, file, result){
	      console.log(result); //得到文件base64编码，比如图片
	      $('#demo1').attr('src', result); //图片链接（base64）
	      $('#canvasId').val(result);
	    });
	  }
	  });

});
 
</script>
</html>