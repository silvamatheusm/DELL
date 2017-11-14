package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Model.Produto;
import Model.Usuario;
import Util.Session;
import View.Login;
import View.TelaFuncionario;

public class FuncionarioPrincipalController implements ActionListener {

	private TelaFuncionario telaFunc;
	private ProdutoDAO produtoDAO;
	ArrayList<Produto> produtos = new ArrayList();

	public FuncionarioPrincipalController(TelaFuncionario telaFunc){
		this.telaFunc = telaFunc;
		produtoDAO = new ProdutoDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Sair")) {
			Login login = new Login();
			login.getFrame().setVisible(true);
			telaFunc.getFrame().dispose();
		}else if(e.getActionCommand().equals("Cadastrar")) {
			String nomeProduto = telaFunc.getTextFieldNomeProduto().getText();
			String precoProduto = telaFunc.getTextFieldPrecoProduto().getText();
			String descricaoProduto = telaFunc.getTextAreaDescricao().getText();

			if(nomeProduto.isEmpty() || precoProduto.isEmpty() || descricaoProduto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para cadastrar", "DELL", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			Produto produto = new Produto();
			produto.setNome(nomeProduto);
			produto.setDescricao(descricaoProduto);
			produto.setPreco(precoProduto);

			produtoDAO.adicionaProduto(produto);
			preencheLista();
			JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
			limpaCampos();
		}else if(e.getActionCommand().equals("Editar")){

			if(telaFunc.getListProdutos().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Selecione um item para editar!", "DELL", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			boolean produtoExiste = false;
			String nomeProduto = telaFunc.getTextFieldNomeProduto().getText();
			String precoProduto = telaFunc.getTextFieldPrecoProduto().getText();
			String descricaoProduto = telaFunc.getTextAreaDescricao().getText();

			for(Produto produto: produtos) {
				if(nomeProduto.equals(produto.getNome())) produtoExiste = true;
			}

			if(nomeProduto.isEmpty() || precoProduto.isEmpty() || descricaoProduto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para editar", "DELL", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Produto produto = new Produto();
			produto.setNome(nomeProduto);
			produto.setDescricao(descricaoProduto);
			produto.setPreco(precoProduto);

			String selected = (String) telaFunc.getListProdutos().getSelectedValue();
			if(produtoDAO.updateProduto(produto,selected) != null) {
				limpaCampos();
				preencheLista();
				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!", "DELL", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getActionCommand().equals("Excluir")){
			if(telaFunc.getListProdutos().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Selecione um item para excluir!", "DELL", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			String selected = (String) telaFunc.getListProdutos().getSelectedValue();
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja deletar " + selected + "?","Warning",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
				if(produtoDAO.excluirProduto(selected)) {
					limpaCampos();
					preencheLista();
					JOptionPane.showMessageDialog(null, "Item excluído com sucesso!", "DELL", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		
			
			
		}

	}

	public void inicializaTela() {
		if(Session.getInstance().getFunc() != null) {
			telaFunc.getLabelHello().setText("Olá, " + Session.getInstance().getFunc().getNome() + "!");
		}
		preencheLista();
		telaFunc.getListProdutos().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String selected = (String) telaFunc.getListProdutos().getSelectedValue();
				for(Produto produto: produtos) {
					if(produto.getNome().equals(selected)) {
						telaFunc.getTextFieldNomeProduto().setText(produto.getNome());
						telaFunc.getTextAreaDescricao().setText(produto.getDescricao());
						telaFunc.getTextFieldPrecoProduto().setText(produto.getPreco());
						break;
					}

				}
			}
		});
	}

	public void preencheLista() {
		produtos.clear();
		produtos = produtoDAO.getAllProdutos();
		DefaultListModel lista = new DefaultListModel();

		for(Produto produto: produtos) {
			lista.addElement(produto.getNome());
		}

		telaFunc.getListProdutos().setModel(lista);

	}
	
	private void limpaCampos() {
		telaFunc.getTextFieldNomeProduto().setText("");
		telaFunc.getTextAreaDescricao().setText("");
		telaFunc.getTextFieldPrecoProduto().setText("");
	}

}
