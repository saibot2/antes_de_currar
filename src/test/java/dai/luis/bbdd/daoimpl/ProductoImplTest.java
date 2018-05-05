package dai.luis.bbdd.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dai.luis.bbdd.daointerfaz.ProductoInterface;
import dai.luis.models.Almacen;
import dai.luis.models.Producto;
import dai.luis.service.ProductoService;

public class ProductoImplTest {

	@InjectMocks
	ProductoService productoService;
	
	@Mock
	ProductoInterface productoInterface;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListadoProductos() {
		List<Producto> productosMock = mockProductosList();
		when(productoInterface.buscaTodosProductos(anyInt(), Mockito.any(Session.class))).thenReturn(productosMock);
		List<Producto> productos = productoService.listadoProductos(1);
		assertNotNull(productos);
		assertEquals(1, productos.size());
		verify(productoInterface).buscaTodosProductos(anyInt(), Mockito.any(Session.class));
	}
	
	@Test
	public void testBuscarProducto() {
		when(productoInterface.buscarProducto(anyLong(), Mockito.any(Session.class))).thenReturn(mockProducto());
		Producto producto = productoService.buscarProducto(1L, 1L);
		assertNotNull(producto);
		assertEquals("Pepinillos", producto.getNombreProducto());
		verify(productoInterface).buscarProducto(anyLong(), Mockito.any(Session.class));
	}
	
	@Test
	public void testCrearProducto() {
		when(productoInterface.crearProducto(Mockito.any(Producto.class), Mockito.any(Session.class))).thenReturn(new Long(10));
		Long id = productoService.crearProducto(mockProducto());
		assertNotNull(id);
		assertEquals(10L, id.longValue());
		verify(productoInterface).crearProducto(Mockito.any(Producto.class), Mockito.any(Session.class));
	}
	
	private Producto mockProducto() {
		Producto producto = new Producto();
		producto.setIdProducto(1L);
		producto.setNombreProducto("Pepinillos");
		producto.setPvp(53.2F);
		
		Almacen almacen = new Almacen();
		almacen.setIdAlmacen(1L);
		almacen.setEsActivo(1);
		almacen.setNombreAlmacen("Alamacenes pepe");
		almacen.setTelefono("677 403914");
		producto.setAlmacen(almacen);
		
		return producto;
	}
	
	private List<Producto> mockProductosList() {
		List<Producto> productos  = new ArrayList<>();
		productos.add(mockProducto());
		return productos;
	}

	
	
}
