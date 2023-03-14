package Seminar4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        TaskManager<Task> taskManager = new TaskManager<>(new InMemoryTaskStorage(), new CsvTaskExporter(), new CsvTaskImporter());

        boolean quit = false;

        while (!quit) {
            // выводим список операций
            System.out.println("1. Добавить задачу");
            System.out.println("2. Изменить задачу");
            System.out.println("3. Посмотреть задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Просмотреть все задачи");
            System.out.println("6. Экспортировать задачи в файл");
            System.out.println("7. Импортировать задачи из файла");
            System.out.println("0. Выйти из приложения");
            System.out.println();

            // считываем ввод пользователя
            int choice = scanner.nextInt();
            scanner.nextLine(); // считываем оставшийся перевод строки
            int taskId;
            String fail;


            switch (choice) {
                case 1:
                    // добавляем задачу
                    System.out.print("Введите дату и время начала выполнения задачи в формате \"dd.MM.yyyy HH:mm\" : ");
                    LocalDateTime addedDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                    System.out.print("Введите дату и время окончания выполнения задачи в формате \"dd.MM.yyyy HH:mm\" : ");
                    LocalDateTime deadlineDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                    System.out.print("Введите приоритет задачи (LOW, MEDIUM, HIGH): ");
                    Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Введите имя автора задачи: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Введите описание задачи: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(addedDateTime, deadlineDateTime, priority, authorName, description);
                    break;
                case 2:
                    // изменяем задачу
                    System.out.print("Введите ID задачи, которую нужно изменить: ");
                    taskId = scanner.nextInt();
                    scanner.nextLine(); // считываем оставшийся перевод строки
                    Task taskToEdit = taskManager.getTaskById(taskId);
                    if (taskToEdit == null) {
                        System.out.println("Задача с таким ID не найдена.");
                    } else {
                        System.out.print("Введите новое описание задачи: ");
                        String newDescription = scanner.nextLine();
                        taskToEdit.setDescription(newDescription);
                        System.out.println("Задача успешно изменена.");
                    }
                    break;
                case 3:
                    System.out.println("Введите id задачи");
                    taskId = scanner.nextInt();
                    if (taskManager.getTaskById(taskId) == null){
                        System.out.println("Такой задачи нету");
                    } else System.out.println(taskManager.getTaskById(taskId));

                case 4:
                    System.out.println("Введите id задачи, которую нужно удалить");
                    taskId = scanner.nextInt();
                    if (taskManager.getTaskById(taskId) == null){
                        System.out.println("Такой задачи нету");
                    } else
                        System.out.println("Нажмите 1 для удаления :" + taskManager.getTaskById(taskId));
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            taskManager.removeTask(taskId);
                            System.out.println("Задача удалена.");
                        }
                    }

                    break;
                case 5:
                    List<Task> tasks = taskManager.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("Задачи не найдены.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Введите путь и файл для экспорта");
                    fail = scanner.next();
                    taskManager.exportTasks(fail);
                    break;
                case 7:
                    System.out.println("Введите путь и файл для импорта");
                    fail = scanner.next();
                    taskManager = taskManager.importTasks(fail);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте еще раз.");
                    break;
            }
        }
        scanner.close();
    }
}
