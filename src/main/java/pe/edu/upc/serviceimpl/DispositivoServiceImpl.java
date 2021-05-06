package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDispositivoDao;
import pe.edu.upc.entity.Dispositivo;
import pe.edu.upc.service.IDispositivoService;

@Named
@RequestScoped
public class DispositivoServiceImpl implements IDispositivoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDispositivoDao sD;
	
	@Override
	public void insertar(Dispositivo dispositivo) {
		sD.insertar(dispositivo);
	}
	
	@Override
	public List<Dispositivo> listar() {
		return sD.listar();
	}
	
	@Override
	public void eliminar(int idDispositivo) {
		sD.eliminar(idDispositivo);
	}
	
	@Override
	public void modificar(Dispositivo dispositivo) {
		
		sD.modificar(dispositivo);
		
	}
}
