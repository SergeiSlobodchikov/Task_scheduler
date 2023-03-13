package Seminar4;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskStorage<Task> taskStorage = new InMemoryTaskStorage();
        TaskExporter taskExporter = new CsvTaskExporter();
        TaskImporter taskImporter = new CsvTaskImporter();
        TaskManager<Task> taskManager = new TaskManager<>(taskStorage, taskExporter, taskImporter);
        taskManager.addTask(LocalDateTime.now(), LocalDateTime.now().plusDays(1), Priority.LOW, "John Doe", "Постирать");
        taskManager.addTask(LocalDateTime.now(), LocalDateTime.now().plusDays(2), Priority.MEDIUM, "Jane Smith", "Купить продукты");
        taskManager.addTask(LocalDateTime.now(), LocalDateTime.now().plusHours(1), Priority.IMMEDIATE, "Bob Johnson", "Позвонить клиенту");
        taskManager.exportTasks("tasks.json");
        TaskManager<Task> importedTasks = taskManager.importTasks("tasks.json");
        System.out.println(taskManager.getTaskById(2));
        System.out.println(importedTasks.getTaskById(2));
        importedTasks.addTask(LocalDateTime.now(), LocalDateTime.now().plusHours(2), Priority.IMMEDIATE, "Bob Johnson", "Сообщить начальнику о сделке");
        System.out.println(importedTasks.getTaskById(4));
        importedTasks.removeTask(3);
        System.out.println(importedTasks.getTaskById(3));
        importedTasks.addTaskWithID(3, LocalDateTime.now(), LocalDateTime.now().plusHours(2), Priority.IMMEDIATE, "Bob Johnson", "Сделка сегодня");
        System.out.println(importedTasks.getTaskById(3));
        importedTasks.getTaskById(3).setDescription("Сделку перенесли");
        importedTasks.getTaskById(3).setDeadlineDateTime(LocalDateTime.now().plusDays(1));
        System.out.println(importedTasks.getTaskById(3));
    }
}