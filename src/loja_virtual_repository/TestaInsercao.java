package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	public static void main(String[] args) throws SQLException {
		//Get a connection with the Mysql driver
		ConnectionFactory connectionFac = new ConnectionFactory();
		Connection connection = connectionFac.criaConexao();
		
		//Create a statement that it will be use to create CRUD methods 
		Statement statement = connection.createStatement();
		 
		//Execute a insert method
		statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES('NOTEBOOK', 'HP')", Statement.RETURN_GENERATED_KEYS);
		
		
		// Get the result (id)
		ResultSet generatedKeys = statement.getGeneratedKeys();
		
		// Print ID
		while(generatedKeys.next()) {
			System.out.println(generatedKeys.getInt(1));
			
		}
	
	}
}
