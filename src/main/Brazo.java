package main;

public class Brazo implements Runnable {

	private Caja caja;

	public Brazo(Mostrador mostrador, Caja caja) {
		this.caja = caja;
	}

	public void vaciarCaja() throws InterruptedException {
		synchronized (caja) {
			while (caja.getIsFull()) {
				System.out.println("Brazo está cambiando la caja...");
				Thread.sleep(3000);
				System.out.println("Brazo ha cambiado la caja");
				caja.vaciar();
				caja.notifyAll();
			}

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
