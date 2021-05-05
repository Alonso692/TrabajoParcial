package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Servicio;

public interface IServicioDao {
	public void insertar(Servicio servicio);
	public List<Servicio> listar();
	public void eliminar(int idServicio );
}
