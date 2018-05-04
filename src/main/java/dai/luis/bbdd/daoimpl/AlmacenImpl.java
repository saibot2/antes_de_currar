package dai.luis.bbdd.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import dai.luis.bbdd.daointerfaz.AlmacenInterface;
import dai.luis.models.Almacen;

@Service
public class AlmacenImpl implements AlmacenInterface {

	@Override
	public Long crearAlmacen(Almacen almacen, Session session) {
		Long id = null;
		Transaction tx = null;				
		session.clear();
	    try {
	       tx = session.beginTransaction();
	       id = (Long)session.save(almacen);
	       tx.commit();
	    } catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();	      
	    }
	    /*finally {
	        if (session != null)session.close();
	    }*/
		return id;
	}
		
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<Almacen> buscarAlmacenes(Almacen almacen, Session session) {
//       // session.clear();
//		List<Almacen> almacenes = new ArrayList<>();
//		Criteria criteria = session.createCriteria(Almacen.class);
//		
//		if(almacen.getIdAlmacen()!=null){
//			criteria.add(Restrictions.eq("idAlmacen",almacen.getIdAlmacen()));
//		}
//		if(almacen.getNombreAlmacen()!=null && !almacen.getNombreAlmacen().isEmpty()){
//			criteria.add(Restrictions.like("nombreAlmacen","%"+almacen.getNombreAlmacen()));
//		}
//		if(almacen.getTelefono()!=null && !almacen.getTelefono().isEmpty()){
//			criteria.add(Restrictions.like("telefono","%"+almacen.getTelefono()));
//		}					
//		
//		criteria.addOrder(Order.asc("idAlmacen"));
//		
//		almacenes = criteria.list();
//		
//		return almacenes;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Almacen> buscarAlmacenes(Almacen almacen,Session session) {
//		String hql = "select DISTINCT a from Almacen a, Producto p";
		String hql = "select a from Almacen a";	
		
		if(almacen.getIdAlmacen()!=null){
			hql+= " where a.idAlmacen=:idAlmacen ";
		}else{
			hql+= " where a.idAlmacen IS NOT NULL ";
		}
				
		hql+= " "
//			+ " AND a = p.almacen "
//			+ " AND p.pvp > 10"			
			+ " AND a.nombreAlmacen like :nombreAlmacen "
			+ " AND a.telefono like :telefono"
			+ " AND a.esActivo <> 0"; //Eso es que no esta borrado
	
		Query query = session.createQuery(hql);	
		
		if(almacen.getIdAlmacen()!=null){
			query.setParameter("idAlmacen", almacen.getIdAlmacen());
		}	
		
	    query.setParameter("nombreAlmacen", almacen.getNombreAlmacen()+"%");
	    query.setParameter("telefono", almacen.getTelefono()+"%");
		
	    List<Almacen> almacenes = query.list();
		
		return almacenes;
	}
	
	@Override
	public Almacen buscarAlmacen(Long id, Session session) {
		Almacen almacen = new Almacen();
        session.clear();
		Transaction tx = null;  
		try {
			tx = session.beginTransaction();
			almacen = (Almacen) session.get(Almacen.class, id);
			tx.commit();//Commit transaction
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
		    e.printStackTrace();
		}
		/*finally {
	        if (session != null)session.close();
	    }*/		
		return almacen;
	}

	@Override
	public String updateAlmacen(Almacen almacen, Session session){
		String mensaje="ok";
		Transaction tx = null;
        session.clear();
		try {
			tx = session.beginTransaction();						
			session.update(almacen);
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

}
