<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<html>
<head>        
   <title>Probando Ajax</title>
    <LINK REL="stylesheet" TYPE="text/css" HREF="<%=request.getContextPath()%>/css/estilo.css">	   
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">   
 </head> 
 
 <body>
        <div>
            <p>.. ESCRIBA ..</p>
            <p><input id="txt_pregunta" type="text" size="30"></p>
            <p><input id="btn_preguntar" type="button" value="Preguntar">   
               <input id="btn_available" type="button" value="Disponibilidad">  
            </p>
            
        </div>
        <div id="rpta_servidor"></div>
        
        
  <div id="resultado"></div>      
        
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/springAJAX.js"></script>
        
</body>
</html>