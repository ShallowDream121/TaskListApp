package org.tasklist.label;

/**
 * 类别类，继承自 {@link Label} 类，表示任务的类别标签.
 * 该类用于对任务进行分类，提供了标签的基本功能，可根据需要扩展更多类别特定的逻辑
 */
public class Category extends Label {
  /** 传参构造函数.
   *
   * @param id  唯一标识符 //TODO 禁止自定义id，由系统统一分配
   * @param name 类别名称
   * @param description 类别描述
   */
  public Category(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}