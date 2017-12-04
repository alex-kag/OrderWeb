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
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"--%>
              <%--.integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">--%>

        <script src='webjars/jquery/3.2.1/jquery.js'></script>
        <script src="site/js/popper.min.js"></script>
        <%--<script src='webjars/popper.js/1.13.0/dist/popper.min.js'></script>--%>
        <%--<script src='webjars/popper.js/1.11.1/dist/popper.min.js'></script>--%>
        <%--<script src="https://getbootstrap.com/assets/js/vendor/popper.min.js"></script>--%>
        <script src='webjars/bootstrap/4.0.0-beta.2/js/bootstrap.min.js'></script>

        <link rel='stylesheet' href='webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css'>
</head>
<body>
<nav class="navbar navbar-expand-md bg-primary navbar-dark">
    <div class="container">
        <%--ToDo: изменить на правильную ссылку--%>
        <a class="navbar-brand" href="">
            <i class="fa d-inline fa-lg fa-cloud"></i>
            <b>  Полоцкая ТЭЦ, заявки</b>
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fa d-inline fa-lg fa-envelope-o"></i> Текущий цех</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary"><i class="fa d-inline fa-lg fa-user-circle-o"></i> Sign in</a>
        </div>
    </div>
</nav>
