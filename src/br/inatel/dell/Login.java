package br.inatel.dell;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Dimension;

public class Login {

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
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(0, 0));
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSenha = new JLabel("Usu\u00E1rio:");
		lblSenha.setBounds(144, 117, 46, 14);
		panel.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(190, 114, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(144, 142, 46, 14);
		panel.add(lblSenha_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 139, 86, 20);
		panel.add(textField_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.BLUE);
		btnEntrar.setBounds(169, 186, 89, 23);
		panel.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(169, 11, 107, 95);
		panel.add(lblNewLabel);
	}
}
