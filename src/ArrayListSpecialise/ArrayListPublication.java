package ArrayListSpecialise;

import Entites.Publication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public final class ArrayListPublication extends ArrayList<Publication> {
    private PropertyChangeSupport support;

    public ArrayListPublication(){
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public boolean add(Publication p) {
        support.firePropertyChange("publication", null, p);
        return super.add(p);
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(143) + "\n| ");
        affichage.append(String.format("%-47s", "Titre"));
        affichage.append("| ");
        affichage.append(String.format("%-47s", "Editeur"));
        affichage.append("| ");
        affichage.append(String.format("%-10s", "Type"));
        affichage.append("| ");
        affichage.append(String.format("%-30s", "Date"));
        affichage.append("|\n");
        for(Publication p: this){
            affichage.append(p.toString()).append("\n");
        }
        affichage.append("-".repeat(143));
        return affichage.toString();
    }
}
