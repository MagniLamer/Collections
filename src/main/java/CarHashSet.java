//import java.util.Iterator;
//
//public class CarHashSet<T> implements CarSet<T> {
//    private static final int INITIAL_CAPACITY = 16;
//    private int size = 0;
//    private Entry[] array = new Entry[INITIAL_CAPACITY];
//    private static final double LOAD_FACTOR = 0.75;
//
//    @Override
//    public boolean add(T car) {
//        if (size >= (array.length * LOAD_FACTOR)) {
//            increaseArray();
//        }
//        boolean added = add(car, array);
//        if (added) {
//            size++;
//        }
//        return added;
//    }
//
//    public boolean add(T car, Entry[] dst) {
//        int position = getElementPosition(car, dst.length);
//        if (dst[position] == null) {
//            Entry entry = new Entry(car, null);
//            dst[position] = entry;
//            return true;
//        } else {
//            Entry existedElement = dst[position];
//            while (true) {
//                if (existedElement.value.equals(car)) {
//                    return false;
//                } else if (existedElement.next == null) {
//                    existedElement.next = new Entry(car, null);
//                    return true;
//                } else {
//                    existedElement = existedElement.next;
//                }
//            }
//
//        }
//
//    }
//
//    @Override
//    public boolean remove(T car) {
//        int position = getElementPosition(car, array.length);
//        if (array[position] == null) {
//            return false;
//        }
//        Entry secondLast = array[position];
//        Entry last = secondLast.next;
//        if (secondLast.value.equals(car)) {
//            array[position] = last;
//            size--;
//            return true;
//        }
//        while (last != null) {
//            if (last.value.equals(car)) {
//                secondLast.next = last.next;
//                size--;
//                return true;
//            } else {
//                secondLast = last;
//                last = last.next;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public void clean() {
//        array = new Entry[INITIAL_CAPACITY];
//        size = 0;
//    }
//
//    @Override
//    public boolean contains(T car) {
//        int position = getElementPosition(car, array.length);
//        if (array[position] == null) {
//            return false;
//        }
//        Entry secondLast = array[position];
//        Entry last = secondLast.next;
//        if (secondLast.value.equals(car)) {
//            return true;
//        }
//        while (last != null) {
//            if (last.value.equals(car)) {
//                return true;
//            } else {
//                last = last.next;
//            }
//        }
//        return false;
//    }
//
//    private void increaseArray() {
//        Entry[] newArray = new Entry[array.length * 2];
//        for (Entry entry : array) {
//            Entry existedElement = entry;
//            while (existedElement != null) {
//                add(existedElement.value, newArray);
//                existedElement = existedElement.next;
//            }
//        }
//        array = newArray;
//    }
//
//    private int getElementPosition(T car, int arrayLength) {
//        return Math.abs(car.hashCode() % arrayLength);
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new Iterator<T>() {
//            int index = 0;
//            int arrayIndex = 0;
//            Entry entry;
//
//            @Override
//            public boolean hasNext() {
//                return index < size;
//            }
//
//            @Override
//            public T next() {
//                while (array[arrayIndex] == null) {
//                    arrayIndex++;
//                }
//                if (entry == null){
//                    entry = array[arrayIndex];
//                    }
//
//                T result = entry.value;
//                entry = entry.next;
//                if (entry == null ){
//                arrayIndex++;
//                }
//                index++;
//                return result;
//            }
//        };
//    }
//
//    private  class Entry {
//        private T value;
//        private Entry next;
//
//        public Entry(Car value, Entry next) {
//            this.value = value;
//            this.next = next;
//        }
//    }
//}
