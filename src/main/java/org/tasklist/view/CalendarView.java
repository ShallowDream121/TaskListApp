package org.tasklist.view;

import java.util.*;
import org.tasklist.taskmanager.Task;

public class CalendarView extends View {
    private static final CalendarView calendarView = new CalendarView();

    private CalendarView() {
    }

    public static CalendarView getCalendarView() {
        return calendarView;
    }

    public void displayCalendar() {
        //TODO
    }

    @Override
    public void displayTask(Task task) {
        //TODO
    }

    @Override
    public void displayTaskList(List<Task> taskList) {
        //TODO
    }
}
