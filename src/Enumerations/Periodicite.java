package Enumerations;

public enum Periodicite {
    ABSENT(),
    QUOTIDIEN(),
    HEBDOMADAIRE(),
    MENSUEL(),
    BIMESTRIEL(),
    BIMENSUEL();

    public static Periodicite getPeriodicite(String string) throws IllegalArgumentException{
        if(string.isEmpty()){
            return Periodicite.ABSENT;
        }
        else if(string.equals("Quotidien")){
            return Periodicite.QUOTIDIEN;
        }
        else if(string.equals("Hebdomadaire")){
            return Periodicite.HEBDOMADAIRE;
        }
        else if(string.equals("Mensuel")){
            return Periodicite.MENSUEL;
        }
        else if(string.equals("Bimestriel")){
            return Periodicite.BIMESTRIEL;
        }
        else if(string.equals("Bimensuel")){
            return Periodicite.BIMENSUEL;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas une périodicité valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ABSENT){
            return "";
        }
        else if(this == QUOTIDIEN){
            return "Quotidien";
        }
        else if(this == HEBDOMADAIRE){
            return "Hebdomadaire";
        }
        else if(this == MENSUEL){
            return "Mensuel";
        }
        else if(this == BIMESTRIEL){
            return "Bimestriel";
        }
        else{
            return "Bimensuel";
        }
    }
}
