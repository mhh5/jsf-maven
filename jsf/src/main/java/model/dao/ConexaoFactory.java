package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/drogaria";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return conexao;
	}
	
}
