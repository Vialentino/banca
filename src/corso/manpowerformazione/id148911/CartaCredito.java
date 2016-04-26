package corso.manpowerformazione.id148911;

import java.util.ArrayList;

public class CartaCredito extends Carta{

	private double fido;
	private ArrayList<CC> ccs;
	public CartaCredito(String pin, CC cc, String intestatario, String scadenza, Sportello sportello,
			double commissione, double GI, double GO, double MI, double MO) {
		super(pin, cc, intestatario, scadenza, sportello, commissione, GI, GO, MI, MO);
		ccs = new ArrayList<>();
		ccs.add(cc);
	}
	public double getFido() {
		return fido;
	}
	public void setFido(double fido) {
		this.fido = fido;
	}
	public ArrayList<CC> getCcs() {
		return ccs;
	}
	public void addCc(CC cc) {
		this.ccs.add(cc);
	}
	public void removeCc(CC cc) {
		this.ccs.remove(cc);
	}
	
}
