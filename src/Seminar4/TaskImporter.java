package Seminar4;

import java.util.List;

public interface TaskImporter <T extends Task> {
    /**
     * @param filePath файл
     * @return импорт списка задач из файла.
     */
    TaskManager<T> importTasks(String filePath);
}
