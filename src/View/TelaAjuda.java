package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.AjudaController;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaAjuda {

	private JFrame frame;
	private AjudaController ajudaController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjuda window = new TelaAjuda();
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
	public TelaAjuda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ajudaController = new AjudaController(this);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextArea dtrpnCasoODefeito = new JTextArea();
		dtrpnCasoODefeito.setBackground(SystemColor.activeCaption);
		dtrpnCasoODefeito.setForeground(Color.BLUE);
		dtrpnCasoODefeito.setText("Caso o defeito apare\u00E7a dentro do prazo de sete dias ap\u00F3s a compra,\r\nou qualquer outra duvida, voc\u00EA pode nos ligar no seguinte telefone\r\nDell Telefone :\r\n(35) 3471-1234");
		dtrpnCasoODefeito.setBounds(27, 89, 505, 110);
		dtrpnCasoODefeito.setWrapStyleWord(true);
		panel.add(dtrpnCasoODefeito);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(172, 210, 89, 23);
		panel.add(btnOk);
		btnOk.addActionListener(ajudaController);
		btnOk.setActionCommand("Ok");
		
		JLabel lblAssistnciaTcnica = new JLabel("Assist\u00EAncia T\u00E9cnica");
		lblAssistnciaTcnica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAssistnciaTcnica.setForeground(Color.BLUE);
		lblAssistnciaTcnica.setBounds(27, 64, 192, 14);
		panel.add(lblAssistnciaTcnica);


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

