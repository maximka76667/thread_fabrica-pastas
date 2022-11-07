package main;

public class Brazo implements Runnable {

	private Caja caja;

	public Brazo(Mostrador mostrador, Caja caja) {
		this.caja = caja;
	}

	@Override
	public void run() {
		while (true) {
			try {
				caja.vaciar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
