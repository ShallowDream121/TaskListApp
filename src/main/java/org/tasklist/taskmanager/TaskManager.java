package org.tasklist.taskmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务管理器类，负责管理任务的增、删、查和更新操作.
 * 提供对任务列表的基本操作接口。
 */
public class TaskManager {
  /**
   * 存储任务的列表.
   */
  private final List<Task> tasks = new ArrayList<>();

  /**
   * 添加一个新的任务到任务列表中.
   *
   * @param task 要添加的任务
   */
  public void addTask(Task task) {
    tasks.add(task);
  }

  /**
   * 从任务列表中移除指定的任务.
   *
   * @param task 要移除的任务
   */
  public void removeTask(Task task) {
    tasks.remove(task);
  }

  /**
   * 根据任务 ID 从任务列表中移除指定的任务.
   *
   * @param taskId 任务ID
   */
  public void removeTask(int taskId) {
    tasks.removeIf(task -> task.getId() == taskId);
  }

  /**
   * 更新指定的任务.
   * 当前为占位方法，具体更新接口待完善。
   *
   * @param task 要更新的任务
   */
  public void updateTask(Task task) {
      // TODO -- 更新逻辑，对不同的信息的更新接口由Task类实现
  }

  /**
   * 根据任务ID获取任务.
   *
   * @param taskId 要查找的任务ID.
   * @return 找到的任务，如果没有找到则返回 null
   */
  public Task getTask(int taskId) {
    for (Task task : tasks) {
      if (task.getId() == taskId) {
        return task;
      }
    }
    return null;
  }

  /**
   * 获取所有任务列表.
   *
   * @return 当前任务列表
   */
  public List<Task> getTasks() {
    return tasks;
  }
}