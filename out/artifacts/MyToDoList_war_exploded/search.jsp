<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/27
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/search.css"/>
    <script src="js/search.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<img src="images/search_bg.png" id="search_bg">
<input type="text" name="" id="input" placeholder="搜索" value="${description}"/>
    <div id="box">
        <ul id="doing">
            <c:forEach var="work" items="${doingList}">
                <li><a href="#"><img src="images/doing.png" id="${work.id}"></a><label>${work.description}</label></li>
            </c:forEach>
        </ul>
        <ul id="done">
            <c:forEach var="work" items="${doneList}">
                <li><a href="#"><img src="images/done.png" id="${work.id}"></a><label>${work.description}</label></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
