package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.Melee;
import view.Treve;

public class ControllerBtnDemarrerMelee {
	private Melee melee;
	private JButton jbutton;
	private Treve treve;
	
	public ControllerBtnDemarrerMelee(Melee m, Treve t, JButton jb) {
		this.melee = m;
		this.jbutton = jb;
		this.treve = t;
		this.jbutton.addActionListener(new ActionListener() {
			int cpt = 0;
			public void actionPerformed(ActionEvent e) {
				if(cpt%2 == 0 ) {
					m.getUneInterface().getPartie().demarrerMelee();
					m.enleverTousEtu();
					m.afficherEtu();
					m.revalidate();
					m.repaint();
				}
				else {
					if(m.getUneInterface().getPartie().getLesJoueurs().get(0).getMesZones().size()<3 
							&& m.getUneInterface().getPartie().getLesJoueurs().get(1).getMesZones().size()<3) {
						t.setJour();
						m.getUneInterface().getMonInteface().changePanel(m.getUneInterface().getMonInteface().getPanelCont(), "4");
					}
					else {
						m.getUneInterface().getMonInteface().changePanel(m.getUneInterface().getMonInteface().getPanelCont(), "5");
					}
				}
				cpt++;
			}
		});
	}
}
