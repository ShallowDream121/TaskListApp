package org.tasklist.reminder;

/**
 * 通知提醒类，继承自 `Reminder` 类，表示基于通知栏的提醒器.
 * 实现了具体的提醒逻辑，发送通知作为提醒的方式。
 */
public class NotificationReminder extends Reminder {

  /**
   * 实现具体的通知提醒逻辑.
   * 通过弹出通知来提醒用户
   */
  @Override
  public void remind() {
    // TODO：实现具体的通知提醒，弹出消息
  }
}
