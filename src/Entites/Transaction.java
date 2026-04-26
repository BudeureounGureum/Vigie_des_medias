package Entites;

import java.time.LocalDateTime;

public final class Transaction {
    private String acheteur;
    private String objet;
    private float valeur;
    private String vendeur;
    private LocalDateTime date;

    public Transaction(){
        acheteur = "filler";
        objet = "filler";
        valeur = 0f;
        vendeur = "filler";
        date = LocalDateTime.now();
    }

    public Transaction(Transaction transaction){
        acheteur = transaction.getAcheteur();
        objet = transaction.getObjet();
        valeur = transaction.getValeur();
        vendeur = transaction.getVendeur();
        date = transaction.getDate();
    }

    public Transaction(String acheteur, String objet, float valeur, String vendeur){
        this.acheteur = acheteur;
        this.objet = objet;
        this.valeur = valeur;
        this.vendeur = vendeur;
        date = LocalDateTime.now();
    }

    public String getAcheteur() {
        return acheteur;
    }

    public String getObjet() {
        return objet;
    }

    public float getValeur() {
        return valeur;
    }

    public String getVendeur() {
        return vendeur;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getAcheteur()));
        affichage.append("| ");
        affichage.append(String.format("%-47s", getObjet()));
        affichage.append("| ");
        affichage.append(String.format("%-13s", getValeur()+"%"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", getVendeur()));
        affichage.append("| ");
        affichage.append(String.format("%-30s", getDate()));
        affichage.append("|");
        return affichage.toString();
    }
}
