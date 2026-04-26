package ModulesSpecialises;

import ModulesSpecialises.Messages.NouvelActionnaire;
import ModulesSpecialises.Messages.SelfMention;
import ModulesSpecialises.Messages.SurMention;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class Vigie implements PropertyChangeListener {

    public Vigie(){
        super();
    }

    public void propertyChange(PropertyChangeEvent evt){
        System.out.println("\n------ MESSAGE VIGIE ------");
        if(evt.getPropertyName().equalsIgnoreCase("selfMention")){
            SelfMention sm = (SelfMention) evt.getNewValue();
            System.out.println("Auto-mention de "+ sm.getAuteur() + " dans la publication:");
            System.out.println(sm.getPublication().toString() + "\n");
        }
        else if(evt.getPropertyName().equalsIgnoreCase("nouvelActionnaire")){
            NouvelActionnaire na = (NouvelActionnaire) evt.getNewValue();
            System.out.println("L'" + na.getType() + " " + na.getNom() + " est un nouvel actionnaire de "+ na.getTransaction().getObjet()
                    + " suite à la transaction:");
            System.out.println(na.getTransaction().toString() + "\n");
        }
        else if(evt.getPropertyName().equalsIgnoreCase("surMention")){
            SurMention sm = (SurMention) evt.getNewValue();
            System.out.println(sm.getNom() + " a dépassé le seuil de " + sm.getSeuil() + "% de mention sur le média " +
                    sm.getEditeur() + " suite à la publication:");
            System.out.println(sm.getPublication().toString() + "\n");
        }
    }
}
