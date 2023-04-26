package groupeseul;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;
import junit.framework.TestSuite;
@SuppressWarnings("unchecked")
public class colTest  extends TestCase{

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testConstructor() {
        col<String> c = new col("test", "String", new ArrayList(Arrays.asList("foo", "bar")));
        assertEquals("test", c.getLabel());
        assertEquals("String", c.getType());
        assertEquals(new ArrayList(Arrays.asList("foo", "bar")), c.getValues());
    }

    @Test
    public void testEmptyConstructor() {
        col<Integer> c = new col("test", "Integer");
        assertEquals("test", c.getLabel());
        assertEquals("Integer", c.getType());
        assertTrue(c.getValues().isEmpty());
    }
    @Test
    public void testGetValues() {
        col<Integer> c = new col("testlabel", "Integer", new ArrayList(Arrays.asList(1, 2, 3)));
        assertEquals(Arrays.asList(1, 2, 3), c.getValues());
    }
    @Test
    public void testGetType() {
        col<Integer> c = new col("testlabel", "Integer", new ArrayList(Arrays.asList(1, 2, 3)));
        assertEquals("Integer", c.getType());
    }

    @Test
    public void testGetlabel() {
        col<Integer> c = new col("testlabel", "Integer", new ArrayList(Arrays.asList(1, 2, 3)));
        assertEquals("testlabel", c.getLabel());
    }
    @Test
    public void testGetSize() {
        col<Integer> c = new col("test", "Integer", new ArrayList(Arrays.asList(1, 2, 3)));
        assertEquals(3, c.getsize());
    }

    @Test
    public void testPresent() {
        col<Integer> c = new col("test", "Integer", new ArrayList(Arrays.asList(1, 2, 3)));
        assertTrue(c.present(2));
        assertFalse(c.present(4));
    }

    @Test
    public void testAdd() {
        col<Double> c = new col("test", "Double");
        assertTrue(c.getValues().isEmpty());
        c.add(3.14);
        assertFalse(c.getValues().isEmpty());
        assertEquals(new ArrayList(Arrays.asList(3.14)), c.getValues());
    }

    @Test
    public void testIsNumeric() {
        col<String> c1 = new col("test", "String");
        assertFalse(c1.isnumeric());
        col<Integer> c2 = new col("test", "Integer");
        assertTrue(c2.isnumeric());
        col<Double> c3 = new col("test", "Double");
        assertTrue(c3.isnumeric());
        col<Float> c4 = new col("test", "Float");
        assertTrue(c4.isnumeric());
    }
}
