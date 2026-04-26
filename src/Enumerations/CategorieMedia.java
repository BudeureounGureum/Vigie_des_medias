package Enumerations;

public enum CategorieMedia {
    ABSENT(),
    TELEVISION(),
    PRESSE(),
    RADIO(),
    SITE();

    public static CategorieMedia getCategorieMedia(String string) throws IllegalArgumentException{
        if(string.isEmpty()){
            return CategorieMedia.ABSENT;
        }
        else if(string.equals("Télévision")){
            return CategorieMedia.TELEVISION;
        }
        else if(string.equals("Presse (généraliste  politique  économique)")){
            return CategorieMedia.PRESSE;
        }
        else if(string.equals("Radio")){
            return CategorieMedia.RADIO;
        }
        else if(string.equals("Site")){
            return CategorieMedia.SITE;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas une catégorie de média valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ABSENT){
            return "";
        }
        else if(this == TELEVISION){
            return "Télévision";
        }
        else if(this == PRESSE){
            return "Presse (généraliste  politique  économique)";
        }
        else if(this == RADIO){
            return "Radio";
        }
        else{
            return "Site";
        }
    }

}
