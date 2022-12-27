package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllerBtnTreveDeployer;
import controller.ControllerBtnTreveRedeployer;
import controller.ControllerBtnTreveValider;
import model.entities.Etudiant;
import model.entities.Zone;

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
	
	private JLabel lblReserStats1;
	private JLabel lblReserStats2;
	
	private ControllerBtnTreveValider c;
	private ControllerBtnTreveDeployer c1;
	private ControllerBtnTreveRedeployer c2;
	private JLabel lblEtuRedeployerStats1;
	private JLabel lblEtuRedeployerStats3;
	private JLabel lblEtuRedeployerStats2;
	private JLabel lblEtuRedeployerStats0;

	
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
		
		lblJoueur = new JLabel();
		lblJoueur.setText("Joueur 1");
		lblJoueur.setForeground(Color.blue);
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
		
		lblReserStats1 = new JLabel("Force:  |  Déxtérité:  |  Résistance: ");		
		lblReserStats2 = new JLabel("Constitution:  |  Initiative:  ");
		
		lblEtuRedeployerStats1 = new JLabel("Force:  |  Déxtérité: ");
		lblEtuRedeployerStats3 = new JLabel("Constitution:  |  Initiative:  ");
		
		lblEtuRedeployerStats2 = new JLabel("Résistance: ");
		
		lblEtuRedeployerStats0 = new JLabel("Classe: ");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnDeployer)
							.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(32)
									.addComponent(comboBoxZoneDeployer, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(61)
									.addComponent(lblMesReservistes))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(75)
									.addComponent(comboBoxEtuDeployer, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
							.addGap(198))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblJoueur)
									.addGap(18, 205, Short.MAX_VALUE))
								.addComponent(lblReserStats1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
								.addComponent(lblReserStats2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTreve, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTreveValider))
							.addGap(59)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEtuRedeployerStats2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEtuARedeployer, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(comboBoxEtuRedeployer, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBoxStratRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(43)
										.addComponent(comboBoxZoneRedeployer, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblEtuRedeployerStats1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblEtuRedeployerStats0, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGap(9))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnRedeployer)
								.addGap(47)))
						.addComponent(lblEtuRedeployerStats3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblJoueur)
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMesReservistes)
								.addComponent(lblEtuARedeployer))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxEtuDeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxEtuRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxStratRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxZoneDeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxZoneRedeployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDeployer)
								.addComponent(btnRedeployer)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblTreve)))
					.addGap(22)
					.addComponent(lblEtuRedeployerStats0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReserStats1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(lblEtuRedeployerStats1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblReserStats2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTreveValider)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEtuRedeployerStats2)
							.addGap(7)
							.addComponent(lblEtuRedeployerStats3)))
					.addGap(18))
		);
		setLayout(groupLayout);
		c1 = new ControllerBtnTreveDeployer(this, btnDeployer);
		c2 = new ControllerBtnTreveRedeployer(this, btnRedeployer);
		this.addEventComboBoxReser(this);
		this.addEventComboBoxEtuRedeployer(this);
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
	
	public void setJoueur0() {
		this.iJoueur = 0;
	}
	
	public void setJour() {
		redeployerSetEnable(true);
		reservisteSetEnable(true);
		//------------------------------Affichage
		if(this.iJoueur == 0) {
			this.lblJoueur.setText("JOUEUR 1");
			this.lblJoueur.setForeground(Color.blue);
		}
		else {
			this.lblJoueur.setText("JOUEUR 2");
			this.lblJoueur.setForeground(Color.red);
		}
		//------------------------------Redeployer
		List<Etudiant> etuRedeployer = this.uneInterface.getPartie().getLesJoueurs().get(iJoueur).etuARedeployer();
		comboBoxEtuRedeployer.removeAllItems();
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
	
	public int getIndexJoueur() {
		return iJoueur;
	}
	
	public void addEventComboBoxReser(Treve t) {
		comboBoxEtuDeployer.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        t.setJourReserStats();
		    }
		});
	}
	
	public void addEventComboBoxEtuRedeployer(Treve t) {
		comboBoxEtuRedeployer.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        t.setJourEtuRedeployerStats();
		    }
		});
	}
	
	public void setJourReserStats() {
		int iEtu = this.getComboBoxEtu().getSelectedIndex(); 
		if(iEtu >= 0 ) {
			List<Etudiant> list = this.getUneInterface().getPartie().getLesJoueurs().get(this.getIndexJoueur()).getReserviste();
			Etudiant etu = list.get(iEtu);
			this.lblReserStats1.setText("Force: "+ etu.getForce()+" | Déxtérité:"+etu.getDexterite()+" | Résistance: "+ etu.getResistance());
			this.lblReserStats2.setText("Constitution: "+etu.getConstitution()+" | Initiative: "+etu.getInitiative());
		}
		else {
			this.lblReserStats1.setText("Force:  |  Déxtérité:  |  Résistance: ");
			this.lblReserStats2.setText("Constitution:  |  Initiative:  ");
		}
	}
	
	public void setJourEtuRedeployerStats() {
		int iEtu = this.getComboBoxEtuRedeployer().getSelectedIndex(); 
		if(iEtu >= 0 ) {
			List<Etudiant> list = this.getUneInterface().getPartie().getLesJoueurs().get(this.getIndexJoueur()).etuARedeployer();
			Etudiant etu = list.get(iEtu);
			this.lblEtuRedeployerStats0.setText("Classe: "+etu.getClasse());
			this.lblEtuRedeployerStats1.setText("Force: "+ etu.getForce()+" | Déxtérité:"+etu.getDexterite());
			this.lblEtuRedeployerStats2.setText("Résistance: "+ etu.getResistance());
			this.lblEtuRedeployerStats3.setText("Constitution: "+etu.getConstitution()+" | Initiative: "+etu.getInitiative());
		}
		else {
			this.lblEtuRedeployerStats0.setText("Classe: ");
			this.lblEtuRedeployerStats1.setText("Force:  |  Déxtérité: ");
			this.lblEtuRedeployerStats2.setText("Résistance: ");
			this.lblEtuRedeployerStats3.setText("Constitution:  |  Initiative:  ");
		}
	}
}
