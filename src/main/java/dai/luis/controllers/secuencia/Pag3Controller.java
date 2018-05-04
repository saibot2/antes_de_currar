package dai.luis.controllers.secuencia;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.beans.MensajePrueba;


@Controller
public class Pag3Controller {
	
	@Autowired
    private MensajePrueba mensajePrueba;
	
	@RequestMapping(value="/pag3.html")
    public ModelAndView handleRequest()
            throws ServletException, IOException {
				
		String mensaje = mensajePrueba.getMensaje()+" 3 ";
		mensajePrueba.setMensaje(mensaje);
		
		return new ModelAndView("secuencia/pag3", "mensaje", mensaje);
	}
}
