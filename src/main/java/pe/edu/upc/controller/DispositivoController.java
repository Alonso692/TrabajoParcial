package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Dispositivo;
import pe.edu.upc.service.IDispositivoService;

@Named
@RequestScoped
public class DispositivoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDispositivoService dService;
	private Dispositivo dispositivo;
	List<Dispositivo> listaDispositivos;
	
	@PostConstruct
	public void init() {
		this.listaDispositivos = new ArrayList<Dispositivo>();
		this.dispositivo= new Dispositivo();
		this.listar();
	}
	
	public String nuevoDispositivo() {
		this.setDispositivo(new Dispositivo());
		return "dispositivo.xhtml";
	}
	
	public void insertar() {
		try {
			dService.insertar(dispositivo);
			limpiarDispositivo();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaDispositivos = dService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void limpiarDispositivo() {
		this.init();
	}
	
	public void eliminar(Dispositivo d) {
		try {
			dService.eliminar(d.getIdDispositivo());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}


	

	
}
