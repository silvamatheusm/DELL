package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import DAO.FuncionarioDAO;
import DAO.UsuarioDAO;
import Model.Funcionario;
import Model.Usuario;
import Util.Session;
import View.Login;
import View.TelaAdmin;
import View.TelaCadastro;
import View.TelaUsuario;
import View.TelaFuncionario;

public class LoginController implements ActionListener{

	Login loginView;
	UsuarioDAO usuarioDAO;
	FuncionarioDAO funcDAO;
	
	public LoginController(Login login){
		loginView = login;
		usuarioDAO = new UsuarioDAO();
		funcDAO = new FuncionarioDAO();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Entrar")){
			String login = loginView.getTextFieldLogin().getText();
			String senha = loginView.getTextFieldSenha().getText();
			
			if(login.isEmpty() || senha.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				return;
			}
			
			if(login.equals("admin") && senha.equals("admin")) {
				TelaAdmin telaAdmin = new TelaAdmin();
				telaAdmin.getFrame().setVisible(true);
				loginView.getFrame().dispose();
				return;
			}
			
			if(loginView.getRdbFuncionario().isSelected()) {
				Funcionario func = funcDAO.verificaLogin(login, senha);
				if(func != null) {
					Session.getInstance().setFunc(func);
					TelaFuncionario telaFuncionario = new TelaFuncionario();
					telaFuncionario.getFrame().setVisible(true);
					loginView.getFrame().dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Usuario e senha incorretos");
				}
			}else if(loginView.getRdbCliente().isSelected()) {
				Usuario user = usuarioDAO.verificaLogin(login, senha);
				if(user != null) {
					Session.getInstance().setUser(user);
					TelaUsuario telaUsuario = new TelaUsuario();
					telaUsuario.getFrame().setVisible(true);
					loginView.getFrame().dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Usuario e senha incorretos");
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Selecione uma opção");
			}
			
		}else if(e.getActionCommand().equals("Cadastrar")) {
			TelaCadastro telaCadastro = new TelaCadastro();
			telaCadastro.getFrame().setVisible(true);
			loginView.getFrame().dispose();
		}
	}


}
