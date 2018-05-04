/*$ es un shortcut de jQuery, o sea dollar es la funcion jQuery*/

function preguntar(){
    $.ajax({
    	type: 'POST',
        url: "preguntar.html",
        data: {
            dato: $("#txt_pregunta").val()
            },
        success: function(data){
            $("#rpta_servidor").html(data);
        }
    });
}

function checkAvailability() {
//	alert('availability.isAvailability');
    $.getJSON(
    		"availability.html", 
    		{ name: $('#txt_pregunta').val()
//    			, 
//    		 headers: { 
//     	        'Accept': 'application/json',
//     	        'Content-Type': 'application/json; charset=UTF-8' 
//	     	 },
//	     	dataType: 'json'
    			},
	    		function(availability) {
    	alert('availability.isAvailability: ');
//    	if (availability.isAvailability) {
//    		alert('disponible');
//            fieldValidated("name", { valid : true });
//        } else {
//        	alert('No disponible');
//            fieldValidated("name", { valid : false,
//                message : $('#name').val() + " is not available, try " });
//        }
    });
}


function mia() {
	$.ajax({
	    url: 'json.html',
	    data: {
	       edad:  $('#txt_pregunta').val()
	    },
	    error: function() {
	    	alert();
	       $('#resultado').html('<p>An error has occurred</p>');
	    },
	    //dataType: 'jsonp',
	    success: function(data) {
	  	  $.each(data, function(key, value) {
					console.log('hola '+value);
					$('#resultado').append(value);
				});
	    },
	    type: 'POST'
	 });
}


$(document).ready(function(e){ 		
	 $("#frm_persona").submit(function(e){		
		 e.preventDefault();
         var var_persona=$(this).serializeObject();
        // alert("DATO: "+JSON.stringify(var_persona));
         $.ajax({
        	 headers: { 
        	        'Accept': 'application/json',
        	        'Content-Type': 'application/json; charset=UTF-8' 
        	 },
        	 url: "persona.html",
             type: 'POST',             
             data: JSON.stringify(var_persona),
             dataType: 'json',
             success: function(data){
            
            	$.each(data, function(key, value) {
      				console.log('hola '+value);
      				$('#servidor').append(value);
      			});
            	 
                 //$("#servidor").html(data);
          },
          	error:function( jqXHR,  textStatus,  errorThrown ){
              console.log('error '+errorThrown);
            }
         });
     });
	
	$("#btn_preguntar").on("click", function(e){			
		preguntar();
	});
	
	$("#btn_available").on("click", function(e){			
		checkAvailability();
	});
});
	
