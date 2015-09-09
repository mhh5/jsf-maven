package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fabricante;

public class FabricanteDAO {
	
	private PreparedStatement query;

	public List<Fabricante> listar() throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("SELECT * FROM fabricante ORDER BY descricao");
		
		ResultSet result = query.executeQuery();
		
		List<Fabricante> fabricantes = new ArrayList<>();
		while (result.next()) {
			Fabricante fabricante = new Fabricante();
			fabricante.setId(result.getInt("id_fabricante"));
			fabricante.setDescricao(result.getString("descricao"));
			
			fabricantes.add(fabricante);
		}
		
		return fabricantes;
	}
	
	public void salvar(Fabricante fabricante) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("INSERT INTO fabricante (descricao) VALUES (?)");
		query.setString(1, fabricante.getDescricao());
		
		query.execute();
	}
	
	public void editar(Fabricante fabricante) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("UPDATE fabricante SET descricao = ? WHERE id_fabricante = ?");
		query.setString(1, fabricante.getDescricao());
		query.setInt(2, fabricante.getId());
		
		query.execute();
	}
	
	public void excluir(Fabricante fabricante) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("DELETE FROM fabricante WHERE id_fabricante = ?");
		query.setInt(1, fabricante.getId());
		
		query.execute();
	}
	
	public Fabricante buscar(Fabricante fabricante) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		
		query = conexao.prepareStatement("SELECT * FROM fabricante WHERE id_fabricante = ?");
		query.setInt(1, fabricante.getId());
		
		ResultSet result = query.executeQuery();
		
		Fabricante novo = null;
		if (result.next()) {
			novo = new Fabricante();
			novo.setId(result.getInt("id_fabricante"));
			novo.setDescricao(result.getString("descricao"));
		}
		
		return novo;
	}
	
}
