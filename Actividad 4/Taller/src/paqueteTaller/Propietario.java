package paqueteTaller;

public class Propietario {
	
	private String nombreCompleto;
	private int numeroCOntacto;
	
	
	public Propietario(String nombreCompleto, int numeroCOntacto) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.numeroCOntacto = numeroCOntacto;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public int getNumeroCOntacto() {
		return numeroCOntacto;
	}


	public void setNumeroCOntacto(int numeroCOntacto) {
		this.numeroCOntacto = numeroCOntacto;
	}
	
	public void registrarPropietario() {
		System.out.println("El propietario " + this.nombreCompleto + " con numero de contacto " + this.numeroCOntacto
				+ " ha sido registrado.");
	}


	@Override
	public String toString() {
		return "Propietario [nombreCompleto=" + nombreCompleto + ", numeroCOntacto=" + numeroCOntacto + "]";
	}
	
	

}
