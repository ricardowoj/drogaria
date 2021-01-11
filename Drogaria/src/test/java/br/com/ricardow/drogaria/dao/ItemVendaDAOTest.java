package br.com.ricardow.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ricardow.drogaria.domain.ItemVenda;
import br.com.ricardow.drogaria.domain.Produto;
import br.com.ricardow.drogaria.domain.Venda;

public class ItemVendaDAOTest {
	@Test
	public void salvar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(11L);
		
		if(produto == null) {
			System.out.println("Nenhum registro encontrado para produto.");
		}
		else if(venda == null)  {
			System.out.println("Nenhum registro encontrado para venda.");
		}
		else {		
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setQuantidade(Short.valueOf("5"));
			itemVenda.setValorParcial(BigDecimal.valueOf(500));
			itemVenda.setProduto(produto);
			itemVenda.setVenda(venda);
			
			ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
			itemVendaDAO.salvar(itemVenda);
			System.out.println("Registro salvo:");
			System.out.println("Valor do item venda: R$" + itemVenda.getValorParcial());
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
		}
	}
}
