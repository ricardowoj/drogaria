package br.com.ricardow.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ricardow.drogaria.dao.EstadoDAO;
import br.com.ricardow.drogaria.domain.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		}
		catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		estado = new Estado();
	}
	
	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			
			novo();
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado salvo com sucesso.");
		}
		catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent event) {
		try {
			estado = (Estado) event.getComponent().getAttributes().get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado excluído com sucesso.");
		} 
		catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
			e.printStackTrace();
		}

	}
	
	public void editar(ActionEvent event) {
		estado = (Estado) event.getComponent().getAttributes().get("estadoSelecionado");
		
	}
}
