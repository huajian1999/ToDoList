<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/26
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/list.css"/>
    <script src="js/list.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div id="top">
            <span id='title'>
                Just Do It!
            </span>
    <div id="person">
        <h4>陆离</h4>
        <p>1622646972@qq.com</p>
    </div>
    <a href="search.jsp" target="right" id="search"><img src="images/搜索.png" ></a>
</div>
<hr >
<div id="list">
    <ul id="worklist">
        <c:forEach var="alist" items="${alists}">
            <li id="${alist.id}">
                <a href="FindAllWorkServlet?listId=${alist.id}" target="right">${alist.name}</a>
            </li>
        </c:forEach>
    </ul>
    <a href="#" id="addlist">新建清单</a>
</div>
<!-- 自定义右键菜单 -->
<div id="menu">
    <ul>
        <li>重命名</li>
        <li>删除清单</li>
    </ul>
</div>
</body>
</html>
