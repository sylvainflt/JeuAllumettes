package allumettes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu extends JPanel implements ActionListener{

	int nbAllumettes= 17;
	
	protected JButton b1, b2, b3;
	protected JPanel allumettes;
	protected JPanel buttons;
	protected JLabel allumettesLabel;
	
	public Jeu() {
		b1 = new JButton("1");
        b1.setSize(20, 20);
        b1.setActionCommand("1");
        b1.addActionListener(this);
        
        b2 = new JButton("2");
        b2.setSize(20, 20);
        b2.setActionCommand("2");
        b2.addActionListener(this);
        
        b3 = new JButton("3");
        b3.setSize(20, 20);
        b3.setActionCommand("3");
        b3.addActionListener(this);
        
        allumettes = new JPanel();
        allumettesLabel = new JLabel(afficherAllumettesString());
        allumettes.add(allumettesLabel);

        buttons = new JPanel();
        buttons.add(b1, BorderLayout.LINE_START);
        buttons.add(b2, BorderLayout.CENTER);
        buttons.add(b3, BorderLayout.LINE_END);
	}	
	
	public JPanel getAllumettes() {
		return allumettes;
	}

	public void setAllumettes(JPanel allumettes) {
		this.allumettes = allumettes;
	}

	public JPanel getButtons() {
		return buttons;
	}

	public void setButtons(JPanel buttons) {
		this.buttons = buttons;
	}

	public void afficherAllumettes() {
	
		for(int i=0; i<nbAllumettes; i++) {
			System.out.print("|");
		}
		System.out.println();
		
	}
	 
	public String afficherAllumettesString() {
		String s = "";
		for(int i=0; i<nbAllumettes; i++) {
			s += "|";
		}
		return s;
		
	}
	
	public void commencerJeu() {
	
		System.out.println("Veuillez entrer le nombre d'allumettes : ");
		Scanner sc = new Scanner(System.in);
		nbAllumettes = sc.nextInt();
		
		Joueur j = new Joueur();
		
		while(nbAllumettes > 0) {
			
			afficherAllumettes();
			
			nbAllumettes -= j.propositionJoueur();
			
			if(nbAllumettes <= 0) {
				System.out.println("le joueur a gagné");
				break;
			}
			
			afficherAllumettes();
			
			nbAllumettes -= Ordinateur.propositionOrdinateur();
			
			if(nbAllumettes <= 0) {
				System.out.println("l'ordinateur a gagné");
				break;
			}
		}
		
	}
	 
	public void menuJeu() {						
		
		Scanner sc = new Scanner(System.in);
		String continuer = "oui";
		
		while(continuer.equalsIgnoreCase("oui")){
			commencerJeu();
			System.out.println("Voulez vous rejouer ?");
			continuer = sc.next();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
        if ("1".equals(e.getActionCommand())) {
        	nbAllumettes -= 1;
        	allumettesLabel.setText(afficherAllumettesString());
        } else if ("2".equals(e.getActionCommand())) {
        	nbAllumettes -= 2;
        	allumettesLabel.setText(afficherAllumettesString());
        } else if ("3".equals(e.getActionCommand())) {
        	nbAllumettes -= 3;
        	allumettesLabel.setText(afficherAllumettesString());
        }
        if(nbAllumettes <= 0) {
        	allumettesLabel.setText("le joueur a gagné");				
		}else {
			nbAllumettes -= Ordinateur.propositionOrdinateur();
			allumettesLabel.setText(afficherAllumettesString());
			if(nbAllumettes <= 0) {
	        	allumettesLabel.setText("l'ordinateur a gagné");				
			}
		}
        
    }
	
}
