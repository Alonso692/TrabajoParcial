package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PagoCliente;
import pe.edu.upc.service.IPagoClienteService;

@Named
@RequestScoped
public class PagoClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPagoClienteService pacService;
	private PagoCliente pagocliente;
	List<PagoCliente> listaPagoClientes;
	
	@PostConstruct
	public void init() {
		this.listaPagoClientes = new ArrayList<PagoCliente>();
		this.pagocliente= new PagoCliente();
		this.listar();
	}
	
	public String nuevoPagoCliente() {
		this.setPagocliente(new PagoCliente());
		return "pagocliente.xhtml";
	}
	
	public void insertar() {
		try {
			pacService.insertar(pagocliente);
			limpiarPagoCliente();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaPagoClientes = pacService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void limpiarPagoCliente() {
		this.init();
	}
	
	public void eliminar(PagoCliente pac) {
		try {
			pacService.eliminar(pac.getIdPagoCliente());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public IPagoClienteService getPacService() {
		return pacService;
	}

	public void setPacService(IPagoClienteService pacService) {
		this.pacService = pacService;
	}

	public PagoCliente getPagocliente() {
		return pagocliente;
	}

	public void setPagocliente(PagoCliente pagocliente) {
		this.pagocliente = pagocliente;
	}

	public List<PagoCliente> getListaPagoClientes() {
		return listaPagoClientes;
	}

	public void setListaPagoClientes(List<PagoCliente> listaPagoClientes) {
		this.listaPagoClientes = listaPagoClientes;
	}


	



	

	
}
