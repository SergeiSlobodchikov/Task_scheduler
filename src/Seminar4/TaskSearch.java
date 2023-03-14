package Seminar4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
public class TaskSearch {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    static void taskSearch(TaskManager taskManager) {
        System.out.println("Поиск задач\n1. По Id\n2. По крайний срок\n3. После срока \n4. По заданному приоритету");
        Scanner scanner = new Scanner(System.in);
        int taskId;
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.print("Введите ID задачи: ");
                taskId = scanner.nextInt();
                scanner.nextLine();
                Task taskById = taskManager.getTaskById(taskId);
                if (taskById == null) {
                    System.out.println("Задача с таким ID не найдена.");
                } else {
                    System.out.println(taskById);
                }
                break;
            case 2:
                System.out.print("Введите крайний срок для поиска в формате \"dd.MM.yyyy HH:mm\": ");
                LocalDateTime deadlineForTasksBefore = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                List<Task> tasksBeforeDeadline = taskManager.getTasksBetween(LocalDateTime.now(),deadlineForTasksBefore);
                if (tasksBeforeDeadline.isEmpty()) {
                    System.out.println("Задачи не найдены.");
                } else {
                    for (Task task : tasksBeforeDeadline) {
                        System.out.println(task);
                    }
                }
                break;
            case 3:
                System.out.print("Введите дату для поиска задач, которые должны быть выполнены после нее в формате \"dd.MM.yyyy HH:mm\": ");
                LocalDateTime searchDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                List<Task> tasksAfterDateTime = taskManager.getTasksAfter(searchDateTime);
                if (tasksAfterDateTime.isEmpty()) {
                    System.out.println("Задачи не найдены.");
                } else {
                    for (Task task : tasksAfterDateTime) {
                        System.out.println(task);
                    }
                }
                break;
            case 4:
                System.out.print("Введите приоритет задачи (LOW, MEDIUM, HIGH): ");
                Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                List<Task> tasksByPriority = taskManager.getTasksByPriority(priority);
                if (tasksByPriority.isEmpty()) {
                    System.out.println("Задачи не найдены.");
                } else {
                    for (Task task : tasksByPriority) {
                        System.out.println(task);
                    }
                }
                break;
            default:
                System.out.println("Некорректный выбор операции.");
                break;
        }
    }
}