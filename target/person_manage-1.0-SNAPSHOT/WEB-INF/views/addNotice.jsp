<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="../includes/easyui_head.jsp"/>
	<script type="text/javascript" charset="utf-8" src="/static/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="/static/ueditor/ueditor.all.min.js">
	</script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="/static/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<!--/XJXYProject得到当前应用的名称  -->
	<form id="ff" method="post" action="add">
		<table cellpadding="7">
			<tr>
				<td>公告名称:</td>
				<td><input class="easyui-textbox" id="name" type="text" name="name"
					data-options="required:true" style="width: 300px; height: 25px"></td>
				<td>公告主题:</td>
				<td><input class="easyui-textbox" type="text" id="title" name="title"
						   style="width: 300px; height: 25px" data-options="required:true"></td>
			</tr>

		</table>
		<textarea id="container" name="content"
				  style="width: 100%; height: 230px;"> </textarea>
			<br>
		<a href="javascript:void(0)" class="easyui-linkbutton c1"  onclick="submitForm()" style="width:100px">保存</a>
	</form>
</body>
<script >
    var ue = UE.getEditor("container");
    function submitForm(){
        $('#ff').form('submit',{
            onSubmit:function(){
                var flag= $(this).form('enableValidation').form('validate');
                if (ue.hasContents()==false) {
                    $.messager.alert("提示信息", "公告内容不能为空");
                    flag=false
                }
                return flag;
            },
            success:function (data) {
                var data = eval('(' + data + ')');
                console.log(data);
                if (data.status == 200) {
                    $.messager.alert('提示信息', data.message, 'info');
                } else {
                    $.messager.alert('提示信息', data.message, 'error');
                }
            }
        });
    }
</script>
</html>