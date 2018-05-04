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
 
	<p><h1>Piedra papel o tijera</h1></p>
	 <form:form action="jugar.html" method="POST" >		
		<table>
			<tr>
				 <ul>
					<form:radiobuttons path="piedraPapelTijera" items="${piedraPapelTijeraMap}" element="li"/>
				 </ul>
			</tr>
					
		</table>
     </form:form> 
    
    <div id="cargando"><p><img src="img/ajax-loader.gif"> Cargando...</p></div>
 	<div id="resultado"></div> 
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/juego.js"></script>   
 </body> 
</html>