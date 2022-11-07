package main;

import java.util.ArrayList;

public class Mostrador {

	private ArrayList<Pasta> pastas;

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

	public Mostrador() {
		pastas = new ArrayList<Pasta>();
	}

	public Pasta addPasta(Pasta nuevaPasta) throws InterruptedException {
		synchronized (this) {
			Thread.sleep(900);
			pastas.add(nuevaPasta);
			show("+" + nuevaPasta);
			notifyAll();
			return nuevaPasta;
		}
	}

	public Pasta cojerPasta() throws InterruptedException {
		synchronized (this) {
			while (getPastasLength() == 0) {
				System.out.println("Mostrador está vacia");
				wait();
			}

			Thread.sleep(500);
			Pasta removedPasta = pastas.remove(0);
			show("-" + removedPasta);
			notifyAll();
			return removedPasta;
		}
	}
}
