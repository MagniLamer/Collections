import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {
    private CarCollection<Car> carCollection;
    @Before
    public void setUp() throws Exception{
        carCollection = new CarHashSetTypeMap<>();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i)); // iznachalno 100 elementov v kolekcii
        }
    }

    @Test
    public void testForEach(){
        int index = 0;
        for (Car car : carCollection){
            index++;
        }
        assertEquals(100,index);
    }
}