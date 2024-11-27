package org.tasklist.view;

import java.util.List;
import org.tasklist.taskmanager.Task;

/**
 * 日历视图类，继承自 {@link View}.
 * 提供日历显示和任务显示功能，单例模式。
 */
public class CalendarView extends View {
  /**
   * 单例模式中的唯一实例.
   */
  private static final CalendarView calendarView = new CalendarView();

  /**
   * 私有构造函数，防止外部实例化.
   */
  private CalendarView() {
  }

  /**
   * 获取 {@link CalendarView} 的唯一实例.
   *
   * @return 日历视图的唯一实例
   */
  public static CalendarView getCalendarView() {
    return calendarView;
  }

  /**
   * 显示日历视图.
   */
  public void displayCalendar() {
      // TODO -- 显示日历视图
  }

  /**
   * 显示单个任务的信息.
   * 实现ShowTask接口
   *
   * @param task 要显示的任务
   */
  @Override
  public void displayTask(Task task) {
      // TODO -- 实现日历的显示逻辑
  }

  /**
   * 显示任务列表的信息.
   * 实现ShowTask接口
   *
   * @param taskList 要显示的任务列表
   */
  @Override
  public void displayTaskList(List<Task> taskList) {
      // TODO -- 实现日历的人物列表显示逻辑
  }
}
