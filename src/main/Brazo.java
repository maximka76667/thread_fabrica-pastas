package main;

public class Brazo implements Runnable {

	private Caja caja;
	private Mostrador mostrador;

	public Brazo(Mostrador mostrador, Caja caja) {
		this.caja = caja;
		this.mostrador = mostrador;
	}

	public void vaciarCaja() throws InterruptedException {
		synchronized (caja) {
			while (caja.getIsFull()) {
				System.out.println("Brazo está cambiando la caja...");
				Thread.sleep(1000);
				caja.vaciar();
			}

		}

		synchronized (mostrador) {
			mostrador.notifyAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				vaciarCaja();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
