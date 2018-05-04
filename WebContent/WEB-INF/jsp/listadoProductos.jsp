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
 <a href="../almacenes.html">Principal</a>
 <p><h2>Listado de Productos  Con paginación </h2></p>
 Productos en total: <c:out value="${requestScope.numTotalObjetos}"/>
    
    <table class="table table-hover">
    	<tr>
    		<th>ID</th> <th>Producto</th> <th>Almacen</th> <th>PVP</th>
   		</tr>
   		<c:forEach var="list" items="${model}">
   		<tr>
   			<td>
   				<c:out value="${list.idProducto}"/>
   			</td>
   			<td>
   				<c:out value="${list.nombreProducto}"/>
   			</td>
   			<td>
   				<c:out value="${list.almacen.nombreAlmacen}"/>
   			</td>
   			<td>
   				<c:out value="${list.pvp}"/>
   			</td>
   		</tr>
   		</c:forEach>
   </table> 	
    
    <c:choose>
    	<c:when test="${requestScope.numPaginas > 1}">
		    <table class="table table-hover">
		    	<tr>
		    		<td colspan="5">
		    			<c:choose>
		    				<c:when test="${requestScope.pagina != 0}">
				    			<a href="../listadoProductos/${requestScope.pagina-1}.html">Atrás</a>
		    				</c:when>
		    				<c:otherwise>
		    					<span class="gris">Atrás</span>
		    				</c:otherwise>
		    			</c:choose>
		    		</td>    	
		    		<td colspan="5">
		    			Página: ${requestScope.pagina+1} / ${requestScope.numPaginas}
						&nbsp;&nbsp;&nbsp;&nbsp;
		    		</td>    	
		    		<td colspan="5">
		    			<c:choose>
		    				<c:when test="${requestScope.pagina != requestScope.numPaginas-1}">
				    			<a href="../listadoProductos/${requestScope.pagina+1}.html">Siguiente</a>
		    				</c:when>
		    				<c:otherwise>
		    					<span class="gris">Siguiente</span>
		    				</c:otherwise>
		    			</c:choose>
		    		</td>
		    	</tr>    
		    </table>
    	</c:when>
    </c:choose>
    
 </body> 
</html>