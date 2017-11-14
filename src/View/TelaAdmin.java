package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.JTextField;

import Controller.AdminController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaAdmin {

	private JFrame frame;
	private JList listClientes;
	private JList listFunc;
	private JButton btnSair;
	private AdminController adminController;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmin window = new TelaAdmin();
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
	public TelaAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		adminController = new AdminController(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		listClientes = new JList();
		listClientes.setBounds(89, 108, 220, 207);
		panel.add(listClientes);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(635, 11, 89, 23);
		panel.add(btnSair);
		btnSair.addActionListener(adminController);
		btnSair.setActionCommand("Sair");
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClientes.setBounds(147, 66, 117, 31);
		panel.add(lblClientes);
		
		JLabel lblFuncionrios = new JLabel("Funcion\u00E1rios");
		lblFuncionrios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFuncionrios.setBounds(394, 66, 166, 31);
		panel.add(lblFuncionrios);
		
		listFunc = new JList();
		listFunc.setBounds(363, 108, 220, 207);
		panel.add(listFunc);
		
		adminController.preencheLista();
	}

	public JFrame getFrame() {
		return frame;
	}

	public JList getListClientes() {
		return listClientes;
	}

	public JList getListFunc() {
		return listFunc;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
	
	
}
