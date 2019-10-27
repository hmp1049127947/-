<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body>
<c:if test="${baseResult!=null}">
	<div id="dlg" class="easyui-dialog" title="信息提示" data-options="iconCls:'icon-tip'" style="width:200px;height:100px;padding:10px">
			${baseResult.message}
	</div>
</c:if>
<div id="tb" style="padding:5px;height:auto">
	<div>
		<input    title="查询"  class="easyui-searchbox" data-options="prompt:'手机号，账号或者用户名',searcher:doSearch" style="width:200px;height:28px;"/> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" style="height:25px;" data-options="iconCls:'icon-delete'" onclick="App.delMulti('delete')">删除</a>
		<a href="#" class="easyui-linkbutton" id="edit" style="height:25px;" data-options="iconCls:'icon-edit01'"  onclick="App.editPerson('editUser','用户修改','350px','450px',true)">修改</a>

	</div>
</div>
<table id="dg" title="用户列表" style="width:99%;height:380px"
	   data-options="rownumbers:true,singleSelect:false,pagination:true,url:'${url}',method:'get'">
	<thead>
	<tr>
		<th  data-options="field:'id',checkbox:true"></th>
		<th data-options="field:'number',width:80">账号</th>
		<th data-options="field:'username',width:100">用户名</th>
		<th data-options="field:'password',width:100">密码</th>
		<th data-options="field:'phone',width:220,align:'right'">手机号</th>
		<th data-options="field:'createdate',width:220,align:'right'">创建时间</th>
		<th data-options="field:'remark',width:240">备注</th>
	</tr>
	</thead>

</table>

<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
        $(pager).pagination({
            beforePageText: '第',//页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '显示{from}到{to}条，共{total}条记录',
        });
    })

    function doSearch(value){
        $.ajax({
			url:'/user/queryPerson' ,
			data:{'keyword':value},
			success:function () {
                location.replace("${pageContext.request.contextPath}/user/queryPerson?keyword=" + value);
            }
		});
    }

    function reFreshData() {
        $('#dg').datagrid().datagrid('getPager');
    }
</script>
</body>
<script src="../static/assets/app/app.js"></script>
</html>