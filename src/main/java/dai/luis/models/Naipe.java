package dai.luis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "naipes", catalog = "pruebas")
public class Naipe implements java.io.Serializable {
	private static final long serialVersionUID = -2859202191597594063L;

	public Naipe() {
	}
	
	@Id	
	@Column(name = "id_naipe", unique = true, nullable = false)
	private Integer idNaipe;
	
	@Column(name = "palo", length = 1)
	private String palo;
	
	@Column(name = "numero")
	private Integer numero;

	public Integer getIdNaipe() {
		return idNaipe;
	}

	public void setIdNaipe(Integer idNaipe) {
		this.idNaipe = idNaipe;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
