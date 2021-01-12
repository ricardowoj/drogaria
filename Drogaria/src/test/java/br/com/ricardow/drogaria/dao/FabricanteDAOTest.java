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

		for (Fabricante fabricante : resultado) {
			System.out.println(
					fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 20L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println(
					fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 17L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		fabricanteDAO.excluir(fabricante);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro removido:");
			System.out.println(
					fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 18L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			fabricante.setRazaoSocial("FSBR - FABRICA DE SOFTWARE DO BRASIL LTDA");
			fabricante.setCnpj("202631100001");
			fabricante.setDescricao("DESENVOLVIMENTO E LICENCIAMENTO DE PROGRAMAS DE COMPUTADOR CUSTOMIZÁVEIS");
			fabricanteDAO.editar(fabricante);
			System.out.println("Registro editado:");
			System.out.println(
					fabricante.getRazaoSocial() + " - " + fabricante.getCnpj() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	public void merge() {
		//Fabricante fabricante = new Fabricante();
		//fabricante.setRazaoSocial("Fabricante teste");
		//fabricante.setCnpj("100000000000");
		//fabricante.setDescricao("Fabricação De testes");
		//FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//fabricanteDAO.merge(fabricante);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(16L);
		fabricante.setCnpj("100000000011");
		fabricanteDAO.merge(fabricante);
	}
}
