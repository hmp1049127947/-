<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body>
<div style="margin: 0px">
    <table id="dg" title="员工管理" class="easyui-datagrid" style="width:2500px;height:350px"
           url="/emp/lists"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="deptName" width="40">部门</th>
            <th field="jobName" width="60">职位</th>
            <th field="name" width="40">姓名</th>
            <th field="cardId" width="100">身份证号</th>
            <th field="address" width="100">地址</th>
            <th field="phone" width="50">手机号</th>
            <th field="email" width="80">邮箱地址</th>
            <th field="gender" width="20">性别</th>
            <th field="birthday" width="100">生日</th>
            <th field="createDate" width="100">创建时间</th>
            <th field="postCode" width="40">邮政编码</th>
            <th field="qqNum" width="80">QQ号</th>
            <th field="race" width="50">民族</th>
            <th field="education" width="30">学历</th>
            <th field="speciality" width="80">专业</th>
            <th field="hobby" width="100">爱好</th>
            <th field="remark" width="100">备注</th>

        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-new01" plain="true" onclick="newUser()">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit01" plain="true" onclick="editUser()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-delete" plain="true" onclick="destroyUser()">删除</a>
    </div>
</div>



<script type="text/javascript">
    var url;
    function newUser(){
        location.href = "${pageContext.request.contextPath}/emp/operate";
    }
    function editUser(){
        var row = $('#dg').datagrid('getSelected');
        console.log(row.id);
        if (row){
            location.href = '${pageContext.request.contextPath}/emp/operate?id='+row.id;
        }
    };

    function destroyUser(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('温馨提示','你确定要删除这条数据吗?',function(r){
                if (r){
                    $.post('${pageContext.request.contextPath}/emp/delete',{id:row.id},function(result){
                        if (result.status==200){
                            $.messager.confirm('提示信息', result.message, function(r){
                                if (r){
                                    $('#dg').datagrid('reload');
                                }
                            });
                        } else {
                            $.messager.show({
                                title: '错误提示',
                                msg: result.message
                            });
                        }
                    },'json');
                }
            });
        }
    }
</script>
</body>
</html>