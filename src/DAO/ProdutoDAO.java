package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Controller.DBConnection;
import Model.Produto;
import Model.Usuario;

public class ProdutoDAO {
	Connection connection;

	public ProdutoDAO(){  
		try {
			this.connection = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public void adicionaProduto(Produto produto) {
		String query = " insert into produto (nome, descricao, preco)"
				+ " values (?, ?, ?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = (PreparedStatement) connection.prepareStatement(query);

			preparedStmt.setString (1, produto.getNome());
			preparedStmt.setString (2, produto.getDescricao());
			preparedStmt.setString (3, produto.getPreco());


			// execute the preparedstatement
			boolean is = preparedStmt.execute();
			System.out.println(is);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Produto> getAllProdutos() {
		ArrayList<Produto> produtos = new ArrayList();
		String query = "SELECT * FROM produto";

		// create the java statement
		try
		{
			Statement st = (Statement) connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				Produto produto = new Produto();
				int id = rs.getInt("idProduto");
				String nome = rs.getString("nome");
				String preco = rs.getString("preco");
				String descricao = rs.getString("descricao");

				produto.setNome(nome);
				produto.setDescricao(descricao);
				produto.setPreco(preco);
				produtos.add(produto);

			}
			st.close();
		}catch(Exception e) {

		}
		return produtos;
	}

	public Produto updateProduto(Produto produto, String nome) {

		String query = "update produto set nome = ?, preco = ?, descricao = ? where nome = '" + nome + "'" ;
		try
		{
			PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
			preparedStmt.setString (1, produto.getNome());
			preparedStmt.setString (2, produto.getPreco());
			preparedStmt.setString (3, produto.getDescricao());

			boolean is = preparedStmt.execute();
			System.out.println(is);

		}catch(Exception e) {
			return null;
		}

		return produto;
	}

	public boolean excluirProduto(String nome) {
		try {
			String query = "DELETE FROM produto WHERE nome = ? ";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);   
			ps.setString(1, nome);
			ps.executeUpdate();  
		} catch(Exception e) {
			return false;
		}
		return true;
	}


}