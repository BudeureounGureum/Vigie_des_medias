package Entites;

import java.util.ArrayList;

import static Main.Main.*;

public final class Mentions {
    private ArrayList<String> individus;
    private ArrayList<String> organisations;
    private ArrayList<String> medias;

    public Mentions(){
        individus = new ArrayList<String>();
        organisations = new ArrayList<String>();
        medias = new ArrayList<String>();
    }

    public Mentions(ArrayList<String> individus, ArrayList<String> organisations, ArrayList<String> medias){
        this.individus = new ArrayList<String>(individus);
        this.organisations = new ArrayList<String>(organisations);
        this.medias = new ArrayList<String>(medias);
    }

    public Mentions(Mentions m){
        this.individus = new ArrayList<String>(m.getIndividus());
        this.organisations = new ArrayList<String>(m.getOrganisations());
        this.medias = new ArrayList<String>(m.getMedias());
    }

    public ArrayList<String> getIndividus() {
        return individus;
    }

    public ArrayList<String> getOrganisations() {
        return organisations;
    }

    public ArrayList<String> getMedias() {
        return medias;
    }

    public boolean add(String s){
        if(listeIndividus.exist(s)){
            individus.add(s);
            return true;
        }
        else if(listeOrganisations.exist(s)){
            organisations.add(s);
            return true;
        }
        else if(listeMedias.exist(s)){
            medias.add(s);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        individus.sort(null);
        organisations.sort(null);
        medias.sort(null);
        StringBuilder affichage = new StringBuilder();
        affichage.append("    Individus: ");
        for(String i: individus){
            affichage.append(" ").append(i).append(" ").append(";");
        }
        affichage.append("\n    Organisations: ");
        for(String o: organisations){
            affichage.append(" ").append(o).append(" ").append(";");
        }
        affichage.append("\n    Medias: ");
        int taille_media = medias.size();
        for(int m=0; m<taille_media-1; m+=1){
            affichage.append(" ").append(medias.get(m)).append(" ").append(";");
        }
        if(taille_media != 0) {
            affichage.append(" ").append(medias.get(taille_media - 1));
        }
        return affichage.toString();
    }
}
