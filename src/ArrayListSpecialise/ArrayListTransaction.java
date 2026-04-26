package ArrayListSpecialise;

import Entites.Transaction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public final class ArrayListTransaction extends ArrayList<Transaction> {
    private PropertyChangeSupport support;

    public ArrayListTransaction(){
        super();
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public boolean add(Transaction t) {
        support.firePropertyChange("transaction", null, t);
        return super.add(t);
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(195) + "\n| ");
        affichage.append(String.format("%-47s", "Acheteur"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", "Objet"));
        affichage.append("| ");
        affichage.append(String.format("%-13s", "Valeur"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", "Vendeur"));
        affichage.append("| ");
        affichage.append(String.format("%-30s", "Date"));
        affichage.append("|\n");
        for(Transaction t: this){
            affichage.append(t.toString()).append("\n");
        }
        affichage.append("-".repeat(195));
        return affichage.toString();
    }
}
