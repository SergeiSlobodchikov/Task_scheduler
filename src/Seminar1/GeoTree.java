package Seminar1;
import java.util.ArrayList;
import java.util.List;

public class GeoTree {

    private List<Node> tree = new ArrayList<>();

    public void addNode(Node node) {
        tree.add(node);
    }

    public List<Node> getTree() {
        return tree;
    }

    public List<Person> getChildren(Person person) {
        List<Person> children = new ArrayList<>();
        for (Node node : tree) {
            if (node.getPerson1().equals(person) && node.getRelationship() == Relationship.PARENT) {
                children.add(node.getPerson2());
            }
        }
        return children;
    }
}
