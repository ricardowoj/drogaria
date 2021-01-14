package br.com.ricardow.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.ricardow.drogaria.dao.CidadeDAO;
import br.com.ricardow.drogaria.dao.EstadoDAO;
import br.com.ricardow.drogaria.domain.Cidade;
import br.com.ricardow.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} 
		catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao listar as cidades");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao listar uma nova cidade");
			e.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			cidades = cidadeDAO.listar();
			
			Messages.addFlashGlobalInfo("Cidade salva com sucesso");
		} 
		catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao salvar a cidade");
			e.printStackTrace();
		}
	}

}
