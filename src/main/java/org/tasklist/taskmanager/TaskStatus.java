package org.tasklist.taskmanager;

/**
 * 任务状态枚举类.
 * 用于表示任务的不同状态。
 * 可展示在任务信息中，并进行相关的修改。
 */
public enum TaskStatus {
  /**
   * 任务待办状态，表示任务尚未开始.
   */
  TODO,

  /**
   * 任务进行中状态，表示任务正在处理.
   */
  IN_PROGRESS,

  /**
   * 任务完成状态，表示任务已完成.
   */
  DONE
}