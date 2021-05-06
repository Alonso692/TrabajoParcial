package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetalleDispositivoPlanDao;
import pe.edu.upc.entity.DetalleDispositivoPlan;

public class DetalleDispositivoPlanDaoImpl implements IDetalleDispositivoPlanDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(DetalleDispositivoPlan detalleDispositivoPlan) {
		try {
			em.persist(detalleDispositivoPlan);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleDispositivoPlan> listar() {
		List<DetalleDispositivoPlan> lista = new ArrayList<DetalleDispositivoPlan>();
		try {
			Query ddp = em.createQuery("select ddp from DetalleDispositivoPlan ddp"); 
			lista = (List<DetalleDispositivoPlan>) ddp.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idDetalleServicioPlan) {
		DetalleDispositivoPlan ddp = new DetalleDispositivoPlan();
		try {
			ddp = em.getReference(DetalleDispositivoPlan.class,idDetalleServicioPlan); 
			em.remove(ddp);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
