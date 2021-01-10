package br.com.ricardow.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Funcionario;
import br.com.ricardow.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(29L);
		
		if(pessoa == null) {
			System.out.println("Nenhum registro encontrado para pessoa.");
		}
		else {
			Funcionario funcionario = new Funcionario();
			funcionario.setCarteiraTrabalho("224324456");;
			funcionario.setDataAdmissao(new Date());;
			funcionario.setPessoa(pessoa);
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionario);
			System.out.println("Registro salvo:");
			System.out.println("Nome do cliente: " + funcionario.getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		
		for(Funcionario funcionario : resultado) {
			System.out.println("Nome do funcionário: " + funcionario.getPessoa().getNome());
			}
		}
	
	@Test
	@Ignore
	public void Buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(37L);
		
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println("Nome do cliente: " + funcionario.getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(37L);
		
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Registro removido:");
			System.out.println("Nome do cliente: " + funcionario.getPessoa().getNome());
		}
	}
	
	@Test
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(38L);
		
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			funcionario.setCarteiraTrabalho("1234567");;
			funcionarioDAO.editar(funcionario);
			System.out.println("Registro editado:");
			System.out.println("Nome do cliente: " + funcionario.getPessoa().getNome());
		}
	}
}
