package dai.luis.beans;
import java.io.Serializable;

public class MensajePrueba implements Serializable {
	private static final long serialVersionUID = 423382551401522919L;
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
