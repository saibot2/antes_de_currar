function jugarAjax(){
    $.ajax({
    	type: 'POST',
        url: "jugar.html",
        data: {
            dato: $('input:radio[name=piedraPapelTijera]:checked').val()
            },
        success: function(data){
            $("#resultado").html(data);
        }
    });
}

/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/
$(document).ready(function(){ 		
	
 	$(":radio").on("click",function(e){
 		$("#resultado").html("");
 		jugarAjax();
	});	
	
 	$(document).ajaxStart(function(){ 	
		$("#cargando").css("display","block");		
		$(":radio").prop('disabled', true);
	});
	
	$(document).ajaxComplete(function(){		
		$("#cargando").css("display","none");
		$(":radio").prop('disabled', false);
	});	
	
});
	
