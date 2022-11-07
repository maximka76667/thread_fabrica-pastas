package main;

public class Empaquetador implements Runnable {

	private Mostrador mostrador;
	private Caja caja;

	public Empaquetador(Mostrador mostrador, Caja caja) {
		this.mostrador = mostrador;
		this.caja = caja;
	}

	public void moverPasta() throws InterruptedException {
		Pasta pasta = mostrador.cojerPasta();
		caja.addPasta(pasta);
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
