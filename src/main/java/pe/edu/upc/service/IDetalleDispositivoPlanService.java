package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleDispositivoPlan;

public interface IDetalleDispositivoPlanService {
	public void insertar(DetalleDispositivoPlan detalleDispositivoPlan);
	public List<DetalleDispositivoPlan> listar();
	public void eliminar(int idDetalleDispositivoPlan);
}
