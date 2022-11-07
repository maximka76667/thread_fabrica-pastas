package main;

import java.util.ArrayList;

public class Caja {

	private ArrayList<Pasta> pastas;
	private int pesoMaximo;
	private boolean isFull;

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

	public Caja(int pesoMaximo) {
		pastas = new ArrayList<Pasta>();
		this.pesoMaximo = pesoMaximo;
	}

	public Pasta addPasta(Pasta pasta) throws InterruptedException {
		synchronized (this) {
			while (calcIsFull(pasta.getPeso())) {
				System.out.println("Caja está llena");
				wait();
			}
			Thread.sleep(1000);
			pastas.add(pasta);
			notifyAll();
			show();
			return pasta;
		}
	}

	public boolean calcIsFull(int nuevoPeso) {
		boolean newState = getPesos() + nuevoPeso > pesoMaximo;
		synchronized (this) {
			setIsFull(newState);
			notifyAll();
		}
		return newState;
	}

	public void vaciar() throws InterruptedException {
		synchronized (this) {
			while (!getIsFull()) {
				wait();
			}
			System.out.println("Brazo está cambiando la caja...");
			Thread.sleep(3000);
			System.out.println("Brazo ha cambiado la caja");
			pastas = new ArrayList<Pasta>();
			setIsFull(false);
			notifyAll();
		}

	}

}
