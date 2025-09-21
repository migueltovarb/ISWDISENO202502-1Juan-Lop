package paqueteEmpleado;

public class ProgramaEmpleado {
	
	public static void main(String[] args) {
		Empleado emp1 = new Empleado(1, "Juan", "Perez", 1000);
		Empleado emp2 = new Empleado(2, "Ana", "Gomez", 1500);

		System.out.println(emp1);
		System.out.println(emp2);

		System.out.println("Salario anual de " + emp1.getNombre() + ": " + emp1.salarioAnual());
		System.out.println("Salario anual de " + emp2.getNombre() + ": " + emp2.salarioAnual());

		emp1.incrementarSalario(10);
		emp2.incrementarSalario(5);

		System.out.println("Despues de incrementar el salario:");
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
