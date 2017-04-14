import com.google.gson.*;
import entities.AutomapJob;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by mdev on 5/19/16.
 */
public class HelloJson {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"OnlineTv\": {\n" +
                "    \"tms_ids\": []\n" +
                "  },\n" +
                "  \"OnlineMovie\": {\n" +
                "    \"tms_ids\": [\n" +
                "      \"MV005014500000\"\n" +
                ",      \"MV005014500001\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"OnlineSpecial\": {\n" +
                "    \"tms_ids\": [\n" +
                "      \"SH019332820000\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonObject onlineTv = jsonObject.getAsJsonObject("OnlineMovie");
        JsonElement tms_ids = onlineTv.get("tms_ids");
        System.out.println(tms_ids.getAsJsonArray().size());
        JsonElement jsonElement = tms_ids.getAsJsonArray().get(1);
        System.out.println("jsonElement = " + jsonElement.getAsString());

        AutomapJob job = new AutomapJob();
        job.series_title = "serries title";
        job.remote_id = "remote id";


        List<String> test = Arrays.asList("a","b");
        String s = new Gson().toJson(test);
        System.out.println("s = " + s);
        JsonObject asJsonObject = new JsonParser().parse(s).getAsJsonObject();
        System.out.println("asJsonObject = " + asJsonObject);
        List list = new Gson().fromJson(new JsonParser().parse(s).getAsJsonObject(), List.class);
        System.out.println("list = " + list);

    }
}
