package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import controller.ControllerBtnDemarrerMelee;
import model.entities.Etudiant;
import model.entities.Zone;

public class Melee extends JPanel {
	private ConfigurationEtudiant uneInterface;
	private Treve treve;
	private Fin fin;
	
	private JLabel lblHallesIndustri;
	private JLabel lblHalleSportive;
	private JPanel panelBureauEtudiant;
	private JPanel panelBibliotheque;
	private JPanel panelQuartierAdmin;
	private JPanel panelHallesIndustri;
	private JPanel panelHalleSportive;
	
	private JButton btnDemarrerMelee;
	private JLabel lblBibliothequeStats;
	private JLabel lblQAStats;
	private JLabel lblHIStats;
	private JLabel lblHSStats;
	private JLabel lblBEStats;
	

	/**
	 * Create the panel.
	 */
	public Melee(ConfigurationEtudiant ui, Treve treve, Fin fin) {	
		this.uneInterface = ui;
		this.treve = treve;
		this.fin = fin;
		
		JLabel lblNewLabel = new JLabel("MELEE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblBibliotheque = new JLabel("Bibliothèque");
		lblBibliotheque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBureauEtudiant = new JLabel("Bureau des Etudiants");
		lblBureauEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lnlQuartierAdministratif = new JLabel("Quartier Administratif");
		lnlQuartierAdministratif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblHallesIndustri = new JLabel("Halles industrielles");
		lblHallesIndustri.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblHalleSportive = new JLabel("Halle Sportive");
		lblHalleSportive.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panelBureauEtudiant = new JPanel();
		panelBureauEtudiant.setBorder(new LineBorder(Color.BLACK, 2));
		
		panelBibliotheque = new JPanel();
		panelBibliotheque.setBorder(new LineBorder(Color.BLACK, 2));
		
		panelQuartierAdmin = new JPanel();
		panelQuartierAdmin.setBorder(new LineBorder(Color.BLACK, 2));
		
		panelHallesIndustri = new JPanel();
		panelHallesIndustri.setBorder(new LineBorder(Color.BLACK, 2));
		
		panelHalleSportive = new JPanel();
		panelHalleSportive.setBorder(new LineBorder(Color.BLACK, 2));
		
		btnDemarrerMelee = new JButton("Demarrer");
		
		lblBibliothequeStats = new JLabel("");
		
		lblQAStats = new JLabel("     ");
		
		lblHIStats = new JLabel("");
		
		lblHSStats = new JLabel("    ");
		
		lblBEStats = new JLabel("     ");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelBibliotheque, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBibliotheque, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(4))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelQuartierAdmin, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(lnlQuartierAdministratif)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(lblBibliothequeStats, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelHallesIndustri, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(panelHalleSportive, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(58))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHallesIndustri, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDemarrerMelee)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(lblHIStats, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(53)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblHalleSportive, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
												.addGap(58))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblBureauEtudiant, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panelBureauEtudiant, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGap(77)
										.addComponent(lblHSStats, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(66)
									.addComponent(lblBEStats, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(lblQAStats, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(463, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblBibliothequeStats, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBEStats))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelBibliotheque, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(panelBureauEtudiant, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBibliotheque)
								.addComponent(lblBureauEtudiant))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQAStats)
								.addComponent(lblHIStats, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHSStats))
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(btnDemarrerMelee)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelQuartierAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelHallesIndustri, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelHalleSportive, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lnlQuartierAdministratif)
						.addComponent(lblHallesIndustri)
						.addComponent(lblHalleSportive))
					.addGap(43))
		);
		
		setLayout(groupLayout);
		ControllerBtnDemarrerMelee c = new ControllerBtnDemarrerMelee(this, treve, fin, btnDemarrerMelee);
	}
	
	public void enleverTousEtu() {
		List<JPanel> lesZones = new ArrayList<>();
		lesZones.add(panelBibliotheque);
		lesZones.add(panelBureauEtudiant);
		lesZones.add(panelQuartierAdmin);
		lesZones.add(panelHallesIndustri);
		lesZones.add(panelHalleSportive);
		for(int iZone=0; iZone<5; iZone++) {
			lesZones.get(iZone).removeAll();
		}
	}
	
	public void afficherEtu() {
		List<JPanel> lesZones = new ArrayList<>();
		lesZones.add(panelBibliotheque);
		lesZones.add(panelBureauEtudiant);
		lesZones.add(panelQuartierAdmin);
		lesZones.add(panelHallesIndustri);
		lesZones.add(panelHalleSportive);
		for(int iZone=0; iZone<5; iZone++) {
			lesZones.get(iZone).setLayout(new GridLayout(4, 4, 2, 0));
			Zone z = this.uneInterface.getPartie().getLesZones().get(iZone);
			for(Etudiant e : z.getEtudiants()) {
				JButton jb = new JButton();
				jb.setEnabled(false);
				if(e.getJoueur().getId() == 1) {
					jb.setBackground(Color.blue);
				}
				else {
					jb.setBackground(Color.red);
				}
				if(e.getClasse()=="maitre") {
					JLabel lblCrown = new JLabel("👑");
					lblCrown.setForeground(Color.white);
					jb.add(lblCrown);
				}
				if(e.getClasse()=="elite") {
					JLabel lblElite = new JLabel("🏅");
					lblElite.setForeground(Color.white);
					jb.add(lblElite);
				}
				lesZones.get(iZone).add(jb);	
			}
		}
	}
	
	public void setJourStatsZone() {
		int BiblioETC =  this.getUneInterface().getPartie().getLesZones().get(0).getNombreETC();
		this.lblBibliothequeStats.setText(BiblioETC+" ETC");
		
		int BEETC = this.getUneInterface().getPartie().getLesZones().get(1).getNombreETC();
		this.lblBEStats.setText(BEETC+" ETC");
		
		int QAETC = this.getUneInterface().getPartie().getLesZones().get(2).getNombreETC();
		this.lblQAStats.setText(QAETC+" ETC");
		
		int HIETC = this.getUneInterface().getPartie().getLesZones().get(3).getNombreETC();
		this.lblHIStats.setText(HIETC+" ETC");
		
		int HSETC = this.getUneInterface().getPartie().getLesZones().get(4).getNombreETC();
		this.lblHSStats.setText(HSETC+" ETC");
	}
	
	public void enleverStatsZone() {
		this.lblBibliothequeStats.setText("");
		this.lblBEStats.setText("");
		this.lblHSStats.setText("");
		this.lblQAStats.setText("");
		this.lblHIStats.setText("");
	}

	public ConfigurationEtudiant getUneInterface() {
		return uneInterface;
	}

	public void setUneInterface(ConfigurationEtudiant uneInterface) {
		this.uneInterface = uneInterface;
	}
	
	
}
