package Bean;

public class ContactBean {
    private String nom;
    private String email;
    
    public ContactBean(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getEmail() {
        return email;
    }
}

