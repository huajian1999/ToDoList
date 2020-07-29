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
    <link rel="stylesheet" type="text/css" href="css/work.css"/>
    <script src="js/work.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div id="box">
        <h1>${listName}</h1>
        <br>
        <p><button type="button">未完成</button></p>
        <br>
        <ul id="doing">
            <c:forEach var="work" items="${doingList}">
                <li id="${work.id}"><a href="#"><img src="images/doing.png"></a><label>${work.description}</label></li>
            </c:forEach>
        </ul>
        <br>
        <p><button type="button">已完成</button></p>
        <br>
        <ul id="done">
            <c:forEach var="work" items="${doneList}">
                <li id="${work.id}"><a href="#"><img src="images/done.png"></a><label>${work.description}</label></li>
            </c:forEach>
        </ul>
        <br><br>
    </div>
    <div id="bottom">
        <p class="addtask">
            <img src="images/圆圈.png" >
            <input type="text" name="newtask" id="newtask" placeholder="添加任务" />
        </p>
    </div>

    <!-- 自定义右键菜单 -->
    <div id="menu">
        <ul>
            <li>删除任务</li>
            <!-- <li>修改任务</li> -->
        </ul>
    </div>

</body>
</html>
