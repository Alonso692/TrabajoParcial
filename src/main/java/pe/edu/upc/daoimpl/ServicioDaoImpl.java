package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IServicioDao;
import pe.edu.upc.entity.Servicio;

public class ServicioDaoImpl implements IServicioDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Servicio servicio) {
		try {
			em.persist(servicio);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> listar() {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			Query s = em.createQuery("select s from Servicio s"); 
			lista = (List<Servicio>) s.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idServicio) {
		Servicio s = new Servicio();
		try {
			s = em.getReference(Servicio.class,idServicio); 
			em.remove(s);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
