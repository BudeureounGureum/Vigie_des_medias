package Entites;

public abstract class Entite {
    private final String nom;

    public Entite(){
        this.nom = "filler";
    }
    public Entite(final String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
