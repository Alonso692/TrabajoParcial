package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDetalleDispositivoPlanDao;
import pe.edu.upc.entity.DetalleDispositivoPlan;
import pe.edu.upc.service.IDetalleDispositivoPlanService;

@Named
@RequestScoped
public class DetalleDispositivoPlanServiceImpl implements IDetalleDispositivoPlanService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDetalleDispositivoPlanDao ddD;
	
	@Override
	public void insertar(DetalleDispositivoPlan detalleDispositivoPlan) {
		ddD.insertar(detalleDispositivoPlan);
	}
	
	@Override
	public List<DetalleDispositivoPlan> listar() {
		return ddD.listar();
	}
	
	@Override
	public void eliminar(int idDetalleDispositivoPlan) {
		ddD.eliminar(idDetalleDispositivoPlan);
	}
}
