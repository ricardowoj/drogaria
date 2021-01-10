package br.com.ricardow.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ricardow.drogaria.domain.Cliente;
import br.com.ricardow.drogaria.domain.Funcionario;
import br.com.ricardow.drogaria.domain.Venda;

public class VendaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(38L);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(36L);
		
		if(funcionario == null) {
			System.out.println("Nenhum registro encontrado para funcionário.");
		}
		else if(cliente == null)  {
			System.out.println("Nenhum registro encontrado para cliente.");
		}
		else {		
			Venda venda = new Venda();
			venda.setHorario(new Date());
			venda.setValorTotal(BigDecimal.valueOf(450));
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda);
			System.out.println("Registro salvo:");
			System.out.println("Valor da venda: R$" + venda.getValorTotal());
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();
		
		for(Venda venda : resultado) {
			System.out.println(
					"Nome do cliente: " + venda.getCliente().getPessoa().getNome() +
					" - Valor total: " + venda.getValorTotal()
					);
			}
		}
	
	@Test
	@Ignore
	public void Buscar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(41L);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			System.out.println(
					"Nome do cliente: " + venda.getCliente().getPessoa().getNome() +
					" - Valor total: " + venda.getValorTotal()
					);
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(41L);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			vendaDAO.excluir(venda);
			System.out.println("Registro removido:");
			System.out.println(
					"Nome do cliente: " + venda.getCliente().getPessoa().getNome() +
					" - Valor total: " + venda.getValorTotal()
					);
		}
	}
	
	@Test
	public void editar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(42L);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado.");
		}
		else {
			venda.setValorTotal(BigDecimal.valueOf(4500));
			vendaDAO.editar(venda);
			System.out.println("Registro editado:");
			System.out.println(
					"Nome do cliente: " + venda.getCliente().getPessoa().getNome() +
					" - Valor total: " + venda.getValorTotal()
					);
		}
	}
}
