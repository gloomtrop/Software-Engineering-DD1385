import org.junit.Test;

import static org.junit.Assert.*;

public class GlesVector1Test {
    @Test
    public void add() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertEquals(0, vec.size());
        vec.add("hej");
        assertEquals(1, vec.size());
        vec.add("då");
        assertEquals(2, vec.size());
        vec.add("bye");
        assertEquals(3, vec.size());
        vec.add("hi");
        assertEquals(4, vec.size());
        assertEquals("hi", vec.get(3));
        assertEquals("hej", vec.get(0));
        assertNull(null, vec.get(10));

    }

    @Test
    public void testAdd() {
        GlesVector<String> vec = new GlesVector<>();
        assertEquals(0, vec.size());
        vec.add(1,"hej");
        assertEquals(1, vec.size());
        vec.add(3,"då");
        assertEquals(2, vec.size());
        vec.add(4,"bye");
        assertEquals(3, vec.size());
        vec.add(5,"hi");
        assertEquals(4, vec.size());
        assertEquals("då", vec.get(3));
        assertEquals("hej", vec.get(1));
        assertNull(null, vec.get(10));
    }

    @Test
    public void indexOf() {
        GlesVector<String> vec = new GlesVector<>();
        assertEquals(0, vec.size());
        vec.add("hej");
        vec.add("då");
        vec.add("bye");
        assertEquals(0, vec.indexOf("hej"));
        assertEquals(1, vec.indexOf("då"));
        assertEquals(2, vec.indexOf("bye"));
        vec.add("hi");
        assertEquals(3, vec.indexOf("hi"));

        assertEquals(-1, vec.indexOf("Axel"));
    }

    @Test
    public void removeAt() {
        GlesVector1<String> vec = new GlesVector1<>();
        vec.add(2,"hej");
        vec.add(1,"Då");
        vec.removeAt(1);
        assertNull(null,vec.get(1));
    }

    @Test
    public void removeElem() {
        GlesVector1<String> vec = new GlesVector1<>();
        vec.add(2,"hej");
        vec.add(1,"Då");
        vec.removeElem("hej");
        assertNull(null,vec.get(2));
    }

    @Test
    public void size() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertEquals(0, vec.size());
        vec.add(1,"hej");
        assertEquals(1, vec.size());
        vec.add(2, "då");
        assertEquals(2, vec.size());
        vec.add(5,"bye");
        assertEquals(3, vec.size());
        vec.add(1,"hi");
        assertEquals(3, vec.size());
        //Test for minIndex
        assertEquals(1, vec.minIndex());
        //Test for maxIndex
        assertEquals(5, vec.maxIndex());
    }

    @Test
    public void minIndex() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertEquals(0, vec.minIndex());
    }

    @Test
    public void maxIndex() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertEquals(0, vec.maxIndex());
    }

    @Test
    public void get() {
        GlesVector1<String> vec = new GlesVector1<>();
        vec.add(1,"Hej");
        assertEquals("Hej", vec.get(1));
        assertNull(null, vec.get(2));
    }

    @Test
    public void toArray() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertNull(null, vec.toArray());
    }

    @Test
    public void sortedValues() {
        GlesVector1<String> vec = new GlesVector1<>();
        assertNull(null, vec.sortedValues());
    }

}