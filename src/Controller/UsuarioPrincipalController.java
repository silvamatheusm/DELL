package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Produto;
import Model.ProdutoDAO;
import Model.Session;
import Model.Usuario;
import View.Login;
import View.TelaDetalhes;
import View.TelaFinalizar;
import View.TelaMeuPerfil;
import View.TelaUsuario;

public class UsuarioPrincipalController implements ActionListener  {

	TelaUsuario telaUsuario;
	private ProdutoDAO produtoDAO;
	Usuario usuario = new Usuario();
	private ArrayList<Produto> listaProdutos = new ArrayList();

	public UsuarioPrincipalController(TelaUsuario telaUsuario){
		this.telaUsuario = telaUsuario;
		produtoDAO = new ProdutoDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Sair")) {
			Login login = new Login();
			login.getFrame().setVisible(true);
			telaUsuario.getFrame().dispose();
		}else if(e.getActionCommand().equals("Adicionar")) {
			String selected = (String) telaUsuario.getListProdutos().getSelectedValue();
			for(Produto produto: listaProdutos) {
				String nomeEpreco = produto.getNome() + " R$" + produto.getPreco();
				if(nomeEpreco.equals(selected)) {
					usuario.adicionaCarrinho(produto);
					atualizaTamCarrinho();
					break;
				}
			}
		}else if(e.getActionCommand().equals("Limpar")) {
			usuario.getProdutos().clear();
			atualizaTamCarrinho();
		}else if(e.getActionCommand().equals("Perfil")) {
			TelaMeuPerfil telaMeuPerfil = new TelaMeuPerfil();
			telaMeuPerfil.getFrame().setVisible(true);
			telaUsuario.getFrame().dispose();
		}else if(e.getActionCommand().equals("Finalizar")) {
			if(usuario.getProdutos().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Selecione um produto antes de finalizar a compra!");
				return;
			}
			Session.getInstance().setUser(usuario);
			TelaFinalizar telaFinalizar = new TelaFinalizar();
			telaFinalizar.getFrame().setVisible(true);
			telaUsuario.getFrame().dispose();

		}
	}

	public void inicializaTela() {
		if(Session.getInstance().getUser() != null) {
			usuario = Session.getInstance().getUser();
			telaUsuario.getLabelHello().setText("Bem vindo, " + usuario.getNome() + "!");
		}

		preencheLista();
		telaUsuario.getListProdutos().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		telaUsuario.getListProdutos().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {

					// Double-click detected
					String selected = (String) telaUsuario.getListProdutos().getSelectedValue();
					for(Produto produto: listaProdutos) {
						String nomeEpreco = produto.getNome() + " R$" + produto.getPreco();
						if(nomeEpreco.equals(selected)) {
							Session.getInstance().setProdutoDetalhe(produto);
							TelaDetalhes telaDetalhes = new TelaDetalhes();
							telaDetalhes.getFrame().setVisible(true);
							break;
						}
					}
				} 
			}
		});
	}


	public void preencheLista() {
		listaProdutos.clear();
		listaProdutos = produtoDAO.getAllProdutos();
		DefaultListModel<String> lista = new DefaultListModel<String>();

		for(Produto produto:listaProdutos) {
			lista.addElement(produto.getNome() + " R$" + produto.getPreco());
		}

		telaUsuario.getListProdutos().setModel(lista);
	}

	private void atualizaTamCarrinho() {
		int tam = usuario.getProdutos().size();
		telaUsuario.getLabelTamCarrinho().setText("Número de itens no carrinho: " + String.valueOf(tam));
	}

}
