package ArrayListSpecialise;

import ModulesSpecialises.ModuleSpecialise;

import java.util.ArrayList;

import static Main.Main.listePublications;
import static Main.Main.vigie;

public final class ArrayListModuleSpecialise extends ArrayList<ModuleSpecialise> {
    @Override
    public boolean add(ModuleSpecialise ms){
        ms.addPropertyChangeListener(vigie);
        return super.add(ms);
    }

    @Override
    public boolean remove(Object ms){
        listePublications.removePropertyChangeListener((ModuleSpecialise)ms);
        ((ModuleSpecialise)ms).removePropertyChangeListener(vigie);
        return super.remove(ms);
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("-".repeat(51) + "\n| ");
        affichage.append(String.format("%-47s", "Nom")).append(" |\n");
        for(ModuleSpecialise ms: this){
            affichage.append("| ").append(String.format("%-47s", ms.getSuivi())).append(" |\n");
        }
        affichage.append("-".repeat(51));
        return affichage.toString();
    }
}
