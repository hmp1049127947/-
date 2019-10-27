<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/5
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body id="allBody">
<table id="dg" class="table table-hover" data-options="rownumbers:true,pagination:true">
    <thead>
    <tr>
        <th style="text-align: left">文件下载<br><br></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${files}" var="file">
        <tr>
            <%--<td><input  class="easyui-textbox" data-options="buttonText:'下载',buttonIcon:'icon-download02',prompt:'${file.fileTitle}',searcher:doSearch" style="width:450px;height:35px;"></td>--%>
            <td style="padding-bottom: 18px">
                <input readonly="readonly" class="easyui-textbox" value="${file.fileTitle}" style="width:420px;height:35px;float: right">
                <a href="${pageContext.request.contextPath}/file/download?fileName=${file.fileName}" style="width:70px;height:35px;float: right" class="easyui-linkbutton" data-options="iconCls:'icon-download02'">下载</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="pp" class="easyui-panel">
    <div class="easyui-pagination" data-options="
					total: 114,
					showPageList: false,
					showRefresh: false,
					displayMsg: ''
				">
    </div>
</div>
</body>
<script>
    $('#pp').pagination({
        total:${total},
        pageSize:6,
        pageList: [6],
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页',
        displayMsg: '显示{from}到{to}条，共{total}条记录',
        pageNumber:${page},
        onSelectPage: function(pageNumber, pageSize) {
            location.href = "${pageContext.request.contextPath}/file/downloadLists?pageNumber=" + pageNumber + "&&pageSize=" + pageSize;
        }
    });
</script>

<script>
    function doSearch(value){
        alert('You input: ' + value);
    }
</script>

</html>
