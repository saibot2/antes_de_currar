package dai.luis.bbdd.daointerfaz;

import java.util.List;

import org.hibernate.Session;

import dai.luis.models.Almacen;


public interface AlmacenInterface {
	public Long crearAlmacen(Almacen almacen, Session session);
	public List<Almacen> buscarAlmacenes(Almacen almacen, Session session);
//	public List<Almacen> buscarAlmacenesHQL(Session session);
	public Almacen buscarAlmacen(Long id, Session session);
	public String updateAlmacen(Almacen almacen, Session session);
}
