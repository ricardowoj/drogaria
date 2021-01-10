package br.com.ricardow.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Cidade;
import br.com.ricardow.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigo = 25L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null) {
			System.out.println("Nenhum registro encontrado para cidade.");
		}
		else {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("Ricardo Wojciechowski");
			pessoa.setCpf("06889189647");
			pessoa.setRg("11645605");
			pessoa.setRua("Rua Quirua");
			pessoa.setNumero((short) 619);
			pessoa.setBairro("Suru");
			pessoa.setCep("06509012");
			pessoa.setComplemento("Cond. New Ville");
			pessoa.setTelefone("1142692333");
			pessoa.setCelular("11942692333");
			pessoa.setEmail("ricardowoj@hotmail.com");
			pessoa.setCidade(cidade);
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.salvar(pessoa);
			
			cidadeDAO.excluir(cidade);
			System.out.println("Registro removido:");
			System.out.println("Nome da cidade: " + cidade.getNome());
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa : resultado) {
			System.out.println(
					"Nome da pessoa: " + pessoa.getNome() 
					+ " - " 
					+ "Nome da cidade: " + pessoa.getCidade().getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 29L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println(
					"Nome da pessoa: " + pessoa.getNome() 
					+ " - " 
					+ "Nome da cidade: " + pessoa.getCidade().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 27L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		if(pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Registro removido:");
			System.out.println("Nome da pessoa: " + pessoa.getNome());
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 25L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null) {
			System.out.println("Nenhum registro encontrado para cidade.");
		}
		else {
			PessoaDAO pessoaDAO = new PessoaDAO();
			Pessoa pessoa = pessoaDAO.buscar(28L);
			pessoa.setRua("Lourenço Collino");
			pessoa.setNumero((short) 348);
			pessoa.setBairro("Pres. Altino");
			pessoa.setCep("06216260");
			pessoa.setComplemento("Próximo estação Osasco");
			pessoa.setCidade(cidade);
			
			pessoaDAO.editar(pessoa);
			
			System.out.println("Registro editado:");
			System.out.println("Nome da pessoa: " + pessoa.getNome());
			}
	}
}
