package ArrayListSpecialise;

import Entites.Organisation;

import java.util.ArrayList;

public final class ArrayListOrganisation extends ArrayList<Organisation> {

    public boolean exist(String nom){
        for(Organisation o : this){
            if(o.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(102) + "\n| ");
        affichage.append(String.format("%-47s", "Nom"));
        affichage.append("| ");
        affichage.append(String.format("%-50s", "Commentaire"));
        affichage.append("|\n");
        for(Organisation o: this){
            affichage.append(o.toString()).append("\n");
        }
        affichage.append("-".repeat(102));
        return affichage.toString();
    }
}
