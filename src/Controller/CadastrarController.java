package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Model.Funcionario;
import Model.FuncionarioDAO;
import Model.Usuario;
import Model.UsuarioDAO;
import View.Login;
import View.TelaCadastro;
import View.TelaUsuario;
import View.TelaFuncionario;

public class CadastrarController implements ActionListener {

	TelaCadastro telaCadastro;

	public CadastrarController(TelaCadastro telaCadastro){
		this.telaCadastro = telaCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Cadastrar")) {
			String nome = telaCadastro.getTextFieldNome().getText();
			String endereco = telaCadastro.getTextFieldEndereco().getText();
			String tel = telaCadastro.getTextFieldTel().getText();
			String cpf = telaCadastro.getTextFieldCpf().getText();
			String senha = telaCadastro.getTextFieldSenha().getText();

			if(nome.isEmpty() || endereco.isEmpty() || tel.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				return;
			}

			if(telaCadastro.getRdbtnFuncionario().isSelected()) {
				Funcionario func = new Funcionario();
				func.setCpf(cpf);
				func.setNome(nome);
				func.setSenha(senha);
				func.setTelefone(tel);
				func.setEndereco(endereco);

				FuncionarioDAO funcDAO = new FuncionarioDAO();
				funcDAO.adicionaFuncionario(func);
				
				Login login = new Login();
				login.getFrame().setVisible(true);
				telaCadastro.getFrame().dispose();
				
			}else if(telaCadastro.getRdbtnCliente().isSelected()) {
				Usuario user = new Usuario();
				user.setCpf(cpf);
				user.setNome(nome);
				user.setSenha(senha);
				user.setTelefone(tel);
				user.setEndereco(endereco);

				UsuarioDAO userDAO = new UsuarioDAO();
				userDAO.adicionaUser(user);

				Login login = new Login();
				login.getFrame().setVisible(true);
				telaCadastro.getFrame().dispose();

			}else {
				JOptionPane.showMessageDialog(null,"Selecione uma opção");
			}
		}else if(e.getActionCommand().equals("Voltar")) {
			Login login = new Login();
			login.getFrame().setVisible(true);
			telaCadastro.getFrame().dispose();
		}

	}
}

