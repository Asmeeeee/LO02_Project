package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.entities.Etudiant;
import model.entities.Partie;
import model.entities.Zone;
import view.Treve;

public class ControllerBtnTreveDeployer {
	
	private JButton jbutton;
	private Treve treve;
	private int iJoueur = 0;
	
	public ControllerBtnTreveDeployer(Treve t, JButton jb) {
		this.treve = t;
		this.jbutton = jb;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getLblJoueur().getText() == "JOUEUR 2") {
					iJoueur = 1;
				}
				int iEtu = t.getComboBoxEtu().getSelectedIndex(); 
				Etudiant etu = t.getUneInterface().getPartie().getLesJoueurs().get(iJoueur).getReserviste().get(iEtu);
				int iZone = t.getComboBoxZone().getSelectedIndex();
				Zone z = (Zone) t.getUneInterface().getPartie().zoneNonControle().get(iZone);
				etu.deployer(z);
                etu.setReserviste(false);
                t.setJour();
			}
		});
	}

}
