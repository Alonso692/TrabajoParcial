package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPagoClienteDao;
import pe.edu.upc.entity.PagoCliente;
import pe.edu.upc.service.IPagoClienteService;

@Named
@RequestScoped
public class PagoClienteServiceImpl implements IPagoClienteService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPagoClienteDao pacD;
	
	@Override
	public void insertar(PagoCliente pagocliente) {
		pacD.insertar(pagocliente);
	}
	
	@Override
	public List<PagoCliente> listar() {
		return pacD.listar();
	}
	
	@Override
	public void eliminar(int idPago) {
		pacD.eliminar(idPago);
	}
}
