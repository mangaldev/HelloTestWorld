package query.builder;

/**
 * Created by mdev on 4/12/17.
 */
public class ORBuilder implements Builder {
    private String query1;
    private String query2;

    public ORBuilder(String query1, String query2) {
        this.query1 = query1;
        this.query2 = query2;
    }

    @Override
    public String build() {
        return String.format("select distinct result from ( %s ) query UNION select distinct result from ( %s ) query ",query1,query2);
    }
}
