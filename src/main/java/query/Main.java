package query;

import org.junit.Before;
import org.junit.Test;
import query.builder.MultipleExpressionBuilder;
import query.builder.QueryBuilder;
import query.builder.SingleExpressionBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * r0       r1         r2         r3
 * MSO => HEADEND => LINEUP => STATION
 * <p>
 * STATION =>
 * (HEADEND = ['HE1'] AND STATUS = ['4']) OR (HEADEND = ['HE1'] AND STATUS = ['5'])
 * <p>
 * STATION =>
 * (MSO = ['78'] AND STATUS = ['4']) OR (HEADEND = ['HE1'] AND STATUS = ['5'])
 * <p>
 * select distinct result from (
 * select distinct r2.to_value as result from entitlements.reference r0
 * left join entitlements.reference r1
 * on r0.to_value = r1.from_value
 * left join entitlements.reference r2
 * on r1.to_value = r2.from_value
 * where
 * r0.from_attribute='MSO' and r0.to_attribute='HEADEND'
 * and r1.from_attribute = 'HEADEND' and r1.to_attribute = 'LINEUP'
 * and r2.from_attribute = 'LINEUP' and r2.to_attribute = 'STATION'
 * and r0.from_value in ('78')
 * intersect
 * select distinct r1.from_value as result from entitlements.reference r1
 * where r1.from_attribute = ('STATION') and r1.to_attribute = 'STATUS'
 * and r1.to_value in ('5')
 * ) query
 * <p>
 * <p>
 * <p>
 * select distinct result from (
 * select  distinct r2.to_value as result from entitlements.reference r1
 * left join entitlements.reference r2
 * on  r1.to_value = r2.from_value
 * where r1.from_attribute = 'HEADEND' and r2.from_attribute = 'LINEUP' and r2.to_attribute = 'STATION'
 * and r1.from_value in ('DEU-0004569')
 * INTERSECT
 * select distinct r1.from_value as result from entitlements.reference r1
 * where r1.from_attribute = ('STATION') and r1.to_value in ('4')
 * ) query
 * union
 * select distinct result from (
 * select  r2.to_value as result from entitlements.reference r1
 * left join entitlements.reference r2
 * on  r1.to_value = r2.from_value
 * where r1.from_attribute = 'HEADEND' and r2.from_attribute = 'LINEUP' and r2.to_attribute = 'STATION'
 * and r1.from_value in ('DEU-0004569')
 * INTERSECT
 * select distinct r1.from_value as result from entitlements.reference r1
 * where r1.from_attribute = ('STATION') and r1.to_value in ('5')
 * ) query
 * <p>
 * <p>
 * <p>
 * Created by mdev on 4/12/17.
 */
public class Main {

    RelationshipGraph graph;

    @Before
    public void init() {
        graph = new RelationshipGraph();

        String relationConfig =
                "SCHEDULEDAY -> EVENT," +
                        "SCHEDULEDAY -> DAY, " +
                        "SCHEDULEDAY -> STATION," +
                        "MSO -> HEADEND," +
                        "COUNTRY -> HEADEND," +
                        "HEADEND -> LINEUP," +
                        "LINEUP -> STATION," +
                        "STATION -> STATUS," +
                        "STATION -> AFFILIATION," +
                        "PROGRAM -> GENRE," +
                        "PROGRAM -> LANGUAGE," +
                        "PROGRAM -> TYPE";


        String[] relations = relationConfig.split(",");
        List<Tuple> tuples = Stream.of(relations).map(rel -> new Tuple<>(rel.substring(0, rel.indexOf("->")).trim(), rel.substring(rel.indexOf("->") + 2).trim())).collect(Collectors.toList());
        tuples.forEach(graph::addRelation);
    }

    @Test
    public void test1() {

        assertEquals(4, graph.path("MSO", "STATION").size());
        assertEquals(4, graph.path("STATION", "MSO").size());
        assertEquals(2, graph.path("STATUS", "STATION").size());
        assertEquals(2, graph.path("STATION", "STATUS").size());
    }

    @Test
    public void test2() {

        String resultType = "STATION";
        String criteria = "STATUS IN ('4')";

        assertEquals("Queries should be generated.", "select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='STATION' and r0.to_attribute='STATUS'  and r0.to_value IN ('4')", new SingleExpressionBuilder(resultType, criteria, graph).build().trim());
    }

    @Test
    public void test3() {

        String resultType = "STATION";
        String criteria = "MSO IN ('78')";

        assertEquals("Queries should be generated.", "select distinct r2.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  left join entitlements.reference r2 on r1.to_value = r2.from_value  where  r0.from_attribute='MSO' and r0.to_attribute='HEADEND'  and  r1.from_attribute='HEADEND' and r1.to_attribute='LINEUP'  and  r2.from_attribute='LINEUP' and r2.to_attribute='STATION'  and r0.from_value IN ('78')", new QueryBuilder(resultType, criteria, graph).build().trim());
    }

