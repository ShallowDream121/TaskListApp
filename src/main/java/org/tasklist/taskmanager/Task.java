package org.tasklist.taskmanager;

import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.reminder.Reminder;
import org.tasklist.user.User;
import java.time.*;
import java.util.*;

public class Task {
    private int id;
    public String title;
    public String description;
    private TaskStatus status;
    public LocalDateTime dueDate;
    public short priority;
    public List<Tag> tags = new ArrayList<>();
    public Category category;
    private User assignee;
    public List<Task> childTasks = new ArrayList<>();
    public Reminder reminder;

    public Task(){
        //TODO
    }
    public Task(int id, String title, String description, LocalDateTime dueDate, short priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.TODO; // 默认状态为 todo
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public short getPriority() {
        return priority;
    }

    public void setPriority(short priority) {
        this.priority = priority;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Task> getChildTasks() {
        return childTasks;
    }

    public void addChildTask(Task childTask) {
        this.childTasks.add(childTask);
    }

    public Task getChildTask(int childTaskID){
        for(int i=0;i<childTasks.size();i++){
            if(childTasks.get(i).getId()==childTaskID){
                return childTasks.get(i);
            }
        }
        //if not found TODO
        return null;
    }

    public void removeChildTask(Task childTask) {
        this.childTasks.remove(childTask);
    }
    public void removeChildTask(int childTaskID) {
        this.childTasks.removeIf(task->task.getId()==childTaskID);
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
