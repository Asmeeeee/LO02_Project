package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;

import controller.ControllerBtnConfigEtudiantValider;
import model.entities.EtudiantFactory;
import model.entities.Joueur;
import model.entities.Partie;

/**
 * @author jerem
 *
 */
public class ConfigurationEtudiant extends JPanel implements Observer{
	private MonInterface monInteface;
	
	private int cptEtu = 1;
	private Partie partie;
	private EtudiantFactory etudiantFactory;
	
	private JLabel lblEtudiant;
	private JLabel lblForce;
	private JLabel lblDexterite;
	private JLabel lblResistance;
	private JLabel lblConstitution;
	private JLabel lblInitiative;
	private JLabel lblReserviste;
	private JCheckBox chckbxReserviste;
	private JComboBox comboBoxZone;
	
	private JSpinner spinnerForce;
	private JSpinner spinnerDexterite;
	private JSpinner spinnerResistance;
	private JSpinner spinnerConstitution;
	private JSpinner spinnerInitiative;
	
	private JButton btnValider;
	private JLabel lblCredit;
	private JLabel lblPhrasePoints;
	private JLabel lblJoueur;
	private JButton btnRepartir;

	/**
	 * Create the panel.
	 */

	
	public ConfigurationEtudiant(MonInterface mi) {
		this.monInteface = mi;
		partie = new Partie();
        partie.setJeux();
        for(Joueur j : partie.getLesJoueurs()) {
    		etudiantFactory.createEtudiant(j);
        }
		
		lblEtudiant = new JLabel("Etudiant "+ cptEtu+"/"+partie.getLesJoueurs().get(0).getMonEquipe().size());
		lblEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblForce = new JLabel("Force");
		lblForce.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblDexterite = new JLabel("Dextérité");
		lblDexterite.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblResistance = new JLabel("Résistance");
		lblResistance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblConstitution = new JLabel("Constitution");
		lblConstitution.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblInitiative = new JLabel("Initiative");
		lblInitiative.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblReserviste = new JLabel("Réserviste");
		lblReserviste.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		SpinnerNumberModel modelD = new SpinnerNumberModel(0, 0, 10, 1);
		SpinnerNumberModel modelR = new SpinnerNumberModel(0, 0, 10, 1);
		SpinnerNumberModel modelF = new SpinnerNumberModel(0, 0, 10, 1);
		SpinnerNumberModel modelI = new SpinnerNumberModel(0, 0, 10, 1);
		SpinnerNumberModel modelC = new SpinnerNumberModel(0, 0, 30, 1);
		
		spinnerDexterite = new JSpinner(modelD);
		spinnerResistance = new JSpinner(modelR);
		spinnerConstitution = new JSpinner(modelC);
		spinnerInitiative = new JSpinner(modelI);
		spinnerForce = new JSpinner(modelF);
		
		chckbxReserviste = new JCheckBox("");
		
		btnValider = new JButton("Valider");
		btnValider.setBackground(Color.GREEN);
		btnValider.setForeground(Color.WHITE);
		
		lblCredit = new JLabel(partie.getLesJoueurs().get(0).getPoints()+"");
		lblCredit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblPhrasePoints = new JLabel("points");
		lblPhrasePoints.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblJoueur = new JLabel("Joueur 1");
		lblJoueur.setForeground(new Color(0, 0, 255));
		lblJoueur.setBackground(new Color(0, 0, 255));
		lblJoueur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		String[] lieux = {"...","Bibliothèque", "Bureau des Etudiants", "Quartier Administratif", "Halles industrielles", "Halle Sportive"};
		comboBoxZone = new JComboBox(lieux);		
		
		btnRepartir = new JButton("Répartir");
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(254, Short.MAX_VALUE)
					.addComponent(lblEtudiant, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(156))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(281, Short.MAX_VALUE)
					.addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPhrasePoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(234))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJoueur)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinnerForce, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblForce, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(lblDexterite, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblResistance, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblConstitution)
									.addGap(18)
									.addComponent(lblInitiative)
									.addGap(18)
									.addComponent(lblReserviste, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(46)
									.addComponent(spinnerDexterite, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(spinnerResistance, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(76)
									.addComponent(spinnerConstitution, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(64)
									.addComponent(spinnerInitiative, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
									.addComponent(chckbxReserviste)
									.addGap(52))))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(225, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBoxZone, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnValider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(125)
					.addComponent(btnRepartir)
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblJoueur)
					.addGap(18)
					.addComponent(lblEtudiant, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhrasePoints)
						.addComponent(lblCredit))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDexterite)
						.addComponent(lblForce)
						.addComponent(lblResistance)
						.addComponent(lblConstitution)
						.addComponent(lblInitiative)
						.addComponent(lblReserviste))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(spinnerForce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinnerDexterite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinnerResistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinnerConstitution, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinnerInitiative, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(chckbxReserviste))
					.addGap(18)
					.addComponent(comboBoxZone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValider)
						.addComponent(btnRepartir))
					.addGap(69))
		);
		setLayout(groupLayout);
		this.partie.addObserver(this);
		ControllerBtnConfigEtudiantValider c1 = new ControllerBtnConfigEtudiantValider(this, btnValider);
		ControllerBtnConfigEtudiantValider c2 = new ControllerBtnConfigEtudiantValider(this, btnRepartir);
	}
	
	public void initializeValue() {
		this.spinnerConstitution.setValue(0);
		this.spinnerDexterite.setValue(0);;
		this.spinnerForce.setValue(0);
		this.spinnerInitiative.setValue(0);
		this.spinnerResistance.setValue(0);
		this.chckbxReserviste.setSelected(false);
		//this.comboBoxZone.setSelectedIndex(0);
	}
	
	public void update(Observable o, Object obj) {
		if(o instanceof  Partie) {
			int iJoueur = (int) obj;
			this.getLblCredit().setText(this.partie.getLesJoueurs().get(iJoueur).getPoints()+"");
		}
		System.out.println("update");
	}
	
	public MonInterface getMonInteface() {
		return monInteface;
	}

	public void setMonInteface(MonInterface monInteface) {
		this.monInteface = monInteface;
	}

	public Partie getPartie() {
		return this.partie;
	}
	
	public void incrementCptEtu() {
		if(this.cptEtu != 20) {
			this.cptEtu ++;
		}
		else {
			this.cptEtu = 1;
		}
		this.getLblEtudiant().setText("Etudiant "+this.cptEtu+"/20");
	}
	

	public JLabel getLblJoueur() {
		return lblJoueur;
	}

	public void setLblJoueur(JLabel lblJoueur) {
		this.lblJoueur = lblJoueur;
	}

	public JLabel getLblEtudiant() {
		return lblEtudiant;
	}

	public void setLblEtudiant(JLabel lblEtudiant) {
		this.lblEtudiant = lblEtudiant;
	}

	public JLabel getLblCredit() {
		return lblCredit;
	}

	public void setLblCredit(JLabel lblCredit) {
		this.lblCredit = lblCredit;
	}
	
	

	public JComboBox getComboBoxZone() {
		return comboBoxZone;
	}

	public void setComboBoxZone(JComboBox comboBoxZone) {
		this.comboBoxZone = comboBoxZone;
	}

	public JSpinner getSpinnerForce() {
		return spinnerForce;
	}

	public void setSpinnerForce(JSpinner spinnerForce) {
		this.spinnerForce = spinnerForce;
	}

	public JSpinner getSpinnerDexterite() {
		return spinnerDexterite;
	}

	public void setSpinnerDexterite(JSpinner spinnerDexterite) {
		this.spinnerDexterite = spinnerDexterite;
	}

	public JSpinner getSpinnerResistance() {
		return spinnerResistance;
	}

	public void setSpinnerResistance(JSpinner spinnerResistance) {
		this.spinnerResistance = spinnerResistance;
	}

	public JSpinner getSpinnerConstitution() {
		return spinnerConstitution;
	}

	public void setSpinnerConstitution(JSpinner spinnerConstitution) {
		this.spinnerConstitution = spinnerConstitution;
	}

	public JSpinner getSpinnerInitiative() {
		return spinnerInitiative;
	}

	public void setSpinnerInitiative(JSpinner spinnerInitiative) {
		this.spinnerInitiative = spinnerInitiative;
	}

	public JCheckBox getChckbxReserviste() {
		return chckbxReserviste;
	}

	public void setChckbxReserviste(JCheckBox chckbxReserviste) {
		this.chckbxReserviste = chckbxReserviste;
	}
}
