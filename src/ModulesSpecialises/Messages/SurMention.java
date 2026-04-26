package ModulesSpecialises.Messages;

import Entites.Publication;

public final class SurMention {
    private String editeur;
    private String nom;
    private Publication publication;
    private float seuil;

    public SurMention(){
        editeur = "filler";
        nom = "filler";
        publication = new Publication();
        seuil = 0.1f;
    }

    public SurMention(String editeur, String nom, Publication publication, float seuil){
        this.editeur = editeur;
        this.nom = nom;
        this.publication = publication;
        this.seuil = seuil;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getNom() {
        return nom;
    }

    public Publication getPublication() {
        return new Publication(publication);
    }

    public float getSeuil() {
        return seuil;
    }
}
