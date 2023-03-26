package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFac = new ConnectionFactory();
		Connection connection = connectionFac.criaConexao();
		
		connection.close();
	}
}
