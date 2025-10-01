package paqueteCuenta;

public class ProgramaCuenta {
	public static void main(String[] args) {
		Cuenta cuenta1 = new Cuenta("Alice");
		Cuenta cuenta2 = new Cuenta("Bob", 500.0);

		System.out.println("Cuenta 1 - Titular: " + cuenta1.getTitular() + ", Saldo: $"
				+ String.format("%.2f", cuenta1.getCantidad()));
		System.out.println("Cuenta 2 - Titular: " + cuenta2.getTitular() + ", Saldo: $"
				+ String.format("%.2f", cuenta2.getCantidad()));

		cuenta1.ingresar(200.0);
		cuenta2.ingresar(-50.0);

		cuenta1.retirar(100.0);
		cuenta2.retirar(600.0);

		System.out.println("Cuenta 1 - Titular: " + cuenta1.getTitular() + ", Saldo final: $"
				+ String.format("%.2f", cuenta1.getCantidad()));
		System.out.println("Cuenta 2 - Titular: " + cuenta2.getTitular() + ", Saldo final: $"
				+ String.format("%.2f", cuenta2.getCantidad()));
	}

}
