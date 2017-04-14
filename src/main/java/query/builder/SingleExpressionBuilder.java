package query.builder;

import com.google.common.base.Strings;
import query.AttributeNode;
import query.RelationshipGraph;

import java.util.List;

/**
 * Created by mdev on 4/12/17.
 * <p>
 * This will create criteria builder for one criteria e.g.
 * MSO = ['78']
 * type OPER values
 * resultType is For which object we are making criteria for .. e.g in this case it will be for Station....
 */
public class SingleExpressionBuilder implements Builder {
    String resultType;
    String type;
    String operator;
    String values;
    List<AttributeNode> path;

    public SingleExpressionBuilder(String resultType, String criteria, RelationshipGraph graph) {
        this.resultType = resultType;
        extract(criteria.trim());
        path = graph.path(type, resultType);
    }

    private void extract(String query) {
        String[] keywords = query.split(" ");
        type = keywords[0];
        operator = keywords[1];
        values = keywords[2];

    }

    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        if (path.size() > 2) {
            stringBuilder.append(" select distinct r").append(path.size() - 2).append(".to_value as result from entitlements.reference r0 ");
            for (int i = 0; i < path.size() - 2; i++) {
                stringBuilder.append(" left join entitlements.reference r").append(i + 1);
                stringBuilder.append(" on r").append(i).append(".to_value = r").append(i + 1).append(".from_value ");
            }
            stringBuilder.append(" where ");
            for (int i = 0; i < path.size() - 1; i++) {
                if (i != 0)
                    stringBuilder.append(" and ");
                stringBuilder.append(" r" + (i) + ".from_attribute='" + path.get(i).type + "' and r" + (i) + ".to_attribute='" + path.get(i + 1).type + "' ");
            }
            if (!Strings.isNullOrEmpty(values))
                stringBuilder.append(" and r0.from_value " + operator + " " + values + " ");
        } else {
            stringBuilder.append("select distinct r0.from_value as result from entitlements.reference r0  where  r0.from_attribute='" + path.get(0).type + "' and r0.to_attribute='" + path.get(1).type + "'  and r0.to_value " + operator + " " + values + " ");
        }
        return stringBuilder.toString();
    }
}
