package Util;

import java.util.ArrayList;

import Model.Funcionario;
import Model.Produto;
import Model.Usuario;

public class Session {

	
	private static Session instance = null;
	private Usuario user;
	private Funcionario func;
	private ArrayList<Produto> produtos = new ArrayList();
	private Produto produtoDetalhe;

	public static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}
	

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}


	public Produto getProdutoDetalhe() {
		return produtoDetalhe;
	}


	public void setProdutoDetalhe(Produto produtoDetalhe) {
		this.produtoDetalhe = produtoDetalhe;
	}
	
	
	
	
	
}
