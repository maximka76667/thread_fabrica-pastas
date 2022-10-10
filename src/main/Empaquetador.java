package main;

public class Empaquetador implements Runnable {

	private Mostrador mostrador;
	private Caja caja;
	private Brazo brazo;

	public Empaquetador(Mostrador mostrador, Caja caja, Brazo brazo) {
		this.mostrador = mostrador;
		this.caja = caja;
		this.brazo = brazo;
	}

	public void moverPasta() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (mostrador) {
			caja.show();
			while (mostrador.getPastasLength() == 0) {
				System.out.println("Empaquetador: Mostrador is empty");
				mostrador.wait();
			}
			Pasta pasta = mostrador.cojerPasta();
			while (caja.calcIsFull(pasta.getPeso())) {
				System.out.println("Empaquetador: Caja is full");
				brazo.vaciarCaja();
			}
			caja.addPasta(pasta);
			mostrador.notifyAll();
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
