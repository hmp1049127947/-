<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/4
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${notice.name}</title>
    <jsp:include page="../includes/easyui_head.jsp"/>
</head>
<body>
<main>
    ${notice.content}
</main>
<footer>
    <a href="#" class="easyui-linkbutton c1" style="width:120px" onclick="history.go(-1)">返回</a>
</footer>
</body>
</html>
