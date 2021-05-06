package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Dispositivo;

public interface IDispositivoDao {
	public void insertar(Dispositivo dispositivo);
	public List<Dispositivo> listar();
	public void eliminar(int idDispositivo );
	public void modificar(Dispositivo dispositivo);

}
