package loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import loja_virtual_repository.ConnectionFactory;
import loja_virtual_repository.model.Produto;

public class ProdutoDao {
	
	private Connection connection;
	
	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().criaConexao()){
			
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());
				
				pstm.execute();
				
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		}
	}
	
	public List<Produto> listar() throws SQLException {
		
		try(Connection connection = new ConnectionFactory().criaConexao()){
			
			String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					List<Produto> list = new ArrayList<>();
					while(rst.next()) {
						list.add(new Produto(rst.getInt(1), rst.getString(2), rst.getString(3)));
					}
					
					return list;
				}
			}
		}
		
	}
}
