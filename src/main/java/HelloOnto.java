import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by mdev on 5/19/16.
 */
public class HelloOnto {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = null;
        response = Unirest.post("http://icecream:social@onto.casttv.com/match")
                .header("content-type", "application/json")
                .body("{\"air_date\":\"2016\",\"content_type\":\"movie\",\"language\":\"en\",\"title\":\"Deadpool\"}")
                .asString();
        System.out.println(response.getBody().toString());
    }
}
