package org.tasklist.view;

import java.util.*;
import org.tasklist.taskmanager.Task;

public interface ShowTask {
    void displayTask(Task task);
    void displayTaskList(List<Task> taskList);
}
