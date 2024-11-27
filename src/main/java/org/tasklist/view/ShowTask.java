package org.tasklist.view;

import java.util.List;
import org.tasklist.taskmanager.Task;

/**
 * 定义显示任务信息的接口.
 * 提供方法用于显示单个任务或任务列表。
 */
public interface ShowTask {
  /**
   * 显示单个任务的信息.
   *
   * @param task 要显示的任务对象
   */
  void displayTask(Task task);

  /**
   * 显示任务列表中任务的全部信息.
   *
   * @param taskList 要显示的任务列表
   */
  void displayTaskList(List<Task> taskList);
}
