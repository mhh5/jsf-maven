package model;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import model.dao.ProdutoDAO;

public class ProdutoTeste {

	@Test
	@Ignore
	public void salvarUmProdutoNoBanco() throws SQLException {		
		Fabricante fabricante = new Fabricante();
		fabricante.setId(8);
		
		Produto produto = new Produto();
		produto.setDescricao("All Star 2");
		produto.setQuantidade(20);
		produto.setPreco(50.00);
		produto.setFabricante(fabricante);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
	}

	@Test
	public void listarTodosOsProdutosDoBanco() throws SQLException {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listar();
		
		for (Produto produto : lista) {
			System.out.println(produto);
		}
	}
	
	@Test
	@Ignore
	public void excluirUmProdutoDoBanco() throws SQLException {
		Produto produto = new Produto();
		produto.setId(2);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(produto);
	}
	
}
