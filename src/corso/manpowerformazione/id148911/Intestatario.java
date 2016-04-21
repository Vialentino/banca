package corso.manpowerformazione.id148911;

import java.util.ArrayList;
import corso.manpowerformazione.id148911.Carta;
import corso.manpowerformazione.id148911.Persona;

public class Intestatario extends Persona{
	
	 ArrayList<Carta> carte;
	 
	 public Intestatario(String nome, String cognome, String cf, Carta ... carte){
		 
		 super(nome,cognome,cf);
		 for (Carta i : carte){
			    this.carte.add(i);
		      }
	 }
	
}
