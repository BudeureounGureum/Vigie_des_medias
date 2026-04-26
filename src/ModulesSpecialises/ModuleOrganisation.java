package ModulesSpecialises;

import ArrayListSpecialise.ArrayListActionnaireMajoritaire;
import ArrayListSpecialise.ArrayListPublication;
import ArrayListSpecialise.ArrayListTransaction;
import Entites.Publication;
import ModulesSpecialises.Messages.SelfMention;
import Entites.Transaction;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static Main.Miscellaneous.CalculParts;
import static Main.Miscellaneous.Possession;
import static Main.Main.*;

public final class ModuleOrganisation extends ModuleSpecialise {
    private ArrayListPublication historiquePublication;
    private HashMap<String, Integer> mentions;
    private ArrayListTransaction historiqueRachat;
    private ArrayList<String> actionnaires;
    private ArrayListActionnaireMajoritaire presidents;

    public ModuleOrganisation(){
        super();
        historiquePublication = new ArrayListPublication();
        mentions = new HashMap<String, Integer>();
        historiqueRachat = new ArrayListTransaction();
        actionnaires = new ArrayList<String>();
        presidents = new ArrayListActionnaireMajoritaire();
        Transaction t = new Transaction("Début Simulation", getSuivi(), 0f, "Début Simulation");
        CalculParts(t, actionnaires, presidents, getSupport());
        listePublications.addPropertyChangeListener(this);
        listeTransactions.addPropertyChangeListener(this);
    }

    public ModuleOrganisation(String suivi){
        super(suivi);
        historiquePublication = new ArrayListPublication();
        mentions = new HashMap<String, Integer>();
        historiqueRachat = new ArrayListTransaction();
        actionnaires = new ArrayList<String>();
        presidents = new ArrayListActionnaireMajoritaire();
        Transaction t = new Transaction("Début Simulation", getSuivi(), 0f, "Début Simulation");
        CalculParts(t, actionnaires, presidents, getSupport());
        listePublications.addPropertyChangeListener(this);
        listeTransactions.addPropertyChangeListener(this);
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
            if(p.getMentions().getOrganisations().stream().anyMatch(s -> s.equalsIgnoreCase(getSuivi()))){    // Si la publication mentionne la personne suivie.
                historiquePublication.add(p);      // On ajoute la publication à l'historique
                mentions.compute(clef, (k, valeur) -> valeur == null ? 1 : valeur + 1); // On incrémente le nombre de mentions par l'éditeur.
                ArrayList<String> vues = new ArrayList<String>();
                vues.add(getSuivi());
                if(Possession(getSuivi(), clef, vues)){       // Si la personne suivie est mentionnée dans une publication d'un média qu'elle possède.
                    SelfMention s = new SelfMention(getSuivi(), p);
                    getSupport().firePropertyChange("selfMention", null, s);   // On alerte la vigie.
                }
            }
        }
        else if(evt.getPropertyName().equals("transaction")){   // Si on reçoit une transaction.
            Transaction t = (Transaction)evt.getNewValue();
            if(t.getObjet().equalsIgnoreCase(getSuivi())){  // Si la transaction concerne l'organisation suivie.
                historiqueRachat.add(t);    // On met à jour l'historique des rachats.
                CalculParts(t, actionnaires, presidents, getSupport());  // On met à jour la liste des actionnaires et l'historique des présidents.
            }
        }
    }

    public ArrayListPublication getHistoriquePublication() {
        return historiquePublication;
    }

    public HashMap<String, Integer> getMentions() {
        return mentions;
    }

    public ArrayListTransaction getHistoriqueRachat() {
        return historiqueRachat;
    }

    public ArrayList<String> getActionnaires() {
        return actionnaires;
    }

    public ArrayListActionnaireMajoritaire getPresidents() {
        return presidents;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getSuivi()));
        affichage.append("| ").append("\nHistorique des mentions\n");
        affichage.append(getHistoriquePublication().toString()).append("\nMentions par média\n");
        affichage.append(getMentions().toString()).append("\nHistorique des rachats\n");
        affichage.append(getHistoriqueRachat().toString()).append("\nListe des actionnaires\n");
        affichage.append(getActionnaires().toString()).append("\nHistorique des propriétaires\n");
        affichage.append(getPresidents().toString());
        return affichage.toString();
    }
}
