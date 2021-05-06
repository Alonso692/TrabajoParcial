package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleServicioPlan;

public interface IDetalleServicioPlanService {
	public void insertar(DetalleServicioPlan detalleServicioPlan);
	public List<DetalleServicioPlan> listar();
	public void eliminar(int idDetalleServicioPlan);
}
