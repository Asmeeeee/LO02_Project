package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControllerBtnDemarrer {
	
	private JButton jbutton;
	
	public ControllerBtnDemarrer(JButton b) {
		this.jbutton = b;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jbutton.getText().equals("OUI")){
					System.out.println("TKT GROS!!!");
				}
				else {
					System.out.println("NON C EST NON");
				}
			}
		});
	}

}
