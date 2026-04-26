package Enumerations;

public enum Prix {
    ABSENT(),
    GRATUIT(),
    PAYANT();

    public static Prix getPrix(String string) throws IllegalArgumentException{
        if(string.isEmpty()){
            return Prix.ABSENT;
        }
        else if(string.equals("Gratuit")){
            return Prix.GRATUIT;
        }
        else if(string.equals("Payant")){
            return Prix.PAYANT;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas un prix valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ABSENT){
            return "";
        }
        else if(this == GRATUIT){
            return "Gratuit";
        }
        else{
            return "Payant";
        }
    }
}
