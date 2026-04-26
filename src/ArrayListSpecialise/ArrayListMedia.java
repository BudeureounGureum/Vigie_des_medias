package ArrayListSpecialise;

import Entites.Media;

import java.util.ArrayList;

public final class ArrayListMedia extends ArrayList<Media> {

    public boolean exist(String nom){
        for(Media m : this){
            if(m.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(146) + "\n| ");
        affichage.append(String.format("%-38s", "Nom"));
        affichage.append("| ");
        affichage.append(String.format("%-45s", "Type"));
        affichage.append("| ");
        affichage.append(String.format("%-15s", "Periodicite"));
        affichage.append("| ");
        affichage.append(String.format("%-15s", "Echelle"));
        affichage.append("| ");
        affichage.append(String.format("%-10s", "Prix"));
        affichage.append("| ");
        affichage.append(String.format("%-10s", "Disparu"));
        affichage.append("|\n");
        for(Media m: this){
            affichage.append(m.toString()).append("\n");
        }
        affichage.append("-".repeat(146));
        return affichage.toString();
    }
}
