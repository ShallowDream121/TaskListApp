package org.tasklist.reminder;

import java.time.*;

public abstract class Reminder {
    protected int id;
    protected String type;
    public LocalDateTime dueDate;
    public boolean isActive;

    public int getId() {
        return id;
    }

    public void activateReminder() {
        isActive = true;
    }

    public void deactivateReminder() {
        isActive = false;
    }

    public abstract void remind();
}

