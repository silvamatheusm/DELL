package View;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.CadastrarController;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;

public class TelaCadastro {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldTel;
	private JTextField textFieldCpf;
	private JRadioButton rdbtnCliente ;
	private JRadioButton rdbtnFuncionario ;
	private CadastrarController cadastrarController;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastrarController = new CadastrarController(this);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(159, 123, 86, 14);
		panel.add(lblNewLabel);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(255, 120, 238, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(159, 170, 86, 14);
		panel.add(lblEndereo);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(159, 195, 76, 14);
		panel.add(lblTelefone);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(159, 220, 76, 14);
		panel.add(lblCpf);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(255, 167, 238, 20);
		panel.add(textFieldEndereco);

		textFieldTel = new JTextField();
		textFieldTel.setColumns(10); 
		textFieldTel.setBounds(255, 192, 238, 20);
		panel.add(textFieldTel);

		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(255, 217, 238, 20);
		panel.add(textFieldCpf);

		JLabel lblPreenchaAsInformaes = new JLabel("Preencha as informa\u00E7\u00F5es abaixo para cadastrar");
		lblPreenchaAsInformaes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreenchaAsInformaes.setBounds(159, 76, 373, 14);
		panel.add(lblPreenchaAsInformaes);

		rdbtnFuncionario = new JRadioButton("Funcionario");
		rdbtnFuncionario.setBounds(245, 258, 109, 23);
		panel.add(rdbtnFuncionario);

		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(384, 258, 109, 23);
		panel.add(rdbtnCliente);

		ButtonGroup grupo1 =  new ButtonGroup();
		grupo1.add(rdbtnCliente);
		grupo1.add(rdbtnFuncionario);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(245, 301, 109, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setActionCommand("Cadastrar");
		btnCadastrar.addActionListener(cadastrarController);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(386, 301, 107, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(cadastrarController);
		btnVoltar.setActionCommand("Voltar");
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(159, 145, 76, 14);
		panel.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(255, 142, 238, 20);
		panel.add(textFieldSenha);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldEndereco() {
		return textFieldEndereco;
	}

	public JTextField getTextFieldTel() {
		return textFieldTel;
	}

	public JTextField getTextFieldCpf() {
		return textFieldCpf;
	}
	
	

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public JRadioButton getRdbtnCliente() {
		return rdbtnCliente;
	}

	public JRadioButton getRdbtnFuncionario() {
		return rdbtnFuncionario;
	}
	
	
}
