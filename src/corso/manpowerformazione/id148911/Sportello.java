package corso.manpowerformazione.id148911;

import corso.manpowerformazione.id148911.Banca;
import corso.manpowerformazione.id148911.Carta;

public class Sportello {

	Banca banca;
	double disponibilita;
	Carta carta;
	
	public Sportello(Banca banca, double disponibilita, Carta carta){
		
		this.banca=banca;
		this.disponibilita=disponibilita;
		this.carta=carta;
	}
	
	public void inserisciCarta(Carta unaCarta){
		
		if (carta!=null){
			System.out.println("Impossibile inserire carta. Altra carta in fase di lettura.");
		}
		else carta=unaCarta;
		
	}
	
    public void espelliCarta(){
		
		if (carta==null){
			System.out.println("Attenzione! Nessuna carta inserita.");
		}
		else carta=null;
		
	}
    
   // public boolean checkPIN(String PIN){
   // 	if(PIN == carta.getPIN()) return true;
   // 	else return false;
   //}
    
    public double preleva(double importoRichiesto){
    	if(carta.checkTetti()==0){
    		if(importoRichiesto<=carta.getCC().getSaldo()){
    			if(importoRichiesto <= disponibilita){
    				//carta.getCC().addMovimento(Movimento(data,ora,causale,importo,dove));
        			System.out.println("Operazione andata a buon fine. Lei ha prelevato"+importoRichiesto);
       		        return importoRichiesto;
       		     }
       		    else{
       			    System.out.println("Disponibilità massima = "+disponibilita);
       			    return 0;
       		    }
    		}
    		else{
    			System.out.println("Saldo non disponibile");
    			return 0;
    		}
    	}
    	else if(carta.checkTetti()==1){
    			System.out.println
    			("Limite massimo giornaliero raggiunto. Impossibile prelevare l'importo richiesto");
    		    return 0;	
    	}
    	else if(carta.checkTetti()==2){
			System.out.println
			("Limite massimo mensile raggiunto. Impossibile prelevare l'importo richiesto");
			return 0;
		}
    	else{
    		System.err.println
    		("ERRORE!! Il tuo checkTetti è malfunzionante.");
    		return 0;
    	}
    }
    public double versa(double importoVersato){
    }
    
    public void visualizzaSaldoEMovimenti(){
    }
    public void bloccaCarta(){
    }
    public void scegliOperazione(){
    }
    
    }
}
