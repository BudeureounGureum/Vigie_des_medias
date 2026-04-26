package Main;

import ArrayListSpecialise.ArrayListActionnaireMajoritaire;
import Entites.*;
import Enumerations.CategorieMedia;
import Enumerations.CategoriePublications;
import Enumerations.Qualificatif;
import ModulesSpecialises.Messages.NouvelActionnaire;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import static Main.Main.*;

/**
 * Contient des fonctions static qui permettent de bien gérer les achats,
 * toutes leurs conséquences, et les modules.
 */

public final class Miscellaneous {

    /**
     * Cherche le pourcentage de parts directes que possède une entité dans une autre.
     * @param origine
     * @param typeOrigine
     * @param cible
     * @param typeCible
     * @return  le pourcentage sous forme de float. -1 s'il n'y a pas de relation entre vendeur et propriété.
     */
    private static float PourcentagePossessionDirecte(String origine, String typeOrigine, String cible, String typeCible){
        if(typeOrigine.equalsIgnoreCase("Individu") && typeCible.equalsIgnoreCase("Media")){
            for(Relation r: relationsIndividuMedia){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    return r.getValeur();
                }
            }
        }
        else if(typeOrigine.equalsIgnoreCase("Individu") && typeCible.equalsIgnoreCase("Organisation")){
            for(Relation r: relationsIndividuOrganisation){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    return r.getValeur();
                }
            }
        }
        else if(typeOrigine.equalsIgnoreCase("Organisation") && typeCible.equalsIgnoreCase("Organisation")){
            for(Relation r: relationsOrganisationOrganisation){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    return r.getValeur();
                }
            }
        }
        else if(typeOrigine.equalsIgnoreCase("Organisation") && typeCible.equalsIgnoreCase("Media")){
            for(Relation r: relationsOrganisationMedia){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    return r.getValeur();
                }
            }
        }
        return -1f;
    }



    /**
     * Actualise les tableaux de relations selon la transaction courante.
     * Supprime des entrées si leur valeur se retrouve à 0 et en ajoute si elle n'existait pas.
     * @param origine
     * @param typeOrigine
     * @param cible
     * @param typeCible
     * @param valeur    Float pouvant être négatif ce qui permet d'actualiser les tableaux du vendeur de la propriété également.
     */
    private static void actualisationRelation(String origine, String typeOrigine, String cible, String typeCible, float valeur){
        if(typeOrigine.equalsIgnoreCase("Individu") && typeCible.equalsIgnoreCase("Media")){    // On regarde dans le tableau adapté.
            for(Relation r: relationsIndividuMedia){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){   // Si une entrée existe déjà.
                    if(r.getValeur()+valeur == 0f){     //  Dans le cas où on rentre un pourcentage négatif. Sert à nettoyer les tableaux.
                        relationsIndividuMedia.remove(r);
                        return;
                    }
                    r.setValeur(r.getValeur() + valeur);    // On l'actualise
                    if(r.getQualificatif() == Qualificatif.PARTICIPE){
                        r.setQualificatif(Qualificatif.EGALE);
                    }
                    return;
                }
            }
            relationsIndividuMedia.add(new Relation(origine, Qualificatif.EGALE, valeur, cible)); // Si elle n'existe pas, on la créée.
        }
        else if(typeOrigine.equalsIgnoreCase("Individu") && typeCible.equalsIgnoreCase("Organisation")){    // On regarde dans le tableau adapté.
            for(Relation r: relationsIndividuOrganisation){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    if(r.getValeur()+valeur == 0f){
                        relationsIndividuOrganisation.remove(r);
                        return;
                    }
                    r.setValeur(r.getValeur() + valeur);
                    if(r.getQualificatif() == Qualificatif.PARTICIPE){
                        r.setQualificatif(Qualificatif.EGALE);
                    }
                    return;
                }
            }
            relationsIndividuOrganisation.add(new Relation(origine, Qualificatif.EGALE, valeur, cible));
        }
        else if(typeOrigine.equalsIgnoreCase("Organisation") && typeCible.equalsIgnoreCase("Organisation")){    // On regarde dans le tableau adapté.
            for(Relation r: relationsOrganisationOrganisation){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    if(r.getValeur()+valeur == 0f){
                        relationsOrganisationOrganisation.remove(r);
                        return;
                    }
                    r.setValeur(r.getValeur() + valeur);
                    if(r.getQualificatif() == Qualificatif.PARTICIPE){
                        r.setQualificatif(Qualificatif.EGALE);
                    }
                    return;
                }
            }
            relationsOrganisationOrganisation.add(new Relation(origine, Qualificatif.EGALE, valeur, cible));
        }
        else if(typeOrigine.equalsIgnoreCase("Organisation") && typeCible.equalsIgnoreCase("Media")){   // On regarde dans le tableau adapté.
            for(Relation r: relationsOrganisationMedia){
                if(r.getOrigine().equalsIgnoreCase(origine) && r.getCible().equalsIgnoreCase(cible)){
                    if(r.getValeur()+valeur == 0f){
                        relationsOrganisationMedia.remove(r);
                        return;
                    }
                    r.setValeur(r.getValeur() + valeur);
                    if(r.getQualificatif() == Qualificatif.PARTICIPE){
                        r.setQualificatif(Qualificatif.EGALE);
                    }
                    return;
                }
            }
            relationsOrganisationMedia.add(new Relation(origine, Qualificatif.EGALE, valeur, cible));
        }

    }

    /**
     * Verifie la validité d'un achat et l'effectue ou non.
     * @param acheteur
     * @param typeAcheteur
     * @param valeur
     * @param propriete
     * @param typePropriete
     * @param vendeur
     * @param typeVendeur
     * @throws IllegalArgumentException Lorsque les paramètres ont mal été saisis.
     */
    public static void Acheter(String acheteur, String typeAcheteur, String valeur, String propriete, String typePropriete,
                               String vendeur, String typeVendeur) throws IllegalArgumentException{

        float pourcentage = Float.parseFloat(valeur);
        if(pourcentage <= 0f || pourcentage > 100f){
            throw new IllegalArgumentException("La valeur de la transaction n'est pas conforme.");
        }

        float pourcentageVendeur = PourcentagePossessionDirecte(vendeur, typeVendeur, propriete, typePropriete);

        if(pourcentageVendeur >= pourcentage){
            actualisationRelation(vendeur, typeVendeur, propriete, typePropriete, -pourcentage);
            actualisationRelation(acheteur, typeAcheteur, propriete, typePropriete, pourcentage);
            listeTransactions.add(new Transaction(acheteur, propriete, pourcentage, vendeur));
        }
        else{
            throw new IllegalArgumentException(vendeur + " ne possède pas assez de parts dans " + propriete + ".");
        }
    }

    /**
     * Cherche si le propriétaire possède des parts directes de la propriété.
     * Cherche récursivement si le propriétaire possède des parts indirectes de la propriété.
     * Différentes de PossessionPourcentage car elle arrête la récursion dès qu'elle trouve une possession.
     * @param proprietaire
     * @param propriete
     * @param vues  ArrayList<String> des propriétaires déjà vus afin de ne pas tourner en rond.
     * @return  Vrai si le propriétaire possède des parts directes ou indirectes de la propriété.
     *          Faux sinon.
     */
    public static boolean Possession(String proprietaire, String propriete, ArrayList<String> vues){
        boolean resultat = false;
            if(listeIndividus.exist(proprietaire)){     // Si propriétaire est un individu, on cherche dans les relations des individus.
                for(Relation r: relationsIndividuMedia){    // Avec les médias.
                    if(r.getOrigine().equalsIgnoreCase(proprietaire)){  // Si le propriétaire est à l'origine de la relation.
                        if(r.getCible().equalsIgnoreCase(propriete)){   // Et que la propriété est la cible de la relation.
                            if(r.getValeur() != 0f) {   // Si la valeur de la relation est supérieur à 0, on renvoie vrai.
                                return true;
                            }
                        }
                    }
                }
                for(Relation r: relationsIndividuOrganisation){ // Avec les organisations.
                    if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                        if(r.getCible().equalsIgnoreCase(propriete)){
                            if(r.getValeur() != 0f) {
                                return true;
                            }
                        }
                        else{    // Si la cible est autre chose que la propriété, on cherche récursivement dans ce que la propriété possède.
                            if(vues.stream().noneMatch(s -> s.equalsIgnoreCase(r.getCible()))){ // Si on ne l'a pas déjà vue.
                                ArrayList<String> prochaineVues = new ArrayList<String>(vues);
                                prochaineVues.add(r.getCible());
                                resultat = Possession(r.getCible(), propriete, prochaineVues);
                            }
                        }
                        if(resultat){
                            return true;
                        }
                    }
                }
            }
            else if(listeOrganisations.exist(proprietaire)){    // De même si le propriétaire est une organisation.
                for(Relation r: relationsOrganisationMedia){
                    if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                        if(r.getCible().equalsIgnoreCase(propriete)){
                            if(r.getValeur() != 0f) {
                                return true;
                            }
                        }
                    }
                }
                for(Relation r: relationsOrganisationOrganisation){
                    if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                        if(r.getCible().equalsIgnoreCase(propriete)){
                            if(r.getValeur() != 0f) {
                                return true;
                            }
                        }
                        else{
                            if(vues.stream().noneMatch(s -> s.equalsIgnoreCase(r.getCible()))){
                                ArrayList<String> prochaineVues = new ArrayList<String>(vues);
                                prochaineVues.add(r.getCible());
                                resultat = Possession(r.getCible(), propriete, prochaineVues);
                            }
                        }
                        if(resultat){
                            return true;
                        }
                    }
                }
            }
        return resultat;
    }

    /**
     * Cherche si le propriétaire possède des parts directes de la propriété.
     * Cherche récursivement si le propriétaire possède des parts indirectes de la propriété.
     * @param proprietaire
     * @param propriete
     * @param vues  ArrayList<String> des propriétaires déjà vus afin de ne pas tourner en rond.
     * @return  Le pourcentage de parts que possède le propriétaire dans la propriété sous forme de float.
     */
    public static float PourcentagePossession(String proprietaire, String propriete, ArrayList<String> vues){
        float resultat = 0f;
        if(listeIndividus.exist(proprietaire)){     // Si propriétaire est un individu, on cherche dans les relations des individus.
            for(Relation r: relationsIndividuMedia){    // Avec les médias.
                if(r.getOrigine().equalsIgnoreCase(proprietaire)){  // Si le propriétaire est à l'origine de la relation.
                    if(r.getCible().equalsIgnoreCase(propriete)){   // Et que la propriété est la cible de la relation.
                        resultat += r.getValeur();
                    }
                }
            }
            for(Relation r: relationsIndividuOrganisation){ // Avec les organisations.
                if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                    if(r.getCible().equalsIgnoreCase(propriete)){
                        resultat += r.getValeur();
                    }
                    else{    // Si la cible est autre chose que la propriété, on cherche récursivement dans ce que la propriété possède.
                        if(r.getValeur() != 0f) {
                            if (vues.stream().noneMatch(s -> s.equalsIgnoreCase(r.getCible()))) {
                                ArrayList<String> prochaineVues = new ArrayList<String>(vues);
                                prochaineVues.add(r.getCible());
                                resultat += (r.getValeur() / 100f) * PourcentagePossession(r.getCible(), propriete, prochaineVues);   // Chaque appel récursif est multiplié par la valeur de la relation qui l'appelle.
                            }
                        }
                    }
                }
            }
        }
        else if(listeOrganisations.exist(proprietaire)){    // De même si le propriétaire est une organisation.
            for(Relation r: relationsOrganisationMedia){
                if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                    if(r.getCible().equalsIgnoreCase(propriete)){
                        resultat += r.getValeur();
                    }
                }
            }
            for(Relation r: relationsOrganisationOrganisation){
                if(r.getOrigine().equalsIgnoreCase(proprietaire)){
                    if(r.getCible().equalsIgnoreCase(propriete)){
                        resultat += r.getValeur();
                    }
                    else{
                        if(r.getValeur() != 0f) {
                            if (vues.stream().noneMatch(s -> s.equalsIgnoreCase(r.getCible()))) {
                                ArrayList<String> prochaineVues = new ArrayList<String>(vues);
                                prochaineVues.add(r.getCible());
                                resultat += (r.getValeur() / 100f) * PourcentagePossession(r.getCible(), propriete, prochaineVues);   // Chaque appel récursif est multiplié par la valeur de la relation qui l'appelle.
                            }
                        }
                    }
                }
            }
        }
        return resultat;
    }

    /**
     * Calcule les parts de chaque Individu et chaque Organisation pour une certaine propriété et met à jour la liste d'actionnaires
     * et l'historique de présidents.
     * Envoie un signal lorsqu'un nouvel actionnaire apparaît.
     * @param t Transaction des parts de la propriété qui nous intéresse.
     * @param actionnaires  Liste d'actionnaires de la propriété.
     * @param presidents    Historique des présidents de la propriété.
     * @param support   Support sur lequel émettre le signal lorsqu'il y a un nouvel actionnaire.
     */
    public static void CalculParts(Transaction t, ArrayList<String> actionnaires, ArrayListActionnaireMajoritaire presidents, PropertyChangeSupport support){
        String president = "";
        String typePresident = "";
        String typePropriete = typeNom(t.getObjet());   // ne peut pas renvoyer "" car c'est un élément de t, une Transaction, donc son existence a déjà été vérifiée.
        float max = 0f;
        for(Individu i: listeIndividus){    // On parcourt la liste d'Individus
            String nom = i.getNom();
            float pourcentage = PourcentagePossessionDirecte(nom, "Individu", t.getObjet(), typePropriete); // On calcule leur pourcentage de possession de la propriété.
            if(pourcentage > 0f){   // S'il possède des parts directes, on cherche la quantité totale de parts (même indirectes) qu'il possède.
                ArrayList<String> vues = new ArrayList<String>();
                vues.add(nom);
                pourcentage = PourcentagePossession(nom, t.getObjet(), vues);
            }
            if(pourcentage > 0f){
                if(actionnaires.stream().noneMatch(s -> s.equalsIgnoreCase(nom))){    // S'ils ne figurent pas parmi les actionnaires, on les ajoute et on le signale.
                    NouvelActionnaire nv = new NouvelActionnaire(nom, "Individu", t);
                    actionnaires.add(nom);
                    support.firePropertyChange("nouvelActionnaire", null, nv);
                }
                if(pourcentage > max){  // S'ils ont le pourcentage maximal, ils deviennent président.
                    president = nom;
                    typePresident = "Individu";
                    max = pourcentage;
                }
            }
            else{
                actionnaires.remove(nom);   // Si leur pourcentage de possession est égale à 0, on les retire de la liste des actionnaires.
            }
        }
        for(Organisation o: listeOrganisations){    // De même avec les organisations.
            String nom = o.getNom();
            float pourcentage = PourcentagePossessionDirecte(nom, "Organisation", t.getObjet(), typePropriete); // On calcule leur pourcentage de possession de la propriété.
            if(pourcentage > 0f){
                ArrayList<String> vues = new ArrayList<String>();
                vues.add(nom);
                pourcentage = PourcentagePossession(nom, t.getObjet(), vues);
            }
            if(pourcentage > 0f){
                if(actionnaires.stream().noneMatch(s -> s.equalsIgnoreCase(nom))){
                    NouvelActionnaire nv = new NouvelActionnaire(nom, "Organisation", t);
                    actionnaires.add(nom);
                    support.firePropertyChange("nouvelActionnaire", null, nv);
                }
                if(pourcentage > max){
                    president = nom;
                    typePresident = "Organisation";
                    max = pourcentage;
                }
            }
            else{
                actionnaires.remove(nom);
            }
        }
        if(presidents.isEmpty() || !presidents.getLast().getNom().equalsIgnoreCase(president)){ // Si on obtient un président différent du dernier, on l'ajoute à l'historique.
            presidents.add(new ActionnaireMajoritaire(president, typePresident));
        }
    }

    /**
     * Verifie que la catégorie de média cm a le droit de publier des publications de catégorie cp.
     * @param cm    catégorie de média
     * @param cp    catégorie de publication
     * @return Vrai si les deux catégories sont compatibles. Faux sinon.
     */
    public static boolean verifCategorie(CategorieMedia cm, CategoriePublications cp){
        if(cm == CategorieMedia.SITE){
            return true;
        }
        if(cm == CategorieMedia.RADIO || cm == CategorieMedia.TELEVISION){
            return cp != CategoriePublications.ARTICLE;
        }
        if(cm == CategorieMedia.PRESSE){
            return cp != CategoriePublications.REPORTAGE;
        }
        return false;
    }

    /**
     * Cherche le type (Individu, Organisation, Média) du nom mis en paramètre.
     * @param nom
     * @return le type ou la String vide si le nom ne fais pas partie de la base de donnée
     */
    public static String typeNom(String nom){
        if(listeIndividus.exist(nom)){
            return "Individu";
        }
        if(listeOrganisations.exist(nom)){
            return "Organisation";
        }
        if(listeMedias.exist(nom)){
            return "Media";
        }
        return "";
    }
}
