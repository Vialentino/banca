package corso.manpowerformazione.id148911;

public class Carta {

	protected final String pin;
	protected final CC cc;
	protected final String intestatario;
	protected final String scadenza;
	protected Sportello sportello;
	protected final double commissione;
	protected final double maxGI;
	protected final double maxGO;
	protected final double maxMI;
	protected final double maxMO;
	protected int stato;
	
	public int getStato() {
		return stato;
	}

	public void cambiaStato(int stato) {
		this.stato = stato;
	}

	



	
	
	public Carta(String pin, CC cc, String intestatario, String scadenza, Sportello sportello, double commissione, double GI, double GO, double MI, double MO, int stato){
		this.pin = pin;
		this.cc = cc;
		this.intestatario = intestatario;
		this.scadenza = scadenza;
		this.commissione = commissione;
		this.maxGI=GI;
		this.maxGO=GO;
		this.maxMI=MI;
		this.maxMO=MO;
		this.stato=stato;
	}
	

	public boolean checkPin(String pin){
		return (this.pin==pin);
	}
	
	public int checkTetti(double movimenti){
		if (cc.getBanca().equals(sportello.getId())){	
			if (movimenti<=maxMI) return 2;	
			if (movimenti<=maxGI) return 1;
			return 0;
		}else{
			if (movimenti<=maxMO) return 2;	
			if (movimenti<=maxGO) return 1;
			return 0;
		}
	}

	public void collegaSportello(Sportello sportello){
		this.sportello = sportello;

	}

	
}
