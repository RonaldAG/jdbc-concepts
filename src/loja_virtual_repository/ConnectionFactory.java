package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

		public static Connection criaConexao() throws SQLException {
			
			// Get a connection with mysql driver
			//The connection is composed by the a path of our database, a user name and a password
			return DriverManager
			.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", 
					"root", "Mysql2710@");
	
		}
}
