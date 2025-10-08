package paqueteVeterinaria;

public class Dueño {
	
	private String nombreCompleto;
	private int documento;
	private int telefono;
	
	public Dueño(String nombreCompleto, int documento, int telefono) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.documento = documento;
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public void registrarDueño() {
		System.out.println("Dueño registrado: " + this.nombreCompleto + ", Documento: " + this.documento
				+ ", Teléfono: " + this.telefono);
	}

	@Override
	public String toString() {
		return "Dueño [nombreCompleto=" + nombreCompleto + ", documento=" + documento + ", telefono=" + telefono + "]";
	}
	

}
