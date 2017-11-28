<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <%--<link rel="stylesheet" href="site/css/bootstrap.css">--%>
    <%--<link rel="stylesheet" href="site/css/datepicker.css">--%>
    <%--<script src="site/js/jquery.js"></script>--%>
    <%--<script src="site/js/bootstrap.js"></script>--%>
    <%--<script src="site/js/bootstrap-datepicker.js"></script>--%>
    <%--<script src="site/js/my.js"></script>--%>
    <%--<script>--%>
    <%--<%@include file="/site/js/my.js"%>--%>
    <%--</script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
              .integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>
<nav id="w0" class="navbar-default navbar-fixed-top navbar" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#w0-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">Число нарядов за сутки</a>
        </div>
        <div id="w0-collapse" class="collapse navbar-collapse">
            <ul id="w1" class="navbar-nav navbar-right nav">
                <li>
                    <a href="/ru/site/about">О проекте</a>
                </li>
                <li>
                    <a >Цех: <c:out value="${sessionScope.userCeh}"/></a>
                </li>
                <li><a href="/ru/user/signup">Выйти-исправить</a></li>
            </ul>
        </div>
    </div>
</nav>
