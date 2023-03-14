package Seminar4;

import java.util.List;

public interface TaskExporter <T extends Task> {
    /**
     * @param tasks список задач для экспорта
     * @param filePath файл
     */
    void export(List<T> tasks, String filePath);

}

