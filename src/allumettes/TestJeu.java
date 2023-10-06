package allumettes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestJeu {

	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Jeu des allumettes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        Jeu j = new Jeu();
        frame.getContentPane().add(new JLabel("veuillez choisir un nombre d'allumettes à retirer"), BorderLayout.PAGE_START);
        frame.getContentPane().add(j.getAllumettes(), BorderLayout.CENTER);
        frame.getContentPane().add(j.getButtons(), BorderLayout.PAGE_END);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        //frame.setSize(350, 150);
    }
	
	public static void main(String[] args) {
		

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
