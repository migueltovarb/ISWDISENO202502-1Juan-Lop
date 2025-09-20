package paqueteCirculo;

public class ProgramaCirculo {
	
	
    public static void main (String[] args) {

        Circulo miCirculo = new Circulo();
        double area = miCirculo.getArea();
        System.out.println("El area del circulo es: " + area);
        miCirculo.setRadio(300);
        area= miCirculo.getArea();

        System.out.println("El area del circulo con radio 300 es: " + area);

        Circulo miSegundoCirculo = new Circulo(400);
        area = miSegundoCirculo.getArea();
        System.out.println("El area del segundo circulo con radio 400 es: " + area);

        double perimetro = miSegundoCirculo.getPerimetro();
        System.out.println("El perimetro del segundo circulo con radio 400 es: " + perimetro);

        System.out.println(miCirculo.toString());

    }

}
