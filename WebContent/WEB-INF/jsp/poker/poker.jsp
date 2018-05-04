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
 
 <jsp:include page="../cabecera.jsp"/>
 
	<p><h1>Cartas Jugador</h1></p>
	 
    	<table>
    		<tr>
    			<c:forEach var="list" items="${requestScope.cartasListP1}" varStatus="i">
	    			<td>
	    				&nbsp;<img src="img/cartas/${list.palo}-${list.numero}.jpg" alt="Smiley face" height="110" width="70">		
	    			</td>
    			</c:forEach>
    		</tr>
    	</table>    	
    	<br>
    	
    	<ul>
	    	<c:forEach var="list" items="${requestScope.mensajesP1List}" varStatus="i">
	    		<li><c:out value="${list}"/></li>
	    	</c:forEach>
    	</ul>
    	<hr>
    <p><h1>Cartas Computadora</h1></p>
	 <br>
	 
    	<table>
    		<tr>
    			<c:forEach var="list" items="${requestScope.cartasListComp}" varStatus="i">
	    			<td>
	    				&nbsp;<img src="img/cartas/${list.palo}-${list.numero}.jpg" alt="Smiley face" height="110" width="70">		
	    			</td>
    			</c:forEach>
    		</tr>
    	</table>	
    	<br>
    	<ul>
	    	<c:forEach var="list" items="${requestScope.mensajesCompList}" varStatus="i">
	    		<li><c:out value="${list}"/></li>
	    	</c:forEach>
    	</ul>
    
    <hr>
    
    <a href="poker.html" class="btn btn-primary btn-sm active" role="button" aria-pressed="true">Repartir cartas</a>

    
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/juego.js"></script>   
 </body> 
</html>