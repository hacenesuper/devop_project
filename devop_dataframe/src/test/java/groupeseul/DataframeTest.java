package groupeseul;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 *
 * @author amrane
 */
@SuppressWarnings("unchecked")
public class DataframeTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);
    
    private Dataframe students, oscars, Df;
    private static Map<String,List<?>> data;
    
    static List<String> prenom;
    static List<Integer> numEtudiant;
    static List<Boolean> estAdmis;
    static List<Double> moyenne;
    @BeforeClass
    public static void initclass()  {
        prenom = new ArrayList<String>(Arrays.asList("Léa", "Claude", "Tony", "Emma", "Ali", "Sarah"));
        numEtudiant = new ArrayList<Integer>(Arrays.asList(118823, 112893, 112534, 113090, 115368, 114982));   
        estAdmis = new ArrayList<Boolean>(Arrays.asList(false, true, true, true, false, true));      
        moyenne = new ArrayList<Double>(Arrays.asList(9.73, 13.28, 12.07, 14.90, 9.45, 15.15)); 
    }
    
    @AfterClass
    public static void finclass() {
        prenom      = null;
        numEtudiant = null;  
        estAdmis    = null;     
        moyenne     = null;
    }
    
    @Before
    public void init() throws FileNotFoundException, IOException, BadArgumentException   {
        data = new HashMap<String,List<?>>();
        data.put("prenom", prenom);
        data.put("num Etudiant", numEtudiant);
        data.put("admis", estAdmis);
        data.put("moyenne", moyenne);
        oscars = new Dataframe("src/test/ressources/oscars.csv");
        
        students = new Dataframe(data);
        Df = new Dataframe();
    }
    
    @After
    public void fin() {
        data = null;
        oscars = null;
        students = null;
    } 
     @Test (expected = BadArgumentException.class)
    public void testConstructor() throws Exception{
        List<Integer> list1  = Arrays.asList(1, 2, 3);        
        List<Integer> list2 = Arrays.asList(4, 5); 
        
        data = new HashMap<String, List<?>>();
        data.put("list1", list1);
        data.put("list2", list2);
        
        Dataframe df = new Dataframe(data);
    }  
    @Test (expected = BadArgumentException.class)
   
    public void testConstructor2() throws Exception{
        data = null;
        Dataframe df = new Dataframe(data);
    }
    
   
    @Test (expected = BadArgumentException.class)
    public void testConstructor3() throws Exception{
        data = new HashMap<String, List<?>>();
        Dataframe df = new Dataframe(data);
    }
    @Test (expected = BadArgumentException.class)
    public void testConstructorlistenull() throws Exception{
        List<Integer> list1  = Arrays.asList(1, 2, 3);        
        List<Integer> list2 = null; 
        
        data = new HashMap<String, List<?>>();
        data.put("list1", list1);
        data.put("list2", list2);
        
        Dataframe df = new Dataframe(data);
    }   
    @Test
    public void testgetnbligne() {
    
        assertEquals(Df.getNbligne(),0);
        assertEquals(students.getNbligne(),6);
        assertEquals(oscars.getNbligne(),89);
       
    }
    @Test
    public void testGetCol() {
        col c =students.getcol("prenom");
       
        assertEquals(c.getLabel(),"prenom");
       
    }
    public void testinsertCol()  {
        col c = new col("testCol1","Integer",  Arrays.asList(1, 2));

        
        Df.insertCol(c);
        assertEquals(c, Df.getcol("testCol1"));
        
    }
   
    
   
 

}
