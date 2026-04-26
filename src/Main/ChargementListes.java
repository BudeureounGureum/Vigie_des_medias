package Main;

import ArrayListSpecialise.ArrayListIndividu;
import ArrayListSpecialise.ArrayListMedia;
import ArrayListSpecialise.ArrayListOrganisation;
import ArrayListSpecialise.ArrayListRelation;
import Entites.Individu;
import Entites.Organisation;
import Entites.Media;
import Entites.Relation;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static Enumerations.CategorieMedia.getCategorieMedia;
import static Enumerations.Echelle.getEchelle;
import static Enumerations.Periodicite.getPeriodicite;
import static Enumerations.Prix.getPrix;
import static Enumerations.Qualificatif.getQualificatif;

/**
 * Classe réunissant des méthodes static qui permettent de charger les tableaux dans le programme.
 */
public final class ChargementListes {
    /**
     * Remplis une liste d'individu 'liste' à l'aide du br.
     * @param br    Fait le lien entre le fichier et le code.
     * @param liste ArrayList dans laquelle on charge les organisations.
     * @throws IOException si un problème survient durant la lecture du fichier.
     */
    private static void remplirIndividu(BufferedReader br, ArrayListIndividu liste) throws IOException{
        br.readLine(); // On enlève l'entête du tableau.
        String ligne;

        while ((ligne = br.readLine()) != null) {         // Tant qu'on n'a pas fini de lire le tableau.
            String[] champs = ligne.split("\t");    // On split chaque ligne de telle sorte à ce qu'on obtienne chaque colonne séparée dans un tableau de String
            int[] rang = new int[4];
            int[] milliardaire = new int[4];
            int taille = champs.length;
            String[] champsPlein;
            if(taille < 9){                               // Si des colonnes sont vides à la fin de la ligne, on les complète pour ne pas avoir d'erreurs.
                champsPlein = new String[9];
                System.arraycopy(champs, 0, champsPlein, 0, taille);
                for (int i = taille; i < 9; i+=1) {
                    champsPlein[i] = "";
                }
            }
            else{
                champsPlein = champs;
            }
            for(int i = 1; i < 9; i+=1){                  // On remplit rang et milliardaire.
                if(i%2 == 0){
                    milliardaire[4-(i/2)] = (champsPlein[i].isEmpty()? 0 : Integer.parseUnsignedInt(champsPlein[i]));
                }
                else{
                    rang[3-(i/2)] = (champsPlein[i].isEmpty()? 0 : Integer.parseUnsignedInt(champsPlein[i]));;
                }
            }
            liste.add(new Individu(champs[0], rang, milliardaire));     // On ajoute à la liste le nouvel individu
        }
    }

    /**
     * Remplis une liste d'organisations 'liste' à l'aide du br.
     * @param br    Fait le lien entre le fichier et le code.
     * @param liste ArrayList dans laquelle on charge les organisations.
     * @throws IOException si un problème survient durant la lecture du fichier.
     */
    private static void remplirOrganisation(BufferedReader br, ArrayListOrganisation liste) throws IOException{
        br.readLine(); // On enlève l'entête du tableau.
        String ligne;

        while ((ligne = br.readLine()) != null) {           // Tant qu'on n'a pas fini de lire le tableau.
            String[] champs = ligne.split("\t");      // On split chaque ligne de telle sorte à ce qu'on obtienne chaque colonne séparée dans un tableau de String
            int taille = champs.length;
            String[] champsPlein;
            if(taille < 2){                                 // Si des colonnes sont vides à la fin de la ligne, on les complète pour ne pas avoir d'erreurs.
                champsPlein = new String[2];
                System.arraycopy(champs, 0, champsPlein, 0, taille);
                for (int i = taille; i < 2; i+=1) {
                    champsPlein[i] = "";
                }
            }
            else{
                champsPlein = champs;
            }
            liste.add(new Organisation(champsPlein[0], champsPlein[1]));    // On ajoute à la liste la nouvelle organisation.
        }
    }

    /**
     * Remplis une liste de média 'liste' à l'aide du br.
     * @param br    Fait le lien entre le fichier et le code.
     * @param liste ArrayList dans laquelle on charge les médias.
     * @throws IOException si un problème survient durant la lecture du fichier.
     */
    private static void remplirMedia(BufferedReader br, ArrayListMedia liste) throws IOException{
        br.readLine(); // On enlève l'entête du tableau.
        String ligne;

        while ((ligne = br.readLine()) != null) {           // Tant qu'on n'a pas fini de lire le tableau.
            String[] champs = ligne.split("\t");      // On split chaque ligne de telle sorte à ce qu'on obtienne chaque colonne séparée dans un tableau de String
            int taille = champs.length;
            String[] champsPlein;
            if(taille < 6){                                 // Si des colonnes sont vides à la fin de la ligne, on les complète pour ne pas avoir d'erreurs.
                champsPlein = new String[6];
                System.arraycopy(champs, 0, champsPlein, 0, taille);
                for (int i = taille; i < 6; i+=1) {
                    champsPlein[i] = "";
                }
            }
            else{
                champsPlein = champs;
            }
            liste.add(new Media(champsPlein[0], getCategorieMedia(champsPlein[1]), getPeriodicite(champsPlein[2]),
                    getEchelle(champsPlein[3]), getPrix(champsPlein[4]), champsPlein[5].isEmpty()));    // On ajoute à la liste le nouveau média.
        }
    }

