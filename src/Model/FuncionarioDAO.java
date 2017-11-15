package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Controller.DBConnection;

public class FuncionarioDAO {
	Connection connection;

	public FuncionarioDAO(){  
		try {
			this.connection = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public void adicionaFuncionario(Funcionario func) {
		String query = " insert into funcionarios (nome, senha, telefone, cpf, endereco)"
				+ " values (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = (PreparedStatement) connection.prepareStatement(query);

			preparedStmt.setString (1, func.getNome());
			preparedStmt.setString (2, func.getSenha());
			preparedStmt.setString (3, func.getTelefone());
			preparedStmt.setString (4, func.getCpf());
			preparedStmt.setString (5, func.getEndereco());

			// execute the preparedstatement
			boolean is = preparedStmt.execute();
			System.out.println(is);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Funcionario> getAllFunc() {
		ArrayList<Funcionario> funcionarios = new ArrayList();
		String query = "SELECT * FROM funcionarios";

		// create the java statement
		try
		{
			Statement st = (Statement) connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				Funcionario func = new Funcionario();
				int id = rs.getInt("idFuncionarios");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				String endereco = rs.getString("endereco");

				func.setNome(nome);
				func.setEndereco(endereco);
				func.setSenha(senha);
				func.setTelefone(telefone);
				func.setCpf(cpf);
				funcionarios.add(func);
				System.out.println(func.getNome());
			}
			st.close();
		}catch(Exception e) {

		}
		return funcionarios;
	}

	public Funcionario verificaLogin(String nomeDigitado, String senhaDigitada) {
		Funcionario func = null;
		String query = "select * from funcionarios WHERE nome ='" + nomeDigitado + "'";
		try
		{
			Statement st = (Statement) connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				int id = rs.getInt("idFuncionarios");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				String endereco = rs.getString("endereco");

				if(senha.equals(senhaDigitada)) {
					func = new Funcionario();
					func.setNome(nome);
					func.setEndereco(endereco);
					func.setSenha(senha);
					func.setTelefone(telefone);
					func.setCpf(cpf);
				}
			}
			st.close();
		}catch(Exception e) {

		}
		return func;
	}
}
