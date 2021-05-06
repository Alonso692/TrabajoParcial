package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	
	@Column(name="nombreServicio", nullable = false, length=100)
	private String nombreServicio;

	@Column(name="descripcionServicio", nullable = false, length=100)
	private String descripcionServicio;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(int idServicio, String nombreServicio, String descripcionServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.descripcionServicio = descripcionServicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionServicio == null) ? 0 : descripcionServicio.hashCode());
		result = prime * result + idServicio;
		result = prime * result + ((nombreServicio == null) ? 0 : nombreServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		if (descripcionServicio == null) {
			if (other.descripcionServicio != null)
				return false;
		} else if (!descripcionServicio.equals(other.descripcionServicio))
			return false;
		if (idServicio != other.idServicio)
			return false;
		if (nombreServicio == null) {
			if (other.nombreServicio != null)
				return false;
		} else if (!nombreServicio.equals(other.nombreServicio))
			return false;
		return true;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}


	
	
}
