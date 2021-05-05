package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Servicio;

public interface IServicioService {
	public void insertar(Servicio servicio);
	public List<Servicio> listar();
	public void eliminar(int idServicio);
}
