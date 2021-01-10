package br.com.ricardow.drogaria.dao;

import java.util.Date;

import org.junit.Test;

import br.com.ricardow.drogaria.domain.Cliente;
import br.com.ricardow.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
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
}
