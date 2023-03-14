package Seminar4;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class CsvTaskExporter implements TaskExporter<Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void export(List<Task> tasks, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.printf("%d,%s,%s,%s,%s,%s%n", task.getId(), task.getAddedDateTime().format(DATE_FORMATTER),
                        task.getDeadlineDateTime().format(DATE_FORMATTER), task.getPriority(), task.getAuthorName(),
                        task.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}