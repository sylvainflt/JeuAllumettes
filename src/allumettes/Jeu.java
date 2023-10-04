package allumettes;

import java.util.Scanner;

public class Jeu {

	int nbAllumettes= 17;
	
	public void afficherAllumettes() {
	
		for(int i=0; i<nbAllumettes; i++) {
			System.out.print("|");
		}
		System.out.println();
		
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
	
	
}
