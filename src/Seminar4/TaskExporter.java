package Seminar4;

import java.util.List;

public interface TaskExporter {
    /**
     * @param tasks список задач для экспорта
     * @param filePath файл
     */
    void export(List<Task> tasks, String filePath);

}
