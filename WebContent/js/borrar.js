/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){ 		
     var id = 0; // identificador que dice a quien borrar
     var enlace; //Enlace del <a href de la jsp, es una cadena por ejemplo: 'borrarCds?id=6'
	
	$(".btnDelete").click(function(e){
		e.preventDefault();		
		enlace = $(this).attr("href");	//de aqui obtengo el id					
		id = enlace.substring(enlace.indexOf("=")+1 );			
		$("#dialogo").dialog("open"); 		
	});	
	
	 $("#dialogo").dialog( {
		 autoOpen: false,
		 modal: true,
		 //title: "Borrar",
		 show: "fold",
		 hide: "scale",
		 buttons: {
		    'Si': function() {		    
		      location.href = "confirmBorrar?id="+id;
		    },
		    'No': function() {
		        $(this).dialog('close');
		    }
		  }
	 });
	
});
	
