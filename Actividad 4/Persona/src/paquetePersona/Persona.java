package paquetePersona;

public class Persona {
    
    private static final char SEXO_POR_DEFECTO = 'H';
    private static final int PESO_BAJO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;
    
  
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;
    
  
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_POR_DEFECTO;
        this.peso = 0.0;
        this.altura = 0.0;
        this.DNI = generaDNI();
    }
    
   
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        comprobarSexo(sexo);
        this.peso = 0.0;
        this.altura = 0.0;
        this.DNI = generaDNI();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.DNI = generaDNI();
    }
    
   
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getDNI() {
        return DNI;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public double getAltura() {
        return altura;
    }
    
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
        comprobarSexo(sexo);
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
 
    public int calcularIMC() {
        if (altura == 0) {
            return PESO_BAJO;
        }
        
        double imc = peso / Math.pow(altura, 2);
        
        if (imc < 20) {
            return PESO_BAJO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }
    

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
    

    private void comprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_POR_DEFECTO;
        } else {
            this.sexo = sexo;
        }
    }
    
 
    private String generaDNI() {
        int numeroDNI = generarNumeroAleatorio();
        char letraDNI = calcularLetraDNI(numeroDNI);
        return String.format("%08d%c", numeroDNI, letraDNI);
    }
    
   
    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 100000000);
    }
    
    
    private char calcularLetraDNI(int numeroDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numeroDNI % 23;
        return letras.charAt(indice);

    }


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
    

}
