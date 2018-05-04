package dai.luis.view;

import dai.luis.models.Producto;

public class AlmacenView {

	private Long idAlmacen;
	private String nombreAlmacen;
	private String telefono;
	private Producto producto;
	
	public Long getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}
	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
