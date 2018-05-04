package dai.luis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dai.luis.service.AlmacenService;
import dai.luis.service.ProductoService;


@Controller 
public class BorrarController {
	@Autowired
	ProductoService productoService;
	
	@Autowired
	AlmacenService almacenService;
	
	@RequestMapping(value="borrarProducto", method = RequestMethod.GET)
	public String borrarProducto(
			@RequestParam(value="id",required=false) Long id,
			@RequestParam(value="idAlmacen",required=false) Long idAlmacen,
			ModelMap model) {			
		model.addAttribute("crearUpdateMsg", "Modifica Producto");
		productoService.borrarProducto(id);
		return "redirect:/modificaAlmacen.html?id="+idAlmacen;
	}
	
	
	@RequestMapping(value="borrarAlmacen", method = RequestMethod.GET)
	public String borrarAlmacen(			
			@RequestParam(value="idAlmacen",required=false) Long idAlmacen,
			ModelMap model) {					
		String mensaje = almacenService.borrarAlmacen(idAlmacen);
		model.addAttribute("mensajecreado",(mensaje.equalsIgnoreCase("ko")?"ERROR al borrar Almacen.":"Almacen borrado satisfactoriamente."));
		return "almacen"; 
	}
}
