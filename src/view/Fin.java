package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

public class Fin extends JPanel {

	private JLabel lblFin;
	private JLabel lblVainqueur;
	/**
	 * Create the panel.
	 */
	public void setJoueur(int n) {
		this.lblVainqueur.setText("Le vainqueur est le Joueur "+n);
	}
	
	public Fin() {
		
		lblFin = new JLabel("FIN");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		lblVainqueur = new JLabel("oui");
		lblVainqueur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(161))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblVainqueur, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addGap(68))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(lblFin)
					.addGap(18)
					.addComponent(lblVainqueur, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
