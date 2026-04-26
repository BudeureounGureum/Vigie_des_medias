package ModulesSpecialises;

import ArrayListSpecialise.ArrayListPublication;
import Entites.Publication;
import ModulesSpecialises.Messages.SelfMention;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static Main.Miscellaneous.Possession;
import static Main.Main.listePublications;

public final class ModuleIndividu extends ModuleSpecialise{
    private ArrayListPublication historique;
    private HashMap<String, Integer> mentions;

    public ModuleIndividu(){
        super();
        historique = new ArrayListPublication();
        mentions = new HashMap<String, Integer>();
        listePublications.addPropertyChangeListener(this);
    }

    public ModuleIndividu(String suivi){
        super(suivi);
        historique = new ArrayListPublication();
        mentions = new HashMap<String, Integer>();
        listePublications.addPropertyChangeListener(this);
    }

    /**
     * Gestion des signaux reçus.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equalsIgnoreCase("publication")){    // Si on reçoit une publication.
            Publication p = (Publication)evt.getNewValue();
            String clef = p.getEditeur();
            if(p.getMentions().getIndividus().stream().anyMatch(s -> s.equalsIgnoreCase(getSuivi()))){    // Si la publication mentionne la personne suivie.
                historique.add(p);      // On ajoute la publication à l'historique
                mentions.compute(clef, (k, valeur) -> valeur == null ? 1 : valeur + 1); // On incrémente le nombre de mentions par l'éditeur.
                ArrayList<String> vues = new ArrayList<String>();
                vues.add(getSuivi());
                if(Possession(getSuivi(), clef, vues)){       // Si la personne suivie est mentionnée dans une publication d'un média qu'elle possède même indirectement.
                    SelfMention s = new SelfMention(getSuivi(), p);
                    getSupport().firePropertyChange("selfMention", null, s);   // On alerte la vigie.
                }
            }
        }
    }

    public ArrayListPublication getHistorique() {
        return historique;
    }

    public HashMap<String, Integer> getMentions() {
        return mentions;
    }

    /**
     * Calcule le pourcentage de mentions pour un média donné.
     * @param editeur   Le média en question.
     * @return  Le pourcentage sous forme de float.
     */
    public float PourcentageMention(String editeur){
        int compteur = 0;
        for(Publication p: listePublications){
            if(p.getEditeur().equalsIgnoreCase(editeur)){
                compteur +=1;
            }
        }
        return (float)mentions.getOrDefault(editeur,0)*100f / (float)compteur;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("");
        affichage.append(String.format("%-47s", getSuivi()));
        affichage.append("\nHistorique des mentions\n");
        affichage.append(getHistorique().toString()).append("\nMentions par média\n");
        affichage.append(getMentions().toString());
        return affichage.toString();
    }
}
