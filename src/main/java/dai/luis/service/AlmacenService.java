package dai.luis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.luis.bbdd.daointerfaz.AlmacenInterface;
import dai.luis.models.Almacen;
import dai.luis.models.Producto;
import dai.luis.util.HibernateUtil;

@Service
public class AlmacenService {
	@Autowired
	AlmacenInterface almacenInterface;
	
	public Long crearAlmacen(Almacen almacen){		 
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Long id = almacenInterface.crearAlmacen(almacen,session);		
		 session.close();
		 return id;
	 }
	
	public Almacen buscarAlmacen(Long id, Session session){
		Almacen almacen = almacenInterface.buscarAlmacen(id,session);				
		return almacen;
	}
	
	public Almacen buscarAlmacenById(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		Almacen almacen = almacenInterface.buscarAlmacen(id,session);		
		for(Producto producto:almacen.getProductos()){
			producto.getNombreProducto();
		}
		session.close();
		return almacen;
	}
	
	public String updateAlmacen(Almacen almacen, Session session){
		String mensaje = almacenInterface.updateAlmacen(almacen, session); 		
		return mensaje;
	}
	
	public String updateAlmacenSession(Almacen almacen){
		Session session = HibernateUtil.getSessionFactory().openSession();	
		String mensaje = almacenInterface.updateAlmacen(almacen, session); 		
		session.close();
		return mensaje;
	}
	
	public String borrarAlmacen(Long id){
		String mensaje="";
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*Busco Almacen para recoger objeto alamcen*/
		Almacen almacen = this.buscarAlmacen(id,session);
		almacen.setEsActivo(0);
		/*Borro almacen*/
		mensaje = this.updateAlmacen(almacen, session);
		session.close();
		return mensaje;
	}
	
	public List<Almacen> buscarAlmacenes (Almacen almacen){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Almacen> almacenes = new ArrayList<>();
		almacenes = almacenInterface.buscarAlmacenes(almacen,session);	
		for(Almacen almacen2:almacenes){
			for(Producto producto:almacen2.getProductos()){
				producto.getNombreProducto();
			}
		}				
		session.close();
		return almacenes;
	}
}
