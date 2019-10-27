<%@ page import="org.springframework.ui.Model" %><%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/6
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../includes/easyui_head.jsp"/>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
</head>
<body>
<form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
<table cellpadding="10">
    <tr>
        <td>部门:</td>
        <td><sys:modal value="${employeeDto.deptId}" type="post" prompt="请选择部门" validation="true"  valueField="id" textField="name" name="deptId" url="/dept/lists"/></td>
        <td style="width: 40px"></td>
        <td>职位:</td>
        <td><sys:modal value="${employeeDto.jobId}"  type="post" prompt="请选择职位" validation="true" valueField="id" textField="name" name="jobId" url="/job/lists"/></td>
        <td style="width: 40px"><input type="hidden" name="id" value="${employeeDto.id}"></td>
        <td>姓名:</td>
        <td><input class="easyui-textbox" value="${employeeDto.name}" type="text" id="name" name="name" data-options="required:true"/></td>
    </tr>
    <tr>
        <td >生日:</td>
        <td><input value="${employeeDto.birthday}" id="birthday" name="birthday" class="easyui-datetimebox"></td>
        <td style="width: 40px"></td>
        <td>邮政编码:</td>
        <td><input id="post_code" value="${employeeDto.postCode}" class="easyui-textbox"  type="text" name="postCode" data-options="required:false"/></td>
        <td style="width: 40px"></td>
        <td>QQ号:</td>
        <td><input class="easyui-textbox" value="${employeeDto.qqNum}"  type="text" id="qq_num" name="qqNum" data-options="required:false,validType:'length[6,10]'"/></td>
    </tr>
    <tr>
        <td >学历:</td>
        <td><sys:modal value="${employeeDto.education}" prompt="请选择学历" validation="false" valueField="name" textField="name" name="education" url="/static/Json/education.json"/></td>
        <td style="width: 40px"></td>
        <td>邮箱地址:</td>
        <td><input class="easyui-textbox" value="${employeeDto.email}" type="text" id="email" name="email" data-options="required:true,validType:'email'"/></td>
        <td style="width: 40px"></td>
        <td>爱好:</td>
        <td><input class="easyui-textbox" value="${employeeDto.hobby}" type="text" id="hobby" name="hobby" data-options="required:false"/></td>
    </tr>
    <tr>
        <td >地址:</td>
        <td><input class="easyui-textbox" value="${employeeDto.address}" type="text" id="address" name="address" data-options="required:true"/></td>
        <td style="width: 40px"></td>
        <td>身份证号:</td>
        <td><input class="easyui-textbox" value="${employeeDto.cardId}" type="text" name="cardId" data-options="required:true,validType:'length[10,18]'"/></td>
        <td style="width: 40px"></td>
        <td>专业:</td>
        <td><input class="easyui-textbox" value="${employeeDto.speciality}" type="text"  name="speciality" data-options="required:false"/></td>
    </tr>
    <tr>
        <td >性别:</td>
        <td><sys:modal value="${employeeDto.sex}" prompt="请选择性别" validation="true" valueField="id" textField="name" name="sex" url="/static/Json/sex.json"/></td>
        <td style="width: 40px"></td>
        <td>手机号:</td>
        <td><input class="easyui-textbox" value="${employeeDto.phone}" type="text" id="phone" name="phone" data-options="required:true,validType:'length[7,11]'"/></td>
        <td style="width: 40px"></td>
        <td>民族:</td>
        <td><sys:modal value="${employeeDto.race}" prompt="请选择民族" validation="false" valueField="name" textField="name" name="race" url="/static/Json/race.json"/></td>
    </tr>
    <tr>
        <td >党派:</td>
        <td><sys:modal value="${employeeDto.party}" prompt="请选择党派" validation="false" valueField="name" textField="name" name="party" url="/static/Json/party.json"/></td>
        <td style="width: 40px"></td>
        <td>备注:</td>
        <td><input class="easyui-textbox" value="${employeeDto.remark}"  multiple="multiple" type="text" id="remark" name="remark" data-options="required:false,multiline:true"></input></td>
    </tr>
</table>
<div id="dlg-buttons" style="text-align: center;margin-top: 45px">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser('/emp/save')" style="width:120px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c7" iconCls="icon-back_red" onclick="history.go(-1)" style="width:120px">取消</a>
</div>
</form>
</body>
<script>
    function saveUser(url){
        $('#fm').form('submit',{
            url: url,
            dataType:"json",
            contentType:"application/json",
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(data){
                var result = eval('('+data+')');
                if (result.status == 200) {
                    $.messager.confirm('提示信息', result.message, function(r){
                        if (r){
                            location.href = "${pageContext.request.contextPath}/emp/page";
                        }
                    });
                } else {
                    $.messager.alert("错误提示", result.message, "error");
                }
            }
        });
    }
</script>
</html>
