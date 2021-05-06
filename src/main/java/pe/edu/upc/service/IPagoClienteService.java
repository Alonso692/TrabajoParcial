package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.PagoCliente;

public interface IPagoClienteService {
	public void insertar(PagoCliente pagocliente);
	public List<PagoCliente> listar();
	public void eliminar(int idPagoCliente);
}
