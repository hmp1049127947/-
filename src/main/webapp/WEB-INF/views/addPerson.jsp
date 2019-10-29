<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<jsp:include page="../includes/easyui_head.jsp"/>
</head>

<body >

	<div class="easyui-panel" title="添加用户" style="width:99%;height: 95%">
	    <form id="ff" method="post"  class="easyui-form" data-options="novalidate:true" >
	    	<table cellpadding="5">
				<tr>
					<td style="width: 80px"></td>
					<td>账号:</td>
					<td><input class="easyui-textbox" type="text" id="number" name="number" prompt="请输入账号" data-options="required:true" ></td>
					<td>用户名:</td>
					<td><input class="easyui-textbox" type="text" id="username"  name="username" data-options="required:false" /></td>
				</tr>
	    		<tr>
					<td style="width: 50px"></td>
	    			<td>密码:</td>
	    			<td><input id="pass" name="password" class="easyui-passwordbox" prompt="请输入密码"  iconWidth="28" data-options="required:true"></td>
					<td>用户角色:</td>
					<td>
						<select editable="false" class="easyui-combobox" name="status" style="width:171px;">
							<option value="1">普通用户</option>
							<option value="2">管理员</option>
							<option value="3">超级管理员</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
					<td style="width: 50px"></td>
	    			<td>手机号:</td>
	    			<td><input class="easyui-textbox" type="text" id="phone" prompt="请输入手机号" name="phone" data-options="required:true,validType:'length[7,11]'"></input></td>
					<td>备注:</td>
					<td><input class="easyui-textbox" name="remark" id="remark"  data-options="multiline:true" style="height:45px"></input></td>
	    		</tr>
				<tr>
					<td style="width: 50px"></td>
					<td style="width: 50px"></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 100px">确定</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 100px">重置</a>
					</td>
				</tr>
	    	</table>
	    </form>
	    </div>
</body>

<script>
    $(function () {
        $("input", $("#number").next("span")).blur(function () {
            var number = $("#number").val();
            var data={"number": number};
			$.post("/user/valid",data,function (result) {
				if (result != null) {
					//该账号已被注册
                    $("#number").textbox("setValue", "");
					$.messager.alert("温馨提示", result.message, "info");

				}
			},"json");
        });

        $("input", $("#phone").next("span")).blur(function () {
            var phone = $("#phone").val();
            var data={"phone": phone};
            $.post("/user/valid",data,function (result) {
                if (result != null) {
                    //该手机号已被注册
                    $("#phone").textbox("setValue", "");
                    $.messager.alert("温馨提示", result.message, "info");
                }
            },"json");
        });


    });
    function submitForm(){
        $('#ff').form('submit',{
            url:"/user/add",
            onSubmit:function(){
                return $(this).form('enableValidation').form('validate');
            },
            dataType: "json",
            success:function (data) {
                var data = eval('(' + data + ')');
                if (data.status == 200) {
                    $.messager.alert('提示信息', data.message, 'info');
                } else {
                    $.messager.alert('提示信息', data.message, 'error');
                }
            }
        });
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</html>