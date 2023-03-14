package Seminar1;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Person john = new Person("John");
        Person jane = new Person("Jane");
        Person alice = new Person("Alice");
        GeoTree tree = new GeoTree();
        tree.addNode(new Node(john, Relationship.PARENT, jane));
        tree.addNode(new Node(john, Relationship.PARENT, alice));
        String filename = "tree.txt";
        System.out.println(tree);
        System.out.println(tree.getTree());
        FileHandler.saveToFile(filename, tree);
        System.out.println("File saved successfully.");
        // сохраняем дерево в файл
//        try {
//            if (FileHandler.fileExists(filename)) {
//                System.out.println("File already exists.");
//            } else {
//                FileHandler.saveToFile(filename, tree.getTree());
//                System.out.println("File saved successfully.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // загружаем дерево из файла
//        List<Node> loadedTree = null;
//        try {
//            if (FileHandler.fileExists(filename)) {
//                loadedTree = FileHandler.loadFromFile(filename);
//                System.out.println("File loaded successfully.");
//            } else {
//                System.out.println("File does not exist.");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if (loadedTree != null) {
//            GeoTree loadedGeoTree = new GeoTree();
//            loadedGeoTree.getTree().addAll(loadedTree);

            // исследуем дерево
            Research research = new Research(tree);
            List<Person> johnChildren = research.getChildren(john);
            System.out.println("John's children: " + johnChildren);
            List<Person> johnDescendants = research.getAllDescendants(john);
            System.out.println("John's descendants: " + johnDescendants);
        }
    }
