package org.tasklist.taskmanager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.reminder.Reminder;

/**
 * 任务类，表示一个任务的基本信息，包括标题、描述、截止日期、优先级、状态等.
 * 支持任务的标签、类别、子任务和提醒的添加修改。
 */
public class Task {
  /**
   * 任务ID，对于一个user是唯一的.
   */
  private int id;

  /**
   * 任务标题.
   */
  public String title;

  /**
   * 任务描述.
   */
  public String description;

  /**
   * 任务状态.
   */
  private TaskStatus status;

  /**
   * 任务的截止日期.
   */
  public LocalDateTime dueDate;

  /**
   * 任务的优先级.
   */
  public short priority;

  /**
   * 任务的标签列表.
   */
  public List<Tag> tags = new ArrayList<>();

  /**
   * 任务所属类别.
   */
  public Category category;

  /**
   * 任务的子任务列表.
   */
  public List<Task> childTasks = new ArrayList<>();

  /**
   * 任务的提醒设置.
   */
  public Reminder reminder;

  /**
   * 默认构造函数，用于创建一个新的任务.
   */
  public Task() {
    // TODO -- 提供基础的成员变量，具体内容由用户输入得到
  }

  /**
   * 带有任务基本信息的构造函数.
   *
   * @param id 任务 ID
   * @param title 任务标题
   * @param description 任务描述
   * @param dueDate 任务截止日期
   * @param priority 任务优先级
   */
  public Task(int id, String title, String description, LocalDateTime dueDate, short priority) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.priority = priority;
    this.status = TaskStatus.TODO; // 默认状态
  }

  /**
   * 获取任务ID.
   *
   * @return 任务ID
   */
  public int getId() {
    return id;
  }

  /**
   * 获取任务标题.
   *
   * @return 任务标题
   */
  public String getTitle() {
    return title;
  }

  /**
   * 设置任务标题.
   *
   * @param title 修改后的任务标题
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * 获取任务描述.
   *
   * @return 任务描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置任务描述.
   *
   * @param description 修改后的任务描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取任务状态.
   *
   * @return 任务状态
   */
  public TaskStatus getStatus() {
    return status;
  }

  /**
   * 设置任务状态.
   *
   * @param status 修改后的任务状态
   */
  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  /**
   * 获取任务的截止日期.
   *
   * @return 任务的截止日期
   */
  public LocalDateTime getDueDate() {
    return dueDate;
  }

  /**
   * 设置任务的截止日期.
   *
   * @param dueDate 修改后的任务的截止日期
   */
  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * 获取任务优先级.
   *
   * @return 任务优先级.
   */
  public short getPriority() {
    return priority;
  }

  /**
   * 设置任务优先级.
   *
   * @param priority 修改后的任务优先级。
   */
  public void setPriority(short priority) {
    this.priority = priority;
  }

  /**
   * 获取任务的标签列表.
   *
   * @return 任务的标签列表
   */
  public List<Tag> getTags() {
    return tags;
  }

  /**
   * 添加标签到任务.
   *
   * @param tag 要添加的标签。
   */
  public void addTag(Tag tag) {
    this.tags.add(tag);
  }

  /**
   * 从任务中移除标签.
   *
   * @param tag 要移除的标签
   */
  public void removeTag(Tag tag) {
    this.tags.remove(tag);
  }

  /**
   * 获取任务的类别.
   *
   * @return 任务的类别
   */
  public Category getCategory() {
    return category;
  }

  /**
   * 设置任务的类别.
   *
   * @param category 修改后的任务的类别。
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * 获取任务的子任务列表.
   *
   * @return 任务的子任务列表
   */
  public List<Task> getChildTasks() {
    return childTasks;
  }

  /**
   * 添加子任务到任务.
   *
   * @param childTask 要添加的子任务。
   */
  public void addChildTask(Task childTask) {
    this.childTasks.add(childTask);
  }

  /**
   * 根据子任务ID获取子任务.
   *
   * @param childTaskId 子任务ID
   * @return 子任务，若没有找到则返回 null
   */
  public Task getChildTask(int childTaskId) {
    for (Task childTask : childTasks) {
      if (childTask.getId() == childTaskId) {
        return childTask;
      }
    }
    // 若没有找到子任务，返回 null。
    return null;
  }

  /**
   * 从任务中移除子任务.
   *
   * @param childTask 要移除的子任务
   */
  public void removeChildTask(Task childTask) {
    this.childTasks.remove(childTask);
  }

  /**
   * 根据子任务ID从任务中移除子任务.
   *
   * @param childTaskId 要移除的子任务ID.
   */
  public void removeChildTask(int childTaskId) {
    this.childTasks.removeIf(task -> task.getId() == childTaskId);
  }

  /**
   * 获取任务的提醒设置.
   *
   * @return 任务的提醒器
   */
  public Reminder getReminder() {
    return reminder;
  }

  /**
   * 设置任务的提醒设置.
   *
   * @param reminder 添加的任务的提醒器
   */
  public void setReminder(Reminder reminder) {
    this.reminder = reminder;
  }

  @Override
  public String toString() {
    return id + " " + title + " " + description;
  }
}
