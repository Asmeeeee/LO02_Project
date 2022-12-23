package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.entities.Etudiant;
import view.ConfigurationEtudiant;
import view.MonInterface;

public class ControllerBtnConfigEtudiantValider {
	private JButton btnValider;
	private ConfigurationEtudiant uneInterface;
	
	public ControllerBtnConfigEtudiantValider(ConfigurationEtudiant c, JButton j) {
		this.uneInterface = c;
		this.btnValider = j;
		this.btnValider.addActionListener(new ActionListener() {
			private int iEtu = 0;
			private int iJoueur = 0;
			public void actionPerformed(ActionEvent e) {
				if(j.getText() != "Répartir") {
					int force = (int) uneInterface.getSpinnerForce().getValue();
					int dexterite = (int) uneInterface.getSpinnerDexterite().getValue();
					int resistance = (int) uneInterface.getSpinnerResistance().getValue();
					int constitution = (int) uneInterface.getSpinnerConstitution().getValue();
					int initiative = (int) uneInterface.getSpinnerInitiative().getValue();
					boolean estReserviste =  uneInterface.getChckbxReserviste().isSelected();
					int totalPoint = force + dexterite + resistance + constitution + initiative;

					if(totalPoint <= Integer.parseInt(uneInterface.getLblCredit().getText())) {
						Etudiant etu = uneInterface.getPartie().getLesJoueurs().get(iJoueur).getMonEquipe().get(iEtu);
						etu.setCaracteristique("1", force);
						etu.setCaracteristique("2", dexterite);
						etu.setCaracteristique("3", resistance);
						etu.setCaracteristique("4", constitution);
						etu.setCaracteristique("5", initiative);
						if(estReserviste) {
							etu.setCaracteristique("6", 0);
						}
						etu.deployer(uneInterface.getPartie().getLesZones().get(uneInterface.getComboBoxZone().getSelectedIndex() - 1));
						uneInterface.incrementCptEtu();
						uneInterface.update(uneInterface.getPartie(), iJoueur);
						if(iEtu<19) {
							iEtu++;
						}
						else {
							if(iJoueur == 0) {
								iEtu = 0;
								iJoueur = 1;
								uneInterface.getLblJoueur().setText("Joueur 2");
								uneInterface.getLblJoueur().setForeground(Color.red);
								uneInterface.getLblCredit().setText(uneInterface.getPartie().getLesJoueurs().get(1).getPoints()+"");
							}
							else {
								MonInterface monInterface = uneInterface.getMonInteface();
								monInterface.getMelee().afficherEtu();
								monInterface.changePanel(monInterface.getPanelCont(), "3");
							}

						}
						etu.afficherTerminal();
						System.out.println(uneInterface.getComboBoxZone().getSelectedIndex() - 1);
						System.out.println(etu.getZone().getNomZone());
						//uneInterface.initializeValue();
					}

				}
				else {
					MonInterface monInterface = uneInterface.getMonInteface();
					uneInterface.getPartie().repartitionAutomatique();
					monInterface.getMelee().afficherEtu();
					monInterface.changePanel(monInterface.getPanelCont(), "3");
				}

			}
		});
		
	}

}
