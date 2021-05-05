package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDetalleServicioPlanDao;
import pe.edu.upc.entity.DetalleServicioPlan;
import pe.edu.upc.service.IDetalleServicioPlanService;

@Named
@RequestScoped
public class DetalleServicioPlanServiceImpl implements IDetalleServicioPlanService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDetalleServicioPlanDao dsD;
	
	@Override
	public void insertar(DetalleServicioPlan detalleServicioPlan) {
		dsD.insertar(detalleServicioPlan);
	}
	
	@Override
	public List<DetalleServicioPlan> listar() {
		return dsD.listar();
	}
	
	@Override
	public void eliminar(int idDetalleServicioPlan) {
		dsD.eliminar(idDetalleServicioPlan);
	}
}
