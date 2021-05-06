package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	
	@Column(name="nombrePlan", nullable = false, length=100)
	private String nombrePlan;
	
	@Column(name="descripcionPlan", nullable = false, length= 100)
	private String descripcionPlan;
	
	@Column(name="precioPlan", nullable = false, length= 4)
	private int precioPlan;

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(int idPlan, String nombrePlan, String descripcionPlan, int precioPlan) {
		super();
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		this.descripcionPlan = descripcionPlan;
		this.precioPlan = precioPlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionPlan == null) ? 0 : descripcionPlan.hashCode());
		result = prime * result + idPlan;
		result = prime * result + ((nombrePlan == null) ? 0 : nombrePlan.hashCode());
		result = prime * result + precioPlan;
		return result;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public String getDescripcionPlan() {
		return descripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}

	public int getPrecioPlan() {
		return precioPlan;
	}

	public void setPrecioPlan(int precioPlan) {
		this.precioPlan = precioPlan;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (descripcionPlan == null) {
			if (other.descripcionPlan != null)
				return false;
		} else if (!descripcionPlan.equals(other.descripcionPlan))
			return false;
		if (idPlan != other.idPlan)
			return false;
		if (nombrePlan == null) {
			if (other.nombrePlan != null)
				return false;
		} else if (!nombrePlan.equals(other.nombrePlan))
			return false;
		if (precioPlan != other.precioPlan)
			return false;
		return true;
	}
	
	









	
}
