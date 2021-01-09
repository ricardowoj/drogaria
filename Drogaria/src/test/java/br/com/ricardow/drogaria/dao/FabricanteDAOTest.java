package br.com.ricardow.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setRazaoSocial("SOFAPE FABRICANTE DE FILTROS LTDA");
		fabricante.setCnpj("041550260002");
		fabricante.setDescricao("Fabricação De Peças");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de registro: " + resultado.size());
		
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	public void buscar() {
		Long codigo = 20L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println(fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}
}
