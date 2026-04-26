package Main;

import Entites.Media;
import Entites.Mentions;
import Entites.Publication;
import Enumerations.CategorieMedia;
import ModulesSpecialises.ModuleIndividu;
import ModulesSpecialises.ModuleMedia;
import ModulesSpecialises.ModuleOrganisation;
import ModulesSpecialises.ModuleSpecialise;

import java.util.ArrayList;
import java.util.Scanner;

import static Enumerations.CategoriePublications.getCategoriePublication;
import static Main.Miscellaneous.Acheter;
import static Main.Miscellaneous.verifCategorie;
import static Main.Main.*;

/**
 * Permet de séparer la gestion des entrées.
 */
public final class GestionEntree {
    /**
     *
     * @param s
     * @param scanner
     */
    public static void gestionEntree(String s, Scanner scanner){
        if(s.equalsIgnoreCase("Parcourir données")){
            while(true){
                System.out.println(" Individus | Organisations | Medias | Relations | Transactions | Publications | Modules Spécialisés | Nvm | Accueil \n");
                s = scanner.nextLine();
                if(s.equalsIgnoreCase("Accueil")){
                    return;
                }
                else if(s.equalsIgnoreCase("Nvm")){
                    break;
                }
                else if(s.equalsIgnoreCase("Individus")){
                    System.out.println(listeIndividus.toString());
                }
                else if(s.equalsIgnoreCase("Organisations")){
                    System.out.println(listeOrganisations.toString());
                }
                else if(s.equalsIgnoreCase("Medias")){
                    System.out.println(listeMedias.toString());
                }
                else if(s.equalsIgnoreCase("Publications")){
                    System.out.println(listePublications.toString());
                }
                else if(s.equalsIgnoreCase("Transactions")){
                    System.out.println(listeTransactions.toString());
                }
                else if(s.equalsIgnoreCase("Relations")){
                    while(true){
                        System.out.println(" Individu-Media | Individu-Organisation | Organisation-Organisation | Organisation-Media | Nvm | Accueil \n");
                        s = scanner.nextLine();
                        if(s.equalsIgnoreCase("Accueil")){
                            return;
                        }
                        else if(s.equalsIgnoreCase("Nvm")){
                            break;
                        }
                        else if(s.equalsIgnoreCase("Individu-Media")){
                            System.out.println(relationsIndividuMedia.toString());
                        }
                        else if(s.equalsIgnoreCase("Individu-Organisation")){
                            System.out.println(relationsIndividuOrganisation.toString());
                        }
                        else if(s.equalsIgnoreCase("Organisation-Organisation")){
                            System.out.println(relationsOrganisationOrganisation.toString());
                        }
                        else if(s.equalsIgnoreCase("Organisation-Media")){
                            System.out.println(relationsOrganisationMedia.toString());
                        }
                        else{
                            System.out.println("Mauvaise commande. Veuillez recommencer.");
                        }
                    }
                }
                else if(s.equalsIgnoreCase("Modules Spécialisés")){
                    while(true) {
                        System.out.println(" Module Individu | Module Organisation | Module Media | Nvm | Accueil \n");
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("Accueil")) {
                            return;
                        } else if (s.equalsIgnoreCase("Nvm")) {
                            break;
                        } else if (s.equalsIgnoreCase("Module Individu")) {
                            System.out.println(modulesIndividu.toString());
                            while(true) {
                                System.out.println(" Afficher 'nom' | Nvm | Accueil \n");
                                s = scanner.nextLine();
                                if (s.equalsIgnoreCase("Accueil")) {
                                    return;
                                } else if (s.equalsIgnoreCase("Nvm")) {
                                    break;
                                } else if (s.substring(0, 8).equalsIgnoreCase("Afficher")) {
                                    boolean trouve = false;
                                    for (ModuleSpecialise ms : modulesIndividu) {
                                        if (ms.getSuivi().equalsIgnoreCase(s.substring(9))) {
                                            System.out.println(ms.toString());
                                            trouve = true;
                                        }
                                    }
                                    if(!trouve) {
                                        System.out.println("Il y a une erreur de syntaxe dans le nom. Veuillez recommencer.");
                                    }
                                } else{
                                    System.out.println("Mauvaise commande. Veuillez recommencer.");
                                }
                            }
                        } else if (s.equalsIgnoreCase("Module Organisation")) {
                            System.out.println(modulesOrganisation.toString());
                            while(true) {
                                System.out.println(" Afficher 'nom' | Nvm | Accueil \n");
                                s = scanner.nextLine();
                                if (s.equalsIgnoreCase("Accueil")) {
                                    return;
                                } else if (s.equalsIgnoreCase("Nvm")) {
                                    break;
                                } else if (s.substring(0, 8).equalsIgnoreCase("Afficher")) {
                                    boolean trouve = false;
                                    for (ModuleSpecialise ms : modulesOrganisation) {
                                        if (ms.getSuivi().equalsIgnoreCase(s.substring(9))) {
                                            System.out.println(ms.toString());
                                            trouve = true;
                                        }
                                    }
                                    if(!trouve) {
                                        System.out.println("Il y a une erreur de syntaxe dans le nom. Veuillez recommencer.");
                                    }
                                } else{
                                    System.out.println("Mauvaise commande. Veuillez recommencer.");
                                }
                            }
                        } else if (s.equalsIgnoreCase("Module Media")) {
                            System.out.println(modulesMedia.toString());
                            while(true) {
                                System.out.println(" Afficher 'nom' | Nvm | Accueil \n");
                                s = scanner.nextLine();
                                if (s.equalsIgnoreCase("Accueil")) {
                                    return;
                                } else if (s.equalsIgnoreCase("Nvm")) {
                                    break;
                                } else if (s.substring(0, 8).equalsIgnoreCase("Afficher")) {
                                    boolean trouve = false;
                                    for (ModuleSpecialise ms : modulesMedia) {
                                        if (ms.getSuivi().equalsIgnoreCase(s.substring(9))) {
                                            System.out.println(ms.toString());
                                            trouve = true;
                                        }
                                    }
                                    if(!trouve) {
                                        System.out.println("Il y a une erreur de syntaxe dans le nom. Veuillez recommencer.");
                                    }
                                } else{
                                    System.out.println("Mauvaise commande. Veuillez recommencer.");
                                }
                            }
                        }
                        else{
                            System.out.println("Mauvaise commande. Veuillez recommencer.");
                        }
                    }
                }
                else{
                    System.out.println("Mauvaise commande. Veuillez recommencer.");
                }
            }

        } else if(s.equalsIgnoreCase("Publier")){
            while(true) {
                System.out.println(" 'Titre';'Media';'Type';'Mention';'Mention' ... | Nvm | Accueil \n");
                s = scanner.nextLine();
                if (s.equalsIgnoreCase("Accueil")) {
                    return;
                } else if (s.equalsIgnoreCase("Nvm")) {
                    break;
                } else {
                    try {
                        String[] champs = s.split(";");
                        if(champs.length == 1){
                            System.out.println("Mauvaise commande. Veuillez recommencer.");
                            continue;
                        }
                        boolean erreur_type = false;
                        if(!listeMedias.exist(champs[1])){
                            throw new IllegalArgumentException("Ce média ne fais pas partie de la base de données. Veuillez réessayer.");
                        }
                        for(Media m: listeMedias){
                            if(m.getNom().equalsIgnoreCase(champs[1])){
                                if(!verifCategorie(CategorieMedia.getCategorieMedia(m.getType()), getCategoriePublication(champs[2]))){
                                    throw new IllegalArgumentException(champs[1] + " ne peut pas diffuser de " + champs[2] +", c'est un média de "
                                            + m.getType() + ". Veuillez réessayer.");
                                }
                                break;
                            }
                        }
                        if (champs.length == 3) {
                            Publication p = new Publication(champs[0], champs[1], getCategoriePublication(champs[2]), new Mentions());
                            listePublications.add(p);
                            System.out.println("Création réussie.");
                        } else if (champs.length > 3) {
                            ArrayList<String> personne = new ArrayList<String>();
                            ArrayList<String> organisation = new ArrayList<String>();
                            ArrayList<String> media = new ArrayList<String>();
                            for (int i = 3; i < champs.length; i += 1) {
                                if (listeIndividus.exist(champs[i])) {
                                    personne.add(champs[i]);
                                } else if (listeOrganisations.exist(champs[i])) {
                                    organisation.add(champs[i]);
                                } else if (listeMedias.exist(champs[i])) {
                                    media.add(champs[i]);
                                } else {
                                    erreur_type = true;
                                }
                            }
                            if (erreur_type) {
                                System.out.println("Erreur lors de la saisie des mentions. Veuillez réessayer.");
                            } else {
                                Mentions m = new Mentions(personne, organisation, media);
                                listePublications.add(new Publication(champs[0], champs[1], getCategoriePublication(champs[2]), m));
                                System.out.println("Publication réussie.");
                            }
                        } else {
                            System.out.println("Il manque des paramètres. Veuillez réessayer.");
                        }
                    } catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else if(s.equalsIgnoreCase("Acheter")) {
            while (true) {
                System.out.println(" 'Acheteur';'Valeur';'Propriété';'Vendeur' | Nvm | Accueil \n");
                s = scanner.nextLine();
                if (s.equalsIgnoreCase("Accueil")) {
                    return;
                } else if (s.equalsIgnoreCase("Nvm")) {
                    break;
                } else{
                    String[] champs = s.split(";");
                    if(champs.length == 1){
                        System.out.println("Mauvaise commande. Veuillez recommencer.");
                        continue;
                    }
                    String type1 = "";
                    String type2 = "";
                    String type3 = "";
                    try {
                        if(!(champs[0].equalsIgnoreCase(champs[3]))){
                            if (champs.length == 4) {
                                if (listeIndividus.exist(champs[0])) {
                                    type1 = "Individu";
                                } else if (listeOrganisations.exist(champs[0])) {
                                    type1 = "Organisation";
                                }
                                if (listeOrganisations.exist(champs[2])) {
                                    type2 = "Organisation";
                                } else if (listeMedias.exist(champs[2])) {
                                    type2 = "Media";
                                }
                                if (listeOrganisations.exist(champs[3])) {
                                    type3 = "Organisation";
                                } else if (listeIndividus.exist(champs[3])) {
                                    type3 = "Individu";
                                }
                                if(!type1.isEmpty() && !type2.isEmpty() && !type3.isEmpty()) {
                                    Acheter(champs[0], type1, champs[1], champs[2], type2, champs[3], type3);
                                    System.out.println("Achat réussi.");
                                }
                                else{
                                    System.out.println("Les valeurs saisies ne figurent pas dans la base de données");
                                }
                            }
                            else{
                                System.out.println("Nombre de paramètres non conforme. Veuillez réessayer.");
                            }
                        }
                        else{
                            System.out.println("L'acheteur et le vendeur ne peuvent pas être la même entité. Veuillez réessayer.");
                        }
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        } else if(s.equalsIgnoreCase("Créer Module Spécialisé")) {
            while (true) {
                System.out.println(" Individu | Organisation | Media | Nvm | Accueil \n");
                s = scanner.nextLine();
                if (s.equalsIgnoreCase("Accueil")) {
                    return;
                } else if (s.equalsIgnoreCase("Nvm")) {
                    break;
                } else if (s.equalsIgnoreCase("Individu")) {
                    while (true) {
                        System.out.println(" 'Nom' | Nvm | Accueil \n");
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("Accueil")) {
                            return;
                        } else if (s.equalsIgnoreCase("Nvm")) {
                            break;
                        } else{
                            if(listeIndividus.exist(s)){
                                modulesIndividu.add(new ModuleIndividu(s));
                                System.out.println("Création réussie.");
                            }
                            else{
                                System.out.println("Le nom ne fait pas partie de la base de données. Veuillez réessayer.");
                            }
                        }
                    }
                } else if (s.equalsIgnoreCase("Organisation")) {
                    while (true) {
                        System.out.println(" 'Nom' | Nvm | Accueil \n");
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("Accueil")) {
                            return;
                        } else if (s.equalsIgnoreCase("Nvm")) {
                            break;
                        } else {
                            if (listeOrganisations.exist(s)) {
                                modulesOrganisation.add(new ModuleOrganisation(s));
                                System.out.println("Création réussie.");
                            } else {
                                System.out.println("Le nom ne fait pas partie de la base de données. Veuillez réessayer.");
                            }
                        }
                    }
                } else if (s.equalsIgnoreCase("Media")) {
                    while (true) {
                        System.out.println(" 'Nom';'Seuil' | Nvm | Accueil \n");
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("Accueil")) {
                            return;
                        } else if (s.equalsIgnoreCase("Nvm")) {
                            break;
                        } else {
                            String[] champs = s.split(";");
                            try{
                                if(champs.length == 1){
                                    if (listeMedias.exist(s)) {
                                        modulesMedia.add(new ModuleMedia(champs[0]));
                                        System.out.println("Création réussie.");
                                    } else {
                                        System.out.println("Le nom ne fait pas partie de la base de données. Veuillez réessayer.");
                                    }
                                }
                                else if (champs.length == 2) {
                                    float seuil = Float.parseFloat(champs[1]);
                                    if (listeMedias.exist(champs[0]) && seuil>=0f && seuil<=100f) {
                                        modulesMedia.add(new ModuleMedia(champs[0], seuil));
                                        System.out.println("Création réussie.");
                                    } else {
                                        System.out.println("Les paramètres ne sont pas conformes. Veuillez réessayer.");
                                    }
                                }
                                else{
                                    System.out.println("Le nombre de paramètre n'as pas été respecté. Veuillez réessayer.");
                                }
                            }
                            catch(IllegalArgumentException e){
                                System.out.println("Le seuil n'est pas conforme. Veuillez réessayer.");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Mauvaise commande. Veuillez recommencer.");
                }
            }
        } else{
            System.out.println("Mauvaise commande. Veuillez recommencer.");
        }
    }
}
