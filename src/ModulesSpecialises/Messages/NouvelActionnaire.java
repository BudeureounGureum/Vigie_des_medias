package ModulesSpecialises.Messages;

import Entites.Entite;
import Entites.Transaction;

public final class NouvelActionnaire extends Entite {
    private String type;
    private Transaction transaction;

    public NouvelActionnaire(){
        super();
        type = "filler";
        transaction = new Transaction();
    }

    public NouvelActionnaire(String nom, String type, Transaction transaction){
        super(nom);
        this.type = type;
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return new Transaction(transaction);
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
        affichage.append(getTransaction().toString());
        return affichage.toString();
    }
}
