package paqueteEmpleado;

public class Empleado {
	
	private int id;
	private String primerNombre;
	private String segundoNombre;
	private int salario;
	
	public Empleado(int id, String primerNombre, String segundoNombre, int salario) {
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}
	
	public String getNombre() {
		return primerNombre + " " + segundoNombre;
	}
	
	public int getSalario() {
		return salario;
	}
	
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public int salarioAnual() {
		return salario * 12;
	}
	
	public int incrementarSalario(int porcentaje) {
		salario += salario * porcentaje / 100;
		return salario;
	}
	
	public String toString() {
		return "Empleado[id=" + id + ", nombre=" + getNombre() + ", salario=" + salario + "]";
	}
	
	

}
