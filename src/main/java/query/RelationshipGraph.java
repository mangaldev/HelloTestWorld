package query;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mdev on 4/12/17.
 *
 */
public class RelationshipGraph {
    private AttributeNode root;
    private Map<String, AttributeNode> nodeMap = new HashMap<>();

    RelationshipGraph() {
        root = new AttributeNode("ROOT");
        nodeMap.put("ROOT", root);
    }

    void addRelation(Tuple<String,String> tuple) {
        String type1 = tuple.value1;
        createNodeIfNotExists(type1);
        String type2 = tuple.value2;
        createNodeIfNotExists(type2);
        nodeMap.get(type1).addReference(nodeMap.get(type2));
    }

    public long distance(String type1, String type2) {
        AttributeNode attributeNode1 = nodeMap.get(type1);
        AttributeNode attributeNode2 = nodeMap.get(type2);
        return Long.max(dfs(attributeNode1, attributeNode2, 0), dfs(attributeNode2, attributeNode1, 0));
    }

    public List<AttributeNode> path(String type1, String type2) {
        List<AttributeNode> path = new LinkedList<>();
        AttributeNode attributeNode1 = nodeMap.get(type1);
        AttributeNode attributeNode2 = nodeMap.get(type2);
        if(!findPath(attributeNode1, attributeNode2,path))
            findPath(attributeNode2, attributeNode1,path);
        return path;
    }

    private boolean findPath(AttributeNode root, AttributeNode toFind, List<AttributeNode> path) {
        path.add(root);
        if (root == toFind) {
            return true;
        }
        for (int i = 0; i < root.referenceTo.size(); i++) {
            AttributeNode attributeNode = root.referenceTo.get(i);
            if(findPath(attributeNode, toFind, path))
                return true;
        }
        path.remove(root);
        return false;
    }

    private long dfs(AttributeNode root, AttributeNode toFind, long level) {
        if (root == toFind)
            return level;
        for (int i = 0; i < root.referenceTo.size(); i++) {
            AttributeNode attributeNode = root.referenceTo.get(i);
            long l = dfs(attributeNode, toFind, level + 1);
            if (l != -1)
                return l;
        }
        return -1;
    }

    private void createNodeIfNotExists(String type) {
        if (!nodeExists(type)) {
            AttributeNode attributeNode = new AttributeNode(type);
            nodeMap.put(type, attributeNode);
            root.addReference(attributeNode);
        }
    }

    private boolean nodeExists(String type) {
        return nodeMap.containsKey(type);
    }

    @Override
    public String toString() {
        return "RelationshipGraph{" +
                "nodeMap=" + nodeMap +
                '}';
    }
}
