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
import javax.swing.JTextArea;

public class TelaFuncionario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		list.setBounds(59, 157, 528, 226);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(589, 157, 17, 226);
		panel.add(scrollBar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(582, 5, 65, 23);
		panel.add(btnSair);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDoProduto.setBounds(20, 47, 137, 14);
		panel.add(lblNomeDoProduto);
		
		textField = new JTextField();
		textField.setBounds(132, 44, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreo.setBounds(20, 72, 89, 14);
		panel.add(lblPreo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 69, 86, 20);
		panel.add(textField_1);
		
		JLabel lblDescrioProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescrioProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrioProduto.setBounds(222, 47, 128, 14);
		panel.add(lblDescrioProduto);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(284, 125, 105, 23);
		panel.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(399, 125, 89, 23);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(498, 125, 89, 23);
		panel.add(btnExcluir);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(360, 42, 287, 54);
		panel.add(textArea);
	}
}
