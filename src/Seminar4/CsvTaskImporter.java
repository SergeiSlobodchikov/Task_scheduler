package Seminar4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//public class CsvTaskImporter implements TaskImporter<Task> {
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    @Override
//    public TaskManager<Task> importTasks(String filePath) {List<Task> tasks = new ArrayList<>();
//        TaskStorage<Task> taskStorage = new InMemoryTaskStorage<>();
//        TaskExporter taskExporter = new CsvTaskExporter();
//        TaskImporter taskImporter = new CsvTaskImporter();
//        TaskManager<Task> taskManager = new TaskManager<>(taskStorage, taskExporter, taskImporter);
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
//                LocalDateTime addedDateTime = LocalDateTime.parse(parts[1], DATE_FORMATTER);
//                LocalDateTime deadlineDateTime = LocalDateTime.parse(parts[2], DATE_FORMATTER);
//                Priority priority = Priority.valueOf(parts[3]);
//                String authorName = parts[4];
//                String description = parts[5];
//                taskManager.addTaskImport(id, addedDateTime, deadlineDateTime, priority, authorName, description);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return taskManager;
//    }
//}


public class CsvTaskImporter implements TaskImporter<Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public TaskManager<Task> importTasks(String filePath) {
        TaskStorage<Task> taskStorage = new InMemoryTaskStorage();
        TaskExporter taskExporter = new CsvTaskExporter();
        TaskImporter taskImporter = new CsvTaskImporter();
        TaskManager<Task> taskManager = new TaskManager<>(taskStorage, taskExporter, taskImporter);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                LocalDateTime addedDateTime = LocalDateTime.parse(parts[1], DATE_FORMATTER);
                LocalDateTime deadlineDateTime = LocalDateTime.parse(parts[2], DATE_FORMATTER);
                Priority priority = Priority.valueOf(parts[3]);
                String authorName = parts[4];
                String description = parts[5];
                taskManager.addTaskWithID(id, addedDateTime, deadlineDateTime, priority, authorName, description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskManager;
    }
}