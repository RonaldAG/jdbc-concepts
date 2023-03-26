package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
		
		public DataSource dataSource;
	
		public ConnectionFactory() {
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("Mysql2710@");
			
			this.dataSource = comboPooledDataSource;
		}
	
		public Connection criaConexao() throws SQLException {
			
			// Get a connection with mysql driver
			//The connection is composed by the a path of our database, a user name and a password
			return dataSource.getConnection();
	
		}
}
