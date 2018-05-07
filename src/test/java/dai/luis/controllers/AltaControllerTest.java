package dai.luis.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dai.luis.models.Almacen;
import dai.luis.models.Producto;
import dai.luis.service.AlmacenService;
import dai.luis.service.ProductoService;

public class AltaControllerTest extends AbstractControllerTest{

	@InjectMocks
	AltaController altaController;
	
	@Mock
	private ProductoService productoService;
	
	@Mock
	private AlmacenService almacenService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		super.setUp(altaController);
	}
	
	@Test
	public void testAlmacenes() throws Exception {
		/*Cualquiera de los dos métodos vale*/
		System.out.println("hola");
		assertExpectedMAVGet("/almacenes", "almacen");		
//		getMockMvc().perform(get("/almacenes"));
	}
	
	
	@Test
	public void testAltaAlmacen() throws Exception {
		/*Cualquiera de los dos métodos vale*/
		assertExpectedMAVGet("/altaAlmacenes", "altaAlmacen");		
		//getMockMvc().perform(get("/altaAlmacenes"));
	}
	
	
	@Test//(expected=Exception.class)
	public void testCrearAlmacen() throws Exception {
		when(almacenService.crearAlmacen(Mockito.any(Almacen.class))).thenReturn(Mockito.anyLong());
		
		//Exception ex = new Exception("Por motivos ajenos a Audatex, la obtención del bastidor y la fecha de matriculación mediante la matrícula no estará disponible temporalmente.");
		//when(almacenService.crearAlmacen(Mockito.any(Almacen.class))).thenThrow(ex);
		getMockMvc().perform(post("/altaAlmacenes")
				.param("idAlmacen", "1")//Estos param son los atributos del objeto Almacen.				
				.param("nombreAlmacen", "Almacen pelele")
				.param("telefono", "555-555555")
				.param("esActivo", "1")
		);
		
		verify(almacenService).crearAlmacen(Mockito.any(Almacen.class));
	}
	
	@Test
	public void testAltaProducto() throws Exception {
		/*Cualquiera de los dos métodos vale*/
		//assertExpectedMAVGet("/altaProducto/1", "modificaProducto");		
		getMockMvc().perform(get("/altaProducto/1"));
	}
	
	@Test
	public void testCrearProducto() throws Exception {
		when(productoService.crearProducto(Mockito.any(Producto.class))).thenReturn(Mockito.anyLong());
		getMockMvc().perform(post("/altaProducto")
				.param("idProducto", "0")//Estos param son los atributos del objeto Producto.				
				.param("nombreProducto", "pelele")
				.param("pvp", "2.5")
				.param("almacen.idAlmacen", "10")
				).andExpect(redirectedUrl("/modificaAlmacen.html?id=10&mensajecreado=Producto+creado+satisfactoriamente."));
		verify(productoService).crearProducto(Mockito.any(Producto.class));
	}
	
	
	
}
