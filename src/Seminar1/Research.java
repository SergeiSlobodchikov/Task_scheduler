package Seminar1;
import java.util.ArrayList;
import java.util.List;

public class Research {
    private GeoTree geoTree;

    public Research(GeoTree geoTree) {
        this.geoTree = geoTree;
    }

    public List<Person> getChildren(Person person) {
        return geoTree.getChildren(person);
    }

    public List<Person> getAllDescendants(Person person) {
        List<Person> descendants = new ArrayList<>();
        List<Person> children = getChildren(person);
        descendants.addAll(children);
        for (Person child : children) {
            descendants.addAll(getAllDescendants(child));
        }
        return descendants;
    }
}

