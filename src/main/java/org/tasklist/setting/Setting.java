package org.tasklist.setting;

import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.reminder.ReminderFactory;
import org.tasklist.taskmanager.TaskManager;

import java.util.*;

public class Setting {
    private List<Tag> tags = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public Tag getTag(int id) {
        for (Tag tag : tags) {
            if (tag.getId() == id) {
                return tag;
            }
        }
        return null;
    }

    public Category getCategory(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public boolean removeTag(Tag tag) {
        tags.remove(tag);
        //TODO
        return true;
    }

    public boolean removeCategory(Category category) {
        categories.remove(category);
        //TODO
        return true;
    }

    public void setReminderPermission(ReminderFactory reminderFactory, TaskManager manager) {
        //TODO
    }
}
