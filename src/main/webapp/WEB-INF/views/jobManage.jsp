<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/6
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../includes/easyui_head.jsp"/>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
</head>
<body>

<table id="dg" title="职位管理" style="width:99%;height:400px"
       toolbar="#toolbar" pagination="true" idField="id"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="name" width="50" editor="{type:'validatebox',options:{required:true}}">职位名称</th>
        <th field="remark" width="80%" editor="{type:'validatebox'}">职位简介</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit01" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">新建</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-delete" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save01" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel01" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">取消</a>
</div>
<script type="text/javascript">
    $(function(){
        $('#dg').edatagrid({
            url: '/job/lists',
            saveUrl: '/job/add',
            updateUrl: '/job/update',
            destroyUrl: '/job/del'
        });
    });
</script>

</body>
</html>