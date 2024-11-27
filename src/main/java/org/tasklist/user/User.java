package org.tasklist.user;
import org.tasklist.setting.Setting;
import org.tasklist.taskmanager.TaskManager;

import java.util.*;

public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private List<Device> authorizedDevices = new ArrayList<>();
    private TaskManager taskManager = new TaskManager();
    private Setting setting = new Setting();

    User(String username,String password,String email){
        //TODO
    };

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean changePassword(String password) {
        this.password = password;
        //TODO
        return true;
    }

    public boolean changeUsername(String username) {
        this.username = username;
        //TODO
        return true;
    }

    public boolean changeEmail(String email) {
        this.email = email;
        //TODO
        return true;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public Setting getSetting() {
        return setting;
    }

    public void unauthorizeDevice(int deviceID){
        authorizedDevices.removeIf(device->device.getDeviceId()==deviceID);
    }
}