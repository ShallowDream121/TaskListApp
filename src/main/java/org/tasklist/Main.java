package org.tasklist;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.taskmanager.Task;
import org.tasklist.taskmanager.TaskManager;
import org.tasklist.taskmanager.TaskStatus;
import org.tasklist.user.Server;
import org.tasklist.user.User;

import static org.tasklist.taskmanager.TaskStatus.*;

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
    Scanner scanner = new Scanner(System.in);
    TaskManager taskManager = new TaskManager();
    User user = new User("default_user", "password", "email@example.com");

    System.out.println("欢迎使用任务单App!");

    while (true) {
      System.out.println("\n==== 任务单App ====");
      System.out.println("1. 任务管理");
      System.out.println("2. 任务视图");
      System.out.println("3. 用户中心");
      System.out.println("4. 退出");
      System.out.print("请输入操作编号：");

      int choice = scanner.nextInt();
      scanner.nextLine(); // 清除换行符

      switch (choice) {
        case 1:
          taskManagement(taskManager, scanner);
          break;
        case 2:
          taskView(taskManager);
          break;
        case 3:
          userCenter(user, scanner);
          break;
        case 4:
          System.out.println("感谢使用任务单App，再见！");
          return;
        default:
          System.out.println("无效的选项，请重新输入！");
      }
    }
  }

  /**
   * 任务管理模块.
   */
  private static void taskManagement(TaskManager taskManager, Scanner scanner) {
    while (true) {
      System.out.println("\n==== 任务管理 ====");
      System.out.println("1. 创建任务");
      System.out.println("2. 删除任务");
      System.out.println("3. 查询任务");
      System.out.println("4. 更新任务");
      System.out.println("5. 加入label");
      System.out.println("6. 返回上一级");
      System.out.print("请输入操作编号：");

      int choice = scanner.nextInt();
      scanner.nextLine(); // 清除换行符

      switch (choice) {
        case 1:
          System.out.println("请输入任务id：");
          int id = Integer.parseInt(scanner.nextLine()); // 读取任务id
          //TODO 系统分配id

          System.out.print("请输入任务标题：");
          String title = scanner.nextLine(); // 读取任务标题

          System.out.print("请输入任务描述：");
          String description = scanner.nextLine(); // 读取任务描述

          System.out.print("请输入任务截止日期 (格式：yyyy-MM-dd HH:mm)：");
          String deadlineInput = scanner.nextLine(); // 读取截止日期
          LocalDateTime dueDate;
          try {
            dueDate = LocalDateTime.parse(deadlineInput.replace(" ", "T")); // 转换为 LocalDateTime
          } catch (Exception e) {
            System.out.println("日期格式错误，请使用格式：yyyy-MM-dd HH:mm");
            break;
          }

          System.out.print("请输入任务优先级 (1-高, 2-中, 3-低)：");
          short priority;
          try {
            priority = Short.parseShort(scanner.nextLine()); // 将字符串转换为 short
            if (priority < 1 || priority > 3) {
              System.out.println("优先级必须为 1（高）、2（中）或 3（低）！");
              break;
            }
          } catch (NumberFormatException e) {
            System.out.println("优先级输入错误，请输入数字 1、2 或 3！");
            break;
          }
          Task task = new Task(id, title, description, dueDate, priority);

          // 添加任务到任务管理器
          taskManager.addTask(task);

          System.out.println("任务创建成功！");
          break;
        case 2:
          System.out.print("请输入要删除的任务id：");
          int taskToRemove = Integer.parseInt(scanner.nextLine());
          Task removedTask = taskManager.getTask(taskToRemove);
          if (removedTask != null) {
            taskManager.removeTask(removedTask);
            System.out.println("任务删除成功！");
          } else {
            System.out.println("未找到该任务！");
          }
          break;
        case 3:
          System.out.println("\n当前任务列表：");
          taskManager.getTasks().forEach(System.out::println);
          break;
        case 4:
          {
          System.out.println("请输入要更新的任务id：");
          int taskToUpdate = Integer.parseInt(scanner.nextLine());

          Task task1 = taskManager.getTask(taskToUpdate);
          if (task1 == null) {
            System.out.println("Task不存在");
            break;
          }
          String newTitle = null;
          String newDes = null;
          int prio = 9;
          TaskStatus news = null;
          boolean flag = true;
          while (flag) {
            System.out.println("如果修改标题，请输入1.");
            System.out.println("如果修改描述，请输入2.");
            System.out.println("如果修改优先级，请输入3.");
            System.out.println("如果修改状态，请输入4.");
            System.out.println("修改完成，请输入5.");
            int c = scanner.nextInt();
            scanner.nextLine();

            switch (c) {
              case 1 -> {
                System.out.println("输入修改后的标题：");
                newTitle = scanner.nextLine();
              }
              case 2 -> {
                System.out.println("输入修改后的描述：");
                newDes = scanner.nextLine();
              }
              case 3 -> {
                System.out.println("输入修改后的优先级：");
                prio = Integer.parseInt(scanner.nextLine());
              }
              case 4 -> {
                System.out.println("输入修改后的状态：TODO = 1;IN_PROGRESS = 2;DONE = 3");
                int res = Integer.parseInt(scanner.nextLine());
                switch (res) {
                  case 1 -> news = TODO;
                  case 2 -> news = IN_PROGRESS;
                  case 3 -> news = DONE;
                  default -> news = null;
                }
              }
              case 5 -> {
                taskManager.updateTask(task1, newTitle, newDes, null, (short) prio, news);
                flag = false;
              }
              default -> System.out.println("非法输入.");
            }
          }
          break;
          }
        case 5:
          {
          System.out.println("请输入要加label的任务id：");
          int TaskId = scanner.nextInt();
          scanner.nextLine();
          Task task2 = taskManager.getTask(TaskId);
          if (task2 == null) {
            System.out.println("任务不存在.");
            continue;
          }

          System.out.println("请输入加入的标签名");
          String tag = scanner.nextLine();
          Tag t = new Tag(1, tag, "");
          task2.addTag(t);
          break;
          }
        case 6:
          return;
        default:
          System.out.println("无效的选项，请重新输入！");
      }
    }
  }

  /**
   * 任务视图模块.
   */
  private static void taskView(TaskManager taskManager) {
    System.out.println("\n==== 任务视图 ====");
    System.out.println("显示任务：");
    System.out.println("未实现ui视图");
  }

  /**
   * 用户中心模块.
   */
  private static void userCenter(User user, Scanner scanner) {
    while (true) {
      System.out.println("\n==== 用户中心 ====");
      System.out.println("1. 查看用户信息");
      System.out.println("2. 修改用户名");
      System.out.println("3. 修改密码");
      System.out.println("4. 修改邮箱");
      System.out.println("5. 返回上一级");
      System.out.print("请输入操作编号：");

      int choice = scanner.nextInt();
      scanner.nextLine(); // 清除换行符

      switch (choice) {
        case 1:
          System.out.println("用户名：" + user.getUsername());
          System.out.println("邮箱：" + user.getEmail());
          break;
        case 2:
          System.out.print("请输入新的用户名：");
          user.changeUsername(scanner.nextLine());
          System.out.println("用户名修改成功！");
          break;
        case 3:
          System.out.print("请输入新的密码：");
          user.changePassword(scanner.nextLine());
          System.out.println("密码修改成功！");
          break;
        case 4:
          System.out.print("请输入新的邮箱地址：");
          user.changeEmail(scanner.nextLine());
          System.out.println("邮箱修改成功！");
          break;
        case 5:
          return;
        default:
          System.out.println("无效的选项，请重新输入！");
      }
    }
  }
}

