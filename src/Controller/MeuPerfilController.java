package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.UsuarioDAO;
import Model.Usuario;
import Util.Session;
import View.TelaMeuPerfil;
import View.TelaUsuario;

public class MeuPerfilController implements ActionListener  {

	TelaMeuPerfil telaMeuPerfil;
	Usuario usuario = new Usuario();

	public MeuPerfilController(TelaMeuPerfil telaMeuPerfil) {
		this.telaMeuPerfil = telaMeuPerfil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Editar")) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja editar?","Editar Usuário",JOptionPane.YES_NO_OPTION);
			if(dialogResult != JOptionPane.YES_OPTION) {
				return;
			}
			String nome = telaMeuPerfil.getTextFieldNome().getText();
			String senha = telaMeuPerfil.getTextFieldSenha().getText();
			String endereco = telaMeuPerfil.getTextFieldEndereco().getText();
			String telefone = telaMeuPerfil.getTextFieldTel().getText();
			String cpf = telaMeuPerfil.getTextFieldCpf().getText();

			Usuario usuarioEditado = new Usuario();
			usuarioEditado.setNome(nome);
			usuarioEditado.setSenha(senha);
			usuarioEditado.setEndereco(endereco);
			usuarioEditado.setTelefone(telefone);
			usuarioEditado.setCpf(cpf);

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioEditado = usuarioDAO.updateUsuario(usuarioEditado, usuario.getNome());
			if(usuarioEditado != null) {
				Session.getInstance().setUser(usuarioEditado);
				TelaUsuario telaUsuario = new TelaUsuario();
				telaUsuario.getFrame().setVisible(true);
				telaMeuPerfil.getFrame().dispose();
			}


		}else if(e.getActionCommand().equals("Voltar")) {
			TelaUsuario telaUsuario = new TelaUsuario();
			telaUsuario.getFrame().setVisible(true);
			telaMeuPerfil.getFrame().dispose();
		}
	}

	public void inicializaTela() {
		if(Session.getInstance().getUser() != null) {
			usuario = Session.getInstance().getUser();
			String nome = usuario.getNome();
			String senha = usuario.getSenha();
			String endereco = usuario.getEndereco();
			String telefone = usuario.getTelefone();
			String cpf = usuario.getCpf();

			telaMeuPerfil.getTextFieldNome().setText(nome);
			telaMeuPerfil.getTextFieldSenha().setText(senha);
			telaMeuPerfil.getTextFieldEndereco().setText(endereco);
			telaMeuPerfil.getTextFieldTel().setText(telefone);
			telaMeuPerfil.getTextFieldCpf().setText(cpf);
		}
	}

}
