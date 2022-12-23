package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllerBtnDemarrer;

public class Intro extends JPanel {
	private MonInterface mi;

	private JLabel lblVoulezVousJouer;
	private JButton btnNon;
	private JButton btnOui;
	/**
	 * Create the panel.
	 */
	public Intro(MonInterface mi) {
		this.mi = mi;
		initialize();
		ControllerBtnDemarrer c1 = new ControllerBtnDemarrer(this.mi, btnOui);
		ControllerBtnDemarrer c2 = new ControllerBtnDemarrer(this.mi, btnNon);


	}
	
	public void initialize() {
		lblVoulezVousJouer = new JLabel("Voulez-vous jouer?");
		lblVoulezVousJouer.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		btnNon = new JButton("NON");
		btnNon.setBackground(Color.RED);
		btnNon.setForeground(Color.WHITE);
		
		btnOui = new JButton("OUI");
		btnOui.setBackground(Color.GREEN);
		btnOui.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(btnNon)
					.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
					.addComponent(btnOui)
					.addGap(65))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(lblVoulezVousJouer, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(lblVoulezVousJouer, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOui)
						.addComponent(btnNon))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
