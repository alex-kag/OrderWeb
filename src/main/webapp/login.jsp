<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="site/header.jsp"></jsp:include>

<div class="container" style="margin-top: 80px">
    <form name="loginForm" method="POST" action="WorkTaskController">
    <input type = "hidden" name="action" value="login"/>
        Login:<br/>
        <input type="text" name="login" value="al"/>
        <br/>Password:<br/>
        <input type="password" name="password" value="ap"/>
        <br/>
        <br/>
        <input type="submit" value="Log in"/>
    </form><hr/>
    Press <font color=red>root/root</font> for enter.
</div>



<jsp:include page="site/footer.jsp"></jsp:include>
