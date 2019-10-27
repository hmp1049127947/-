<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统</title>
	<jsp:include page="../includes/easyui_head.jsp"/>
	<script src="static/assets/app/loadImg.js"></script>
	<script src="static/assets/app/currentTime.js"></script>
</head>
<body onload="startTime()">
<div id="loading" style="position:absolute;z-index:1000;top:0px;left:0px;width:100%;height:100%;background:#FFFFFF;text-align :center;padding-top:6%;">
	<img src="static/images/loading3.gif" width="100%" height="100%">
</div>
<div class="easyui-layout" style="width:100%;height:98%;">
		<!--上面部分-->
		<div data-options="region:'north',border:false"
			style="background-image: url('static/images/topbg.gif'); height: 80px; overflow: hidden">
			<div style="position: relative;">
				<img src="static/images/top_logo.png" alt="找不到图片">
				<table style="position: absolute; right: 35px; top: 15px;">
					<tr>
						<td style="width: 25px"><img src="static/images/homepage.png" style="width: 21px;height: 21px">
						</td>
						<td style="width: 40px"><a href=""
							style="color: #FFFFFF; text-decoration: none">首页</a></td>
						<td style="width: 25px"><img src="static/images/exit.png" style="width: 21px;height: 21px"></td>
						<td style="width: 80px">
						<a href="${pageContext.request.contextPath}/logout"
							style="color: #FFFFFF; text-decoration: none">退出登录</a></td>
					</tr>
				</table>
				<div
					style="position: absolute; background-image: url('static/images/StatBarBg.png'); left: 400px; top: 47px; width: 100%; height: 33px; background-size: 100% 100%;">
					<div style="width: 100%">
						<table style="margin-left: 50px; margin-top: 7px">
							<tr>
								<td style="width: 25px"><img src="static/easyui/themes/icons/user02.png"></td>
								<td style="width: 180px">当前用户:<span style="color: red">${user.username}</span></td>
								<td style="width: 540px"></td>
								<td style="width: 25px"><img src="static/images/StatBar_time.gif"></td>
								<td id="time" style="width: 300px"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		
		<div data-options="region:'south',split:true,border:false" style="height:30px;">
			<jsp:include page="chat.jsp"/>
			&copy copyright 2019 wyu160802 | Design by
			<a href="#" style="color: blue;text-decoration-line:none">hmp</a>
		</div>
		<div data-options="region:'east',split:true" title="系统公告" style="width:100px;"></div>
		<div data-options="region:'west',split:true" title="公司人员信息管理" style="width:180px;">

			<div class="easyui-accordion" data-options="multiple:true" style="width:170px">
				<div title="用户管理" data-options="iconCls:'icon-user01plus'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search01'" id="queryPerson">用户查询</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-addUser'" id="addPerson">添加用户</a>
				</div>

				<div title="部门管理" data-options="iconCls:'icon-dept01'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-dept02'" id="queryDept">部门管理</a>
				</div>

				<div title="职位管理" data-options="iconCls:'icon-job01'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-job'" id="jobManage">职位管理</a>
				</div>

				<div title="员工管理"  data-options="iconCls:'icon-emp01'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-emp01'" id="empManage">员工管理</a>

				</div>

				<div title="公告管理" data-options="iconCls:'icon-notice01'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-notice_query'" id="queryNotice">公告查询</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-notice_add'" id="addNotice">添加公告</a>
				</div>

				<div title="下载中心" data-options="iconCls:'icon-download01'" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-download03'" id="download">文件下载</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-upload01'" id="uploadFile">文件上传</a>
				</div>
			</div>
			
		</div>
		<div  data-options="region:'center',split:true">
			<div class="easyui-tabs" style="height:100%" id="tt"></div>
		</div>
	</div>
	<script>
		$(function(){
			addTabs("#tt","用户查询","icon-search01","user/queryPerson");
			$("#addPerson").click(function(){
				addTabs("#tt","用户添加","icon-addUser","user/addPerson");
			});
			
			$("#queryPerson").click(function(){
				addTabs("#tt","用户查询","icon-search01","user/queryPerson");
			});
			
			$("#addNotice").click(function (){
				addTabs("#tt","添加公告","icon-notice_add","/notice/addNotice");
			});
            $("#queryNotice").click(function (){
                addTabs("#tt","公告查询","icon-notice_query","/notice/queryNotice");
            });
            $("#uploadFile").click(function (){
                addTabs("#tt","文件上传","icon-upload01","/file/upload");
            });
            $("#download").click(function (){
                addTabs("#tt","文件下载","icon-download03","/file/downloadLists");
            });
            $("#queryDept").click(function (){
                addTabs("#tt","部门管理","icon-dept02","/dept/queryDept");
            });
            $("#jobManage").click(function (){
                addTabs("#tt","职位管理","icon-job","/job/getJobPage");
            });
            $("#empManage").click(function (){
                addTabs("#tt","员工管理","icon-emp01","/emp/page");
            });


        });
		function addTabs(id,title,icon,url){
			var res=$(id).tabs("exists",title);
			if(res){
				$(id).tabs("select",title);
			}else{
				var content='<iframe scrolling="auto" frameborder="0" src="'
				+url+'" style="width:100%;height:100%;"><iframe>';
				
				$(id).tabs('add',{
					title: title,
					content: content,
					iconCls: icon,
					closable: true
				});
			}
			
		}
	</script>
</body>

</html>