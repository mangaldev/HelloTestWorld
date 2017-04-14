package query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdev on 4/12/17.
 */
public class AttributeNode {
    public String type;
    List<AttributeNode> referenceTo;

    AttributeNode(String type) {
        this.type = type;
        referenceTo = new ArrayList<>();
    }

    void addReference(AttributeNode other) {
        if (!referenceTo.contains(other))
            referenceTo.add(other);
    }

    @Override
    public String toString() {
        return "AttributeNode{" +
                "type='" + type + '\'' +
                ((referenceTo.size() == 0) ? "" : ", referenceTo=" + referenceTo + "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeNode attributeNode = (AttributeNode) o;
        return type.equals(attributeNode.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
