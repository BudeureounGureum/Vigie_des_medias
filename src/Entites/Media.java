package Entites;

import Enumerations.CategorieMedia;
import Enumerations.Periodicite;
import Enumerations.Echelle;
import Enumerations.Prix;

public final class Media extends Entite {
    private final CategorieMedia type;
    private final Periodicite periodicite;
    private final Echelle echelle;
    private final Prix prix;
    private final boolean disparu;

    public Media(){
        super();
        this.type = CategorieMedia.ABSENT;
        this.periodicite = Periodicite.ABSENT;
        this.echelle = Echelle.ABSENT;
        this.prix = Prix.ABSENT;
        this.disparu = true;
    }

    public Media(String nom, CategorieMedia type, Periodicite periodicite, Echelle echelle, Prix prix, boolean disparu){
        super(nom);
        this.type = type;
        this.periodicite = periodicite;
        this.echelle = echelle;
        this.prix = prix;
        this.disparu = disparu;
    }

    public String getType() {
        return type.toString();
    }

    public String getPeriodicite() {
        return periodicite.toString();
    }

    public String getEchelle() {
        return echelle.toString();
    }

    public String getPrix() {
        return prix.toString();
    }

    public boolean isDisparu(){
        return disparu;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-38s", getNom()));
        affichage.append("| ");
        affichage.append(String.format("%-45s", getType()));
        affichage.append("| ");
        affichage.append(String.format("%-15s", getPeriodicite()));
        affichage.append("| ");
        affichage.append(String.format("%-15s", getEchelle()));
        affichage.append("| ");
        affichage.append(String.format("%-10s", getPrix()));
        affichage.append("| ");
        affichage.append(String.format("%-10s", isDisparu()? "checked" : ""));
        affichage.append("|");
        return affichage.toString();
    }
}