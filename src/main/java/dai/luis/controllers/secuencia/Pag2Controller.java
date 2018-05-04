package dai.luis.controllers.secuencia;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.beans.MensajePrueba;


@Controller
public class Pag2Controller {
	
	@Autowired
    private MensajePrueba mensajePrueba;
	
	@RequestMapping(value="/pag2.html")
    public ModelAndView handleRequest2()
            throws ServletException, IOException {
				
		String mensaje = mensajePrueba.getMensaje()+" 2 ";
		mensajePrueba.setMensaje(mensaje);
		
		return new ModelAndView("secuencia/pag2", "mensaje", mensaje);
	}
}
