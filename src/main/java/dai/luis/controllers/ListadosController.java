package dai.luis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dai.luis.models.Producto;
import dai.luis.service.ProductoService;

@Controller 
public class ListadosController {
	public static final int TAMANYO_PAGINA = 4;
	
	@Autowired
	ProductoService productoService;
	
	/*LISTADO PAGINADO*/
	@RequestMapping(value="listadoProductos/{pagina}", method = RequestMethod.GET)
	public String listadoProductos(@PathVariable Integer pagina, ModelMap model) {			
		List<Producto> productos = productoService.listadoProductos(pagina);
		model.addAttribute("model", productos);
		model.addAttribute("pagina", pagina);
		Long numTotalObjetos = productoService.cuentaTodosProductos();
		int numPaginas =(int) Math.ceil((double)numTotalObjetos / (double)TAMANYO_PAGINA);
		model.addAttribute("numTotalObjetos", numTotalObjetos);
		model.addAttribute("numPaginas", numPaginas);		
		return "listadoProductos";
	}
	
	
	
}
