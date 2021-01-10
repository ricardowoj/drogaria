package br.com.ricardow.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Fabricante;
import br.com.ricardow.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigoFabricante = 18L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro encontrado para cidade.");
		}
		else {
			Produto produto = new Produto();
			produto.setDescricao("TYLENOL 750mg é um analgésico.");
			produto.setNome("Tylenol 750mg");
			produto.setPreco(BigDecimal.valueOf(25.99));
			produto.setQuantidade(Short.valueOf("1000"));
			produto.setFabricante(fabricante);
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			
			System.out.println("Registro salvo:");
			System.out.println("Nome do produto: " + produto.getNome());
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		for(Produto produto : resultado) {
			System.out.println(
					"nome: " + produto.getNome() +
					" - " +
					"Quantidade: " + produto.getQuantidade()
					);
		}
	}
	
	@Test
	@Ignore
	public void Buscar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(31L);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println("Nome do produto: " + produto.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(31L);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			produtoDAO.excluir(produto);
			System.out.println("Registro removido:");
			System.out.println("Nome do produto: " + produto.getNome());
		}
	}
	
	@Test
	public void editar() {
		Long codigoFabricante = 18L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro encontrado para cidade.");
		}
		else {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.buscar(32L);
			produto.setDescricao("TYLENOL 1000mg é um analgésico.");
			produto.setNome("Tylenol 1000mg");
			produto.setPreco(BigDecimal.valueOf(29.19));
			
			produtoDAO.editar(produto);
			
			System.out.println("Registro salvo:");
			System.out.println("Nome do produto: " + produto.getNome());
		}
	}
}
