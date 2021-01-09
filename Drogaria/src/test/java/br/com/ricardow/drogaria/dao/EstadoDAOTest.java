package br.com.ricardow.drogaria.dao;

import org.junit.Test;

import br.com.ricardow.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
}
