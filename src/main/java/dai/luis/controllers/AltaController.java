package dai.luis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.models.Almacen;
import dai.luis.models.Producto;
import dai.luis.service.AlmacenService;
import dai.luis.service.ProductoService;

@Controller 
public class AltaController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	AlmacenService almacenService;
	
	@RequestMapping(value="almacenes", method = RequestMethod.GET)
	 public String almacenes(ModelMap model) { 
		model.addAttribute("mensaje", "Hello Spring MVC Framework!"); 
		return "almacen"; 
	 } 
	 
	 @RequestMapping("altaAlmacenes")
	 public ModelAndView altaAlmacen(ModelMap model){	
		 Almacen almacen = new Almacen();
		 almacen.setEsActivo(1);
		 return new ModelAndView("altaAlmacen","command",almacen);
	 }
	 
	 @RequestMapping(value="altaAlmacenes", method = RequestMethod.POST)
	 public String crearAlmacen(Almacen almacen,ModelMap model) { 
	    Long id = almacenService.crearAlmacen(almacen);
	    model.addAttribute("mensajecreado", (id==null?"ERROR al crear Almacen.":"Almacen creado satisfactoriamente.") );
		return "almacen"; 
	 } 
	 
	 @RequestMapping("altaProducto/{idAlmacen}")
	 public ModelAndView altaProducto(
			 @PathVariable Long idAlmacen, 
			 ModelMap model){	
		 model.addAttribute("crearUpdateMsg", "Crear Producto");
		 model.addAttribute("idAlmacen", idAlmacen);
		 Producto producto = new Producto();
		 Almacen almacen = new Almacen();
		 almacen.setIdAlmacen(idAlmacen);
		 producto.setAlmacen(almacen);
		 return new ModelAndView("modificaProducto","command",producto);
	 }
	 
	 @RequestMapping(value="altaProducto", method = RequestMethod.POST)
	 public String crearProducto(Producto producto,ModelMap model) { 
	    model.addAttribute("mensajecreado","Producto creado satisfactoriamente.");
	    Long id = productoService.crearProducto (producto);
		model.addAttribute("mensajecreado",(id==null?"ERROR al crear Producto.":"Producto creado satisfactoriamente.") );
		return "redirect:/modificaAlmacen.html?id="+producto.getAlmacen().getIdAlmacen();
	 } 
	 
}
