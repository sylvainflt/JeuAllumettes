package allumettes;

public class Ordinateur {

	public static int propositionOrdinateur() {
		
		int proposition = (int) Math.floor(Math.random()*3)+1;
		
		System.out.println("L'ordinateur a choisi le nombre "+proposition);
		
		return proposition;
	}
	
	
	public static void main(String[] args) {
		
		Ordinateur.propositionOrdinateur();
		
	}
}
