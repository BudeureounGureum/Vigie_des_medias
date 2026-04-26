package ArrayListSpecialise;

import Entites.ActionnaireMajoritaire;

import java.util.ArrayList;

public final class ArrayListActionnaireMajoritaire extends ArrayList<ActionnaireMajoritaire> {

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(97) + "\n| ");
        affichage.append(String.format("%-47s", "Nom"));
        affichage.append("| ");
        affichage.append(String.format("%-13s", "Type"));
        affichage.append("| ");
        affichage.append(String.format("%-30s", "Date"));
        affichage.append("|\n");
        for(ActionnaireMajoritaire a: this){
            affichage.append(a.toString()).append("\n");
        }
        affichage.append("-".repeat(97));
        return affichage.toString();
    }
}
