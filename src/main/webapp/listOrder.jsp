<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="site/header.jsp"></jsp:include>

<div class="panel panel-default">
    <div class="panel-heading">
        <h1 class="panel-title">заполнить количество на дату</h1>
    </div>
    <div class="panel-body">
        <form name="orderForm" method="POST" action="WorkTaskController">
            <input type = "hidden" name="action" value="order"/>
    </div>
</div>


<jsp:include page="site/footer.jsp"></jsp:include>