    /**
     * Remplis une liste de relation 'liste' à l'aide du br.
     * @param br    Fait le lien entre le fichier et le code.
     * @param liste ArrayList dans laquelle on charge les relations.
     * @throws IOException si un problème survient durant la lecture du fichier.
     */
    private static void remplirRelation(BufferedReader br, ArrayListRelation liste) throws IOException{
        br.readLine(); // On enlève l'entête du tableau.
        String ligne;

        while ((ligne = br.readLine()) != null) {           // Tant qu'on n'a pas fini de lire le tableau.
            String[] champs = ligne.split("\t");      // On split chaque ligne de telle sorte à ce qu'on obtienne chaque colonne séparée dans un tableau de String
            int taille = champs.length;
            String[] champsPlein;
            if(taille < 6){                                 // Si des colonnes sont vides à la fin de la ligne, on les complète pour ne pas avoir d'erreurs.
                champsPlein = new String[6];
                System.arraycopy(champs, 0, champsPlein, 0, taille);
                for (int i = taille; i < 6; i+=1) {
                    champsPlein[i] = "";
                }
            }
            else{
                champsPlein = champs;
            }
            liste.add(new Relation(champsPlein[1], getQualificatif(champsPlein[2]),
                    champsPlein[3].isEmpty()? 0f : Float.parseFloat(champsPlein[3].substring(0, champsPlein[3].length()-1)),
                    champsPlein[4]));    // On ajoute à la liste le nouveau média.
        }
    }

