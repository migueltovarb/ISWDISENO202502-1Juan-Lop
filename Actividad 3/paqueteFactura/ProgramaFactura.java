package paqueteFactura;

public class ProgramaFactura {

	public static void main(String[] args) {
		Factura fac1 = new Factura("001", "Monitor", 2, 150.0);
		Factura fac2 = new Factura("002", "Teclado", 3, 50.0);

		System.out.println(fac1);
		System.out.println(fac2);

		System.out.println("Total de la factura " + fac1.getId() + ": " + fac1.getTototal());
		System.out.println("Total de la factura " + fac2.getId() + ": " + fac2.getTototal());

		fac1.setCantidad(5);
		fac2.setPrecioPorUnidad(45.0);

		System.out.println("Despues de actualizar la cantidad y el precio:");
		System.out.println(fac1);
		System.out.println(fac2);

		System.out.println("Total actualizado de la factura " + fac1.getId() + ": " + fac1.getTototal());
		System.out.println("Total actualizado de la factura " + fac2.getId() + ": " + fac2.getTototal());
	}

}
