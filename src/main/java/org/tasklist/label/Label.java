package org.tasklist.label;

/**
 * 标签抽象类，表示一个标签对象，用于标识任务的tag或category.
 * 包含标签的基本属性
 */
public abstract class Label {

  /**
   * 标签的唯一标识符.
   */
  protected int id;

  /**
   * 标签的名称.
   */
  public String name;

  /**
   * 标签的描述信息.
   */
  public String description;

  /**
   * 获取标签的ID.
   *
   * @return 标签的ID
   */
  public int getId() {
    return id;
  }
}