<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pruebas Ajax</title>
</head>
<body>

<form:form action="regresaAjax.html" method="POST" >
	<p>
	<form:label path="email">Email:</form:label>
	<form:input id="email" path="email"/>
	</p>
	<p>
	<form:label path="apellidos">Apellidos:</form:label>
	<form:input path="apellidos"/>
	</p>
	
	<input id="btnAjax" type="submit" value="Saludar"/>
</form:form>  
<br>
<div id="cargando">
	<img class="btn btn-success" src="img/ajax-loader.gif">
</div>
<hr>

<div id="mensaje"></div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" > </script>
<script type="text/javascript" src="js/ajax.js"></script>
</body>
</html>