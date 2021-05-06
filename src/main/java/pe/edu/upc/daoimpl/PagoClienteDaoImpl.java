package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPagoClienteDao;
import pe.edu.upc.entity.PagoCliente;

public class PagoClienteDaoImpl implements IPagoClienteDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(PagoCliente pagocliente) {
		try {
			em.persist(pagocliente);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagoCliente> listar() {
		List<PagoCliente> lista = new ArrayList<PagoCliente>();
		try {
			Query q = em.createQuery("select pc from Pago pc"); 
			lista = (List<PagoCliente>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPagoCliente) {
		PagoCliente pc= new PagoCliente();
		try {
			pc = em.getReference(PagoCliente.class,idPagoCliente); 
			em.remove(pc);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
