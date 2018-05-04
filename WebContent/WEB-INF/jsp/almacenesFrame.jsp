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
 
 
 <body onload="loadi();">
 
 	<jsp:include page="cabecera.jsp"/>
	<p><span class="errorblock"><c:out value="${mensajecreado}"/></span></p>
 	<p><h1>CONSULTA ALMACENES</h1></p>
	
	<form:form action="consultaAlmacen.html" method="POST" commandName="almacenBeanFiltro">  
		<table >
			<tr>
				<th><form:label path="idAlmacen">ID:</form:label></th>
				<td><form:input path="idAlmacen" autofocus="autofocus"/></td>
			</tr>
			<tr>
				<th><form:label path="nombreAlmacen">Nombre:</form:label></th>
				<td><form:input path="nombreAlmacen"/></td>
			</tr>
			<tr>
				<th><form:label path="telefono">Teléfono:</form:label></th>
				<td><form:input path="telefono"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Consultar"/></td>
			</tr>
		</table>
   </form:form> 
   <hr>
 	Almacenes en total: <c:out value="${requestScope.model.size()}"/>
    <c:out value="${requestScope.mensaje}"/>
	  
	  	<table class="table table-hover">
	    	<tr>
	    		<th>ID</th> <th>Almacen</th> <th>Teléfono</th> <th>Productos</th> <th>Editar</th><th>Eliminar</th>
	    	</tr>
	     <c:forEach var="list" items="${model}">
	    	<tr>
	    		<td><c:out value="${list.idAlmacen}"/></td>
	    		<td><c:out value="${list.nombreAlmacen}"/></td>
	    		<td><c:out value="${list.telefono}"/></td>
	    		<td>
				<c:out value="${list.productos.size()}"/> x	    			
				<select>
    			 	<c:forEach var="list2" items="${list.productos}">			    
						<option value="">${list2.nombreProducto}</option>
				    </c:forEach>
				</select>
	    			
	    		</td>
	    		<td>
		    		<form:form action="editaAlmacen.html" method="POST" commandName="almacenBeanFiltro">  
		    			<form:hidden path="idAlmacen"/>
						<form:hidden path="nombreAlmacen"/>
						<form:hidden path="telefono"/>		
						<form:hidden path="idAlmacenEditar" value="${list.idAlmacen}"/>
						<button type="submit"><img src="img/modi2.png" alt="Editar" /></button>
		    		</form:form>
	    		</td>
	    		<td>
	    			<a href="borrarAlmacen.html?idAlmacen=${list.idAlmacen}"><img src="img/eliminar.png" border="0" height="23" > </a>
	    		</td>	    		
	    	</tr>
	     </c:forEach>
	 </table>   	 
    
 </body> 
</html>
