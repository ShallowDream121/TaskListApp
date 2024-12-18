package org.tasklist.user;

import java.util.ArrayList;
import java.util.List;
import org.tasklist.setting.Setting;
import org.tasklist.taskmanager.TaskManager;

/**
 * 表示系统和本地客户端的用户.
 * 直接提供管理用户信息、授权设备管理的功能。
 * 通过TaskManager和setting间接管理任务和设置。
 */
public class User {
  /** 用户的唯一ID.
   * 暂时使用long
  */
  private long id;

  /**
   * 用户名/昵称.
   */
  private String username;

  /**
   * 用户密码.
   */
  private String password;

  /**
   * 用户的电子邮箱地址.
   */
  private String email;

  /**
   * 授权的设备列表.
   */
  private final List<Device> authorizedDevices = new ArrayList<>();

  /**
   * 与用户关联的任务管理器.
   */
  private TaskManager taskManager;

  /**
   * 用户的设置.
   */
  private Setting setting;

  /**
   * 使用指定的用户名、密码和邮箱构造用户对象.
   *
   * @param username 用户名
   * @param password 密码
   * @param email    电子邮箱地址
   */
  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  /** 通过用户名、TaskManager和Setting对象构造用户对象.
   * 服务器端使用的构造函数
   *
   * @param username    用户名
   * @param taskManager 任务管理器实例
   * @param setting     设置实例
   */
  public User(String username, TaskManager taskManager, Setting setting) {
    this.username = username;
    this.taskManager = taskManager;
    this.setting = setting;
  }

  /** 获取用户名.
   *
   * @return user实例的用户名
   */
  public String getUsername() {
    return username;
  }

  /** 获取电子邮箱地址.
   *
   * @return 电子邮箱地址
   */
  public String getEmail() {
    return email;
  }

  /** 修改用户密码.
   *
   * @param password 新密码
   * @return 如果密码修改成功，返回 {@code true}
   */
  public boolean changePassword(String password) {
    // TODO -- 添加密码修改逻辑
    this.password = password;
    return true;
  }

  /** 修改用户名.
   *
   * @param username 新用户名
   * @return 如果用户名修改成功，返回 {@code true}
   */
  public boolean changeUsername(String username) {
    // TODO -- 添加用户名修改逻辑
    this.username = username;
    return true;
  }

  /** 修改电子邮箱地址.
   *
   * @param email 新的电子邮箱地址
   * @return 如果邮箱修改成功，返回 {@code true}
   */
  public boolean changeEmail(String email) {
    // TODO -- 添加邮箱修改逻辑
    this.email = email;
    return true;
  }

  /** 获取任务管理器实例.
   *
   * @return 任务管理器
   */
  public TaskManager getTaskManager() {
    return taskManager;
  }

  /** 获取用户设置.
   *
   * @return 用户设置实例
   */
  public Setting getSetting() {
    return setting;
  }

  /** 根据设备ID撤销设备的授权.
   *
   * @param deviceId 要撤销授权的设备 ID
   */
  public void unauthorizeDevice(int deviceId) {
    authorizedDevices.removeIf(device -> device.getDeviceId() == deviceId);
  }

  public List<Device> getDevices() {
    return authorizedDevices;
  }

  /** getter函数，获得密码.
   *
   * @return 用户密码
   */
  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true; // 如果两个对象是同一个引用
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false; // 如果类型不匹配
    }
    User user = (User) obj;
    return username.equals(user.username) && email.equals(user.email); // 根据username和email来判断是否相等
  }
}