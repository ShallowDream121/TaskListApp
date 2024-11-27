package org.tasklist.reminder;

/**
 * 闹钟提醒类，继承自 `Reminder` 类，表示基于闹钟的提醒器.
 * 实现了具体的提醒逻辑，使用闹钟响铃作为提醒的方式
 */
public class AlarmReminder extends Reminder {

  /**
   * 实现具体的闹钟提醒器逻辑.
   * 通过响铃或振动发出提醒。
   */
  @Override
  public void remind() {
    // TODO：实现具体的闹钟提醒
  }
}