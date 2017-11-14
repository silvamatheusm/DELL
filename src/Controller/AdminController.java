package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import DAO.UsuarioDAO;
import Model.Usuario;
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
		ArrayList<Usuario> usuarios = userDAO.getAllUsers();
		DefaultListModel lista = new DefaultListModel();
		
		for(Usuario user: usuarios) {
			lista.addElement(user.getNome());
		}
		
		telaAdmin.getListClientes().setModel(lista);
		
	}

}
