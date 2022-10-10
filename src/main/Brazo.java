package main;

public class Brazo {

	private Caja caja;

	public Brazo(Caja caja) {
		this.caja = caja;
	}

	public void vaciarCaja() throws InterruptedException {
		System.out.println("Brazo está cambiando la caja...");
		Thread.sleep(2000);
		caja.vaciar();
	}

}
