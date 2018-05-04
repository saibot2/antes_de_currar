/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){  			
	/*Creamos etiqueta division*/
	var division = $("<div>");
	/*le doy estilo*/
	division.attr("id","imagen");
	var color = $("#colorIdAsignado").val();
	convetir(color,division);
	
	$("#colorIdAsignado").on("change", function(e){	
		color = $("#colorIdAsignado").val();
	 	convetir(color,division);	 	
	});
		
});

function convetir(color,division){			
		var letra ="";				
		switch(color){
			case "0":
				letra = "R";				
				break;
			case "1":
				letra = "G";			
				break;	
			case "2":
				letra = "B";													
		}	
		if(color!="-1"){
			/*le añadimos contenido con'html' contenido entre <div> y </div>*/
			division.html("<img src='img/cam"+letra+".gif' alt='Imagen' width='50' height='60' class='bordeImg'>");
			/*aun no esta agregada a la pagina, Así la insertamos en el BODY*/
			division.appendTo("#camisa");	
		}	
}
