package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

import Controller.LoginController;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class Login {

	private JFrame frame;
	private JTextField textFieldLogin;
	private JPasswordField textFieldSenha;
	private LoginController loginController;
	private JRadioButton rdbFuncionario ,rdbCliente;

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

		loginController = new LoginController(this);

		ButtonGroup grupo1 =  new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(0, 0));
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblSenha = new JLabel("Login:");
		lblSenha.setBounds(144, 117, 46, 14);
		panel.add(lblSenha);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(190, 114, 86, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblSenha_1 = new JLabel("Senha:");
		lblSenha_1.setBounds(144, 142, 46, 14);
		panel.add(lblSenha_1);

		textFieldSenha = new JPasswordField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(190, 139, 86, 20);
		panel.add(textFieldSenha);
		textFieldSenha.addActionListener(loginController);
		textFieldSenha.setActionCommand("Enter");

		rdbFuncionario = new JRadioButton("Funcion\u00E1rio");
		rdbFuncionario.setBounds(144, 164, 132, 23);
		panel.add(rdbFuncionario);

		rdbCliente = new JRadioButton("Cliente");
		rdbCliente.setBounds(144, 190, 132, 23);
		panel.add(rdbCliente);
	
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.BLUE);
		btnEntrar.setBounds(101, 220, 107, 23);
		panel.add(btnEntrar);
		btnEntrar.addActionListener(loginController);
		btnEntrar.setActionCommand("Entrar");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(169, 11, 107, 95);
		panel.add(lblNewLabel);

		grupo1.add(rdbFuncionario);
		grupo1.add(rdbCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(Color.BLUE);
		btnCadastrar.setActionCommand("Entrar");
		btnCadastrar.setBounds(231, 220, 107, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(loginController);
		btnCadastrar.setActionCommand("Cadastrar");
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setBounds(321, 0, 89, 23);
		panel.add(btnAjuda);
		btnAjuda.addActionListener(loginController);
		btnAjuda.setActionCommand("Ajuda");
		
	}

	public JTextField getTextFieldLogin() {
		return  textFieldLogin;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public JRadioButton getRdbFuncionario() {
		return rdbFuncionario;
	}

	public JRadioButton getRdbCliente() {
		return rdbCliente;
	}

	public JFrame getFrame() {
		return frame;
	}
}
