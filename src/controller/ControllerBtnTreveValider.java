package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ConfigurationEtudiant;
import view.Melee;
import view.Treve;

public class ControllerBtnTreveValider {
	private JButton jbutton;
	private Treve treve;
	private ConfigurationEtudiant ci;
	private Melee melee;
	
	public ControllerBtnTreveValider(Treve t, ConfigurationEtudiant ci, Melee m ,JButton jb) {
		this.treve = t;
		this.jbutton = jb;
		this.ci = ci;
		this.melee = m;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getLblJoueur().getText() == "Joueur 1") {
					t.changerJoueur();
					t.setJour();
				}
				else {
					//ci.getPartie().demarrerMelee();
					m.enleverTousEtu();
					m.afficherEtu();
					ci.getMonInteface().changePanel(ci.getMonInteface().getPanelCont(), "3");
				}
			}
		});
	}

}
