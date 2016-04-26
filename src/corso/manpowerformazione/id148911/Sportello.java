package corso.manpowerformazione.id148911;

import corso.manpowerformazione.id148911.Banca;
import corso.manpowerformazione.id148911.Carta;
import java.time.*;

public class Sportello {

	Banca banca;
	String dove;
	double disponibilita;
	Carta carta;
	
	public Sportello(Banca banca, String dove, double disponibilita, Carta carta){
		
		this.banca=banca;
		this.dove=dove;
		this.disponibilita=disponibilita;
		this.carta=carta;
	}
	
    private void espelliCarta(){
		
		if (carta==null){
			System.out.println("Attenzione! Nessuna carta inserita.");
		}
		else {
			System.out.println("Ritirare la carta");
			carta=null;
		}
		
	}
    
   private boolean checkPIN(int tentativo){
	   Scanner input1 = new Scanner(System.in);
		String PIN = input1.nextString();
    	if(PIN == carta.getPIN()) return true;
    	else{
    		if(tentativo <3) return checkPIN(tentativo+1);
    		else return false;
    	}
   }
    
    private double preleva(double importoRichiesto){
    	if(carta.checkTetti()==0){
    		if(importoRichiesto<=carta.getCC().getSaldo()){
    			if(importoRichiesto <= disponibilita){
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
    private double versa(double importoVersato){
    	
    	System.out.println("Operazione andata a buon fine. Lei ha versato"+importoVersato);
       	return importoVersato;
    
    }
    
    private void visualizzaSaldoEMovimenti(){
    }
    private boolean bloccaCarta(){
    }
    private int scegliOperazione(){
   
    	System.out.println("Scegli operazione:");
    	System.out.println("Prelievo --> digiti 1");
    	System.out.println("Versamento --> digiti 2");
    	System.out.println("Visualizza saldo & movimenti --> digiti 3");
    	System.out.println("Espelli carta --> digiti 0");
    	
    	
    	Scanner input1 = new Scanner(System.in);
		int Scelta = input1.nextInt();
		
		if (Scelta!= 0 && Scelta !=1 && Scelta !=2 && Scelta !=3){
			System.out.println(Scelta+" non è una scelta disponibile");
			return scegliOperazione();
		}
		else return Scelta;
    }
    
    private void SportelloMain(){
    	
    	boolean controlloPIN = checkPIN(1);
    	if(controlloPIN){
    		int Scelta = scegliOperazione();
        	if (Scelta == 1){
    			System.out.println("Inserisci importo desiderato");
    			Scanner input2 = new Scanner(System.in);
    			double importoRichiesto = input2.nextDouble();
    			double denaroInUscita = preleva(importoRichiesto);
    			if(denaroInUscita !=0){
    				LocalDateTime oggi=LocalDateTime.now();
    				String data = 
    						(oggi.getDayOfMonth()+"/"+
    				         oggi.getMonth().getValue()+"/"+
    				         oggi.getYear());
    				LocalTime adesso=LocalTime.now();
    				String ora =(adesso.getHour()+":"+adesso.getMinute());
    				String causale = "prelievo";
    				carta.getCC().addMovimento(Movimento(data,ora,causale,-importoRichiesto,dove));
    			}
    		}
    		else if (Scelta == 2);
    		else if (Scelta == 3);
    		
    	    espelliCarta();	
    	}	
    	else{
    		//boolean cartaBloccata = bloccaCarta();
    	}
    }
    
    public void inserisciCarta(Carta carta){
		
		if (this.carta!=null){
			System.out.println("Impossibile inserire carta. Altra carta in fase di lettura.");
		}
		else {
			this.carta=carta;
			SportelloMain();
		}
		
	}
    
    }
}
