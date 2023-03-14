package Seminar4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

class TaskManager<T extends Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private TaskStorage<T> taskStorage;
    private TaskExporter taskExporter;
    private TaskImporter taskImporter;

    public TaskManager(TaskStorage<T> taskStorage, TaskExporter taskExporter, TaskImporter taskImporter) {
        this.taskStorage = taskStorage;
        this.taskExporter = taskExporter;
        this.taskImporter = taskImporter;
    }

    public void addTask(LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        T task = (T) new Task(addedDateTime, deadlineDateTime, priority, authorName, description);
        taskStorage.add(task);
    }

    public void addTaskWithID(int id, LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        T task = (T) new Task(id, addedDateTime, deadlineDateTime, priority, authorName, description);
        taskStorage.add(task);
    }

    public void removeTask(int id) {
        taskStorage.remove(id);
    }


    public T getTaskById(int id) {
        return taskStorage.getById(id);
    }

    public List<T> getAllTasks() {
        return taskStorage.getAll();
    }

    public void exportTasks(String filePath) {
        List<T> tasks = taskStorage.getAll();
        taskExporter.export(tasks, filePath);
    }

    public TaskManager<Task> importTasks(String filePath) {
        return taskImporter.importTasks(filePath);
    }


    public List<T> getTasksByPriority(Priority priority) {
        return taskStorage.getAll().stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<T> getTasksAfter(LocalDateTime dateTime) {
        return taskStorage.getAll().stream()
                .filter(task -> task.getDeadlineDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }

    public List<T> getTasksBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return taskStorage.getAll().stream()
                .filter(task -> task.getDeadlineDateTime().isAfter(startDateTime) && task.getDeadlineDateTime().isBefore(endDateTime))
                .collect(Collectors.toList());
    }

    public void setCurrentId(int num){
        Task setID = null;
        setID.setId(num);
    }
    

}

