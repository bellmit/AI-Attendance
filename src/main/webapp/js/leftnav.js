$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:ctx+"/sys/getmenus",
		dataType:"json",
		success:function(data){
			console.log(data)
			for(var i = 0 ; i < data.length ; i ++){
				$("#menus").append(
						'<dl  id="menu-live" style="margin-top: 4px;">' + 
						'<dt>' +' <img width="20" alt="" src="${ctx}/img/icon/1.png">'+
						"管理员" + '<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;'+'</i>' +
						'</dt>'+
						'<dd>' +
						'<ul>'+ 
						'<li>'+
						'<a  style="border: 1px solid #C8C8C8; border-radius: 10px;" '+
						'data-href="${ctx}/user/getadminconfig" '+
						'data-title="角色管理" href="javascript:void(0)">' +
						'<img alt="" width="20"src="${ctx}/img/icon/2.png"> '
						+"&nbsp;&nbsp;角色管理"
							+'</a>'+
						'</li>'+
						'</ul>'+
						'</dd>'+
						'</dl>'
				);
			}
		},
		error:function(data){
		   layer.alert("error")
		}
	});
 
});
