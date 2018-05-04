package dai.luis.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.luis.bbdd.daointerfaz.ProductoInterface;
import dai.luis.models.Almacen;
import dai.luis.models.Producto;
import dai.luis.util.HibernateUtil;

@Service
public class ProductoService {
	
	@Autowired
	ProductoInterface productoInterface;
	
	 public Long crearProducto (Producto producto){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		Long id = productoInterface.crearProducto(producto, session);
		session.close();
		return id;
	 }
	 
	 public void borrarProducto(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		productoInterface.borrarProducto(id,session);
		session.close();
	}
	 
	 public Long cuentaTodosProductos(){		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long numProductos = productoInterface.cuentaTodosProductos(session);		
		session.close();
		return numProductos;
	}
	
	 public List<Producto> listadoProductos(int paginaAMostrar){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Producto> productos = productoInterface.buscaTodosProductos(paginaAMostrar, session);	
		for(Producto item:productos){//Para rellenar Almacen
			item.getAlmacen().getIdAlmacen();
		}
		session.close();
		return productos;
	} 
	 
	 public Producto buscarProducto(Long id,Long idAlmacen){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		Producto producto = productoInterface.buscarProducto(id, session);
		Almacen almacen = new Almacen();
		almacen.setIdAlmacen(idAlmacen);			
		producto.setAlmacen(almacen);
		session.close();
		return producto;
	} 
	 
	 public String updateProducto(Producto producto){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		String mensaje = productoInterface.updateProducto(producto, session); 		
		session.close();
		return mensaje;
	}	 
}
