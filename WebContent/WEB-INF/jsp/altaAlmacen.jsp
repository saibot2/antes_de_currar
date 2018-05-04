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
 
 <jsp:include page="cabecera.jsp"/>
 
	<p><h1>Alta Almacen</h1></p>
 	
	<form:form action="altaAlmacenes.html" method="POST" >
		<form:hidden  path="idAlmacen"/>
		<form:hidden  path="esActivo"/>
		<table>
			<tr>
				<th><form:label path="nombreAlmacen">Nombre:</form:label></th>
				<td><form:input path="nombreAlmacen" autofocus="autofocus"/></td>
			</tr>
			<tr>
				<th><form:label path="telefono">Teléfono:</form:label></th>
				<td><form:input path="telefono"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Crear"/></td>
			</tr>
		</table>
   </form:form>  

 </body> 
</html>