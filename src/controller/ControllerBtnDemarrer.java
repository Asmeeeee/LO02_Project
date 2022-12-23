package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Executable;
import view.MonInterface;

public class ControllerBtnDemarrer {
	
	private JButton jbutton;
	private MonInterface monInterface;
	private Executable executable;
	
	public ControllerBtnDemarrer(MonInterface monInterface ,JButton b) {
		this.monInterface = monInterface;
		this.jbutton = b;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jbutton.getText().equals("OUI")){
					monInterface.changePanel(monInterface.getPanelCont(), "2");
				}
				else {
					monInterface.fermerJeux();
				}
			}
		});
	}

}
