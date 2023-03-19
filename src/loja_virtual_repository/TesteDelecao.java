package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDelecao {

	public static void main(String[] args) throws SQLException {
		//Get the connection with mysql driver
		Connection connection = ConnectionFactory.criaConexao();
		
		//Create a prepare statement
		PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id>2");
		
		//Execute the query
		statement.execute();
		
		//Get the response
		//Response in this context is the total lines modified by the query
		int updateCount = statement.getUpdateCount();
		
		
		System.out.println("Total lines modified by delete command: " + updateCount);
		
	}
}
