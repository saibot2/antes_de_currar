
$(document).ready(function(){  
	//businesslines
//	$( "#selectBusinessLine" ).change(function () {
//		
//		$.getJSON('json', function(data) {
//			
//			$.each(data, function(key, value) {
//				console.log('hola '+value);
//				$('#resultado').append(value);
//			});
//		});
//	});
	
	
	
	
	
	
   $.ajax({
      url: 'json',
      data: {
         edad: 22
      },
      error: function() {
         $('#resultado').html('<p>An error has occurred</p>');
      },
   //   dataType: 'jsonp',
      success: function(data) {
    	  $.each(data, function(key, value) {
				console.log('hola '+value);
				$('#resultado').append(value);
			});
      },
      type: 'GET'
   });
		
	
});

