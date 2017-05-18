import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mdev on 5/8/17.
 */
public class TestParentTypeCast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("mangal");
        LinkedList linkedList = (LinkedList) list;
        System.out.println("linkedList = " + linkedList);
    }
}
