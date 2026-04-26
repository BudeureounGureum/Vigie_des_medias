package Entites;

import Enumerations.CategoriePublications;

import java.time.LocalDateTime;

public final class Publication {
    private final String titre;
    private final String editeur;
    private final CategoriePublications type;
    private final LocalDateTime date;
    private final Mentions mentions;

    public Publication(){
        titre = "filler";
        editeur = "filler";
        type = CategoriePublications.ARTICLE;
        date = LocalDateTime.now();
        mentions = new Mentions();
    }

    public Publication(String titre, String editeur, CategoriePublications type, Mentions mentions){
        this.titre = titre;
        this.editeur = editeur;
        this.type = type;
        this.date = LocalDateTime.now();
        this.mentions = new Mentions(mentions);
    }
    public Publication(Publication publication){
        this.titre = publication.getTitre();
        this.editeur = publication.getEditeur();
        this.type = publication.getType();
        this.date = publication.getDate();
        this.mentions = new Mentions(publication.getMentions());
    }

    public String getTitre() {
        return titre;
    }

    public String getEditeur(){
        return editeur;
    }

    public CategoriePublications getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Mentions getMentions() {
        return new Mentions(mentions);
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getTitre()));
        affichage.append("| ");
        affichage.append(String.format("%-47s", getEditeur()));
        affichage.append("| ");
        affichage.append(String.format("%-10s", getType().toString()));
        affichage.append("| ");
        affichage.append(String.format("%-30s", getDate()));
        affichage.append("|\nMentions\n");
        affichage.append(getMentions().toString());
        return affichage.toString();
    }
}
