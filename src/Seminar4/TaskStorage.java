package Seminar4;

import java.util.List;

public interface TaskStorage {
    /**
     * @param task Добавляем новую задачу
     */
    void add(Task task);

    /**
     * @param id удаляем задачу по индефекатару
     */
    void remove(int id);

    /**
     * @param id получение задачи по индефекатару
     */
    Task getById(int id);

    /**
     * @return получение списка всех задач
     */
    List<Task> getAll();
}
