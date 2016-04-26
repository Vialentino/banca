package corso.manpowerformazione.id148911;

import java.util.ArrayList;
import corso.manpowerformazione.id148911.CC;
import corso.manpowerformazione.id148911.Persona;

public class Cliente extends Persona{
	
	 ArrayList<CC> conti;
	 
	 public Cliente(String nome, String cognome, String cf, CC ... conti){
		 
		 super(nome,cognome,cf);
		 for (CC i : conti){
			    this.conti.add(i);
		      }
	 }
	
}
