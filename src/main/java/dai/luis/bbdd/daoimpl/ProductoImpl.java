package dai.luis.bbdd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import dai.luis.bbdd.daointerfaz.ProductoInterface;
import dai.luis.controllers.ListadosController;
import dai.luis.models.Producto;

@Service
public class ProductoImpl implements ProductoInterface {

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscarProductos(Long idAlmacen, Session session) {
		List<Producto> productos = new ArrayList<>();
        session.clear();
		String hql = "from Producto p"
		        + " where p.almacenes.idAlmacen=:idAlmacen order by p.idProducto";
		Query query = session.createQuery(hql);
		query.setParameter("idAlmacen", idAlmacen);
		productos = query.list();
		return productos;
	}

	@Override
	public Producto buscarProducto(Long id, Session session) {
		Producto producto = new Producto();
        session.clear();
		Transaction tx = null;  
		try {
			tx = session.beginTransaction();
			producto = (Producto) session.get(Producto.class, id);
			tx.commit();//Commit transaction
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
		    e.printStackTrace();
		}
		/*finally {
	        if (session != null)session.close();
	    }*/		
		return producto;
	}

	@Override
	public String updateProducto(Producto producto, Session session) {
		String mensaje="ok";
		Transaction tx = null;
        session.clear();
		try {
			tx = session.beginTransaction();	
			session.update(producto);
			tx.commit();
		}catch (HibernateException e) {			
			if(tx!=null) tx.rollback();		
			mensaje="ko";
			e.printStackTrace();
		}
		/*finally {
	        if (session != null)session.close();
	    }*/
		return mensaje;
	}

	@Override
	public Long crearProducto(Producto producto, Session session) {
		Long id = null;
		Transaction tx = null;
        session.clear();
		try {
			tx = session.beginTransaction();	
			id = (Long) session.save(producto);
			tx.commit();
		}catch (HibernateException e) {			
			if(tx!=null) tx.rollback();					
			e.printStackTrace();
		}
		/*finally {
	        if (session != null)session.close();
	    }*/
		return id;
	}

	@Override
	public void borrarProducto(Long id, Session session) {
		Transaction tx = null;    
	    try {
	       tx = session.beginTransaction();
	       Producto producto = (Producto) session.get(Producto.class, id);
	       session.delete(producto);
	       tx.commit();//Commit transaction
	    } catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }
	    /*finally {
	       session.close(); 
	    }*/
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscaTodosProductos(int paginaAMostrar, Session session) {
		
		List<Producto> productos = new ArrayList<>();
        session.clear();
		String hql = " select p from Producto p, Almacen a"
		           + " where p.almacen = a"
		           + " order by p.idProducto";
		Query query = session.createQuery(hql);
		
		query.setMaxResults(ListadosController.TAMANYO_PAGINA);
		query.setFirstResult(paginaAMostrar * ListadosController.TAMANYO_PAGINA);
		
		productos = query.list();
		return productos;
	}

	@Override
	public Long cuentaTodosProductos(Session session) {
		Long numProductos =  (Long) session.createQuery("SELECT count(*) FROM Producto p").uniqueResult();
		return numProductos;
	}
}
