package br.com.ricardow.drogaria.dao;

import org.junit.Test;

import br.com.ricardow.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setRazaoSocial("SOFAPE FABRICANTE DE FILTROS LTDA");
		fabricante.setCnpj("041550260002");
		fabricante.setDescricao("Fabricação De Peças");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
}
