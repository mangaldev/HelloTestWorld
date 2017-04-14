import org.apache.commons.collections4.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mdev on 5/29/16.
 */
public class HelloPartition {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("a","b","c","d","e");
        List<List<String>> partition = ListUtils.partition(names, 2);
        System.out.println(partition);

        List<Integer> list = new ArrayList<>();
//        System.out.println("list = " + list.size());
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
        Set<Integer> genreSet = new LinkedHashSet<>(list);
        Set<Integer> genreHashSet = new HashSet<>(list);
        System.out.println(genreSet);
        System.out.println(genreHashSet);
    }
}
