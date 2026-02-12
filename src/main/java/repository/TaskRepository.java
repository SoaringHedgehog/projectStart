package repository;

import entity.Task;

import java.time.LocalDate;

public interface TaskRepository {
    void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish);
    Task findByName(String taskName);
    Task findById(int projectId);
    void updateByName(String taskName);
    void updateById(int taskId);
    void deleteByName(String taskName);
    int getRepositorySize();
    void printTask(String taskName);
}
