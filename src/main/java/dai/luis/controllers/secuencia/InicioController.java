package dai.luis.controllers.secuencia;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.beans.MensajePrueba;


@Controller
public class InicioController {

	@Autowired
    private MensajePrueba mensajePrueba;
	
	@RequestMapping(value="/pag1.html")
    public ModelAndView handleRequest(/*HttpSession sesion*/)
            throws ServletException, IOException {
				
		mensajePrueba.setMensaje("Hola tios");
		String mensaje = mensajePrueba.getMensaje();
		//sesion.setAttribute("key", "mensajito");
		
		return new ModelAndView("secuencia/pag1", "mensaje", mensaje);
	}
}
