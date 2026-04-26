package Enumerations;

public enum Qualificatif {
    ABSENT(),
    CONTROLE(),
    EGALE(),
    SUPERIEUR(),
    INFERIEUR(),
    PARTICIPE();

    public static Qualificatif getQualificatif(String string) throws IllegalArgumentException{
        if(string.isEmpty()){
            return Qualificatif.ABSENT;
        }
        else if(string.equals("contrôle")){
            return Qualificatif.CONTROLE;
        }
        else if(string.equals("égal à")){
            return Qualificatif.EGALE;
        }
        else if(string.equals("supérieur à")){
            return Qualificatif.SUPERIEUR;
        }
        else if(string.equals("inférieur à")){
            return Qualificatif.INFERIEUR;
        }
        else if(string.equals("participe")){
            return Qualificatif.PARTICIPE;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas un Qualificatif valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ABSENT){
            return "";
        }
        else if(this == CONTROLE){
            return "contrôle";
        }
        else if(this == EGALE){
            return "égal à";
        }
        else if(this == SUPERIEUR){
            return "supérieur à";
        }
        else if(this == INFERIEUR){
            return "inférieur à";
        }
        else{
            return "participe";
        }
    }
}
