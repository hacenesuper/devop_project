package groupeseul;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BadArgumentException, FileNotFoundException, IOException
    {
        List<String> name = new ArrayList<String> (Arrays.asList("Léa", "Claude", "Tony", "Emma", "Ali", "Sarah"));
        List<Integer> num = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));   
        List<Boolean> admission = new ArrayList<Boolean>(Arrays.asList(true, true, false, true, false, true));      
        List<Double> moy = new ArrayList<Double> (Arrays.asList(9.73, 17.83, 14.77, 11.00, 7.45, 11.15)); 
        
        Map<String,List<?>> dataset = new HashMap<String,List<?>>();
        dataset.put("NOM", name);
        dataset.put("num Etudiant", num);
        dataset.put("admis", admission);
        dataset.put("moyenne", moy);
        
    /****************** Dataframe from data structure ******************/
        
       Dataframe df1 = new Dataframe(dataset);
        System.out.println("\n\t\t\t\tDATAFRAME: \n");
        
      
        df1.afficher();
        System.out.println("\n\t\t\t\tSTATS OF COLUMN : moy\n");
        
      //  df1.afficherStats("moy");
        System.out.println("\n\n");
        
        
    /****************** Dataframe from csv file (oscars) ****************/
       
        Dataframe df2 = new Dataframe(args[0]);
        System.out.println("\t\t\t\t OSCARS DATAFRAME : \n");
        
        df2.afficher();
        System.out.println("\n\t\t\tSTATS OF COLUMN : AGE\n");
        
      //  df2.afficherStats("Age");
        System.out.println("");
        System.out.println("\t\t\tSELECTION ligne: \n");
        
        Dataframe d = df2.selectLigne(85,88);
        
        d.afficher();
        System.out.println("");
        System.out.println("\t\t\tSELECTION collone: \n");
      
        ArrayList<String> L = new ArrayList<String> (Arrays.asList("Name", "Age", "Movie"));
        d = d.selectCol(L);
        

        d.afficher();
        System.out.println("");
        
    }
}
