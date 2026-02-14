package repository;

import entity.Project;

import java.time.LocalDate;

public interface ProjectRepository {
    void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, int userId);
    Project findByName(String projectName);
    Project findById(int projectId);
    Project updateByName(String projectName);
    Project updateById(int projectId);
    void delete(String projectName);
    int getRepositorySize();
    void printTasks(Project project);
    void printAllProjects();
}
