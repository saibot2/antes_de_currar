package dai.luis.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.beans.AlmacenBean;
import dai.luis.models.Almacen;
import dai.luis.service.AlmacenService;

@Controller 
public class ConsultaController {
	
	@Autowired
	private AlmacenService almacenService;
	
	@RequestMapping("consultaAlmacen")
	public ModelAndView irFormulario(HttpServletRequest req, ModelMap model){		
		String mensaje = req.getParameter("mensajecreado");
		model.addAttribute("mensajecreado", mensaje);
		return new ModelAndView("almacenesFrame","almacenBeanFiltro",new AlmacenBean());
	}
	
	@RequestMapping(value="consultaAlmacen", method = RequestMethod.POST)
	public ModelAndView consultarAlmacen(AlmacenBean almacenBeanFiltro, ModelMap model) {	
		Almacen almacenDaoFiltro = new Almacen();
		almacenDaoFiltro = almacenBeanToAlmacenDaoMapper(almacenBeanFiltro);
		
		List<Almacen> almacenes = almacenService.buscarAlmacenes (almacenDaoFiltro);	
		model.addAttribute("model", almacenes);
		return new ModelAndView("almacenesFrame", "almacenBeanFiltro", almacenBeanFiltro);
	}
	
	private Almacen almacenBeanToAlmacenDaoMapper (AlmacenBean almacenBean){
		Almacen almacenDao = new Almacen();		
		almacenDao.setIdAlmacen(almacenBean.getIdAlmacen());
		almacenDao.setNombreAlmacen(almacenBean.getNombreAlmacen());
		almacenDao.setTelefono(almacenBean.getTelefono());
		return almacenDao;		
	}
//	private AlmacenBean almacenDaoToalmacenBeanMapper(Almacen almacenDAO){
//		AlmacenBean almacenFiltro = new AlmacenBean();
//		almacenFiltro.setIdAlmacen(almacenDAO.getIdAlmacen());
//		almacenFiltro.setNombreAlmacen(almacenDAO.getNombreAlmacen());
//		almacenFiltro.setTelefono(almacenDAO.getTelefono());
//		return almacenFiltro;
//	}
}
