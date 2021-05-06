package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.DetalleDispositivoPlan;

public interface IDetalleDispositivoPlanDao {
	public void insertar(DetalleDispositivoPlan detalleDispositivoPlan);
	public List<DetalleDispositivoPlan> listar();
	public void eliminar(int idDetalleDispositivoPlan );
}
