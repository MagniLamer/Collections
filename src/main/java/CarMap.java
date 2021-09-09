import java.util.List;
import java.util.Set;

public interface CarMap<K, V> {
    void put(K key, V value);

    V get (K key); // vozvrashaet znacheniepo klychy

    Set<K> keySet(); // spisok vseh vladelcev

    List<V> values(); // spisok vseh znacheniy

    boolean remove (K key); // ydalaet kluch i ego znchenie

    int size();

    void clear();
}
