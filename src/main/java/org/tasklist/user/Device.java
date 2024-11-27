package org.tasklist.user;
import java.time.*;

public class Device {
    public int deviceId;
    public String deviceName;
    public String deviceType;
    public LocalDateTime lastSyncTime;
    private boolean isAuthorized;

    public void authorizeDevice() {
        isAuthorized = true;
    }

    public void unauthorizeDevice() {
        isAuthorized = false;
    }

    public int getDeviceId(){
        return deviceId;
    }
}

