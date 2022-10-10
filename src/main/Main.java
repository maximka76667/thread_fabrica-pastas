package main;

public class Main {

	public static void main(String[] args) {

		Mostrador mostrador = new Mostrador();

		Caja caja = new Caja(30);
		Brazo brazo = new Brazo(caja);

		Thread tHorno = new Thread(new Horno(mostrador));

		Thread tEmpaquetador = new Thread(new Empaquetador(mostrador, caja, brazo));

		tHorno.start();
		tEmpaquetador.start();
	}

}
