package allumettes;

import java.util.Scanner;

public class Joueur {

	public int propositionJoueur() {
	
		System.out.println("Veuillez entrer un nombre entre 1 et 3 : ");
		
		Scanner sc = new Scanner(System.in);
		
		int propJ = sc.nextInt();
		while(propJ < 1 || propJ > 3) {
			System.out.println("Veuillez entrer un nombre entre 1 et 3 : ");
			propJ = sc.nextInt();
		}				
			
		return propJ;
		
	}
	
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur();
		System.out.println(j1.propositionJoueur());
		
	}
	
}
