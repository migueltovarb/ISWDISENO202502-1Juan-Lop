package paqueteTaller;

import java.util.List;

public class Vehiculo {
	private int placa;
	private String marca;
	private int modelo;
	private Propietario propietario;
	private List<Servicio> servicios;
	
	
	public Vehiculo(int placa, String marca, int modelo, Propietario propietario, List<Servicio> servicios) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = propietario;
		this.servicios = servicios;
	}


	public int getPlaca() {
		return placa;
	}


	public void setPlaca(int placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getModelo() {
		return modelo;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public List<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void registrarVehiculo() {
		System.out.println("El vehiculo con placa " + this.placa + ", marca " + this.marca + ", modelo " + this.modelo
				+ " ha sido registrado.");
	}
    
	public void registrarVehiculoAPropietario() {
		System.out.println("El vehiculo con placa " + this.placa + ", marca " + this.marca + ", modelo " + this.modelo
				+ " ha sido registrado al propietario " + this.propietario.getNombreCompleto() + ".");
	}
	
	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
		System.out.println("El servicio de tipo " + servicio.getTipoServicio()
				+ " ha sido agregado al vehiculo con placa " + this.placa + ".");
	}
	
	public void validarPlacaUnica(int placa, List<Vehiculo> vehiculos) {
		for (Vehiculo v : vehiculos) {
			if (v.getPlaca() == placa) {
				System.out.println("La placa " + placa + " ya existe. Por favor, ingrese una placa unica.");
				return;
			}
		}
		System.out.println("La placa " + placa + " es unica y ha sido registrada.");
	}
	
	public double calcularCostoTotalServicios() {
		double total = 0;
		for (Servicio s : this.servicios) {
			total += s.getCostoServicio();
		}
		return total;
	}
	
	public void historialServicios() {
		System.out.println("Historial de servicios para el vehiculo con placa " + this.placa + ":");
		for (Servicio s : this.servicios) {
			System.out.println(s);
		}
	}


	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo 
		        + ", propietario=" + propietario.getNombreCompleto() 
		        + ", cantidadServicios=" + servicios.size() + "]";
	}
	
	

}
