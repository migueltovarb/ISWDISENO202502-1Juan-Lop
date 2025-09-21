package paqueteFactura;

public class Factura {
	
	private String id;
	private String descripcion;
	private int cantidad;
	private double precioPorUnidad;
	
	public Factura(String id, String descripcion, int cantidad, double precioPorUnidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioPorUnidad = precioPorUnidad;	
	}
	
	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }
	
	public void setPrecioPorUnidad(double precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}
	
	public double getTototal() {
		return  precioPorUnidad * cantidad;
		
	}
	
	public String toString() {
		return "Factura[id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precioPorUnidad="
				+ precioPorUnidad + "]";
	}
	

}
