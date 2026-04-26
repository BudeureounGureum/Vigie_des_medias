package ArrayListSpecialise;

import Entites.Individu;

import java.util.ArrayList;

public final class ArrayListIndividu extends ArrayList<Individu> {

    public boolean exist(String nom){
        for(Individu i : this){
            if(i.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(217) + "\n| ");
        affichage.append(String.format("%-30s", "Nom"));
        affichage.append("| ");
        affichage.append(String.format("%-19s", "rangChallenges2024"));
        affichage.append("| ");
        affichage.append(String.format("%-23s", "milliardaireForbes2024"));
        affichage.append("| ");
        affichage.append(String.format("%-19s", "rangChallenges2024"));
        affichage.append("| ");
        affichage.append(String.format("%-23s", "milliardaireForbes2024"));
        affichage.append("| ");
        affichage.append(String.format("%-19s", "rangChallenges2024"));
        affichage.append("| ");
        affichage.append(String.format("%-23s", "milliardaireForbes2024"));
        affichage.append("| ");
        affichage.append(String.format("%-19s", "rangChallenges2024"));
        affichage.append("| ");
        affichage.append(String.format("%-23s", "milliardaireForbes2024"));
        affichage.append("|\n");
        for(Individu i: this){
            affichage.append(i.toString()).append("\n");
        }
        affichage.append("-".repeat(217));
        return affichage.toString();
    }
}
