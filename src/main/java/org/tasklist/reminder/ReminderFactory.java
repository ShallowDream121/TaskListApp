package org.tasklist.reminder;

import java.time.*;

public class ReminderFactory {
    private static final ReminderFactory reminderFactory = new ReminderFactory();
    private boolean alarmPermission;
    private boolean notificationPermission;

    private ReminderFactory() {
    }

    public static ReminderFactory getFactory() {
        return reminderFactory;
    }

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

    public void setAlarmPermission(boolean permission) {
        alarmPermission = permission;
    }

    public void setNotificationPermission(boolean permission) {
        notificationPermission = permission;
    }
}

