package main;

import java.util.ArrayList;

public class Mostrador {

	private ArrayList<Pasta> pastas;

	public Mostrador() {
		pastas = new ArrayList<Pasta>();
	}

	public Pasta addPasta(Pasta nuevaPasta) {
		pastas.add(nuevaPasta);
		show("+" + nuevaPasta);
		return nuevaPasta;
	}

	public Pasta cojerPasta() {
		Pasta removedPasta = pastas.remove(0);
		show("-" + removedPasta);
		return removedPasta;
	}

	public int getPastasLength() {
		return this.pastas.size();
	}

	public int getPesos() {
		int pesos = 0;
		for (Pasta pasta : pastas) {
			pesos += pasta.getPeso();
		}
		return pesos;
	}

	public void show(String message) {
		System.out.print("Mostrador " + message + ": ");
		for (Pasta pasta : pastas) {
			System.out.print(pasta + " ");
		}
		System.out.println();
	}
}
