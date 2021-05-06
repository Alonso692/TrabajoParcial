package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPlanDao;
import pe.edu.upc.entity.Plan;

public class PlanDaoImpl implements IPlanDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Plan plan) {
		try {
			em.persist(plan);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> listar() {
		List<Plan> lista = new ArrayList<Plan>();
		try {
			Query p = em.createQuery("select p from Plan p"); 
			lista = (List<Plan>) p.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findByNamePlan(Plan c) {
		List<Plan> lista = new ArrayList<Plan>();
		Query q = em.createQuery("from Plan c where c.nombrePlan like ?1");
		q.setParameter(1, "%" + c.getNombrePlan() + "%");
		lista = (List<Plan>)q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPlan) {
		Plan p = new Plan();
		try {
			p = em.getReference(Plan.class,idPlan); 
			em.remove(p);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

	@Transactional
	@Override
	public void modificar(Plan plan) {
		try {
			em.merge(plan);
		} catch (Exception ex) {
			System.out.println("Error en la actualizacion del Plan");
		}
		
	}
	
}
