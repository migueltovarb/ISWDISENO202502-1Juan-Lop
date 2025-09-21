package paqueteAuthor;

public class Author {
    
    private String name;
    private String email;
    private char gender; 


    public Author(String name, String email, char gender) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        char g = Character.toLowerCase(gender);
        if (g != 'm' && g != 'f') {
            throw new IllegalArgumentException("El género debe ser 'm' o 'f'");
        }

        this.name = name;
        this.email = email;
        this.gender = g;
    }

    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        this.email = email;
    }

    public char getGender() {
        return gender;
    }


    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }

}