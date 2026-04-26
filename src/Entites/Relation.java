package Entites;

import Enumerations.Qualificatif;

public final class Relation {
    private String origine;
    private Qualificatif qualificatif;
    private float valeur;
    private String cible;

    public Relation(){
        origine = "filler";
        qualificatif = Qualificatif.ABSENT;
        valeur = 0f;
        cible = "filler";
    }

    public Relation(String origine, Qualificatif qualificatif, float valeur, String cible){
        this.origine = origine;
        this.qualificatif = qualificatif;
        this.valeur = valeur;
        this.cible = cible;
    }

    public String getOrigine() {
        return origine;
    }

    public Qualificatif getQualificatif() {
        return qualificatif;
    }

    public float getValeur() {
        return valeur;
    }

    public String getCible() {
        return cible;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public void setQualificatif(Qualificatif qualificatif) {
        this.qualificatif = qualificatif;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getOrigine()));
        affichage.append("| ");
        affichage.append(String.format("%-13s", getQualificatif().toString()));
        affichage.append("| ");
        affichage.append(String.format("%-7s", getValeur() + "%"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", getCible()));
        affichage.append("|");
        return affichage.toString();
    }
}
