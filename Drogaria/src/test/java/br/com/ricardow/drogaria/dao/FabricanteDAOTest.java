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
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de registro: " + resultado.size());
		
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}
}
