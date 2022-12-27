package view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;


public class MonInterface {

	//-------------------------------Phase 1
	private JFrame frame;
	JPanel panelCont = new JPanel();
	private Intro intro;
	private ConfigurationEtudiant configurationEtudiant;
	private Melee melee;
	private Treve treve;
	private Fin fin;


	private CardLayout cl = new CardLayout();
	

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
	}
	
	public void changePanel(Container c, String num) {
		cl.show(c, num);
	}

	
	
	public JPanel getPanelCont() {
		return this.panelCont;
	}
	
	public void fermerJeux() {
		this.frame.dispose();
	}
	
	
	public void setComponent(Component component){
	    frame.getContentPane().removeAll();
	    frame.getContentPane().add(component, 0);
	    frame.revalidate();   // revalidate all the frame components
	    frame.repaint();      // and repaint the frame
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelCont.setLayout(cl);
		fin = new Fin();
		intro = new Intro(this);
		configurationEtudiant = new ConfigurationEtudiant(this);
		treve = new Treve(configurationEtudiant);
		melee = new Melee(configurationEtudiant, treve, fin);
		treve.setMelee(melee);

		

		panelCont.add(intro, "1");
		panelCont.add(configurationEtudiant, "2");
		panelCont.add(melee,"3");
		panelCont.add(treve,"4");
		panelCont.add(fin,"5");
		cl.show(panelCont, "1");
		
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void update(Observable o, Object arg) {
		System.out.println("update");
	}
	
	
	
	public Treve getTreve() {
		return treve;
	}

	public void setTreve(Treve treve) {
		this.treve = treve;
	}

	public Melee getMelee() {
		return melee;
	}

	public void setMelee(Melee melee) {
		this.melee = melee;
	}
}
