package main;

public class Pasta {

	private int peso;

	public Pasta(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "" + peso;
	}

}
