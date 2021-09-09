public interface CarList<T> extends CarCollection<T> {
    T get(int index);

    boolean add(T car);

    boolean add(T car, int index);

    boolean remove(T car); // remove Car by name

    boolean removeAt(int index);// remove car by index

    int size();// size of our list

    boolean contains(T car);

    void clean();// remove all cars from list
}
