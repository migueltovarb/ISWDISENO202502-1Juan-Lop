package paqueteBook;

public class ProgramaBook {
	
	public static void main(String[] args) {
        Author a1 = new Author("Gabriel García Márquez", "gabriel@example.com", 'M');
        Book b1 = new Book("Cien años de soledad", a1, 45.99, 10);

        System.out.println(b1);

        
        System.out.println("Título: " + b1.getName());
        System.out.println("Autor: " + b1.getAuthor().getName());
        System.out.println("Precio: " + b1.getPrice());
        System.out.println("Cantidad: " + b1.getQty());

        
        b1.setPrice(39.99);
        b1.setQty(12);

        System.out.println("Después de actualizar:");
        System.out.println(b1);
    }

}
