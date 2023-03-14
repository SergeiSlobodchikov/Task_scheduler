package Seminar1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class FileHandler {

    public static void saveToFile(String filename, GeoTree geoTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(geoTree.getTree());
        }
    }
}
