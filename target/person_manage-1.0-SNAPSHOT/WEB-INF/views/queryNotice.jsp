<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/4
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告查询</title>
    <jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body>
<table id="dg" title="用户列表" style="width:99%;height:380px"
       data-options="rownumbers:true,singleSelect:true,pagination:true,url:'/notice/lists',method:'get'">
    <thead>
    <tr>
        <th  data-options="field:'id',checkbox:true"></th>
        <th data-options="field:'name',width:150">公告名称</th>
        <th data-options="field:'title',width:400">公告主题</th>
        <th data-options="field:'content',width:800">公告内容</th>
    </tr>
    </thead>

</table>


<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            buttons:[{
                iconCls:'icon-search',
                text:'查看',
                handler:function(){
                    Previews();
                }
            }]
        });
    })

    function Previews() {
        var cbId=0;
        var checkbox=$('input[name="id"]');
        //获取选中的checkbox的value,value值等于数据库的id的值
        checkbox.each(function () {
            var id =$(this).attr("value");
            if (id != null && id != "undefine" && $(this).is(":checked")) {
                cbId = id;
            }
        });
        if (cbId!=0) {
            var url="${pageContext.request.contextPath}/notice/previews?id="+cbId.toString();
            location.href = url;
        }
    }

</script>


</body>
</html>
