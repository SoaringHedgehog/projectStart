package service;

import repository.TaskRepository;

public class TaskService {
    private TaskRepository tr;

    public TaskService(){
        this.tr = new TaskRepository();
    }
}
