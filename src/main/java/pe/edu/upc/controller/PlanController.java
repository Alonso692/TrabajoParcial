package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Plan;
import pe.edu.upc.service.IPlanService;

@Named
@RequestScoped
public class PlanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPlanService pService;
	private Plan plan;
	List<Plan> listaPlanes;
	
	@PostConstruct
	public void init() {
		this.listaPlanes = new ArrayList<Plan>();
		this.plan= new Plan();
		this.listar();
	}
	
	public String nuevoPlan() {
		this.setPlan(new Plan());
		return "plan.xhtml";
	}
	
	public void insertar() {
		try {
			pService.insertar(plan);
			limpiarPlan();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaPlanes = pService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void limpiarPlan() {
		this.init();
	}
	
	public void eliminar(Plan p) {
		try {
			pService.eliminar(p.getIdPlan());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public String goModificar(Plan plan) {
		this.setPlan(plan);
		return "editar.xhtml";
	}
	
	
	public void modificar() {
		try {
			pService.modificar(plan);
			this.listar();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}

	public void setListaPlanes(List<Plan> listaPlanes) {
		this.listaPlanes = listaPlanes;
	}
	
	
	public void clean() {
		this.init();
	}
	
	public void findByName() {
		if (plan.getNombrePlan().isEmpty()) {
			this.listar();
		}
		else {
			listaPlanes = this.pService.findByNamePlan(this.getPlan());
		}
	}



	

	
}
