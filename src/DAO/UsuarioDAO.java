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

public class UsuarioDAO {
	Connection connection;
	public UsuarioDAO(){  
		try {
			this.connection = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public void adicionaUser(Usuario user) {
		String query = " insert into usuario (nome, senha, telefone, cpf, endereco)"
				+ " values (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = (PreparedStatement) connection.prepareStatement(query);

			preparedStmt.setString (1, user.getNome());
			preparedStmt.setString (2, user.getSenha());
			preparedStmt.setString (3, user.getTelefone());
			preparedStmt.setString (4, user.getCpf());
			preparedStmt.setString (5, user.getEndereco());

			// execute the preparedstatement
			boolean is = preparedStmt.execute();
			System.out.println(is);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Usuario> getAllUsers() {
		ArrayList<Usuario> usuarios = new ArrayList();
		String query = "SELECT * FROM usuario";

		// create the java statement
		try
		{
			Statement st = (Statement) connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				Usuario user = new Usuario();
				int id = rs.getInt("idUsuario");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				String endereco = rs.getString("endereco");

				user.setNome(nome);
				user.setEndereco(endereco);
				user.setSenha(senha);
				user.setTelefone(telefone);
				user.setCpf(cpf);
				usuarios.add(user);
				System.out.println(user.getNome());
			}
			st.close();
		}catch(Exception e) {

		}
		return usuarios;
	}

	public Usuario verificaLogin(String nomeDigitado, String senhaDigitada) {
		Usuario usuario = null;
		String query = "select * from usuario WHERE nome ='" + nomeDigitado + "'";
		try
		{
			Statement st = (Statement) connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				int id = rs.getInt("idUsuario");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				String endereco = rs.getString("endereco");
				
				if(senha.equals(senhaDigitada)) {
					usuario = new Usuario();
					usuario.setNome(nome);
					usuario.setEndereco(endereco);
					usuario.setSenha(senha);
					usuario.setTelefone(telefone);
					usuario.setCpf(cpf);
				}
			}
			st.close();
		}catch(Exception e) {

		}
		return usuario;
	}
	
	public Usuario updateUsuario(Usuario usuario, String nome) {

		String query = "update usuario set nome = ?, senha = ?, telefone = ?, cpf = ?, endereco = ? where nome = '" + nome + "'" ;
		
		try
		{
			PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
			preparedStmt.setString (1, usuario.getNome());
			preparedStmt.setString (2, usuario.getSenha());
			preparedStmt.setString (3, usuario.getTelefone());
			preparedStmt.setString (4, usuario.getCpf());
			preparedStmt.setString (5, usuario.getEndereco());

			boolean is = preparedStmt.execute();
			System.out.println(is);

		}catch(Exception e) {
			return null;
		}

		return usuario;
	}
}
