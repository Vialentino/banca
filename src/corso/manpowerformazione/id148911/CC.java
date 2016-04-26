package corso.manpowerformazione.id148911;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

class Movimento {
	private String data;
	private String ora;
	private String causale;
	private double importo;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
}


public class CC {
	private Banca banca;
	private String iban;
	private double saldo;
	private Cliente cliente;
	private double fido;
	private ArrayList<Carta> carte=new ArrayList<Carta>();
	private ArrayList<Movimento> movimenti=new ArrayList<Movimento>();
	
	public CC(Banca banca, String iban, double saldo, Cliente cliente){
		this.banca=banca;
		this.iban=iban;
		this.saldo=saldo;
		this.cliente=cliente;
	}
	
	
	
	public Banca getBanca() {
		return banca;
	}

	public String getIban() {
		return iban;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public ArrayList<Carta> getCarte() {
		return carte;
	}



	public void setCarte(ArrayList<Carta> carte) {
		this.carte = carte;
	}



	public void addMovimento(Movimento m){
		movimenti.add(m);
		aggiornaSaldo();
	}
	
	public void aggiornaSaldo(){
		saldo=saldo+movimenti.get(movimenti.size()-1).getImporto();
	}
	
	public boolean checkDisponibilita(float importo){
		if((saldo+fido)<importo)
			return false;
		return true;
	}
	
	public void concediFido(float importo){
		if(importo<0)
			return;
		fido=importo;
	}
	
	public void revocaFido(){
		if(fido>0)
			fido=0;
	}
	
	public void visualizzaSaldoMovimenti(){
		JOptionPane.showMessageDialog(null, "Saldo: "+saldo+"\n"+"Lista movimenti: \n"+toString(movimenti));
	}
	
	public void registraCarta(Carta c){
		if(c.getCC().equals(this))
			carte.add(c);
		System.err.println("La carta non appartiene a questo conto");
	}
	
	public String toString(ArrayList<Movimento> mov){
		String s="";
		for(Movimento m : mov){
			s+=m.getImporto()+" "+m.getCausale()+" "+m.getData()+" "+m.getOra()+"\n";
		}
		return s;
	}
	
	
	
}
