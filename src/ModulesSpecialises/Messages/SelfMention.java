package ModulesSpecialises.Messages;

import Entites.Publication;

public final class SelfMention {
    private final String auteur;
    private final Publication publication;

    public SelfMention(){
        auteur = "filleur";
        publication = new Publication();
    }
    public SelfMention(String auteur, Publication publication){
        this.auteur = auteur;
        this.publication = new Publication(publication);
    }

    public String getAuteur() {
        return auteur;
    }

    public Publication getPublication() {
        return new Publication(publication);
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getAuteur()));
        affichage.append(getPublication().toString());
        return affichage.toString();
    }
}
