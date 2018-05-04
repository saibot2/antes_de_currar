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
<style>
	body {background-color:lightgray}	
	#cargando{
		display: none;
	}
</style>
<body>
<h2>Form3</h2>
<form id="registro" action="#">
    Login: <input type="text" name="login" id="campo_login"> 
    <span id="mensaje"></span><br>
    <div id="cargando">
		<img class="btn btn-success" src="img/ajax-loader.gif">
	</div>
    <br>
    Nombre: <input type="text" name="nombre"> <br><br><br><br><br><br>
    <input id="btnAjax" type="submit" value="registrar">
</form>


<hr>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js" > </script>
<script type="text/javascript" src="js/ajax03.js"></script>
</body>
</html>