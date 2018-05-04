<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pag 2</title>
</head>
<body>
	<h1>Pag 2</h1>

	<p>MENSAJE: <c:out value="${mensaje}"/></p>
	<p>KEY: <c:out value="${key}"/></p>
		
	<p><a href="<c:url value="pag3.html"/>">Pag 3</a></p>
</body>
</html>