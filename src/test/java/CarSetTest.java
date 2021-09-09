import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    private  CarSet<Car> carSet;
    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSetTypeMap<>();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i)); // iznachalno 100 elementov v kolekcii
        }
    }

    @Test
    public void whenAddThreeSimilarObjectsThenSizeIncreaseBy1() {
        assertTrue(carSet.add(new Car("BMW", 13)));
        assertFalse(carSet.add(new Car("BMW", 13)));
        assertFalse(carSet.add(new Car("BMW", 13)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenElementRemoveThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("Brand30",30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30",30)));
        assertEquals(99, carSet.size());
    }


    @Test
    public void whenSetClearedThenSize0() {
        carSet.clean();
        assertEquals(0, carSet.size());
    }
    @Test
    public void contains(){
        assertTrue(carSet.contains(new Car("Brand20", 20)));
        assertFalse(carSet.contains(new Car("Brand200", 20)));
    }

}