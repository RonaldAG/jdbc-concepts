package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import loja_virtual_repository.dao.ProdutoDao;
import loja_virtual_repository.model.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Comoda", "madeira");
		
		try(Connection connection = new ConnectionFactory().criaConexao()){
			ProdutoDao produtoDao = new ProdutoDao(connection);
			
			//produtoDao.salvar(comoda);
			
			List<Produto> listar = produtoDao.listar();
			
			listar.forEach(x -> System.out.println(x));
		}
		
	}
}
