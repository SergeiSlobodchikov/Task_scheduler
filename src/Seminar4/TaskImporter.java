package Seminar4;

import java.util.List;

public interface TaskImporter {
    /**
     * @param filePath файл
     * @return импорт списка задач из файла.
     */
    List<Task> importTasks(String filePath);
}
