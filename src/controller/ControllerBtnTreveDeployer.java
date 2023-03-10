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
	
	public ControllerBtnTreveDeployer(Treve t, JButton jb) {
		this.treve = t;
		this.jbutton = jb;
		this.jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iEtu = t.getComboBoxEtu().getSelectedIndex(); 
				System.out.println(iEtu);
				Etudiant etu = t.getUneInterface().getPartie().getLesJoueurs().get(t.getIndexJoueur()).getReserviste().get(iEtu);
				int iZone = t.getComboBoxZone().getSelectedIndex();
				Zone z = (Zone) t.getUneInterface().getPartie().zoneNonControle().get(iZone);
				etu.deployer(z);
                etu.setReserviste(false);
                t.setJour();
			}
		});
	}

}
