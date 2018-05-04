/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){  
	/*$.getJSON( url [, data ] [, success ] )*///data es el JSON, 
	//success es lo que hay que hacer en caso que todo vaya bien	
	//$("#btnAjax").removeClass("disabled");	
	
//	$("#btnAjax").click(function(e){		
//		e.preventDefault();
//		var mail = $("#email").val();			
//        $.getJSON("regresaAjax.html",
//         {email: mail}, //Este es el json que le paso por http GET al servidor, se puede omitir		
//          function(result){        	
//            $.each(result, function(key, value){
//            	/*Estos 2 metodos añaden html a la etiqueta destino pero son diferentes
//            	 * con 'append' vas agregando codigo, con html no.*/            	
//            	   	
//            	//$("#destino").html("<p>"+key+": "+ value+"</p>");    
//            	if(key=="resultado" && value==false){            		
//            		$("#value").html("<p class=\"Error\">Email ya registrado</p>");
//            		$("#email").focus();
//            	}
//            	if(key=="resultado" && value==true){            		
//            		$("#value").html("<p class=\"noError\">Email no coincide</p>");
//            		$("#direccion").focus();
//            	}            	
//            });
//        });
//    });
	
	$("#btnAjax").click(function(e){			
		e.preventDefault();
        $.getJSON('loginDisponible03.html', 
          "login="+$('#campo_login').val(),null,
          function(bean) {
        	alert("Success");                     
          }); 
        
	});
	
	
	
	$(document).ajaxStart(function(){
		
		$("#btnAjax").css("display","none");
		$("#cargando").css("display","block");
	});
	
	$(document).ajaxComplete(function(){		
		$("#cargando").css("display","none");
		$("#btnAjax").css("display","block");
	});	
	
});  