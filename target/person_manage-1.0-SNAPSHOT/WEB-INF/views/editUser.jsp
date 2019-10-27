<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/2
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body>
<div style="width:350px">
    <div style="padding:20px 20px 20px 20px">
        <form  id="ff" class="easyui-form" method="get">
            <input type="hidden" id="id"  name="id" value="${user.id}">
            <table cellpadding="5">
                <tr>
                    <td>账号:</td>
                    <td><input class="easyui-textbox" type="text" id="number" name="number" value="${user.number}" data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-textbox" type="text" id="username" name="username" value="${user.username}"/></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="password" id="psw_again" name="psw_again" data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td><input class="easyui-textbox" type="text" id="phone" name="phone" value="${user.phone}"  data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td><input class="easyui-textbox" id="remark" name="remark" value="${user.remark}" data-options="multiline:true" style="height:60px"/></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>
    </div>
</div>
<script>
    function submitForm(){
        var id = $("#id").val();
        var psw = $("#password").val();
        var psw_again = $("#psw_again").val();
        var number = $("#number").val();
        var phone = $("#phone").val();
        var username = $("#username").val();
        var remark = $("#remark").val();
        if (id == "" || id == "undefine" || id == null) {
            $.messager.alert('提示信息', '操作错误', 'error');
            return;
        }
        else if (number == "" || number == "undefine" || number == null) {
            $.messager.alert('提示信息', '账号不能为空', 'error');
            return;
        }
        else if (psw == "" || psw == "undefine" || psw == null) {
            $.messager.alert('提示信息', '密码不能为空', 'error');
            return;
        }
        else if (psw_again == "" || psw_again == "undefine" || psw_again == null) {
            $.messager.alert('提示信息', '确认密码不能为空', 'error');
            return;
        }
        else if (phone == "" || phone == "undefine" || phone == null) {
            $.messager.alert('提示信息', '手机号不能为空', 'error');
            return;
        }
        if (psw == psw_again) {
            $.ajax({
                url:"/user/edit",
                type: "POST",
                data: {"id":id,"number":number,"phone":phone,"username":username,"password":psw, "remark": remark},
                dataType:"JSON",
                success:function (data) {
                    if (data.status == 200) {
                        $.messager.alert('提示信息', data.message, 'info');
                    } else {
                        $.messager.alert('提示信息', data.message, 'error');
                    }
                }

            });

        } else {
            $.messager.alert('操作错误', '两次密码不一致', 'error');
        }
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>