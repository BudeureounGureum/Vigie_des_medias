package Entites;

public final class Organisation extends Entite {
    private String commentaire;

    public Organisation(){
        super();
        this.commentaire = "filler";
    }

    public Organisation(String nom, String commentaire){
        super(nom);
        this.commentaire = commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getNom()));
        affichage.append("| ");
        affichage.append(String.format("%-50s", commentaire));
        affichage.append("|");
        return affichage.toString();
    }
}
