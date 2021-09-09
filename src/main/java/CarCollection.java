public interface CarCollection<T> extends Iterable<T>{
    boolean add(T car);
    boolean remove(T car);
    void clean();
    int size();
    boolean contains(T car);
}
