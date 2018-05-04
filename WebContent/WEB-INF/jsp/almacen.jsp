<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<html>
<head>        
    <title>SpringMVC</title> 
    <LINK REL="stylesheet" TYPE="text/css" HREF="<%=request.getContextPath()%>/css/estilo.css">	   
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">   
 </head> 
 
 <body>
 	<p><h1>ALMACENES</h1></p>
	<p><c:out value="${requestScope.mensaje}"/></p>	
	<div class="errorblock">
		<p><c:out value="${requestScope.mensajecreado}"/></p>
	</div>	
        
    <br>
    
    <ul>
    	<li><a href="altaAlmacenes.html">Alta Almacen</a></li>
    	<li><a href="consultaAlmacen.html">Consulta Almacen</a></li>
    	<li><a href="listadoProductos/0.html">Consulta Productos</a></li>
    	<li><a href="jugar.html">Jugar Piedra Papel o Tijera</a></li>       
    	<li><a href="poker.html">Poker</a></li>
    </ul>
    
 </body> 
</html>