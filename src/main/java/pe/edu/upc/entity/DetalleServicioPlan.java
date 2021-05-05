package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleServioPlan")
public class DetalleServicioPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleServicioPlan;
	
	@Column(name="descripcionDetalleSP", nullable=false, length=100)
	private String descripcionDetalleSP;
	
	@ManyToOne
	@JoinColumn(name="idPlan")
	private Plan plan;
	
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	public DetalleServicioPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleServicioPlan(int idDetalleServicioPlan, String descripcionDetalleSP, Plan plan, Servicio servicio) {
		super();
		this.idDetalleServicioPlan = idDetalleServicioPlan;
		this.descripcionDetalleSP = descripcionDetalleSP;
		this.plan = plan;
		this.servicio = servicio;
	}

	public int getIdDetalleServicioPlan() {
		return idDetalleServicioPlan;
	}

	public void setIdDetalleServicioPlan(int idDetalleServicioPlan) {
		this.idDetalleServicioPlan = idDetalleServicioPlan;
	}

	public String getDescripcionDetalleSP() {
		return descripcionDetalleSP;
	}

	public void setDescripcionDetalleSP(String descripcionDetalleSP) {
		this.descripcionDetalleSP = descripcionDetalleSP;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	
}
