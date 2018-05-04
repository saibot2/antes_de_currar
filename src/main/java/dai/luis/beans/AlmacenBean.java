package dai.luis.beans;

import java.io.Serializable;

public class AlmacenBean implements Serializable {
	private static final long serialVersionUID = 3481274912989833917L;
	
	private Long idAlmacen;
	private Long idAlmacenEditar;
	private String nombreAlmacen;
	private String telefono;	
	
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
	public Long getIdAlmacenEditar() {
		return idAlmacenEditar;
	}
	public void setIdAlmacenEditar(Long idAlmacenEditar) {
		this.idAlmacenEditar = idAlmacenEditar;
	}
}
