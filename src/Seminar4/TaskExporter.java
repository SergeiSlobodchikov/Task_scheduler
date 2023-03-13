package Seminar4;

public interface TaskExporter {
    /**
     * @param tasks список задач для экспорта
     * @param filePath файл
     */
    void export(List<Task> tasks, String filePath);
}
