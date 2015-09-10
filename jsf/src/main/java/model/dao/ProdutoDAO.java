package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fabricante;
import model.Produto;

public class ProdutoDAO {

	private PreparedStatement query;

	public List<Produto> listar() throws SQLException {
		Connection conexao = ConexaoFactory.conectar();

		query = conexao.prepareStatement(
				"SELECT p.id_produto, p.descricao, p.quantidade, p.preco, f.id_fabricante, f.descricao FROM produto p JOIN fabricante f ON f.id_fabricante = p.fabricante");

		ResultSet result = query.executeQuery();

		List<Produto> produtos = new ArrayList<>();
		while (result.next()) {
			Fabricante fabricante = new Fabricante();
			fabricante.setId(result.getInt("f.id_fabricante"));
			fabricante.setDescricao(result.getString("f.descricao"));

			Produto produto = new Produto();
			produto.setId(result.getInt("p.id_produto"));
			produto.setDescricao(result.getString("p.descricao"));
			produto.setQuantidade(result.getInt("p.quantidade"));
			produto.setPreco(result.getDouble("p.preco"));
			produto.setFabricante(fabricante);
			
			produtos.add(produto);
		}

		return produtos;
	}

	public void salvar(Produto produto) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();

		query = conexao
				.prepareStatement("INSERT INTO produto (descricao, quantidade, preco, fabricante) VALUES (?, ?, ?, ?)");
		query.setString(1, produto.getDescricao());
		query.setInt(2, produto.getQuantidade());
		query.setDouble(3, produto.getPreco());
		query.setInt(4, produto.getFabricante().getId());

		query.execute();
	}
	
	public void editar(Produto produto) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("UPDATE produto SET descricao = ?, quantidade = ?, preco = ?, fabricante = ? WHERE id_produto = ?");
		query.setString(1, produto.getDescricao());
		query.setInt(2, produto.getQuantidade());
		query.setDouble(3, produto.getPreco());
		query.setInt(4, produto.getFabricante().getId());
		query.setInt(5, produto.getId());
		
		query.execute();
	}

	public void excluir(Produto produto) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
		query.setInt(1, produto.getId());
		
		query.execute();
	}
	
}
