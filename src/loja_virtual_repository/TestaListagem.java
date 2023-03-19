package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.criaConexao();
		
		// Executa uma select na tabela produto
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUTO");
		
		//Execute query
		statement.execute();
		
		//Pega o resultado da query acima
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			//Itera por cada coluna afim de achar seus respectivos valores
			Integer id = resultSet.getInt("id");
			String name = resultSet.getString("nome");
			String descricao = resultSet.getNString("descricao");
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(descricao);
		}
		
		
		
		connection.close();	
	}
}
