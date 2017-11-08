package View;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;

public class TelaCadastro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(159, 123, 86, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(255, 120, 238, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(159, 148, 86, 14);
		panel.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(159, 173, 76, 14);
		panel.add(lblTelefone);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(159, 198, 76, 14);
		panel.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 145, 238, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 170, 238, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 195, 238, 20);
		panel.add(textField_3);
		
		JLabel lblPreenchaAsInformaes = new JLabel("Preencha as informa\u00E7\u00F5es abaixo para cadastrar");
		lblPreenchaAsInformaes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreenchaAsInformaes.setBounds(159, 76, 373, 14);
		panel.add(lblPreenchaAsInformaes);
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionario");
		rdbtnFuncionario.setBounds(245, 233, 109, 23);
		panel.add(rdbtnFuncionario);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(384, 233, 109, 23);
		panel.add(rdbtnCliente);
		
		ButtonGroup grupo1 =  new ButtonGroup();
		grupo1.add(rdbtnCliente);
		grupo1.add(rdbtnFuncionario);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(245, 301, 109, 23);
		panel.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(386, 301, 107, 23);
		panel.add(btnVoltar);
	}
}
