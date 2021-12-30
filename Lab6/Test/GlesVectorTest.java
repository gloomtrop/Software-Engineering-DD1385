import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

////Krav: För en tom SparseVec, testa size(), minIndex(), maxIndex() som ju alla ska ge heltalsvärden.
//      Testa get(k), där k är ett godtyckligt int-värde. Anropa toArray() och sortedValues() på tom
//      vektor och gör lämpliga tester på resultaten.
////Krav: Lägg till element på specificerade positioner, några på samma index och testa size() efter varje insättning.
//      Testa värdena på minIndex() och maxIndex().
////Krav: Lägg till element på ospecificerad position. Testa size() och get() så att det stämmer med förväntade värden.
//      Kom ihåg att testa get() med ett index som inte används. Den ska gå ge null.
////Krav: Testa båda varianterna av remove och gör tester som visar att de fungerar.
////Krav: I SparseVec-implementationens main-metod, skapa en vektor, lägg in minst fem värden och testa toString(),
//      toArray() och sortedValues() genom att anropa dem och skriva ut resultaten.
//      Använd alltså inte JUnit och assert för dessa tester.
//Tips: Det räcker att använda assertEquals() och assertNull() i testerna.
//      Men använd gärna fler varianter av assert om det passar. Gör gärna en testmetod för varje grupp av tester,
//      t.ex. testEmpty, testIndex, testRemove. Men det är OK att ha en enda metod.

public class GlesVectorTest {

    @Test
    public void add() {
        GlesVector<String> vec = new GlesVector<>();
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
        GlesVector<String> vec = new GlesVector<>();
        vec.add(2,"hej");
        vec.add(1,"Då");
        vec.removeAt(1);
        assertNull(null,vec.get(1));
    }

    @Test
    public void removeElem() {
        GlesVector<String> vec = new GlesVector<>();
        vec.add(2,"hej");
        vec.add(1,"Då");
        vec.removeElem("hej");
        assertNull(null,vec.get(2));
    }

    @Test
    public void size() {
        GlesVector<String> vec = new GlesVector<>();
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
        GlesVector<String> vec = new GlesVector<>();
        assertEquals(0, vec.minIndex());
    }

    @Test
    public void maxIndex() {
        GlesVector<String> vec = new GlesVector<>();
        assertEquals(0, vec.maxIndex());
    }

    @Test
    public void get() {
        GlesVector<String> vec = new GlesVector<>();
        vec.add(1,"Hej");
        assertEquals("Hej", vec.get(1));
        assertNull(null, vec.get(2));
    }

    @Test
    public void toArray() {
        GlesVector<String> vec = new GlesVector<>();
        assertNull(null, vec.toArray());
    }

    @Test
    public void sortedValues() {
        GlesVector<String> vec = new GlesVector<>();
        assertNull(null, vec.sortedValues());
    }
}