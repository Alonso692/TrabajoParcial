package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Plan;
import pe.edu.upc.entity.Servicio;
import pe.edu.upc.entity.DetalleServicioPlan;

import pe.edu.upc.service.IPlanService;
import pe.edu.upc.service.IServicioService;
import pe.edu.upc.service.IDetalleServicioPlanService;

@Named
@RequestScoped
public class DetalleServicioPlanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPlanService pService;
	@Inject
	private IServicioService sService;
	
	@Inject
	private IDetalleServicioPlanService dsService;
			
	private Plan plan;
	private Servicio servicio;

	private DetalleServicioPlan detalleServicioPlan;
	
	List<Plan> listaPlanes;
	List<Servicio> listaServicios;
	List<DetalleServicioPlan> listaDetalleServicioPlanes;
	
	@PostConstruct
	public void init() {
		plan = new Plan();
		servicio = new Servicio();
		detalleServicioPlan = new DetalleServicioPlan();
		listaPlanes = new ArrayList<Plan>();
		listaServicios = new ArrayList<Servicio>();
		listaDetalleServicioPlanes = new ArrayList<DetalleServicioPlan>();
		
		this.listDetalleServicioPlan();
		this.listPlan();
		this.listServicio();
	}
	
	public String nuevoDetalleServicioPlan() {
		this.setDetalleServicioPlan(new DetalleServicioPlan());
		return "detalleservicioplan.xhtml";
	}
	
	public void insertar() {
		try {
			dsService.insertar(detalleServicioPlan);
			limpiarDetalleServicioPlan();
			this.listDetalleServicioPlan();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listPlan() {
		try {
			listaPlanes = pService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listServicio() {
		try {
			listaServicios = sService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listDetalleServicioPlan() {
		try {
			listaDetalleServicioPlanes = dsService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarDetalleServicioPlan() {
		this.init();
	}
	
	public void eliminar(DetalleServicioPlan detalleServicioPlan) {
		try {
			dsService.eliminar(detalleServicioPlan.getIdDetalleServicioPlan());
			this.listDetalleServicioPlan();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
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

	public DetalleServicioPlan getDetalleServicioPlan() {
		return detalleServicioPlan;
	}

	public void setDetalleServicioPlan(DetalleServicioPlan detalleServicioPlan) {
		this.detalleServicioPlan = detalleServicioPlan;
	}

	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}

	public void setListaPlanes(List<Plan> listaPlanes) {
		this.listaPlanes = listaPlanes;
	}

	public List<Servicio> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}

	public List<DetalleServicioPlan> getListaDetalleServicioPlanes() {
		return listaDetalleServicioPlanes;
	}

	public void setListaDetalleServicioPlanes(List<DetalleServicioPlan> listaDetalleServicioPlanes) {
		this.listaDetalleServicioPlanes = listaDetalleServicioPlanes;
	}


	
	
}
