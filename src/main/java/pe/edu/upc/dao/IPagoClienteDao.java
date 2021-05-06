package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.PagoCliente;

public interface IPagoClienteDao {
	public void insertar(PagoCliente pagocliente);
	public List<PagoCliente> listar();
	public void eliminar(int idPagoCliente );
}
