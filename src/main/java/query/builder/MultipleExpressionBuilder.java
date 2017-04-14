package query.builder;

import com.google.common.base.Strings;
import query.RelationshipGraph;

import java.util.*;

/**
 * Created by mdev on 4/12/17.
 * This will create criteria builder for mulitple expression criteria e.g.
 * {HEADEND IN ('DEU-0004569') AND STATUS IN ('4')}
 * {SINGLE OR/AND SINGLE OR/AND SINGLE}
 * resultType is For which object we are making criteria for .. e.g in this case it will be for Station....
 */
public class MultipleExpressionBuilder implements Builder {
    String criteria;
    List<String> conditionalOperator = Arrays.asList("AND", "OR");
    RelationshipGraph graph;
    String resultType;


    public MultipleExpressionBuilder(String resultType, String criteria, RelationshipGraph graph) {
        this.resultType = resultType;
        this.graph = graph;
        this.criteria = criteria.trim();
    }

    @Override
    public String build() {
        Scanner sc = new Scanner(criteria);
        String expresionSoFar = "";
        String lastOperator = "";
        Deque<String> queryHolder = new ArrayDeque<>();
        while (sc.hasNext()) {
            String word = sc.next();
            if (conditionalOperator.contains(word)) {
                queryHolder.add(new SingleExpressionBuilder(resultType, expresionSoFar, graph).build());
                expresionSoFar = "";
                lastOperator = word;
            } else {
                expresionSoFar += word + " ";
            }
            if (queryHolder.size() == 2) {
                if (lastOperator.equalsIgnoreCase("OR")) {
                    queryHolder.add(queryHolder.poll()+ " UNION " + queryHolder.poll()+" ");
                } else {
                    queryHolder.add(queryHolder.poll()+ " INTERSECT " + queryHolder.poll()+" ");
                }
            }
        }
        if(!Strings.isNullOrEmpty(expresionSoFar)){
            queryHolder.add(new SingleExpressionBuilder(resultType, expresionSoFar, graph).build());
        }
        if (queryHolder.size() == 2) {
            if (lastOperator.equalsIgnoreCase("OR")) {
                queryHolder.add(queryHolder.poll()+ " UNION " + queryHolder.poll()+" ");
            } else {
                queryHolder.add(queryHolder.poll()+ " INTERSECT " + queryHolder.poll()+" ");
            }
        }
        return queryHolder.poll();
    }
}
