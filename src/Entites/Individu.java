package Entites;

public final class Individu extends Entite {

    // Rangs stockés à partir de 2021 dans l'ordre croissant pour simplifier l'ajout d'année futur.

    private final int[] rangChallenges;

    private final int[] milliardaireForbes;

    public Individu(){
        super();
        this.rangChallenges = new int[0];
        this.milliardaireForbes = new int[0];
    }

    public Individu(String nom, int[] rangChallenges, int[] milliardaireForbes){
        super(nom);
        this.rangChallenges = rangChallenges;
        this.milliardaireForbes = milliardaireForbes;
    }

    public int[] getMilliardaireForbes() {
        return milliardaireForbes;
    }

    public int[] getRangChallenges() {
        return rangChallenges;
    }

    @Override
    public String toString(){
        StringBuilder affichage = new StringBuilder("| ");
        affichage.append(String.format("%-30s", getNom()));
        affichage.append("| ");
        affichage.append(String.format("%-19s", rangChallenges[3] == 0? "" : rangChallenges[3]));
        affichage.append("| ");
        affichage.append(String.format("%-23s", milliardaireForbes[3] == 0? "" : milliardaireForbes[3]));
        affichage.append("| ");
        affichage.append(String.format("%-19s", rangChallenges[2] == 0? "" : rangChallenges[2]));
        affichage.append("| ");
        affichage.append(String.format("%-23s", milliardaireForbes[2] == 0? "" : milliardaireForbes[2]));
        affichage.append("| ");
        affichage.append(String.format("%-19s", rangChallenges[1] == 0? "" : rangChallenges[1]));
        affichage.append("| ");
        affichage.append(String.format("%-23s", milliardaireForbes[1] == 0? "" : milliardaireForbes[1]));
        affichage.append("| ");
        affichage.append(String.format("%-19s", rangChallenges[0] == 0? "" : rangChallenges[0]));
        affichage.append("| ");
        affichage.append(String.format("%-23s", milliardaireForbes[0] == 0? "" : milliardaireForbes[0]));
        affichage.append("|");
        return affichage.toString();
    }
}
