package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Plan;

public interface IPlanService {
	public void insertar(Plan plan);
	public List<Plan> listar();
	public void eliminar(int idPlan);
}
