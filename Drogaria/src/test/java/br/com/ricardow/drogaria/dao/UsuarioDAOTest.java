package br.com.ricardow.drogaria.dao;

import org.junit.Test;

import br.com.ricardow.drogaria.domain.Pessoa;
import br.com.ricardow.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(8L);
		
		if(pessoa == null) {
			System.out.println("Nenhum registro encontrado para funcionário.");
		}
		else {		
			Usuario usuario = new Usuario();
			usuario.setSenha("123456");
			usuario.setTipo('A');
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			System.out.println("Registro salvo:");
			System.out.println("Nome do usuário: " + usuario.getPessoa().getNome());
		}
	}
}
