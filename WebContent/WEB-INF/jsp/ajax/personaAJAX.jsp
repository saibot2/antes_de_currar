<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>      
<html>
<head>        
   <title>Probando Ajax</title>
    <LINK REL="stylesheet" TYPE="text/css" HREF="<%=request.getContextPath()%>/css/estilo.css">	   
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">   
 </head> 
 
 <body>
     
     <form:form action="#" method="POST" id="frm_persona" name="frm_persona">
		<p>
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre"/>
		</p>
		<p>
		<form:label path="apellidos">Apellidos:</form:label>
		<form:input path="apellidos"/>     
		</p>
		<p>
		<form:label path="edad">Edad:</form:label>
		<form:input path="edad"/>
		</p>
		<p>
		<input type="submit" value=" Ir "/>
		</p>         
      </form:form>  
        
        <p>        
        	<div id="servidor"></div>
        </p>
        
       
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/ jquery-1.4.4.js"></script> --%>

 <script type="text/javascript" src="<%=request.getContextPath()%>/js/json.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/springAJAX.js"></script>
        
</body>
</html>