package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPagoDao;
import pe.edu.upc.entity.Pago;

public class PagoDaoImpl implements IPagoDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Pago pago) {
		try {
			em.persist(pago);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> listar() {
		List<Pago> lista = new ArrayList<Pago>();
		try {
			Query q = em.createQuery("select pa from Pago pa"); 
			lista = (List<Pago>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPago) {
		Pago pa= new Pago();
		try {
			pa = em.getReference(Pago.class,idPago); 
			em.remove(pa);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
