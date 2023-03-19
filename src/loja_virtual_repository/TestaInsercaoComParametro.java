package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		//Get a connection with the Mysql driver
		Connection connection = ConnectionFactory.criaConexao();
		
		//Create a statement that it will be use to create CRUD methods 
		//Create a PREPARE STATEMENT. A prepare statement is much more secure than a CREATE STATEMENT. So, do preference to use this.
		PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		//Inject values
		statement.setString(1, "Computador");
		statement.setString(2, "Dell vostros");
		
		//Execute the query
		statement.execute();
		
		
		// Get the result (id)
		ResultSet generatedKeys = statement.getGeneratedKeys();
		
		// Print ID
		while(generatedKeys.next()) {
			System.out.println(generatedKeys.getInt(1));
			
		}
	
	}
}
