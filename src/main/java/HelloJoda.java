import org.joda.time.MutableDateTime;

/**
 * Created by mdev on 12/29/16.
 */
public class HelloJoda {

    public static void main(String[] args) {

        MutableDateTime date = new MutableDateTime();
        date.setYear(2016);
        date.setDayOfYear(60);  // 29th Feb  according to 2016
        System.out.println(date); //  It will print 29th Feb 2015
        date.setYear(2015);
        System.out.println(date); //  It will print 29th Feb 2015
    }
}
