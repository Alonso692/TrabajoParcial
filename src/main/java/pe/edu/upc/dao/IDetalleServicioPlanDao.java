package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.DetalleServicioPlan;

public interface IDetalleServicioPlanDao {
	public void insertar(DetalleServicioPlan detalleServicioPlan);
	public List<DetalleServicioPlan> listar();
	public void eliminar(int idDetalleServicioPlan );
}
