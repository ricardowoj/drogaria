package br.com.ricardow.drogaria.dao;

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
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
}
