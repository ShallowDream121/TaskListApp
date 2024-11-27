package org.tasklist.setting;

import java.util.ArrayList;
import java.util.List;
import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.reminder.ReminderFactory;
import org.tasklist.taskmanager.TaskManager;

/**
 * 设置类，管理任务相关的标签和分类.
 * 提供对标签和分类的增、查、删操作
 * 设置功能有待完善
 */
public class Setting {
  /**
   * 存储用户定义的标签的列表.
   */
  private List<Tag> tags = new ArrayList<>();

  /**
   * 存储用户定义的分类的列表.
   */
  private List<Category> categories = new ArrayList<>();

  /**
   * 根据标签ID获取标签.
   *
   * @param id 标签ID
   * @return 找到的标签，如果没有找到则返回 null
   */
  public Tag getTag(int id) {
    for (Tag tag : tags) {
      if (tag.getId() == id) {
        return tag;
      }
    }
    return null;
  }

  /**
   * 根据分类ID获取分类.
   *
   * @param id 分类ID
   * @return 找到的分类，如果没有找到则返回 null
   */
  public Category getCategory(int id) {
    for (Category category : categories) {
      if (category.getId() == id) {
        return category;
      }
    }
    return null;
  }

  /**
   * 向设置中添加一个标签.
   *
   * @param tag 要添加的标签
   */
  public void addTag(Tag tag) {
    tags.add(tag);
  }

  /**
   * 向设置中添加一个分类.
   *
   * @param category 要添加的分类
   */
  public void addCategory(Category category) {
    categories.add(category);
  }

  /**
   * 从设置中移除指定的标签.
   *
   * @param tag 要移除的标签
   * @return 如果标签存在并成功移除或标签本来不存在，则返回 {@code true}；否则返回 {@code false}
   */
  public boolean removeTag(Tag tag) {
    return tags.removeIf(tagIt -> tagIt.equals(tag));
  }

  /**
   * 从设置中移除指定的分类.
   *
   * @param category 要移除的分类
   * @return 如果分类存在并成功移除或分类本来不存在，则返回 {@code true}；否则返回 {@code false}
   */
  public boolean removeCategory(Category category) {
    return categories.removeIf(cateIt -> cateIt.equals(category));
  }

  /**
   * 设置提醒权限.
   * 目前为占位方法，具体提醒权限及接口声明待完善
   *
   * @param reminderFactory 提醒工厂，用于创建提醒实例
   * @param taskManager 任务管理器，用于管理任务
   */
  public void setReminderPermission(ReminderFactory reminderFactory, TaskManager taskManager) {
    //TODO -- 设置提醒权限的逻辑
  }
}
