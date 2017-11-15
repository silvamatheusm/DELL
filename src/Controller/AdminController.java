package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Model.Funcionario;
import Model.FuncionarioDAO;
import Model.Usuario;
import Model.UsuarioDAO;
import View.Login;
import View.TelaAdmin;

public class AdminController  implements ActionListener{

	TelaAdmin telaAdmin;

	public AdminController(TelaAdmin telaAdmin) {
		this.telaAdmin = telaAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Sair")) {
			Login login = new Login();
			login.getFrame().setVisible(true);
			telaAdmin.getFrame().dispose();
		}
	}
	
	public void preencheLista() {
		UsuarioDAO userDAO = new UsuarioDAO();
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		
		ArrayList<Usuario> usuarios = userDAO.getAllUsers();
		ArrayList<Funcionario> funcionarios = funcDAO.getAllFunc();
				
		DefaultListModel listaUser = new DefaultListModel();
		DefaultListModel listaFunc = new DefaultListModel();
		
		for(Usuario user: usuarios) {
			listaUser.addElement(user.getNome());
		}
		
		for(Funcionario func: funcionarios) {
			listaFunc.addElement(func.getNome());
		}
		telaAdmin.getListClientes().setModel(listaUser);
		telaAdmin.getListFunc().setModel(listaFunc);
		
	}

}
