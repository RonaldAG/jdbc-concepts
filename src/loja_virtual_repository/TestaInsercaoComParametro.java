package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		//Get a connection with the Mysql driver
		ConnectionFactory connectionFac = new ConnectionFactory();
		Connection connection = connectionFac.criaConexao();
		
		//Take control of the transactions. Make the insert into database manually.
		connection.setAutoCommit(false);
		
		//Create a statement that it will be use to create CRUD methods 
		//Create a PREPARE STATEMENT. A prepare statement is much more secure than a CREATE STATEMENT. So, do preference to use this.
		try (PreparedStatement statement = 
				connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
				) {
			addItens("SmartTv", "45 Polegadas", statement);
			addItens("Celular", "Iphone", statement);
			
			//Add items will just do correctly if both products does not throw exceptions.
			connection.commit();
				
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTED");
			//Undo all changes made in the current transaction
			connection.rollback();
		}
			connection.close();			
	}
	
	private static void addItens(String name, String description, PreparedStatement statement) throws SQLException {
		//Set values
		statement.setString(1, name);
		statement.setString(2, description);
		
		//Execute query
		statement.execute();
		
		//Get result
		ResultSet resultSet = statement.getGeneratedKeys();

		//Print the result
		while(resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println(id);
		}
		resultSet.close();
		
	}
}
