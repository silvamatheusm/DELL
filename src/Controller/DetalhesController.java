package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Produto;
import Model.Session;
import View.TelaDetalhes;

public class DetalhesController  implements ActionListener{
	
	TelaDetalhes telaDetalhes;
	
	public DetalhesController(TelaDetalhes telaDetalhes) {
		this.telaDetalhes = telaDetalhes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Ok")) {
			telaDetalhes.getFrame().dispose();
			Session.getInstance().setProdutoDetalhe(null);
		}
	}
	
	public void inicializaTela() {
		if(Session.getInstance().getProdutoDetalhe() != null) {
		
			Produto produto = Session.getInstance().getProdutoDetalhe();
			telaDetalhes.getTextNome().setText("Nome:" + produto.getNome());
			telaDetalhes.getTextPreco().setText("Preço: " + produto.getPreco());
			telaDetalhes.getTextDescricao().setText("<html>Esse é um exemplo de label com <br> HTML!</html>" );
			
			String descricao = produto.getDescricao();
			
			
			telaDetalhes.getTextDescricao().setText("Descrição: " + produto.getDescricao());
			
		}
	}

}
