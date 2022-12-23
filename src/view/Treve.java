package view;

import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllerBtnTreveDeployer;
import controller.ControllerBtnTreveValider;
import model.entities.Etudiant;
import model.entities.Zone;
import java.awt.Color;

public class Treve extends JPanel {
	
	private ConfigurationEtudiant uneInterface;
	private Melee melee;
	
	private JLabel lblTreve;
	private JComboBox comboBoxEtuDeployer;
	private JComboBox comboBoxZoneDeployer;
	private JComboBox comboBoxStratRedeployer;
	private JLabel lblJoueur;
	private JComboBox comboBoxEtuRedeployer;
	private JComboBox comboBoxZoneRedeployer;
	private JButton btnRedeployer;
	private JButton btnDeployer;
	private JButton btnTreveValider;
	
	private int iJoueur = 0;
	private JLabel lblMesReservistes;
	private JLabel lblEtuARedeployer;
	
	private ControllerBtnTreveValider c;
	
	/**
	 * Create the panel.
	 * @param configurationEtudiant 
	 */
	public Treve(ConfigurationEtudiant configurationEtudiant) {
		this.uneInterface = configurationEtudiant;
		
		lblTreve = new JLabel("Treve");
		lblTreve.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		comboBoxEtuDeployer = new JComboBox();
		
		comboBoxZoneDeployer = new JComboBox();
		
		String[] strat = {"Offensive", "Défensive", "Aléatoire"};
		comboBoxStratRedeployer = new JComboBox(strat);
		
		btnDeployer = new JButton("Déployer");
		
		lblJoueur = new JLabel("Joueur 1");
		lblJoueur.setBackground(new Color(0, 0, 255));
		lblJoueur.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		comboBoxEtuRedeployer = new JComboBox();
		
		comboBoxZoneRedeployer = new JComboBox();
		
		btnRedeployer = new JButton("Redéployer");
		
		btnTreveValider = new JButton("Valider");
		
		lblMesReservistes = new JLabel("Mes réservistes");
		lblMesReservistes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblEtuARedeployer = new JLabel("Etudiants à redéployer");
		lblEtuARedeployer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(comboBoxZoneDeployer, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
					.addComponent(comboBoxZoneRedeployer, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(btnDeployer)
					.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
					.addComponent(btnRedeployer)
					.addGap(84))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(comboBoxEtuDeployer, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
					.addComponent(comboBoxEtuRedeployer, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBoxStratRedeployer, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(lblMesReservistes)
					.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
					.addComponent(lblEtuARedeployer)
					.addGap(62))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblJoueur)
					.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTreve, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnTreveValider)
							.addGap(254))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJoueur)
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMesReservistes)
								.addComponent(lblEtuARedeployer))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxEtuDeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxStratRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxEtuRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxZoneDeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxZoneRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDeployer)
								.addComponent(btnRedeployer)))
						.addComponent(lblTreve))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(btnTreveValider)
					.addGap(48))
		);
		setLayout(groupLayout);
		ControllerBtnTreveDeployer c1 = new ControllerBtnTreveDeployer(this, btnDeployer);
	}
	
	public void reservisteSetEnable(Boolean b) {
		comboBoxEtuDeployer.setEnabled(b);
		comboBoxZoneDeployer.setEnabled(b);
		btnDeployer.setEnabled(b);
	}
	
	public void redeployerSetEnable(Boolean b) {
		comboBoxEtuRedeployer.setEnabled(b);
		comboBoxStratRedeployer.setEnabled(b);
		comboBoxZoneRedeployer.setEnabled(b);
		btnRedeployer.setEnabled(b);
	}
	
	public void setJour() {
		redeployerSetEnable(true);
		reservisteSetEnable(true);
		//------------------------------Redeployer
		List<Etudiant> etuRedeployer = this.uneInterface.getPartie().getLesJoueurs().get(iJoueur).etuARedeployer();
		comboBoxEtuRedeployer.removeAll();
		for(Etudiant e : etuRedeployer) {
			if(e!=null) {
				comboBoxEtuRedeployer.addItem(e.toString());	
			}
		}
		if(etuRedeployer.size() == 0) {
			redeployerSetEnable(false);
		}
		
		//-------------------------------Reserviste
		List<Etudiant> reserviste = this.uneInterface.getPartie().getLesJoueurs().get(iJoueur).reserviste();
		comboBoxEtuDeployer.removeAllItems();
		for(Etudiant e : reserviste) {
			if(e!=null) {
				comboBoxEtuDeployer.addItem(e.toString());
			}
		}
		if(reserviste.size() == 0) {
			reservisteSetEnable(false);
		}
		
		//----------------------------Les zones
		List<Zone> zonesNonControle = this.uneInterface.getPartie().zoneNonControle();
		comboBoxZoneDeployer.removeAllItems();
		comboBoxZoneRedeployer.removeAllItems();
		for(Zone z : zonesNonControle) {
			if(z!= null) {
				comboBoxZoneDeployer.addItem(z.getNomZone());
				comboBoxZoneRedeployer.addItem(z.getNomZone());
			}
		}
	}
	
	
	
	public JComboBox getComboBoxEtu() {
		return comboBoxEtuDeployer;
	}

	public void setComboBoxEtu(JComboBox comboBoxEtu) {
		this.comboBoxEtuDeployer = comboBoxEtu;
	}

	public JComboBox getComboBoxZone() {
		return comboBoxZoneDeployer;
	}

	public void setComboBoxZone(JComboBox comboBoxZone) {
		this.comboBoxZoneDeployer = comboBoxZone;
	}

	public JComboBox getComboBoxStratRedeployer() {
		return comboBoxStratRedeployer;
	}

	public void setComboBoxStratRedeployer(JComboBox comboBoxStratRedeployer) {
		this.comboBoxStratRedeployer = comboBoxStratRedeployer;
	}

	public JComboBox getComboBoxEtuRedeployer() {
		return comboBoxEtuRedeployer;
	}

	public void setComboBoxEtuRedeployer(JComboBox comboBoxEtuRedeployer) {
		this.comboBoxEtuRedeployer = comboBoxEtuRedeployer;
	}

	public JComboBox getComboBoxZoneRedeployer() {
		return comboBoxZoneRedeployer;
	}

	public void setComboBoxZoneRedeployer(JComboBox comboBoxZoneRedeployer) {
		this.comboBoxZoneRedeployer = comboBoxZoneRedeployer;
	}

	public void changerJoueur() {
		this.lblJoueur.setText("JOUEUR 2");
		this.lblJoueur.setForeground(Color.red);
		this.iJoueur++;
		
	}

	public JLabel getLblJoueur() {
		return lblJoueur;
	}

	public void setLblJoueur(JLabel lblJoueur) {
		this.lblJoueur = lblJoueur;
	}

	public ConfigurationEtudiant getUneInterface() {
		return uneInterface;
	}

	public void setUneInterface(ConfigurationEtudiant uneInterface) {
		this.uneInterface = uneInterface;
	}
	
	public Melee getMelee() {
		return this.melee;
	}

	public void setMelee(Melee m) {
		this.melee = m;
		c = new ControllerBtnTreveValider(this, this.uneInterface, this.melee, btnTreveValider);
	}
	
	
}
