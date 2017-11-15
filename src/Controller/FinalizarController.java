package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Model.Produto;
import Model.Session;
import Model.Usuario;
import View.TelaFinalizar;
import View.TelaUsuario;

public class FinalizarController implements ActionListener {

	TelaFinalizar telaFinalizar;
	Usuario usuario = new Usuario();
	double total = 0;

	public FinalizarController(TelaFinalizar telaFinalizar) {
		this.telaFinalizar = telaFinalizar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Comprar")) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja finalizar a compra no valor de " + total + "?","Finalizar Compra",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
				Session.getInstance().getUser().getProdutos().clear();
				JOptionPane.showMessageDialog(null,"Agradecemos a preferência. Volte sempre.");
				TelaUsuario telaUsuario = new TelaUsuario();
				telaUsuario.getFrame().setVisible(true);
				telaFinalizar.getFrame().dispose();
			}

		}else if(e.getActionCommand().equals("Cancelar")) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja CANCELAR a compra no valor de " + total + "?","Finalizar Compra",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
				Session.getInstance().getUser().getProdutos().clear();
				TelaUsuario telaUsuario = new TelaUsuario();
				telaUsuario.getFrame().setVisible(true);
				telaFinalizar.getFrame().dispose();
			}
		}
	}

	public void inicializaTela() {
		if(Session.getInstance().getUser() != null) {
			usuario = Session.getInstance().getUser();
			preencheLista();
		}
	}

	public void preencheLista() {

		total = 0;
		ArrayList<String> aux = new ArrayList();
		HashMap<String, Integer> hashMap = new HashMap();

		DefaultListModel<String> lista = new DefaultListModel<String>();

		for(Produto produto: usuario.getProdutos()) {
			if(aux.contains(produto.getNome())) {
				int n = 0;

				n = hashMap.get(produto.getNome());

				n++;
				hashMap.put(produto.getNome(),n );
				continue;
			}
			aux.add(produto.getNome());
			hashMap.put(produto.getNome(),1);
		}
		aux.clear();

		for(Produto produto: usuario.getProdutos()) {
			total+=Integer.parseInt(produto.getPreco());
			if(aux.contains(produto.getNome())) continue;
			aux.add(produto.getNome());
			int n = hashMap.get(produto.getNome());
			int preco = Integer.parseInt(produto.getPreco()) * n;
			lista.addElement(n + "x " + produto.getNome() + "       R$" + preco);
		}

		telaFinalizar.getListMeusProdutos().setModel(lista);
		telaFinalizar.getTextTotal().setText("Total:" + total);
	}
}
