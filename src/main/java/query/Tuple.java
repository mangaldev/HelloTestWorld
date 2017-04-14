package query;

/**
 * Created by mdev on 4/12/17.
 *
 */
public class Tuple<K,V> {
    K value1;
    V value2;

    Tuple(K value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
