package br.com.ricardow.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Cliente;
import br.com.ricardow.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(28L);
		
		if(pessoa == null) {
			System.out.println("Nenhum registro encontrado para pessoa.");
		}
		else {
			Cliente cliente = new Cliente();
			cliente.setDataCadastro(new Date());
			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);
			System.out.println("Registro salvo:");
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		
		for(Cliente cliente : resultado) {
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
			}
		}
	
	@Test
	@Ignore
	public void Buscar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(34L);
		
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(34L);
		
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			clienteDAO.excluir(cliente);
			System.out.println("Registro removido:");
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
		}
	}
	
	@Test
	public void editar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(35L);
		
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			cliente.setLiberado(false);
			clienteDAO.editar(cliente);
			System.out.println("Registro editado:");
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
		}
	}
}
