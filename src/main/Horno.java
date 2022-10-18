package main;

public class Horno implements Runnable {

	int[] pesos = { 3, 7, 10 };
	private Mostrador mostrador;

	public Horno(Mostrador mostrador, Caja caja) {
		this.mostrador = mostrador;
	}

	public void producirPasta() throws InterruptedException {
		Thread.sleep(900);
		synchronized (mostrador) {
			int pesoAleatorio = (int) Math.floor(Math.random() * pesos.length);
			Pasta nuevaPasta = new Pasta(pesos[pesoAleatorio]);
			mostrador.addPasta(nuevaPasta);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				producirPasta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
