package ModulesSpecialises;

import ArrayListSpecialise.ArrayListActionnaireMajoritaire;
import ArrayListSpecialise.ArrayListPublication;
import ArrayListSpecialise.ArrayListTransaction;
import Entites.Publication;
import Entites.Transaction;
import ModulesSpecialises.Messages.SurMention;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static Main.Miscellaneous.CalculParts;
import static Main.Main.listePublications;
import static Main.Main.listeTransactions;

public final class ModuleMedia extends ModuleSpecialise{
    private ArrayListPublication historiquePublication;
    private HashMap<String, Integer> mentionsPersonne;
    private HashMap<String, Integer> mentionsOrganisation;
    private HashMap<String, Integer> mentionsMedia;
    private ArrayListTransaction historiqueRachat;
    private ArrayList<String> actionnaires;
    private ArrayListActionnaireMajoritaire presidents;
    private float seuil;

    public ModuleMedia(){
        super();
        historiquePublication = new ArrayListPublication();
        mentionsPersonne = new HashMap<String, Integer>();
        mentionsOrganisation = new HashMap<String, Integer>();
        mentionsMedia = new HashMap<String, Integer>();
        historiqueRachat = new ArrayListTransaction();
        actionnaires = new ArrayList<String>();
        presidents = new ArrayListActionnaireMajoritaire();
        seuil = 0.1f;
        Transaction t = new Transaction("Début Simulation", getSuivi(), 0f, "Début Simulation");
        CalculParts(t, actionnaires, presidents, getSupport());
        listePublications.addPropertyChangeListener(this);
        listeTransactions.addPropertyChangeListener(this);
    }

    public ModuleMedia(String suivi){
        super(suivi);
        historiquePublication = new ArrayListPublication();
        mentionsPersonne = new HashMap<String, Integer>();
        mentionsOrganisation = new HashMap<String, Integer>();
        mentionsMedia = new HashMap<String, Integer>();
        historiqueRachat = new ArrayListTransaction();
        actionnaires = new ArrayList<String>();
        presidents = new ArrayListActionnaireMajoritaire();
        seuil = 0.1f;
        Transaction t = new Transaction("Début Simulation", getSuivi(), 0f, "Début Simulation");
        CalculParts(t, actionnaires, presidents, getSupport());
        listePublications.addPropertyChangeListener(this);
        listeTransactions.addPropertyChangeListener(this);
    }

    public ModuleMedia(String suivi, float seuil){
        super(suivi);
        historiquePublication = new ArrayListPublication();
        mentionsPersonne = new HashMap<String, Integer>();
        mentionsOrganisation = new HashMap<String, Integer>();
        mentionsMedia = new HashMap<String, Integer>();
        historiqueRachat = new ArrayListTransaction();
        actionnaires = new ArrayList<String>();
        presidents = new ArrayListActionnaireMajoritaire();
        this.seuil = seuil;
        Transaction t = new Transaction("Début Simulation", getSuivi(), 0f, "Début Simulation");
        CalculParts(t, actionnaires, presidents, getSupport());
        listePublications.addPropertyChangeListener(this);
        listeTransactions.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("publication")){    // Si on reçoit une publication.
            Publication p = (Publication)evt.getNewValue();
            if(p.getEditeur().equalsIgnoreCase(getSuivi())){
                historiquePublication.add(p);
                for(String nom: p.getMentions().getIndividus()){
                    mentionsPersonne.compute(nom, (k, valeur) -> valeur == null ? 1 : valeur + 1);
                    if((float)mentionsPersonne.get(nom) / (float)historiquePublication.size() > seuil/100f){
                        SurMention sm = new SurMention(getSuivi(), nom, p, getSeuil());
                        getSupport().firePropertyChange("surMention", null, sm);
                    }
                }
                for(String nom: p.getMentions().getOrganisations()){
                    mentionsOrganisation.compute(nom, (k, valeur) -> valeur == null ? 1 : valeur + 1);
                    if((float)mentionsOrganisation.get(nom) / (float)historiquePublication.size() > seuil/100f){
                        SurMention sm = new SurMention(getSuivi(), nom, p, getSeuil());
                        getSupport().firePropertyChange("surMention", null, sm);
                    }
                }
                for(String nom: p.getMentions().getMedias()){
                    mentionsMedia.compute(nom, (k, valeur) -> valeur == null ? 1 : valeur + 1);
                    if((float)mentionsMedia.get(nom) / (float)historiquePublication.size() > seuil/100f){
                        SurMention sm = new SurMention(getSuivi(), nom, p, getSeuil());
                        getSupport().firePropertyChange("surMention", null, sm);
                    }
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

    public HashMap<String, Integer> getMentionsPersonne() {
        return mentionsPersonne;
    }

    public HashMap<String, Integer> getMentionsOrganisation() {
        return mentionsOrganisation;
    }

    public HashMap<String, Integer> getMentionsMedia() {
        return mentionsMedia;
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

    public float getSeuil() {
        return seuil;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-47s", getSuivi()));
        affichage.append("| ").append("\nHistorique des publications\n");
        affichage.append(getHistoriquePublication().toString()).append("\nMentions d'individus\n");
        affichage.append(getMentionsPersonne().toString()).append("\nMentions d'organisations\n");
        affichage.append(getMentionsOrganisation().toString()).append("\nMentions de média\n");
        affichage.append(getMentionsMedia().toString()).append("\nHistorique des rachats\n");
        affichage.append(getHistoriqueRachat().toString()).append("\nListe des actionnaires\n");
        for(String nom: getActionnaires()){
            affichage.append(nom).append("\n");
        }
        affichage.append("\nHistorique des propriétaires\n").append(getPresidents().toString()).append("\n");
        affichage.append("\nSeuil d'alerte = ").append(getSeuil());
        return affichage.toString();
    }
}
