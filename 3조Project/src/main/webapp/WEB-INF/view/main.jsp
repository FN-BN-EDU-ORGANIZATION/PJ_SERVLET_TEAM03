<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>MAIN</h1>
<hr />
<c:if test="${empty ROLE}">
	<a href="${pageContext.request.contextPath}/login.do"  >LOGIN</a></br>
</c:if>
<c:if test="${not empty ROLE}">
	<a href="${pageContext.request.contextPath}/logout.do" > >LOGOUT</a></br>
</c:if>

</body>
</html>