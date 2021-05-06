package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDispositivoDao;
import pe.edu.upc.entity.Dispositivo;

public class DispositivoDaoImpl implements IDispositivoDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Dispositivo dispositivo) {
		try {
			em.persist(dispositivo);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dispositivo> listar() {
		List<Dispositivo> lista = new ArrayList<Dispositivo>();
		try {
			Query d= em.createQuery("select d from Dispositivo d"); 
			lista = (List<Dispositivo>) d.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idDispositivo) {
		Dispositivo d = new Dispositivo();
		try {
			d = em.getReference(Dispositivo.class,idDispositivo); 
			em.remove(d);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	@Transactional
	@Override
	public void modificar(Dispositivo dispositivo) {
		try {
			em.merge(dispositivo);
		} catch (Exception ex) {
			System.out.println("Error en la actualizacion del Plan");
		}
		
	}
	
}
