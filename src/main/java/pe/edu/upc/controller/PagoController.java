package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Pago;
import pe.edu.upc.service.IPagoService;

@Named
@RequestScoped
public class PagoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPagoService paService;
	private Pago pago;
	List<Pago> listaPagos;
	
	@PostConstruct
	public void init() {
		this.listaPagos = new ArrayList<Pago>();
		this.pago= new Pago();
		this.listar();
	}
	
	public String nuevoPago() {
		this.setPago(new Pago());
		return "pago.xhtml";
	}
	
	public void insertar() {
		try {
			paService.insertar(pago);
			limpiarPago();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaPagos = paService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void limpiarPago() {
		this.init();
	}
	
	public void eliminar(Pago pa) {
		try {
			paService.eliminar(pa.getIdPago());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public IPagoService getPaService() {
		return paService;
	}

	public void setPaService(IPagoService paService) {
		this.paService = paService;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}



	

	
}
