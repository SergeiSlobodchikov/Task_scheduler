package Seminar4;

import java.time.LocalDateTime;
import java.util.List;

class TaskManager{
    private TaskStorage taskStorage;
    private TaskExporter taskExporter;
    private TaskImporter taskImporter;

    public TaskManager(TaskStorage taskStorage, TaskExporter taskExporter, TaskImporter taskImporter) {
        this.taskStorage = taskStorage;
        this.taskExporter = taskExporter;
        this.taskImporter = taskImporter;
    }

    public void addTask(LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        Task task = new Task(addedDateTime, deadlineDateTime, priority, authorName, description);
        taskStorage.add(task);
    }

    public void removeTask(int id) {
        taskStorage.remove(id);
    }

    public Task getTaskById(int id) {
        return taskStorage.getById(id);
    }

    public List<Task> getAllTasks() {
        return taskStorage.getAll();
    }

    public void exportTasks(String filePath) {
        List<Task> tasks = taskStorage.getAll();
        taskExporter.export(tasks, filePath);
    }

    public List<Task> importTasks(String filePath) {
        return taskImporter.importTasks(filePath);
    }
}
