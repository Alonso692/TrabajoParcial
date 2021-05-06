package pe.edu.upc.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombreUsuario", nullable = false, length=100)
	private String nombreUsuario;
	
	@Column(name="apellidoUsuario", nullable = false, length= 100)
	private String apellidoUsuario;
	
	@Column(name="correoUsuario", nullable = false, length= 100)
	private String correoUsuario;
	
	@Column(name="tipoUsuario", nullable = false, length= 20)
	private String topoUsuario;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
			String topoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.correoUsuario = correoUsuario;
		this.topoUsuario = topoUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getTopoUsuario() {
		return topoUsuario;
	}

	public void setTopoUsuario(String topoUsuario) {
		this.topoUsuario = topoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoUsuario == null) ? 0 : apellidoUsuario.hashCode());
		result = prime * result + ((correoUsuario == null) ? 0 : correoUsuario.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((topoUsuario == null) ? 0 : topoUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apellidoUsuario == null) {
			if (other.apellidoUsuario != null)
				return false;
		} else if (!apellidoUsuario.equals(other.apellidoUsuario))
			return false;
		if (correoUsuario == null) {
			if (other.correoUsuario != null)
				return false;
		} else if (!correoUsuario.equals(other.correoUsuario))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (topoUsuario == null) {
			if (other.topoUsuario != null)
				return false;
		} else if (!topoUsuario.equals(other.topoUsuario))
			return false;
		return true;
	}
	
	

	









	
}
