package Enumerations;

public enum Echelle {
    ABSENT(),
    INTERNATIONAL(),
    NATIONAL(),
    REGIONAL(),
    EUROPE(),
    SUISSE(),
    MONACO();

    public static Echelle getEchelle(String string) throws IllegalArgumentException{
        if(string.isEmpty()){
            return Echelle.ABSENT;
        }
        else if(string.equals("International")){
            return Echelle.INTERNATIONAL;
        }
        else if(string.equals("National")){
            return Echelle.NATIONAL;
        }
        else if(string.equals("Régional")){
            return Echelle.REGIONAL;
        }
        else if(string.equals("Europe")){
            return Echelle.EUROPE;
        }
        else if(string.equals("Suisse")){
            return Echelle.SUISSE;
        }
        else if(string.equals("Monaco")){
            return Echelle.MONACO;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas une échelle valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ABSENT){
            return "";
        }
        else if(this == INTERNATIONAL){
            return "International";
        }
        else if(this == NATIONAL){
            return "National";
        }
        else if(this == REGIONAL){
            return "Régional";
        }
        else if(this == EUROPE){
            return "Europe";
        }
        else if(this == SUISSE){
            return "Suisse";
        }
        else{
            return "Monaco";
        }
    }
}
