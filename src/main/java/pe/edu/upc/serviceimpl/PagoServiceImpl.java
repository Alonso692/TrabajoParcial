package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPagoDao;
import pe.edu.upc.entity.Pago;
import pe.edu.upc.service.IPagoService;

@Named
@RequestScoped
public class PagoServiceImpl implements IPagoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPagoDao paD;
	
	@Override
	public void insertar(Pago pago) {
		paD.insertar(pago);
	}
	
	@Override
	public List<Pago> listar() {
		return paD.listar();
	}
	
	@Override
	public void eliminar(int idPago) {
		paD.eliminar(idPago);
	}
}
