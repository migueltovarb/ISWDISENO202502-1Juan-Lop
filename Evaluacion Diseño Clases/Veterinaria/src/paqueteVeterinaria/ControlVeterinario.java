package paqueteVeterinaria;

public class ControlVeterinario {
	
	private String fecha;	
	private TipoControl tipoControl;
	private String observaciones;
	private Mascota mascota;
	
	
	public ControlVeterinario(String fecha, TipoControl tipoControl, String observaciones, Mascota mascota) {
		super();
		this.fecha = fecha;
		this.tipoControl = tipoControl;
		this.observaciones = observaciones;
		this.mascota = mascota;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public TipoControl getTipoControl() {
		return tipoControl;
	}


	public void setTipoControl(TipoControl tipoControl) {
		this.tipoControl = tipoControl;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public boolean mascotaExiste() {
		return this.mascota != null;
	}


	@Override
	public String toString() {
	    return "ControlVeterinario [fecha=" + fecha + ", tipoControl=" + tipoControl 
	           + ", observaciones=" + observaciones 
	           + ", mascota=" + (mascota != null ? mascota.getNombre() : "Sin asignar") + "]";
	}
	
	

}
