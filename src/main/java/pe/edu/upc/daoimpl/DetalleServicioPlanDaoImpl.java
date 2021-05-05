package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetalleServicioPlanDao;
import pe.edu.upc.entity.DetalleServicioPlan;

public class DetalleServicioPlanDaoImpl implements IDetalleServicioPlanDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(DetalleServicioPlan detalleServicioPlan) {
		try {
			em.persist(detalleServicioPlan);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleServicioPlan> listar() {
		List<DetalleServicioPlan> lista = new ArrayList<DetalleServicioPlan>();
		try {
			Query dsp = em.createQuery("select dsp from DetalleServicioPlan dsp"); 
			lista = (List<DetalleServicioPlan>) dsp.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idDetalleServicioPlan) {
		DetalleServicioPlan dsp = new DetalleServicioPlan();
		try {
			dsp = em.getReference(DetalleServicioPlan.class,idDetalleServicioPlan); 
			em.remove(dsp);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
