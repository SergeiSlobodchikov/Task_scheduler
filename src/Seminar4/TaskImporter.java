package Seminar4;

public interface TaskImporter {
    /**
     * @param filePath файл
     * @return импорт списка задач из файла.
     */
    List<Task> importTasks(String filePath);
}
