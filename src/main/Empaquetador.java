package main;

public class Empaquetador implements Runnable {

	private Mostrador mostrador;
	private Caja caja;

	public Empaquetador(Mostrador mostrador, Caja caja) {
		this.mostrador = mostrador;
		this.caja = caja;
	}

	public void moverPasta() throws InterruptedException {
		Pasta pasta;
		Thread.sleep(1000);
		synchronized (mostrador) {
			while (mostrador.getPastasLength() == 0) {
				System.out.println("Empaquetador: Mostrador is empty");
				caja.wait();
			}
			pasta = mostrador.cojerPasta();
		}

		synchronized (caja) {
			while (caja.calcIsFull(pasta.getPeso())) {
				System.out.println("Empaquetador: Caja is full");
				caja.wait();
			}
			caja.addPasta(pasta);
			caja.notifyAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				moverPasta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
