package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pago")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	
	@Column(name="tipoPago", nullable = false, length=20)
	private String tipoPago;
	
	@Column(name="descripcionPlan", nullable = false, length= 100)
	private String descripcionPlan;
	
	@Column(name="fechaPago", nullable = false, length= 4)
	private Date fechaPago;

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int idPago, String tipoPago, String descripcionPlan, Date fechaPago) {
		super();
		this.idPago = idPago;
		this.tipoPago = tipoPago;
		this.descripcionPlan = descripcionPlan;
		this.fechaPago = fechaPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionPlan == null) ? 0 : descripcionPlan.hashCode());
		result = prime * result + ((fechaPago == null) ? 0 : fechaPago.hashCode());
		result = prime * result + idPago;
		result = prime * result + ((tipoPago == null) ? 0 : tipoPago.hashCode());
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
		Pago other = (Pago) obj;
		if (descripcionPlan == null) {
			if (other.descripcionPlan != null)
				return false;
		} else if (!descripcionPlan.equals(other.descripcionPlan))
			return false;
		if (fechaPago == null) {
			if (other.fechaPago != null)
				return false;
		} else if (!fechaPago.equals(other.fechaPago))
			return false;
		if (idPago != other.idPago)
			return false;
		if (tipoPago == null) {
			if (other.tipoPago != null)
				return false;
		} else if (!tipoPago.equals(other.tipoPago))
			return false;
		return true;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getDescripcionPlan() {
		return descripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}










	
}
