package query.builder;

import com.google.common.base.Strings;
import query.RelationshipGraph;

import java.util.*;

/**
 * Created by mdev on 4/12/17.
 * This will create criteria builder for mulitple expression criteria e.g.
 * {HEADEND IN ('DEU-0004569') AND STATUS IN ('4')} OR {HEADEND IN ('HE1') AND STATUS IN ('5')}
 * {MULTIPLE} OR/AND {MULTIPLE} OR/AND {MULTIPLE}
 * resultType is For which object we are making criteria for .. e.g in this case it will be for Station....
 */
public class QueryBuilder implements Builder {
    String criteria;
    List<String> conditionalOperator = Arrays.asList("AND", "OR");
    RelationshipGraph graph;
    String resultType;

    public QueryBuilder(String resultType, String criteria, RelationshipGraph graph) {
        this.resultType = resultType;
        this.graph = graph;
        this.criteria = criteria.trim();
    }

    @Override
    public String build() {
        String expresionSoFar = " ";
        String lastOperator = "";
        boolean processingMultipleExpression = false;
        Deque<String> queryHolder = new ArrayDeque<>();
        Scanner sc = new Scanner(criteria);
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.equals("{")) {
                expresionSoFar = "";
                processingMultipleExpression = true;
            } else if (word.equals("}")) {
                queryHolder.add(new MultipleExpressionBuilder(resultType, expresionSoFar, graph).build());
                processingMultipleExpression = false;
                expresionSoFar = "";
            } else if (!processingMultipleExpression && conditionalOperator.contains(word)) {
                lastOperator = word;
            } else {
                expresionSoFar = expresionSoFar + word + " ";
            }
            if (queryHolder.size() == 2) {
                if (lastOperator.equalsIgnoreCase("OR")) {
                    queryHolder.add(new ORBuilder(queryHolder.poll(), queryHolder.poll()).build());
                } else {
                    queryHolder.add(new AndBuilder(queryHolder.poll(), queryHolder.poll()).build());
                }
            }
        }
        if (!Strings.isNullOrEmpty(expresionSoFar)) {
            queryHolder.add(new MultipleExpressionBuilder(resultType, expresionSoFar, graph).build());
        }
        if (queryHolder.size() == 2) {
            if (lastOperator.equalsIgnoreCase("OR")) {
                queryHolder.add(new ORBuilder(queryHolder.poll(), queryHolder.poll()).build());
            } else {
                queryHolder.add(new AndBuilder(queryHolder.poll(), queryHolder.poll()).build());
            }
        }
        return queryHolder.poll();

    }

}
