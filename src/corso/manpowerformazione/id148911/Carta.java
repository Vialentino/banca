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
	
	
	public Carta(String pin, CC cc, String intestatario, String scadenza, Sportello sportello, double commissione, double GI, double GO, double MI, double MO){
		this.pin = pin;
		this.cc = cc;
		this.intestatario = intestatario;
		this.scadenza = scadenza;
		this.commissione = commissione;
		this.maxGI=GI;
		this.maxGO=GO;
		this.maxMI=MI;
		this.maxMO=MO;
	}
	
	public void collegaSportello(Sportello sportello){
		this.sportello = sportello;
	}

	
}
