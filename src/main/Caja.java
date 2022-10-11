package main;

import java.util.ArrayList;

public class Caja {

	private ArrayList<Pasta> pastas;
	private int pesoMaximo;
	private boolean isFull;

	public Caja(int pesoMaximo) {
		pastas = new ArrayList<Pasta>();
		this.pesoMaximo = pesoMaximo;
	}

	public Pasta addPasta(Pasta pasta) {
		pastas.add(pasta);
		show();
		return pasta;
	}

	public int getPastasLength() {
		return this.pastas.size();
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public int getPesos() {
		int pesos = 0;
		for (Pasta pasta : pastas) {
			pesos += pasta.getPeso();
		}
		return pesos;
	}

	public boolean calcIsFull(int nuevoPeso) {
		boolean newState = getPesos() + nuevoPeso > pesoMaximo;
		setIsFull(newState);
		return newState;
	}

	public boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}

	public void show() {
		System.out.print("Caja: ");
		for (Pasta pasta : pastas) {
			System.out.print(pasta + " ");
		}
		System.out.println();
	}

	public void vaciar() {
		pastas = new ArrayList<Pasta>();
		setIsFull(false);
	}

}
