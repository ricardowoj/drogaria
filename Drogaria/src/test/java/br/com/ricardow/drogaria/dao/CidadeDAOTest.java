package br.com.ricardow.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Cidade;
import br.com.ricardow.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(21L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Osasco");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado) {
			System.out.println(
					"Nome da cidade: " + cidade.getNome() 
					+ "\n" 
					+ "Nome do estado: " + cidade.getEstado().getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 23L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println(
					"Nome da cidade: " + cidade.getNome() 
					+ "\n" 
					+ "Nome do estado: " + cidade.getEstado().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 23L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			cidadeDAO.excluir(cidade);
			System.out.println("Registro removido:");
			System.out.println("Nome da cidade: " + cidade.getNome());
		}
	}
	
	@Test
	public void editar() {
		Long codigoEstado = 22L;
		Long codigoCidade = 24L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if(estado == null) {
			System.out.println("Nenhum estado localizado");
		}
		else if (cidade == null) {
			System.out.println("Nenhuma cidade localizada");
		}
		else {
			cidade.setNome("Vitória");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
			System.out.println("Registro editado:");
			System.out.println(
					"Nome da cidade: " + cidade.getNome() 
					+ "\n" 
					+ "Nome do estado: " + cidade.getEstado().getNome());
		}
	}
}
