<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>

<body>
<%--<jsp:include page="master.jsp"></jsp:include>--%>
<br>
	<table border=1>
		<thead>
			<tr>
				<th>User id </th>
				<th>login</th>
				<th>pass</th>
				<th>Цех</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var = "user">
				<tr>
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.login}"/></td>
					<td><c:out value="${user.pass}"/></td>
					<td><c:out value="${user.tblCehEntity.cehName}"/></td>
					<td><a href = "WorkTaskController?action=edit_user&id=<c:out value = "${user.id}"/>">Update</a></td>
					<td><a href = "WorkTaskController?action=delete_user&id=<c:out value = "${user.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href = "WorkTaskController?action=insert_user">Add user</a></p>
</body>
</html>