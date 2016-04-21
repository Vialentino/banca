package corso.manpowerformazione.id148911;

import java.util.ArrayList;

import corso.manpowerformazione.id148911.Cliente;

public class CC {
	private String iban;
	private float saldo;
	private Cliente cliente;
	private float fido;
	private ArrayList<Carta> carte=new ArrayList<Carta>();
	private ArrayList<Movimento> movimenti=new ArrayList<Movimento>();
	
	public void addMovimento(Movimento m){
		movimenti.add(m);
		aggiornaSaldo();
	}
	
	public void aggiornaSaldo(){
		saldo=saldo+movimenti.get(movimenti.size()-1).getImporto();
	}
	
	public boolean checkDisponibilita(float importo){
		
	}

}
