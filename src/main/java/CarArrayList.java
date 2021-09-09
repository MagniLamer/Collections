import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        chchekIndex(index);
        return (T)array[index];
    }

    @Override
    public boolean add(T car) {
        increaseArray();
//            Car[] newArray = new Car[array.length *2];
//            for (int i = 0; i <array.length ; i++) {
//                newArray[i] = array[i];
//
//            }
//            array = newArray;

        array[size] = car;
        size++;
        return  true;
    }

    @Override
    public boolean add(T car, int index) {

        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        chchekIndex(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T car) {
        for( Object carInArray : array){
            if (car.equals((T)carInArray)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clean() {
        Object[] array = new Object[10];
        size = 0;
    }

    private void chchekIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);// yvelichenie masiva array v 2 raza s pomoshiu Arrays

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T)array[index++];
                }
        };
    }
}
