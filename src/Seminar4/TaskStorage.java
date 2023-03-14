package Seminar4;

import java.util.List;

public interface TaskStorage<T extends Task> {
    /**
     * @param task Добавляем новую задачу
     */
    void add(T task);

    /**
     * @param id удаляем задачу по индефекатару
     */
    void remove(int id);

    /**
     * @param id получение задачи по индефекатару
     */
    T getById(int id);

    /**
     * @return получение списка всех задач
     */
    List<T> getAll();
}
