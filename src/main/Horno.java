package main;

public class Horno implements Runnable {

	private Mostrador mostrador;
	protected int tipo;

	public Horno(Mostrador mostrador, Caja caja, int tipo) {
		this.mostrador = mostrador;
		this.tipo = tipo;
	}

	public Pasta producirPasta() throws InterruptedException {
		Pasta nuevaPasta = new Pasta(tipo);
		Thread.sleep(1000);
		return nuevaPasta;
	}

	@Override
	public void run() {
		while (true) {
			try {
				mostrador.addPasta(producirPasta());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
