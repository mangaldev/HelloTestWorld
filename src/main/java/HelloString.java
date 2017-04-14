/**
 * Created by mdev on 8/22/16.
 */
public class HelloString {
    public static void main(String[] args) {
        String test = ".*VUBX0277688206815811";
        String word = "tvn.com/VUBX0277688206815811";
        System.out.println(word.matches(test));
    }
}
