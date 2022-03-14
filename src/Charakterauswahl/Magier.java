package Charakterauswahl;

public class Magier {
	
	
	public Magier ()
	{
		
		String magier = "Magier";
		
		int HP = 	10,
			ATK = 	7,
			Meteor = 100;
		

		
		if (HP < 3)
		{
			System.out.println(magier);
			System.out.println("HP: "+ HP +" ATK: "+ ATK);
			System.out.println("Besonderheit: Meteor " + Meteor + " ATK");
		}
		else
		{
			System.out.println(magier);
			System.out.println("HP: "+ HP +" ATK: "+ ATK);

		}
		
		
	}
	
	
	
	
public static void main(String[] args) {
	
	new Magier();
	
	
	
	/*
	
	Magier
 	
 	HP:		10
 	ATK:	7
 	
 	Besonderheiten:
 	
 	Solange HP unter 3, neue Fähigkeit Meteor 100 Schaden
	
	 */
	
	
	
	
	
}
}
