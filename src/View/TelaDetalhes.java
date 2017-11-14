package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.DetalhesController;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class TelaDetalhes {

	private JFrame frame;
	private JLabel textNome;
	private JLabel textPreco;
	private JTextArea  textDescricao;
	private JButton btnOk;
	private DetalhesController detalhesController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDetalhes window = new TelaDetalhes();
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
	public TelaDetalhes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 379, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		detalhesController = new DetalhesController(this);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textNome = new JLabel("Nome: Computador");
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNome.setBounds(88, 39, 175, 14);
		panel.add(textNome);
		
		textPreco = new JLabel("Preco: R$500");
		textPreco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPreco.setBounds(88, 64, 111, 14);
		panel.add(textPreco);
		
		textDescricao = new JTextArea ("Descri\u00E7\u00E3o: Computador desktop \\n para jogos ");
		textDescricao.setBackground(UIManager.getColor("Button.background"));
		textDescricao.setEditable(false);
		textDescricao.setLineWrap(true);
		textDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDescricao.setBounds(88, 89, 210, 88);
		textDescricao.setWrapStyleWord(true);
		panel.add(textDescricao);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(140, 188, 89, 23);
		panel.add(btnOk);
		btnOk.addActionListener(detalhesController);
		btnOk.setActionCommand("Ok");
		
		detalhesController.inicializaTela();
	}

	public JLabel getTextNome() {
		return textNome;
	}

	public void setTextNome(JLabel textNome) {
		this.textNome = textNome;
	}

	public JLabel getTextPreco() {
		return textPreco;
	}

	public void setTextPreco(JLabel textPreco) {
		this.textPreco = textPreco;
	}

	public JTextArea  getTextDescricao() {
		return textDescricao;
	}

	public void setTextDescricao(JTextArea  textDescricao) {
		this.textDescricao = textDescricao;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	
	
	
}

