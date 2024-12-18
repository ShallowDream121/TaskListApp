package org.tasklist.user;

import java.util.ArrayList;
import java.util.List;

/** Server类，用于创建远程服务器实例，通过实例在本地进行初始界面的操作--登录、注册等操作.
 */
public class Server {
  private final List<User> users = new ArrayList<>();

  /** 用户注册函数.
   *
   * @param username 用户昵称，可用于登录
   * @param password 用户密码，用于验证登录
   * @param email 用户邮箱，与昵称功能相同
   * @return 注册成功返回 {@code true}
   */
  public boolean registerUser(String username, String password, String email) {
    // 检查用户名是否已存在
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        System.out.println("username already exists.");
        return false;
      } else if (user.getEmail().equals(email)) {
        System.out.println("email has already registered.");
        return false;
      }
    }
    User newUser = new User(username, password, email);
    users.add(newUser);
    return true;
  }

  /** 用户注销函数，本地执行注销操作后，需要与server端交互.
   *
   * @param user 用户对象实例，需要注销的对象
  */
  public void unregisterUser(User user) {
    users.remove(user);
  }

  /**用户登录函数，通过用户名登录.
  *
  * @param username 用户输入的昵称
  * @param password 用户输入的密码
  * @return 返回服务器查询验证后的user实例，用于后续app的操作
  */
  public User loginUser(String username, String password) {
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        if (user.getPassword().equals(password)) {
          return user;
        } else {
          System.out.println("wrong password.");
          return null;
        }
      }
    }
    System.out.println("wrong username.");
    return null;
  }

  /**用户登录函数，通过用户邮箱登录.
   *
   * @param email 用户输入的邮箱
   * @param password 用户输入的密码
   * @return 返回服务器查询验证后的user实例，用于后续app的操作
   */
  public User loginUserByEmail(String email, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        if (user.getPassword().equals(password)) {
          return user;
        } else {
          System.out.println("wrong password.");
          return null;
        }
      }
    }
    System.out.println("wrong email.");
    return null;
  }

  /**用户登出函数，与远程服务器交互，存储更新后的user数据.
   *
   * @param user 需要登出（更新数据）的user实例
   * @return 服务器更新成功后返回 {@code true}
   */
  public boolean logoutUser(User user) {
    // TODO -- 保存user数据，上传给云端服务器
    // 简化处理，返回 true
    return true;
  }

  /**用户数据更新函数，用于在登出之前进行周期性的更新保存，保证多平台多设备的数据同步功能.
   *
   * @param user 需要更新数据的user实例，本地设备登录期间唯一user
   * @return 云端数据同步成功返回 {@code true}
   */
  public boolean updateUser(User user) {
    // TODO -- Update user logic
    // 简化处理，返回 true
    return true;
  }
}

