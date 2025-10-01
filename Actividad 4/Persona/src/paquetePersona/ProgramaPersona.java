package paquetePersona;

public class ProgramaPersona {
	public static void main(String[] args) {
		
		Persona persona1 = new Persona();
		Persona persona2 = new Persona("Juan", 25, 'H');
		Persona persona3 = new Persona("Ana", 30, 'M', 60.0, 1.65);

		
		System.out.println(persona1);
		System.out.println(persona2);
		System.out.println(persona3);

		
		System.out.println("IMC de " + persona1.getNombre() + ": " + persona1.calcularIMC());
		System.out.println("IMC de " + persona2.getNombre() + ": " + persona2.calcularIMC());
		System.out.println("IMC de " + persona3.getNombre() + ": " + persona3.calcularIMC());

		
		System.out.println(persona1.getNombre() + " es mayor de edad: " + persona1.esMayorDeEdad());
		System.out.println(persona2.getNombre() + " es mayor de edad: " + persona2.esMayorDeEdad());
		System.out.println(persona3.getNombre() + " es mayor de edad: " + persona3.esMayorDeEdad());
	}
}

