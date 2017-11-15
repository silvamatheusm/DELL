package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Login;
import View.TelaAjuda;

public class AjudaController implements ActionListener {
	
	TelaAjuda telaAjuda;
	
	public AjudaController(TelaAjuda telaAjuda) {
		this.telaAjuda = telaAjuda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ok")){
			Login login = new Login();
			login.getFrame().setVisible(true);
			telaAjuda.getFrame().dispose();
		}

	}

}
