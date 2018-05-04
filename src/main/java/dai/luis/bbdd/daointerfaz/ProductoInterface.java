package dai.luis.bbdd.daointerfaz;

import java.util.List;

import org.hibernate.Session;

import dai.luis.models.Producto;

public interface ProductoInterface {
	public List<Producto> buscarProductos(Long idAlmacen, Session session);
	public List<Producto> buscaTodosProductos(int paginaAMostrar, Session session);
	public Producto buscarProducto(Long id, Session session);
	public String updateProducto(Producto producto, Session session);
	public Long crearProducto(Producto producto, Session session);
	public void borrarProducto(Long id, Session session);
	public Long cuentaTodosProductos(Session session);
}