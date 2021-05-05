package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Plan;
import pe.edu.upc.entity.Dispositivo;
import pe.edu.upc.entity.DetalleDispositivoPlan;

import pe.edu.upc.service.IPlanService;
import pe.edu.upc.service.IDispositivoService;
import pe.edu.upc.service.IDetalleDispositivoPlanService;

@Named
@RequestScoped
public class DetalleDispositivoPlanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPlanService pService;
	@Inject
	private IDispositivoService dService;
	
	@Inject
	private IDetalleDispositivoPlanService ddService;
			
	private Plan plan;
	private Dispositivo dispositivo;
	private DetalleDispositivoPlan detalleDispositivoPlan;
	
	List<Plan> listaPlanes;
	List<Dispositivo> listaDispositivos;
	List<DetalleDispositivoPlan> listaDetalleDispositivoPlanes;
	
	@PostConstruct
	public void init() {
		plan = new Plan();
		dispositivo = new Dispositivo();
		detalleDispositivoPlan = new DetalleDispositivoPlan();
		listaPlanes = new ArrayList<Plan>();
		listaDispositivos = new ArrayList<Dispositivo>();
		listaDetalleDispositivoPlanes = new ArrayList<DetalleDispositivoPlan>();
		
		this.listDetalleDispositivoPlan();
		this.listPlan();
		this.listDispositivo();
	}
	
	public String nuevoDetalleDispositivoPlan() {
		this.setDetalleDispositivoPlan(new DetalleDispositivoPlan());
		return "detalledispositivoplan.xhtml";
	}
	
	public void insertar() {
		try {
			ddService.insertar(detalleDispositivoPlan);
			limpiarDetalleDispositivoPlan();
			this.listDetalleDispositivoPlan();
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
	
	public void listDispositivo() {
		try {
			listaDispositivos = dService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listDetalleDispositivoPlan() {
		try {
			listaDetalleDispositivoPlanes = ddService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarDetalleDispositivoPlan() {
		this.init();
	}
	
	public void eliminar(DetalleDispositivoPlan detalleDispositivoPlan) {
		try {
			ddService.eliminar(detalleDispositivoPlan.getIdDetalleDispositivoPlan());
			this.listDetalleDispositivoPlan();
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

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public DetalleDispositivoPlan getDetalleDispositivoPlan() {
		return detalleDispositivoPlan;
	}

	public void setDetalleDispositivoPlan(DetalleDispositivoPlan detalleDispositivoPlan) {
		this.detalleDispositivoPlan = detalleDispositivoPlan;
	}

	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}

	public void setListaPlanes(List<Plan> listaPlanes) {
		this.listaPlanes = listaPlanes;
	}

	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	public List<DetalleDispositivoPlan> getListaDetalleDispositivoPlanes() {
		return listaDetalleDispositivoPlanes;
	}

	public void setListaDetalleDispositivoPlanes(List<DetalleDispositivoPlan> listaDetalleDispositivoPlanes) {
		this.listaDetalleDispositivoPlanes = listaDetalleDispositivoPlanes;
	}

	


}
