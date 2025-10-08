package paqueteTaller;

public class Servicio {
	
	private TipoServicio tipoServicio;
	private double costoServicio;
	private String fechaServicio;
	Vehiculo vehiculo;

	public Servicio(TipoServicio tipoServicio, double costoServicio, String fechaServicio, Vehiculo vehiculo) {
		super();
		this.tipoServicio = tipoServicio;
		this.costoServicio = costoServicio;
		this.fechaServicio = fechaServicio;
		this.vehiculo = vehiculo;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public double getCostoServicio() {
		return costoServicio;
	}

	public void setCostoServicio(double costoServicio) {
		this.costoServicio = costoServicio;
	}

	public String getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public boolean costoMayorACero() {
		return this.costoServicio > 0;
	}
	
	public boolean vehiculoExixte() {
		return this.vehiculo != null;
	}

	@Override
	public String toString() {
		return "Servicio [tipoServicio=" + tipoServicio + ", costoServicio=" + costoServicio + ", fechaServicio="
		        + fechaServicio + ", vehiculoPlaca=" + (vehiculo != null ? vehiculo.getPlaca() : "N/A") + "]";
	}
	
	
	
}
