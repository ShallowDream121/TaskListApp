package org.tasklist.taskmanager;

import java.time.LocalDateTime;
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
   *
   * @param task 要更新的任务
   * @param newTitle 新的标题 (可为 null，表示不更新)
   * @param newDescription 新的描述 (可为 null，表示不更新)
   * @param newDueDate 新的截止日期 (可为 null，表示不更新)
   * @param newPriority 新的优先级 (可为 -1，表示不更新)
   * @param newStatus 新的任务状态 (可为 null，表示不更新)
   */
  public void updateTask(Task task, String newTitle, String newDescription,
                         LocalDateTime newDueDate, short newPriority, TaskStatus newStatus) {
    if (task == null) {
      throw new IllegalArgumentException("任务不能为空！");
    }

    // 更新标题
    if (newTitle != null) {
      task.setTitle(newTitle);
    }

    // 更新描述
    if (newDescription != null) {
      task.setDescription(newDescription);
    }

    // 更新截止日期
    if (newDueDate != null) {
      task.setDueDate(newDueDate);
    }

    // 更新优先级
    if (newPriority >= 1 && newPriority <= 3) {
      task.setPriority(newPriority);
    }

    // 更新状态
    if (newStatus != null) {
      task.setStatus(newStatus);
    }
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