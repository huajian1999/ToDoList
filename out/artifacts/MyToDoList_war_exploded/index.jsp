<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/26
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        frame{
            border:0;
            float:left;
            height:100%;
        }
    </style>
</head>

<frameset cols="30%,70%" frameborder="no">
    <frame name="left" src="FindAllListServlet" noresize="noresize" />
    <frame name="right" src="welcome.jsp" noresize="noresize"/>
</frameset>

</html>
