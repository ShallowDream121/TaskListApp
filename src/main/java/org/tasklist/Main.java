package org.tasklist;

import java.time.LocalDateTime;
import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.taskmanager.Task;
import org.tasklist.taskmanager.TaskManager;
import org.tasklist.user.Server;
import org.tasklist.user.User;

/**
 * 入口类Main.
 */
public class Main {
  /**
   * 入口函数.
   *
    * @param args 参数列表
   */
  public static void main(String[] args) {
    // 创建服务器实例
    Server server = new Server();

    // 创建用户实例
    User user = new User("john_doe", "password123", "john.doe@example.com");

    // 创建任务管理器实例
    TaskManager taskManager = new TaskManager();

    // 创建标签和类别实例
    Tag tag = new Tag();  // 这里可以设置标签的属性
    Category category = new Category();  // 这里可以设置类别的属性

    // 创建任务实例
    Task task = new Task(1, "Complete Project", "Finish the project by end of the week",
        LocalDateTime.now().plusDays(7), (short) 1);

    // 任务管理器添加任务
    taskManager.addTask(task);

    // 输出成功信息
    System.out.println("build success!");
  }
}

