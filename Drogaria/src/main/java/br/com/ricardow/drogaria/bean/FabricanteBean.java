package br.com.ricardow.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ricardow.drogaria.dao.FabricanteDAO;
import br.com.ricardow.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	@PostConstruct
	public void listar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void novo() {
		fabricante = new Fabricante();
	}
	
	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);
			
			novo();
			fabricantes = fabricanteDAO.listar();
			
			Messages.addFlashGlobalInfo("Fabricante salvo com sucesso");
		} 
		catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent event) {
		try {
			fabricante = (Fabricante) event.getComponent().getAttributes().get("fabricanteSelecionado");
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			
			fabricantes = fabricanteDAO.listar();
			
			Messages.addFlashGlobalInfo("Fabricante removido com sucesso");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent event) {
		fabricante = (Fabricante) event.getComponent().getAttributes().get("fabricanteSelecionado");
	}
}
