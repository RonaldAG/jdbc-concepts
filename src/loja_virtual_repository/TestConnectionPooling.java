package loja_virtual_repository;

import java.sql.SQLException;

public class TestConnectionPooling {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			cf.criaConexao();
			System.out.println("connection number " + i	);
		}
	}
}
