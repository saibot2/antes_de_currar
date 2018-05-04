<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<html>
<head>        
    <title>SpringMVC</title> 	
    <LINK REL="stylesheet" TYPE="text/css" HREF="<%=request.getContextPath()%>/css/estilo.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">  
 </head> 
 
 <body> 
 	<a href="javascript:history.back(1)">Volver</a>
 	<p><h1><c:out value="${requestScope.crearUpdateMsg}"/></h1></p> 	 	
 	
 	<c:choose>
	   <c:when test="${requestScope.crearUpdateMsg == 'Crear Producto'}">
	      <c:set var="ruta" scope="request" value="${pageContext.request.contextPath}/altaProducto.html"/>
	      <c:set var="boton" scope="request" value="Crear"/>
	      <c:set var="claseInvisible" scope="request" value="invisible"/>
	   </c:when>
	   <c:when test="${requestScope.crearUpdateMsg == 'Modifica Producto'}">
	       <c:set var="ruta" scope="request" value="${pageContext.request.contextPath}/modificaProducto.html"/>
	       <c:set var="boton" scope="request" value="Actualizar"/>
	       <c:set var="claseInvisible" scope="request" value="visible"/>
	   </c:when>	   
	</c:choose>
 	
	<p>Almacen nº: <c:out value="${command.almacen.idAlmacen}"/></p>
	
	<form:form action="${ruta}" method="POST" >
		<form:hidden path="idProducto"/>		
		<form:hidden path="almacen.idAlmacen"/>
		
		<table>
			<tr>
				<th><span class="${claseInvisible}">ID:</span></th>
				<td><c:out value="${command.idProducto}"/></td>
			</tr>
			<tr>
				<th><form:label path="nombreProducto">Nombre:</form:label></th>
				<td><form:input path="nombreProducto" autofocus="autofocus"/></td>
			</tr>
			<tr>
				<th><form:label path="pvp">PVP:</form:label></th>
				<td><form:input path="pvp"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="${boton}"/></td>
			</tr>
		</table>
   </form:form>  
	 		 
 </body> 
</html>