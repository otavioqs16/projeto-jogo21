package iftm;

public class Card {

	String cartas, naipe;

	int valor;
	
	public Card(String pcartas, String pnaipe, int pvalor){
		cartas = pcartas;
		naipe = pnaipe;
		valor = pvalor;
	}

	public String getCartas() {
		return cartas;
	}

	public void setCartas(String cartas) {
		this.cartas = cartas;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
