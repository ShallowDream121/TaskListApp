package user;

import org.junit.jupiter.api.*;
import org.tasklist.setting.Setting;
import org.tasklist.taskmanager.TaskManager;
import org.tasklist.user.Device;
import org.tasklist.user.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link User} 类的单元测试.
 * 本类测试了 User 类的功能
 */
class UserTest {

    private User user;

    /**
     * 在每个测试用例之前初始化一个默认的 {@link User} 实例。
     */
    @BeforeEach
    void setUp() {
        user = new User("testUser", "password123", "test@example.com");
    }

    /**
     * 测试 {@link User#getUsername()} 方法，确保用户名的初始值正确。
     */
    @Test
    void testGetUsername() {
        assertEquals("testUser", user.getUsername(), "用户名应该与初始化时的值一致。");
    }

    /**
     * 测试 {@link User#changeUsername(String)} 方法，验证用户名是否能成功修改。
     */
    @Test
    void testChangeUsername() {
        boolean result = user.changeUsername("newUser");
        assertTrue(result, "修改用户名应该返回 true。");
        assertEquals("newUser", user.getUsername(), "用户名应该已更新为新值。");
    }

    /**
     * 测试 {@link User#getEmail()} 方法，确保电子邮箱地址的初始值正确。
     */
    @Test
    void testGetEmail() {
        assertEquals("test@example.com", user.getEmail(), "电子邮箱地址应该与初始化时的值一致。");
    }

    /**
     * 测试 {@link User#changeEmail(String)} 方法，验证电子邮箱地址是否能成功修改。
     */
    @Test
    void testChangeEmail() {
        boolean result = user.changeEmail("new@example.com");
        assertTrue(result, "修改电子邮箱地址应该返回 true。");
        assertEquals("new@example.com", user.getEmail(), "电子邮箱地址应该已更新为新值。");
    }

    /**
     * 测试 {@link User#changePassword(String)} 方法，验证密码是否能成功修改。
     */
    @Test
    void testChangePassword() {
        boolean result = user.changePassword("newPassword123");
        assertTrue(result, "修改密码应该返回 true。");
        assertEquals("newPassword123", user.getPassword(), "密码应该已更新为新值。");
    }

    /**
     * 测试授权设备的管理，使用 {@link User#getDevices()} 和 {@link User#unauthorizeDevice(int)} 方法。
     */
    @Test
    void testDeviceAuthorization() {
        Device device1 = new Device(1, "Device1");
        Device device2 = new Device(2, "Device2");

        user.getDevices().add(device1);
        user.getDevices().add(device2);

        assertEquals(2, user.getDevices().size(), "应该授权了两个设备。");

        user.unauthorizeDevice(1);
        assertEquals(1, user.getDevices().size(), "应该只剩下一个被授权的设备。");
        assertEquals(2, user.getDevices().get(0).getDeviceId(), "剩下的设备 ID 应该为 2。");
    }

    /**
     * 测试 {@link User#getTaskManager()} 方法，验证 TaskManager 实例是否正确关联到用户。
     */
    @Test
    void testTaskManager() {
        TaskManager taskManager = new TaskManager();
        user = new User("testUser", taskManager, new Setting());

        assertNotNull(user.getTaskManager(), "TaskManager 不应该为 null。");
        assertEquals(taskManager, user.getTaskManager(), "TaskManager 应该与分配的实例一致。");
    }

    /**
     * 测试使用 {@link User#equals(Object)} 方法判断同一个 {@link User} 实例是否相等。
     */
    @Test
    void testEqualsSameObject() {
        assertEquals(user, user, "同一个对象应该等于其自身。");
    }

    /**
     * 测试两个具有不同用户名的 {@link User} 实例是否不相等，使用 {@link User#equals(Object)} 方法。
     */
    @Test
    void testNotEqualsDifferentUsername() {
        User otherUser = new User("differentUser", "password123", "test@example.com");
        assertNotEquals(user, otherUser, "用户名不同的用户实例应该不相等。");
    }

    /**
     * 测试两个具有不同电子邮箱地址的 {@link User} 实例是否不相等，使用 {@link User#equals(Object)} 方法。
     */
    @Test
    void testNotEqualsDifferentEmail() {
        User otherUser = new User("testUser", "password123", "different@example.com");
        assertNotEquals(user, otherUser, "电子邮箱地址不同的用户实例应该不相等。");
    }
}

