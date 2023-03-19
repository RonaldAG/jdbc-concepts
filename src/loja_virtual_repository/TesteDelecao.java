package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDelecao {

	public static void main(String[] args) throws SQLException {
		//Get the connection with mysql driver
		Connection connection = ConnectionFactory.criaConexao();
		
		//Create a statement
		Statement statement = connection.createStatement();
		
		//Execute a sql command
		statement.execute("DELETE FROM produto WHERE id>2");
		
		//Get the response
		//Response in this context is the total lines modified by the query
		int updateCount = statement.getUpdateCount();
		
		System.out.println("Total lines modified by delete command: " + updateCount);
		
	}
}
