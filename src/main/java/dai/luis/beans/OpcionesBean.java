package dai.luis.beans;

import java.io.Serializable;
import java.util.List;

public class OpcionesBean implements Serializable{	
	private static final long serialVersionUID = 7883115379944041595L;
	
	private boolean disponible;
    private List<String> sugerencias;
    
    public OpcionesBean() {    	
    }
	
    public OpcionesBean(boolean disponible,List<String> sugerencias) {
    	this.disponible=disponible;
    	this.sugerencias=sugerencias;    	
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public List<String> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<String> sugerencias) {
		this.sugerencias = sugerencias;
	}
}
