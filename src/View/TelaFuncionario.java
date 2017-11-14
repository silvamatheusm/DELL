package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Controller.FuncionarioPrincipalController;

import javax.swing.JTextArea;

public class TelaFuncionario {

	private JFrame frame;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldPrecoProduto;
	private JLabel labelHello;
	private JList listProdutos;
	private JTextArea textAreaDescricao;
	private FuncionarioPrincipalController funcController;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					TelaFuncionario window = new TelaFuncionario();
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
	public TelaFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		funcController = new FuncionarioPrincipalController (this);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		labelHello = new JLabel("Ol\u00E1, Fulano");
		labelHello.setForeground(SystemColor.desktop);
		labelHello.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelHello.setBounds(10, 0, 340, 29);
		panel.add(labelHello);

		listProdutos = new JList();
		listProdutos.setFont(new Font("Tahoma", Font.BOLD, 11));
		listProdutos.setBounds(59, 157, 528, 226);
		panel.add(listProdutos);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(589, 157, 17, 226);
		panel.add(scrollBar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(582, 5, 65, 23);
		panel.add(btnSair);
		btnSair.addActionListener(funcController);
		btnSair.setActionCommand("Sair");
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDoProduto.setBounds(20, 47, 137, 14);
		panel.add(lblNomeDoProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(132, 44, 86, 20);
		panel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreo.setBounds(20, 72, 89, 14);
		panel.add(lblPreo);

		textFieldPrecoProduto = new JTextField();
		textFieldPrecoProduto.setColumns(10);
		textFieldPrecoProduto.setBounds(132, 69, 86, 20);
		panel.add(textFieldPrecoProduto);

		JLabel lblDescrioProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescrioProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrioProduto.setBounds(222, 47, 128, 14);
		panel.add(lblDescrioProduto);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(284, 125, 105, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(funcController);
		btnCadastrar.setActionCommand("Cadastrar");

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(399, 125, 89, 23);
		panel.add(btnEditar);
		btnEditar.addActionListener(funcController);
		btnEditar.setActionCommand("Editar");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(498, 125, 89, 23);
		panel.add(btnExcluir);
		btnExcluir.addActionListener(funcController);
		btnExcluir.setActionCommand("Excluir");

		textAreaDescricao = new JTextArea();
		textAreaDescricao.setBounds(360, 42, 287, 54);
		panel.add(textAreaDescricao);
		
		funcController.inicializaTela();
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldNomeProduto() {
		return textFieldNomeProduto;
	}

	public void setTextFieldNomeProduto(JTextField textFieldNomeProduto) {
		this.textFieldNomeProduto = textFieldNomeProduto;
	}

	public JTextField getTextFieldPrecoProduto() {
		return textFieldPrecoProduto;
	}

	public void setTextFieldPrecoProduto(JTextField textFieldPrecoProduto) {
		this.textFieldPrecoProduto = textFieldPrecoProduto;
	}

	public JList getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(JList listProdutos) {
		this.listProdutos = listProdutos;
	}

	public JTextArea getTextAreaDescricao() {
		return textAreaDescricao;
	}

	public void setTextAreaDescricao(JTextArea textAreaDescricao) {
		this.textAreaDescricao = textAreaDescricao;
	}

	public JLabel getLabelHello() {
		return labelHello;
	}

	public void setLabelHello(JLabel labelHello) {
		this.labelHello = labelHello;
	}
	
	
}
