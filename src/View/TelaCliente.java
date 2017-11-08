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

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TelaCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
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
	public TelaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOlFulano = new JLabel("Ol\u00E1, Fulano");
		lblOlFulano.setForeground(SystemColor.desktop);
		lblOlFulano.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOlFulano.setBounds(10, 0, 147, 29);
		panel.add(lblOlFulano);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 11));
		list.setBounds(60, 124, 528, 226);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(596, 124, 17, 226);
		panel.add(scrollBar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(582, 5, 65, 23);
		panel.add(btnSair);
		
		JButton btnCadastrar = new JButton("Finalizar compra");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(278, 372, 153, 23);
		panel.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Adicionar no carrinho");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(441, 372, 172, 23);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Meu Perfil");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(465, 5, 107, 23);
		panel.add(btnExcluir);
		
		JLabel lblSelecioneOProduto = new JLabel("Selecione o produto para ver a descri\u00E7\u00E3o");
		lblSelecioneOProduto.setForeground(Color.BLACK);
		lblSelecioneOProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelecioneOProduto.setBounds(60, 84, 288, 29);
		panel.add(lblSelecioneOProduto);
	
	}
}
