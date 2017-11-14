package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.UsuarioPrincipalController;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TelaUsuario {

	private JFrame frame;
	private JLabel labelHello;
	private UsuarioPrincipalController usuarioController;
	private JList listProdutos;
	private JLabel labelTamCarrinho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario window = new TelaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usuarioController = new UsuarioPrincipalController(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		labelHello = new JLabel("Ol\u00E1, Fulano");
		labelHello.setForeground(SystemColor.desktop);
		labelHello.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelHello.setBounds(10, 0, 320, 29);
		panel.add(labelHello);
		
		listProdutos = new JList();
		listProdutos.setFont(new Font("Tahoma", Font.BOLD, 11));
		listProdutos.setBounds(60, 124, 528, 226);
		panel.add(listProdutos);
	
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(596, 124, 17, 226);
		panel.add(scrollBar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(582, 5, 65, 23);
		panel.add(btnSair);
		btnSair.addActionListener(usuarioController);
		btnSair.setActionCommand("Sair");
		
		
		JButton btnFinalizar = new JButton("Finalizar compra");
		btnFinalizar.setBounds(10, 372, 153, 23);
		panel.add(btnFinalizar);
		btnFinalizar.addActionListener(usuarioController);
		btnFinalizar.setActionCommand("Finalizar");
		
		JButton btnAddCarrinho = new JButton("Adicionar no carrinho");
		btnAddCarrinho.setBounds(173, 372, 172, 23);
		panel.add(btnAddCarrinho);
		btnAddCarrinho.addActionListener(usuarioController);
		btnAddCarrinho.setActionCommand("Adicionar");
		
		JButton btnMeuPerfil = new JButton("Meu Perfil");
		btnMeuPerfil.setBounds(465, 5, 107, 23);
		panel.add(btnMeuPerfil);
		btnMeuPerfil.addActionListener(usuarioController);
		btnMeuPerfil.setActionCommand("Perfil");
		
		JLabel lblSelecioneOProduto = new JLabel("Clique no produto para ver a descri\u00E7\u00E3o");
		lblSelecioneOProduto.setForeground(Color.BLACK);
		lblSelecioneOProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelecioneOProduto.setBounds(60, 84, 288, 29);
		panel.add(lblSelecioneOProduto);
		
		labelTamCarrinho = new JLabel("N\u00B0 de itens no carrinho: 0");
		labelTamCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelTamCarrinho.setBounds(500, 376, 189, 14);
		panel.add(labelTamCarrinho);
		
		JButton btnLimparCarrinho = new JButton("Limpar carrinho");
		btnLimparCarrinho.setBounds(355, 372, 138, 23);
		panel.add(btnLimparCarrinho);
		btnLimparCarrinho.addActionListener(usuarioController);
		btnLimparCarrinho.setActionCommand("Limpar");
		
		usuarioController.inicializaTela();
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public JLabel getLabelHello() {
		return labelHello;
	}

	public void setLabelHello(JLabel labelHello) {
		this.labelHello = labelHello;
	}

	public JList getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(JList listProdutos) {
		this.listProdutos = listProdutos;
	}

	public JLabel getLabelTamCarrinho() {
		return labelTamCarrinho;
	}

	public void setLabelTamCarrinho(JLabel labelTamCarrinho) {
		this.labelTamCarrinho = labelTamCarrinho;
	}
	
	
}
