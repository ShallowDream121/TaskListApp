package org.tasklist.view;

import java.util.List;
import org.tasklist.taskmanager.Task;

/**
 * 时间线视图类，继承自 {@link View}.
 * 提供时间线显示和任务显示功能，遵循单例模式。
 */
public class TimelineView extends View {
  /**
   * 单例模式中的唯一实例.
   */
  private static final TimelineView timelineView = new TimelineView();

  /**
   * 私有构造函数，防止外部实例化.
   */
  private TimelineView() {
  }

  /**
   * 获取 {@link TimelineView} 的唯一实例.
   *
   * @return 时间线视图对象的唯一实例
   */
  public static TimelineView getTimelineView() {
    return timelineView;
  }

  /**
   * 显示时间线视图.
   */
  public void displayTimeline() {
      // TODO -- 显示时间线（轴）
  }

  /**
   * 显示单个任务的信息.
   *
   * @param task 要显示的任务
   */
  @Override
  public void displayTask(Task task) {
      // TODO -- 实现时间线显示任务逻辑
  }

  /**
   * 显示任务列表的信息.
   *
   * @param taskList 要显示的任务列表
   */
  @Override
  public void displayTaskList(List<Task> taskList) {
      // TODO -- 实现时间线显示任务列表逻辑
  }
}
