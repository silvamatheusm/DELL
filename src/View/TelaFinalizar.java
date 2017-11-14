package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.FinalizarController;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFinalizar {

	private JFrame frame;
	private JList listMeusProdutos;
	private JLabel textTotal;
	private FinalizarController finalizarController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFinalizar window = new TelaFinalizar();
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
	public TelaFinalizar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		finalizarController = new FinalizarController(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCarrinhoDeCompras = new JLabel("Carrinho de compras");
		lblCarrinhoDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrinhoDeCompras.setBounds(42, 37, 181, 29);
		panel.add(lblCarrinhoDeCompras);
		
		listMeusProdutos = new JList();
		listMeusProdutos.setBounds(38, 77, 216, 180);
		panel.add(listMeusProdutos);
		
		textTotal = new JLabel("Total:");
		textTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTotal.setBounds(38, 291, 216, 14);
		panel.add(textTotal);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(278, 101, 153, 23);
		panel.add(btnComprar);
		btnComprar.addActionListener(finalizarController);
		btnComprar.setActionCommand("Comprar");
		
		JButton btnCancelar = new JButton("Cancelar Compra");
		btnCancelar.setBounds(278, 160, 153, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(finalizarController);
		btnCancelar.setActionCommand("Cancelar");
		
		finalizarController.inicializaTela();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JList getListMeusProdutos() {
		return listMeusProdutos;
	}

	public void setListMeusProdutos(JList listMeusProdutos) {
		this.listMeusProdutos = listMeusProdutos;
	}

	public JLabel getTextTotal() {
		return textTotal;
	}

	public void setTextTotal(JLabel textTotal) {
		this.textTotal = textTotal;
	}
	
	
}
