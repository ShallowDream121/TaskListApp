package org.tasklist.label;

/**
 * 标签类，继承自 {@link Label} 类，表示任务的标签.
 * 该类用于标识任务的特定属性，可以通过标签对任务进行标记
 * 可根据需要扩展更多标签特定的逻辑
 */
public class Tag extends Label {
  /**
   * 传参构造函数.
   *
   * @param id 唯一标识符 //TODO 禁止自定义id，由系统统一分配
   * @param name 标签名称
   * @param description 标签描述
   */
  public Tag(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}