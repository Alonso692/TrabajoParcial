package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivo")
public class Dispositivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;
	
	@Column(name="tipoDispositivo", nullable = false, length=100)
	private String tipoDispositivo;

	@Column(name="modeloDispositivo", nullable = false, length=50)
	private String modeloDispositivo;
	
	@Column(name="descripcionDispositivo", nullable = false, length=100)
	private String descripcionDispositivo;
	
	@Column(name="precioDispositivo", nullable = false, length=4)
	private int precioDispositivo;

	public Dispositivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dispositivo(int idDispositivo, String tipoDispositivo, String modeloDispositivo,
			String descripcionDispositivo, int precioDispositivo) {
		super();
		this.idDispositivo = idDispositivo;
		this.tipoDispositivo = tipoDispositivo;
		this.modeloDispositivo = modeloDispositivo;
		this.descripcionDispositivo = descripcionDispositivo;
		this.precioDispositivo = precioDispositivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionDispositivo == null) ? 0 : descripcionDispositivo.hashCode());
		result = prime * result + idDispositivo;
		result = prime * result + ((modeloDispositivo == null) ? 0 : modeloDispositivo.hashCode());
		result = prime * result + precioDispositivo;
		result = prime * result + ((tipoDispositivo == null) ? 0 : tipoDispositivo.hashCode());
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
		Dispositivo other = (Dispositivo) obj;
		if (descripcionDispositivo == null) {
			if (other.descripcionDispositivo != null)
				return false;
		} else if (!descripcionDispositivo.equals(other.descripcionDispositivo))
			return false;
		if (idDispositivo != other.idDispositivo)
			return false;
		if (modeloDispositivo == null) {
			if (other.modeloDispositivo != null)
				return false;
		} else if (!modeloDispositivo.equals(other.modeloDispositivo))
			return false;
		if (precioDispositivo != other.precioDispositivo)
			return false;
		if (tipoDispositivo == null) {
			if (other.tipoDispositivo != null)
				return false;
		} else if (!tipoDispositivo.equals(other.tipoDispositivo))
			return false;
		return true;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getModeloDispositivo() {
		return modeloDispositivo;
	}

	public void setModeloDispositivo(String modeloDispositivo) {
		this.modeloDispositivo = modeloDispositivo;
	}

	public String getDescripcionDispositivo() {
		return descripcionDispositivo;
	}

	public void setDescripcionDispositivo(String descripcionDispositivo) {
		this.descripcionDispositivo = descripcionDispositivo;
	}

	public int getPrecioDispositivo() {
		return precioDispositivo;
	}

	public void setPrecioDispositivo(int precioDispositivo) {
		this.precioDispositivo = precioDispositivo;
	}

	
	
	
	
}
