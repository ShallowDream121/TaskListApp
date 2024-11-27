package org.tasklist.view;

import org.tasklist.label.Label;

/**
 * 抽象类 View，用于展示任务视图.
 * 实现了 {@link ShowTask} 接口，包含任务的显示功能。
 * 提供筛选功能，可实现任务的筛选展示。
 */
public abstract class View implements ShowTask {

  /**
   * 根据指定的标签对任务进行筛选.
   *
   * @param label 筛选依据的标签
   */
  public void filter(Label label) {
      // 筛选逻辑
  }
}
