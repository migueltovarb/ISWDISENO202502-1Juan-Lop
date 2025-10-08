package paqueteVeterinaria;

import java.util.List;

public class Mascota {
	
	private String nombre;
	private String especie;
	private int edad;
	private Dueño dueño;
	private List<ControlVeterinario> controlesVeterinarios;
	
	public Mascota(String nombre, String especie, int edad, Dueño dueño,
			List<ControlVeterinario> controlesVeterinarios) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.dueño = dueño;
		this.controlesVeterinarios = controlesVeterinarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Dueño getDueño() {
		return dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

	public List<ControlVeterinario> getControlesVeterinarios() {
		return controlesVeterinarios;
	}

	public void setControlesVeterinarios(List<ControlVeterinario> controlesVeterinarios) {
		this.controlesVeterinarios = controlesVeterinarios;
	}
	
	public boolean tieneControles() {
		return this.controlesVeterinarios != null && !this.controlesVeterinarios.isEmpty();
	}
	
	public void registrarMascotaDueño() {
		System.out.println("Mascota registrada: " + this.nombre + ", Especie: " + this.especie + ", Edad: " + this.edad
				+ ", Dueño: " + this.dueño.getNombreCompleto());
	}
	
	public void registrarControlVeterinario(ControlVeterinario control) {
		if (this.controlesVeterinarios != null) {
			this.controlesVeterinarios.add(control);
			System.out.println("Control veterinario registrado para la mascota " + this.nombre + " en fecha "
					+ control.getFecha());
		} else {
			System.out.println("No se puede registrar el control veterinario, la lista de controles es nula.");
		}
	}

	public void historialControles() {
		if (this.tieneControles()) {
			System.out.println("Historial de controles veterinarios para la mascota " + this.nombre + ":");
			for (ControlVeterinario c : this.controlesVeterinarios) {
				System.out.println(c);
			}
		} else {
			System.out.println("La mascota " + this.nombre + " no tiene controles veterinarios registrados.");
		}
	}

	@Override
	public String toString() {
	    return "Mascota [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad 
	           + ", dueño=" + dueño.getNombreCompleto() 
	           + ", controles=" + (controlesVeterinarios != null ? controlesVeterinarios.size() : 0) + "]";
	}
	

}
