package org.tasklist.reminder;

import java.time.LocalDateTime;

/**
 * 提醒器工厂类，用于创建不同类型的提醒器（闹钟提醒器、通知提醒器）.
 * 该类实现了单例模式，确保全局只有一个实例
 */
public class ReminderFactory {
  /**
   * 提醒器工厂的唯一实例.
   */
  private static final ReminderFactory reminderFactory = new ReminderFactory();

  /**
   * 闹钟提醒器权限.
   */
  private boolean alarmPermission;

  /**
   * 通知栏提醒器权限.
   */
  private boolean notificationPermission;

  /**
   * 私有构造函数，防止外部直接实例化.
   */
  private ReminderFactory() {
  }

  /**
   * 获取提醒器工厂的唯一实例.
   *
   * @return 提醒器工厂的唯一实例
   */
  public static ReminderFactory getFactory() {
    return reminderFactory;
  }

  /**
   * 根据类型创建提醒器对象.
   * 如果类型是 "alarm" 且允许创建闹钟提醒，则返回一个闹钟提醒实例。
   * 如果类型是 "notification" 且允许创建通知提醒，则返回一个通知提醒实例。
   * 如果类型不匹配或权限未开启，则返回 null。
   * TODO -- 提醒器创建逻辑待完善
   *
   * @param type 提醒器的类型，可以是 "alarm" 或 "notification"
   * @param dueDate 提醒时间
   * @return 对应类型的提醒器对象，或 null 如果类型不匹配或权限未开启等错误
   */
  public Reminder createReminder(String type, LocalDateTime dueDate) {
    if (type.equalsIgnoreCase("alarm") && alarmPermission) {
      AlarmReminder alarmReminder = new AlarmReminder();
      alarmReminder.dueDate = dueDate;
      return alarmReminder;
    } else if (type.equalsIgnoreCase("notification") && notificationPermission) {
      NotificationReminder notificationReminder = new NotificationReminder();
      notificationReminder.dueDate = dueDate;
      return notificationReminder;
    }
    return null;
  }

  /**
   * 设置闹钟提醒器权限.
   *
   * @param permission 修改后的权限
   */
  public void setAlarmPermission(boolean permission) {
    alarmPermission = permission;
  }

  /**
   * 设置通知栏提醒器权限.
   *
   * @param permission 修改后的权限
   */
  public void setNotificationPermission(boolean permission) {
    notificationPermission = permission;
  }
}

