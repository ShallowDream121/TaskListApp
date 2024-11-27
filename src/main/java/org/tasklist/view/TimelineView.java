package org.tasklist.view;

import java.util.*;
import org.tasklist.taskmanager.Task;

public class TimelineView extends View {
    private static final TimelineView timelineView = new TimelineView();

    private TimelineView() {
    }

    public static TimelineView getTimelineView() {
        return timelineView;
    }

    public void displayTimeline() {
        // Display logic
    }

    @Override
    public void displayTask(Task task) {
        // Task display logic
    }

    @Override
    public void displayTaskList(List<Task> taskList) {
        // Task list display logic
    }
}
