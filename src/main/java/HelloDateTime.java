import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by mdev on 6/20/16.
 */
public class HelloDateTime {

    public static void main(String[] args) {
        String startedAt = "06/19/2016 2:35 PM";
        String startedAt1= "06/01/2016 10:13 PM";
        String startedAt2 = "2016-06-24";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(startedAt2, formatter);
        System.out.println("dateFromString2 = " + parse);
        boolean after = parse.isAfter(LocalDate.now().minusMonths(2));
        System.out.println("after = " + after);
//        Date dateFromString = getDateFromString(startedAt, "MM/dd/yyyy h:mm a");
//        Date dateFromString1= getDateFromString(startedAt1,"MM/dd/yyyy h:mm a");
//        System.out.println(dateFromString);
//        System.out.println(dateFromString1);



    }


    public static Date getDateFromString(String date, String datePattern) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime startedDate = LocalDateTime.parse(date, formatter);
        return Date.from(startedDate.atZone(ZoneId.systemDefault()).toInstant());
    }
}