    @Test
    public void test4() {

        String resultType = "STATION";
        String criteria = "HEADEND IN ('DEU-0004569') AND STATUS IN ('4')";

        assertEquals("Queries should be generated.", "select distinct r1.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  where  r0.from_attribute='HEADEND' and r0.to_attribute='LINEUP'  and  r1.from_attribute='LINEUP' and r1.to_attribute='STATION'  and r0.from_value IN ('DEU-0004569')  INTERSECT select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='STATION' and r0.to_attribute='STATUS'  and r0.to_value IN ('4')", new MultipleExpressionBuilder(resultType, criteria, graph).build().trim());
    }

    @Test
    public void test5() {
        String resultType = "STATION";
        String criteria = "MSO IN ('78') OR STATUS IN ('4')";
        assertEquals("Queries should be generated.", "select distinct r2.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  left join entitlements.reference r2 on r1.to_value = r2.from_value  where  r0.from_attribute='MSO' and r0.to_attribute='HEADEND'  and  r1.from_attribute='HEADEND' and r1.to_attribute='LINEUP'  and  r2.from_attribute='LINEUP' and r2.to_attribute='STATION'  and r0.from_value IN ('78')  UNION select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='STATION' and r0.to_attribute='STATUS'  and r0.to_value IN ('4')", new MultipleExpressionBuilder(resultType, criteria, graph).build().trim());

    }

    @Test
    public void test6() {
        String resultType = "PROGRAM";
        String criteria = "LANGUAGE IN ('English','German') OR GENRE IN ('3','5') AND TYPE = '4'";
        assertEquals("Queries should be generated.", "select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='LANGUAGE'  and r0.to_value IN ('English','German')  INTERSECT select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='GENRE'  and r0.to_value IN ('3','5')   INTERSECT select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='TYPE'  and r0.to_value = '4'", new MultipleExpressionBuilder(resultType, criteria, graph).build().trim());
    }

    @Test
    public void test7() {
        String resultType = "PROGRAM";
        String criteria = "{ LANGUAGE IN ('English','German')  AND  GENRE IN ('3','5')  AND  TYPE = '4' } OR { TYPE = '10' } ";
        assertEquals("Queries should be generated.", "select distinct result from ( select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='LANGUAGE'  and r0.to_value IN ('English','German')  INTERSECT select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='GENRE'  and r0.to_value IN ('3','5')   INTERSECT select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='TYPE'  and r0.to_value = '4'   ) query UNION select distinct result from ( select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='PROGRAM' and r0.to_attribute='TYPE'  and r0.to_value = '10'  ) query", new QueryBuilder(resultType, criteria, graph).build().trim());

    }

    @Test
    public void test8() {
        String resultType = "STATION";
        String criteria = "{ MSO IN ('78') AND HEADEND IN ('DEU-0004569') }";
        assertEquals("Queries should be generated.", "select distinct r2.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  left join entitlements.reference r2 on r1.to_value = r2.from_value  where  r0.from_attribute='MSO' and r0.to_attribute='HEADEND'  and  r1.from_attribute='HEADEND' and r1.to_attribute='LINEUP'  and  r2.from_attribute='LINEUP' and r2.to_attribute='STATION'  and r0.from_value IN ('78')  INTERSECT  select distinct r1.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  where  r0.from_attribute='HEADEND' and r0.to_attribute='LINEUP'  and  r1.from_attribute='LINEUP' and r1.to_attribute='STATION'  and r0.from_value IN ('DEU-0004569')", new QueryBuilder(resultType, criteria, graph).build().trim());
    }

    @Test
    public void test9() {
        String resultType = "STATION";
        String criteria = "{ MSO IN ('17680','6769784') OR LINEUP IN ('ARG-0000812-DEFAULT','ARG-0000812-X') }";
        assertEquals("Queries should be generated.", "select distinct r2.to_value as result from entitlements.reference r0  left join entitlements.reference r1 on r0.to_value = r1.from_value  left join entitlements.reference r2 on r1.to_value = r2.from_value  where  r0.from_attribute='MSO' and r0.to_attribute='HEADEND'  and  r1.from_attribute='HEADEND' and r1.to_attribute='LINEUP'  and  r2.from_attribute='LINEUP' and r2.to_attribute='STATION'  and r0.from_value IN ('17680','6769784')  UNION select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='LINEUP' and r0.to_attribute='STATION'  and r0.to_value IN ('ARG-0000812-DEFAULT','ARG-0000812-X')", new QueryBuilder(resultType, criteria, graph).build().trim());
    }
}
