package ArrayListSpecialise;

import Entites.Relation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public final class ArrayListRelation extends ArrayList<Relation> {
    private PropertyChangeSupport support;

    public ArrayListRelation(){
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
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(123) + "\n| ");
        affichage.append(String.format("%-47s", "Origine"));
        affichage.append("| ");
        affichage.append(String.format("%-13s", "Qualificatif"));
        affichage.append("| ");
        affichage.append(String.format("%-7s", "Valeur"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", "Cible"));
        affichage.append("|\n");
        for(Relation r: this){
            affichage.append(r.toString()).append("\n");
        }
        affichage.append("-".repeat(123));
        return affichage.toString();
    }
}