    /**
     * Appelle une fonction remplir... selon la classe qui est donnée en paramètre
     * @param chemin vers le fichier à lire sous forme de String
     * @param classe des éléments de l'ArrayList fournie en paramètre
     * @param liste  ArrayList dans lesquelles on charge les éléments des tableaux.
     * @throws IOException Remonte l'erreur des méthodes appelées.
     */
    private static void lireTSV(String chemin, String classe, ArrayList<?> liste) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {      // On ouvre le fichier à lire.
            if(classe.equals("personnes.tsv")){
                remplirIndividu(br, (ArrayListIndividu) liste);
            }
            else if(classe.equals("organisations.tsv")){
                remplirOrganisation(br, (ArrayListOrganisation) liste);
            }
            else if(classe.equals("medias.tsv")){
                remplirMedia(br, (ArrayListMedia) liste);
            }
            else if(classe.equals("personne-media.tsv")){
                remplirRelation(br, (ArrayListRelation) liste);
            }
            else if(classe.equals("personne-organisation.tsv")){
                remplirRelation(br, (ArrayListRelation) liste);
            }
            else if(classe.equals("organisation-organisation.tsv")){
                remplirRelation(br, (ArrayListRelation) liste);
            }
            else if(classe.equals("organisation-media.tsv")){
                remplirRelation(br, (ArrayListRelation) liste);
            }

        } catch (IOException e) {
            throw new IOException("Erreur lors de la lecture de " + classe);
        }
    }

    /**
     * Télécharge le fichier à l'url donné et le dépose au cheminLocal donné.
     * @param url vers le fichier à télécharger.
     * @param cheminLocal vers l'endroit où il faut déposer le fichier.
     * @throws IOException si un problème survient durant le téléchargement du fichier.
     */
    private static void telechargementGitHub(String url, String cheminLocal) throws IOException{
        try (InputStream in = new URL(url).openStream();
             FileOutputStream fos = new FileOutputStream(cheminLocal)) {
            byte[] buffer = new byte[4096];
            int bytesLus;
            while ((bytesLus = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLus);
            }
            System.out.println("Téléchargement réussi!");
        } catch (IOException e) {
            throw new IOException("Le téléchargement de" + url + " a échoué.");
        }
    }

    /**
     * Remplit la liste avec les bons tableaux.
     * Si les tableaux sont manquants, demande à l'utilisateur s'il veut les télécharger.
     * @param liste ArrayList (contenant un objet filler pour que l'on récupère sa classe) à remplir.
     * @throws IOException  si le téléchargement ou la lecture des tableaux a rencontré un problème.
     */
    private static void verificationTableaux(ArrayList<?> liste, String classe) throws IOException{
        liste.removeFirst();    // On enlève le premier élément filler qui nous permet de savoir de quelle classe sont les éléments de la liste
        String cheminLocal = "Donnees_Projet/" + classe;
        String githubUrl = "https://raw.githubusercontent.com/mdiplo/Medias_francais/master/" + classe;

        // On s'assure que le fichier est présent localement.
        if (!Files.exists(Paths.get(cheminLocal))) {    // Il n'est pas présent donc on demande si l'utilisateur veut le télécharger automatiquement.
            String reponse;
            Scanner scanner = new Scanner(System.in);
            System.out.println(classe + " n'a pas été trouvé. Voulez-vous le télécharger automatiquement dans le dossier du projet?");
            reponse = scanner.nextLine();

            while(!(reponse.equalsIgnoreCase("y") || reponse.equalsIgnoreCase("yes") || reponse.equalsIgnoreCase("oui")) &&
            !(reponse.equalsIgnoreCase("n") || reponse.equalsIgnoreCase("no") || reponse.equalsIgnoreCase("non"))){

                System.out.println("Réponse non-conforme. Veuillez répondre y / yes / oui ou n / no / non.");
                reponse = scanner.nextLine();
            }

            if(reponse.equalsIgnoreCase("y") || reponse.equalsIgnoreCase("yes") || reponse.equalsIgnoreCase("oui")){
                System.out.println("Téléchargement en cours...");
                try {
                    if (!Files.exists(Paths.get("Donnees_Projet"))) {   // On crée le dossier où l'on stocke les données s'il n'existe pas.
                        try {
                            // Create the directory
                            Files.createDirectories(Paths.get("Donnees_Projet"));
                        } catch (IOException e) {
                            System.err.println("Le dossier des données n'a pas pu être créé: " + e.getMessage());
                        }
                    }
                    telechargementGitHub(githubUrl, cheminLocal);
                }
                catch(IOException e){
                    throw new IOException(e.getMessage() + "\nVeuillez relancer le programme pour essayer à nouveau.");
                }
            }
            else if(reponse.equalsIgnoreCase("n") || reponse.equalsIgnoreCase("no") || reponse.equalsIgnoreCase("non")){
                throw new IOException("Veuillez télécharger et inclure les tableaux nécessaires dans 'Projet/Medias_francais-master' et relancez le programme.");
            }
        }

        try {
            lireTSV(cheminLocal, classe, liste);    // On lit le tableau maintenant téléchargé.
        }
        catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Remplis les listes et les trie par ordre lexicographique.
     * @param listeIndividus
     * @param listeOrganisations
     * @param listeMedias
     * @param RelationsIndividuMedia
     * @param RelationsIndividuOrganisation
     * @param RelationsOrganisationOrganisation
     * @param RelationsOrganisationMedia
     * @throws IOException Remonte les exceptions des fonctions appelées.
     */
    public static void remplir(ArrayListIndividu listeIndividus, ArrayListOrganisation listeOrganisations,
                               ArrayListMedia listeMedias, ArrayListRelation RelationsIndividuMedia,
                               ArrayListRelation RelationsIndividuOrganisation, ArrayListRelation RelationsOrganisationOrganisation,
                               ArrayListRelation RelationsOrganisationMedia) throws IOException{

        listeIndividus.add(new Individu());
        verificationTableaux(listeIndividus, "personnes.tsv");
        listeIndividus.sort(Comparator.comparing(Individu::getNom));

        listeOrganisations.add(new Organisation());
        verificationTableaux(listeOrganisations, "organisations.tsv");
        listeOrganisations.sort(Comparator.comparing(Organisation::getNom));

        listeMedias.add(new Media());
        verificationTableaux(listeMedias, "medias.tsv");
        listeMedias.sort(Comparator.comparing(Media::getNom));

        RelationsIndividuMedia.add(new Relation());
        verificationTableaux(RelationsIndividuMedia, "personne-media.tsv");
        RelationsIndividuMedia.sort(Comparator.comparing(Relation::getOrigine));

        RelationsIndividuOrganisation.add(new Relation());
        verificationTableaux(RelationsIndividuOrganisation, "personne-organisation.tsv");
        RelationsIndividuOrganisation.sort(Comparator.comparing(Relation::getOrigine));

        RelationsOrganisationOrganisation.add(new Relation());
        verificationTableaux(RelationsOrganisationOrganisation, "organisation-organisation.tsv");
        RelationsOrganisationOrganisation.sort(Comparator.comparing(Relation::getOrigine));

        RelationsOrganisationMedia.add(new Relation());
        verificationTableaux(RelationsOrganisationMedia, "organisation-media.tsv");
        RelationsOrganisationMedia.sort(Comparator.comparing(Relation::getOrigine));
    }
}
