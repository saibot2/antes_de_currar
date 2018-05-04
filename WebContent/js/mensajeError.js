/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){  
	
	/*Creamos etiqueta division*/
	var division = $("<div >");
	/*le doy estilo*/
	division.attr("id","mensaje");
	/*le añadimos contenido con'html' contenido entre <div> y </div>*/
	division.html("<p class=\"Error\">Esto es un cuadro de dialogo...</p> <button id=\"enlacecerrar\">Aceptar</button> ");
	/*aun no esta agregada a la pagina, Así la insertamos en el BODY*/
	division.appendTo("#mensaje");
	
	
	$("#enlacecerrar").on("click", function(e){
		division.fadeOut(1000,function(){
			division.remove();//prepend
		});		
	});
	
});
