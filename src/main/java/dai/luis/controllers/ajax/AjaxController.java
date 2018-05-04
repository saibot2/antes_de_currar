package dai.luis.controllers.ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dai.luis.beans.Bean;
import dai.luis.beans.OpcionesBean;
import dai.luis.view.AvailabilityStatus;
import dai.luis.view.PersonaView;
import dai.luis.view.PreguntaView;

@Controller
public class AjaxController {

	@Autowired
	private PreguntaView preguntaView;
	
	/*LLamar a este controller asi: http://localhost:8080/antesDeCurrar/preguntar.html*/
	@RequestMapping(value="preguntar", method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
        PreguntaView p = new PreguntaView();
        model.addAttribute(p);
        return "ajax/formAJAX";
    }

	@RequestMapping(value = "preguntar", method = RequestMethod.POST)
    public @ResponseBody String preguntar(@RequestParam String dato){
		preguntaView.setPregunta(dato);
        return preguntaView.getRespuesta();
    }
	
	@RequestMapping(value = "persona.html", method = RequestMethod.GET)
    public ModelAndView irPersonaAjax (){
		 return new ModelAndView("ajax/personaAJAX","command",new PersonaView()); 
    }
	
	@RequestMapping(value = "persona.html", method = RequestMethod.POST/*, produces = "application/json"*/)
	//@ResponseStatus(HttpStatus.OK)
    public @ResponseBody String personaAjax (@RequestBody PersonaView persona){
		System.out.println("hola /persona.html");
		String respuesta = "";
		ObjectMapper mapper = new ObjectMapper();
	    try {
	    	respuesta = mapper.writeValueAsString(persona);//respuesta es algo así como: {"nombre":"luis","apellidos":"del amo","edad":19}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	    return respuesta;
		//return "Llego: " + persona.getApellidos() + " - " + persona.getNombre() + " - " + persona.getEdad();		
    }
	
	@RequestMapping(value="availability", method=RequestMethod.GET)
	public @ResponseBody AvailabilityStatus getAvailability(@RequestBody String name) {
	    AvailabilityStatus availabilityStatus = new AvailabilityStatus();
	    availabilityStatus.setAvailability(true);
	    System.out.println("NOMBRE: "+name);
//	    for (String a : getNombres()) {
//	        if (a.equals(name)) {
//	        	availabilityStatus.setAvailability(false);
//	        	break;
//	        }
//	    }
	    
	    return availabilityStatus;
	}
	
	
//	@RequestMapping(value="/irFormAJAX", method = RequestMethod.GET)
//	public ModelAndView  execute(){						   
//	   return new ModelAndView("Ajax03/formularioAjax03","command",new Persona()); 	
//	} 	
	
	@RequestMapping(value ="/regresaAjax", method = RequestMethod.GET,
			produces ="application/json;charset=UTF-8", headers=/*"Accept=*/"Accept=application/json")
    public @ResponseBody OpcionesBean opcionDisponible(@RequestParam("mail") String mail){	
				 
		 //Thread.sleep(200);			
		 List<String> sugerencias = new ArrayList<String>();
	     sugerencias.add("Suge01");
	     sugerencias.add("Suge02");
	     sugerencias.add("Suge03");
	     sugerencias.add("Suge04");
	     OpcionesBean opcionesBean = new OpcionesBean(true,null);
	     System.out.println("AJAX");
         return opcionesBean;                         
    }
	
	@RequestMapping(value ="loginDisponible03", method = RequestMethod.GET
			,produces ="application/json;charset=UTF-8"/*, headers="Accept=text/xml, application/json"*/)
    public @ResponseBody Bean bean(@RequestParam("login") String login) 
    		throws InterruptedException {
       		
		//Thread.sleep(500);			
		boolean a = true;
		Bean bean = new Bean();
		bean.setA(10);
		bean.setB(20L);
			
        return bean;
       
    }
	
	private List<String> getNombres(){
		List<String> nombres = new ArrayList<>();
		nombres.add("juan");
		nombres.add("manuel");
		nombres.add("pedro");
		return nombres;
	}
}
