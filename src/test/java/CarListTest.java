import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class CarListTest {

    private CarList<Car> carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarLinkedList<>();

        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i)); // iznachalno 100 elementov v kolekcii
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());//ybedilis chto 100 elementov
    }

    @Test
    public void insertIntoMiddle(){
        Car car = new Car("BMW", 12);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW", 12);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW", 12);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5)); // edalenie elementa vozvrashaet true esli ydalenie proshlo yspeshno
        assertEquals(99, carList.size());// proveriam razmer lista stal 99
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased(){
        Car car = new Car("Toyots", 15);
        carList.add(car);
        assertEquals(101, carList.size());// list stal bolshe na odin element proveriam
        assertTrue(carList.remove(car)); // ybeditsa chto ydalenie proshlo yspeshno
        assertEquals(100, carList.size());// ybeditsa chto razmer lista stal 100
    }

    @Test
    public void whenNonExistentElemebtRemovedThenReturnFalse(){
        Car car = new Car("Toyots", 15);
        assertFalse(carList.remove(car)); // pitaemsa udalit elemen rotorogo net v kolekcii iz kolekcii
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0(){
        carList.clean();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException(){
        carList.get(100);
    }

    @Test
    public void methodGetReturnRightValue(){
        Car car =carList.get(0);
        assertEquals("Brand0",car.getBrand());
    }

    @Test
    public void contains(){
        assertTrue(carList.contains(new Car("Brand20", 20)));
        assertFalse(carList.contains(new Car("Brand200", 20)));
    }
}