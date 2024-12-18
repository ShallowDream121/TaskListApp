package org.tasklist.user;

import java.time.LocalDateTime;

/**
 * 表示用户的设备.
 * 包含设备的基本信息以及授权和同步状态。
 */
public class Device {
  /**
   * 设备的唯一ID.
   */
  public int deviceId;

  /**
   * 设备名称.
   */
  public String deviceName;

  /**
   * 设备的类型.
   */
  public String deviceType;

  /**
   * 设备的最后一次同步时间.
   */
  public LocalDateTime lastSyncTime;

  /**
   * 表示设备是否已被授权.
   */
  private boolean isAuthorized;

  /**传参构造函数.
   *
   * @param id 标识符
   * @param name 设备名称
   */
  public Device(int id, String name) {
    this.deviceId = id;
    this.deviceName = name;
  }

  /**
   * 授权该设备.
   * 设置设备为已授权状态。
   */
  public void authorizeDevice() {
    this.isAuthorized = true;
  }

  /**
   * 撤销该设备的授权.
   * 设置设备为未授权状态。
   */
  public void unauthorizeDevice() {
    this.isAuthorized = false;
  }

  /** 获取设备的唯一ID.
   *
   * @return 设备ID
   */
  public int getDeviceId() {
    return deviceId;
  }
}

