package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllerBtnDemarrer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonInterface {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnNon;
	private JButton btnOui;
	private GroupLayout groupLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		initialize();
		ControllerBtnDemarrer controllerBtnDemarrerOui = new ControllerBtnDemarrer(btnOui);
		ControllerBtnDemarrer controllerBtnDemarrerNon = new ControllerBtnDemarrer(btnNon);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblNewLabel = new JLabel("Voulez-vous jouez?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		btnNon = new JButton("NON");
		btnNon.setForeground(Color.WHITE);
		btnNon.setBackground(Color.RED);
		
		btnOui = new JButton("OUI");
		btnOui.setBackground(Color.GREEN);
		btnOui.setForeground(Color.WHITE);
		groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(107))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(btnNon)
					.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
					.addComponent(btnOui)
					.addGap(97))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNon)
						.addComponent(btnOui))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
