package Enumerations;

public enum CategoriePublications {
    ARTICLE(),
    REPORTAGE(),
    INTERVIEW();

    public static CategoriePublications getCategoriePublication(String string) throws IllegalArgumentException{
        if(string.equalsIgnoreCase("article")){
            return CategoriePublications.ARTICLE;
        }
        else if(string.equalsIgnoreCase("reportage")){
            return CategoriePublications.REPORTAGE;
        }
        else if(string.equalsIgnoreCase("interview")){
            return CategoriePublications.INTERVIEW;
        }
        else{
            throw new IllegalArgumentException("Ce n'est pas une catégorie de publication valide.");
        }
    }

    @Override
    public String toString(){
        if(this == ARTICLE){
            return "Article";
        }
        else if(this == REPORTAGE){
            return "Reportage";
        }
        else{
            return "Interview";
        }
    }
}
