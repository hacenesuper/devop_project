package groupeseul;

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
public class Dataframe_test {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);
    
    private Dataframe students, cities, oscars, emptyDf;
    private static Map<String,List<?>> data;
    
    static List<String> prenom;
    static List<Integer> numEtudiant;
    static List<Boolean> estAdmis;
    static List<Double> moyenne;


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
    
    /**
     * 
     * Null dataset
     */
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
    public void testnbRows() {
        assertEquals(emptyDf.getNbligne(),0);
        assertEquals(students.getNbligne(),6);
        assertEquals(oscars.getNbligne(),89);
       
    }



}
