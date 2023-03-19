package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.criaConexao();
		
		Statement statement = connection.createStatement();
		
		
		// Executa uma select na tabela produto
		statement.execute("SELECT * FROM PRODUTO");
		
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
