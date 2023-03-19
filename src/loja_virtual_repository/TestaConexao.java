package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.criaConexao();
		
		connection.close();
	}
}
