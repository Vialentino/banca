package corso.manpowerformazione.id148911;

public class Carta {

	private final String pin;
	private final CC cc;
	private final String intestatario;
	private final String scadenza;
	private final Sportello sportello;
	private final double commissione;
	private  double maxGI;
	private  double maxGO;
	private  double maxMI;
	private  double maxMO;
	protected int stato;
	
	public int getStato() {
		return stato;
	}

	public void cambiaStato(int stato) {
		this.stato = stato;
	}

	
	
	
	public Carta(String pin, CC cc, String intestatario, String scadenza, Sportello sportello, double commissione, double GI, double GO, double MI, double MO){
		this.pin = pin;
		this.cc = cc;
		this.intestatario = intestatario;
		this.scadenza = scadenza;
		this.commissione = commissione;
		this.sportello = sportello;
		this.maxGI=GI;
		this.maxGO=GO;
		this.maxMI=MI;
		this.maxMO=MO;
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

}
