package corso.manpowerformazione.id148911;

public class Carta {

	private final String pin;
	private final CC cc;
	private final String intestatario;
	private final String scadenza;
	private final Sportello sportello;
	private final double commissione;
	private final double maxGI;
	private final double maxGO;
	private final double maxMI;
	private final double maxMO;
	
	
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

}
