package groupeseul;

import java.util.ArrayList;
import java.util.List;

public class col <VALUE extends Object>{
    private String label;
    private String type;
    private List<VALUE> values;


    /**
     * creation d'une colone dune liste de valeurs 
     * @param label le titre de la colone 
     * @param type le type des valeurs de la colone 
     * @param values liste des valeurs de la colone 
     */
    public col(String label, String type, List<VALUE> values){
        this.label = label;
        this.type = type;
        this.values = values;
    }

    /**
     * creation d'une colone vide 
     * @param label le titre de la colone 
     * @param type le type de la colone 
     */
    public col(String label, String type){
        this.label = label;
        this.type = type;
        this.values = new ArrayList<VALUE>();
    }
/**
     * donne la taille de la colone 
     * @return taille de la colone 
     */
    public int getsize(){
        return this.values.size();
    }
    
    /**
     * la methode donne le label de la colone 
     * @return le label de la colone 
     */
    public String getLabel() {
        return label;
    }
    

    /**
     * la methode retourne le type de la colone 
     * @return le ltype de la colone 
     */
    public String getType() {
        return type;
    }
    
    /**
     * This methode is used to get the values of a Column object
     * @return une liste des valeurs presents dans la colone 
     */
    public List<VALUE> getValues() {
        return values;
    }
    /**
     * This methode is used to test whether the Column contains a value
     * @param v la valeur a virifier si elle est presente dans la colone 
     * @return true si la valeur est presente , faux sinon 
     */
    public boolean present (VALUE v){
        return values.contains(v);
        
    }
    
    /**
     * la methode ajoute une valeur a la colone 
     * @param v la valeur a ajouter 
     */
    public void add(VALUE v){
        this.values.add(v);
    }
    /**
     * la methode teste si la colonne est costituer de valeur numerique 
     * @return
     */
    public boolean isnumeric(){
        return( ( this.getType().equals("Integer")) ||
                ( this.getType().equals("Double" )) ||
                ( this.getType().equals("Float"  ))       
            );
    }
}
