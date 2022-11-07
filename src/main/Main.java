package main;

public class Main {

	public static void main(String[] args) {

		final int[] pesos = { 3, 7, 10 };

		Caja caja = new Caja(30);
		Mostrador mostrador = new Mostrador();

		for (int i = 0; i < 3; i++) {
			Thread tHorno = new Thread(new Horno(mostrador, caja, pesos[i]), "Horno-" + i);
			tHorno.start();
		}

		for (int i = 0; i < 2; i++) {
			Thread tEmpaquetador = new Thread(new Empaquetador(mostrador, caja), "Empq-" + i);
			tEmpaquetador.start();
		}

		Thread tBrazo = new Thread(new Brazo(mostrador, caja));
		tBrazo.start();
	}

}
