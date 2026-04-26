package Entites;

import java.time.LocalDateTime;

public final class ActionnaireMajoritaire extends Entite {
    private LocalDateTime date;
    private String type;

    public ActionnaireMajoritaire(){
        super();
        date = LocalDateTime.now();
        type = "filler";
    }

    public ActionnaireMajoritaire(String nom, String type){
        super(nom);
        date = LocalDateTime.now();
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getNom()));
        affichage.append("| ");
        affichage.append(String.format("%-13s", getType()));
        affichage.append("| ");
        affichage.append((String.format("%-30s", getDate())));
        affichage.append("|");
        return affichage.toString();
    }
}
