package paqueteCuenta;

public class Cuenta {
    private String titular;
    private double cantidad;
    

    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad = 0.0;
    }
    
 
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }
    
 
    public String getTitular() {
        return titular;
    }
    
    public double getCantidad() {
        return cantidad;
    }
    

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
 
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
            System.out.println("✓ Ingreso exitoso de $" + String.format("%.2f", cantidad));
            System.out.println("  Nuevo saldo: $" + String.format("%.2f", this.cantidad));
        } else {
            System.out.println("✗ No se puede ingresar una cantidad negativa o cero");
        }
    }
    

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            double nuevoSaldo = this.cantidad - cantidad;
            
            if (nuevoSaldo < 0) {
                System.out.println("⚠ Advertencia: Saldo insuficiente");
                System.out.println("  Saldo actual: $" + String.format("%.2f", this.cantidad));
                System.out.println("  Intentando retirar: $" + String.format("%.2f", cantidad));
                this.cantidad = 0.0;
                System.out.println("  La cuenta queda en $0.00");
            } else {
                this.cantidad = nuevoSaldo;
                System.out.println("✓ Retiro exitoso de $" + String.format("%.2f", cantidad));
                System.out.println("  Nuevo saldo: $" + String.format("%.2f", this.cantidad));
            }
        } else {
            System.out.println("✗ No se puede retirar una cantidad negativa o cero");
        }
    }


	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
    

}
