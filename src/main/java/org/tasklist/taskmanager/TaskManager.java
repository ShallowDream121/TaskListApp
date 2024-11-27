package org.tasklist.taskmanager;

import java.util.*;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
    public void removeTask(int taskID){
        tasks.removeIf(task->task.getId()==taskID);
    }

    public void updateTask(Task task) {
        // Update logic
    }

    public Task getTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
