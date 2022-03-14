package Charakterauswahl;

public class Krieger {


	public Krieger()
	{
		String krieger = "Krieger";
		
		int HP = 	10,
			ATK = 	8;
		
		if (HP < 6)
		{
			System.out.println(krieger);
			int dopatk = ATK*2;
			System.out.println("HP: "+ HP +" ATK: "+ dopatk);
			// System.out.println("Besonderheit: " + dopatk + " ATK");
		}
		else
		{
			System.out.println(krieger);
			System.out.println("HP: "+ HP +" ATK: "+ ATK);

		}
	}
	
	
	
	public static void main(String[] args) {
		
		new Krieger();
		
		/*
		 
	Krieger
 	
 	HP: 	10
 	ATK: 	8
 	
 	Besonderheiten:
 	
 	HP unter 6, doppelter Schaden
		 
		 */
		
	
		
		
		
		
		
		
		
	}
}
