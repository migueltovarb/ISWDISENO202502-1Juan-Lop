package paqueteAuthor;

public class ProgramaAuthor {
	
	
    public static void main(String[] args) {
        
        Author a1 = new Author("Gabriela García", "gabriela@example.com", 'f');
        Author a2 = new Author("Carlos Pérez", "carlos@example.com", 'm');

        
        System.out.println(a1);
        System.out.println(a2);

        
        System.out.println("Nombre: " + a1.getName());
        System.out.println("Email: " + a1.getEmail());
        System.out.println("Género: " + a1.getGender());

        
        a1.setEmail("ggarcia@dominio.com");
        System.out.println("Email actualizado de " + a1.getName() + ": " + a1.getEmail());

        
        System.out.println("Después de actualizar email:");
        System.out.println(a1);
    }
}
