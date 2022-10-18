package main;

public class Main {

	public static void main(String[] args) {

		Mostrador mostrador = new Mostrador();
		Caja caja = new Caja(30);

		Thread tHorno = new Thread(new Horno(mostrador, caja));
		Thread tEmpaquetador = new Thread(new Empaquetador(mostrador, caja));
		Thread tBrazo = new Thread(new Brazo(mostrador, caja));

		tHorno.start();
		tEmpaquetador.start();
		tBrazo.start();
	}

}
