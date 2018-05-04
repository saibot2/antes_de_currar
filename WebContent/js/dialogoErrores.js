/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){  
	var nombreApe;
	var email;
	var direccion;	
	var mensajeErrorHTML="";
	
	function validarEmail(valor) {
		var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
		if (expr.test(valor)){
			  return true;
		} else {
			  return false;
		}
	}	
	
	function valida() {
		mensajeErrorHTML="";
		nombreApe = $("#nombre").val();		
		if(nombreApe.trim()==""){			
			mensajeErrorHTML+="<li>Campo 'Nombre' obligatorio</li>";
			//$("#divNombre").addClass( "has-error" );
		}
		
		email = $("#email").val();
		if(email.trim()==""){			
			mensajeErrorHTML+="<li>Campo 'Email' obligatorio</li>";			
		}else{
			if(email.length>30){
				mensajeErrorHTML+="<li>Campo 'Email' muy largo (30 caracteres máximo)</li>";
			}
			if(!validarEmail(email)){				
				mensajeErrorHTML+="<li>Campo 'Email' No Válido</li>";
				//$("#divEmail").addClass( "has-error" );
			}
		}					
		
		direccion = $("#direccion").val();	
		if(direccion.trim()==""){					
			mensajeErrorHTML+="<li>Campo 'Dirección' obligatorio</li>";
			//$("#divMensaje").addClass( "has-error" );
		}
		
		if(nombreApe.length>60){						
			mensajeErrorHTML+="<li>Campo 'Nombre' muy largo, (Máx. 60 caracteres)</li>";
			//$("#divNombre").addClass( "has-error" );
		}
	}
	
	$("#f2").on("submit", function(e){
		e.preventDefault();		
		valida();													
		$("#listErrors").html(mensajeErrorHTML);				

		if(mensajeErrorHTML!=""){
			$("#dialogoError").dialog("open"); 			
		}else{						
			document.getElementById("f2").submit();			
		}		
	});	
	
	 $("#dialogoError").dialog( {
		 autoOpen: false,
		 modal: true,
		 title: "Errores en el formulario",
		 show: "fold",
		 hide: "scale",
		 buttons: {		    
		    'Aceptar': function() {
		        $(this).dialog('close');
		    }
		  }
	 });
	 
	
});  