package org.tasklist.reminder;

import java.time.LocalDateTime;

/**
 * 提醒器类的抽象基类，表示任务的提醒器.
 * 提供启用和禁用提醒器的基本操作，子类需要实现具体的提醒逻辑。
 */
public abstract class Reminder {
  /**
   * 提醒器的唯一标识符.
   */
  protected int id;

  /**
   * 提醒器的类型（通知栏提醒/闹钟提醒）.
   */
  protected String type;

  /**
   * 提醒器时间.
   */
  public LocalDateTime dueDate;

  /**
   * 提醒器是否处于激活状态.
   */
  public boolean isActive;

  /**
   * 获取提醒器的ID.
   *
   * @return 提醒器ID
   */
  public int getId() {
    return id;
  }

  /**
   * 激活提醒器，将提醒状态设置为激活.
   */
  public void activateReminder() {
    isActive = true;
  }

  /**
   * 禁用提醒器，将提醒状态设置为禁用.
   */
  public void deactivateReminder() {
    isActive = false;
  }

  /**
   * 子类需要实现的具体提醒逻辑.
   */
  public abstract void remind();
}

