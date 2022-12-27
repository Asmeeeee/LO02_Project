package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.entities.Etudiant;
import model.entities.Zone;
import view.Treve;

public class ControllerBtnTreveRedeployer {
	
	private JButton jbutton;
	private Treve treve;
	
	public ControllerBtnTreveRedeployer(Treve t, JButton jb) {
		this.treve = t;
		this.jbutton = jb;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iEtu = t.getComboBoxEtu().getSelectedIndex(); 
				Etudiant etu = t.getUneInterface().getPartie().getLesJoueurs().get(t.getIndexJoueur()).etuARedeployer().get(iEtu);
				int iZone = t.getComboBoxZoneRedeployer().getSelectedIndex();
				Zone z = (Zone) t.getUneInterface().getPartie().zoneNonControle().get(iZone);
				etu.deployer(z);
                etu.setReserviste(false);
                t.setJour();
			}
		});
	}

}
