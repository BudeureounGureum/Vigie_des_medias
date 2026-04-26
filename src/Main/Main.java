package Main;

import ArrayListSpecialise.*;
import ModulesSpecialises.Vigie;

import java.io.IOException;
import java.util.Scanner;

import static Main.GestionEntree.gestionEntree;
import static Main.ChargementListes.remplir;

public class nMain {
    public static ArrayListIndividu listeIndividus = new ArrayListIndividu();
    public static ArrayListOrganisation listeOrganisations = new ArrayListOrganisation();
    public static ArrayListMedia listeMedias = new ArrayListMedia();
    public static ArrayListPublication listePublications = new ArrayListPublication();
    public static ArrayListTransaction listeTransactions = new ArrayListTransaction();
    public static ArrayListRelation relationsIndividuMedia = new ArrayListRelation();
    public static ArrayListRelation relationsIndividuOrganisation = new ArrayListRelation();
    public static ArrayListRelation relationsOrganisationOrganisation = new ArrayListRelation();
    public static ArrayListRelation relationsOrganisationMedia = new ArrayListRelation();
    public static ArrayListModuleSpecialise modulesIndividu = new ArrayListModuleSpecialise();
    public static ArrayListModuleSpecialise modulesOrganisation= new ArrayListModuleSpecialise();
    public static ArrayListModuleSpecialise modulesMedia = new ArrayListModuleSpecialise();
    public static Vigie vigie = new Vigie();


    public static void main(String[] args) {

        try {
            remplir(listeIndividus, listeOrganisations, listeMedias, relationsIndividuMedia,
                    relationsIndividuOrganisation, relationsOrganisationOrganisation, relationsOrganisationMedia);   // Initialisation des tableaux.
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String reponse;
        System.out.println("\nVeuillez saisir votre requête:");
        while(true) {
            System.out.println(" Parcourir données | Publier | Acheter | Créer Module Spécialisé | Exit \n");
            reponse = scanner.nextLine();
            if(reponse.equalsIgnoreCase("exit")){
                System.out.println("Au revoir.");
                return;
            }
            gestionEntree(reponse, scanner);
        }
    }
}