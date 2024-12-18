package user;

import org.junit.jupiter.api.*;
import org.tasklist.user.Server;
import org.tasklist.user.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Server 和 User 类的集成测试。
 * 测试用户注册、登录、注销、登出等功能。
 */
class ServerTest {

    private Server server;

    /**
     * 每个测试用例前初始化 Server 实例。
     */
    @BeforeEach
    void setUp() {
        server = new Server();
    }

    /**
     * 测试用户注册。
     */
    @Test
    void testRegisterUser_Success() {
        boolean registered = server.registerUser("user1", "password123", "user1@example.com");
        assertTrue(registered, "用户注册应该成功。");

        boolean isRegistered = server.registerUser("user1", "newpassword", "user2@example.com");
        assertFalse(isRegistered, "用户名重复时，用户注册应该失败。");

        boolean isRegistered2 = server.registerUser("user2", "newpassword", "user1@example.com");
        assertFalse(isRegistered2, "邮箱重复时，用户注册应该失败。");
    }

    /**
     * 测试登录。
     */
    @Test
    void testLoginUserByUsername_Success() {
        server.registerUser("user1", "password123", "user1@example.com");
        User loggedInUser = server.loginUser("user1", "password123");
        assertNotNull(loggedInUser, "用户名登录应该成功并返回用户对象。");
        assertEquals("user1", loggedInUser.getUsername(), "登录返回的用户用户名应该匹配。");

        User loggedInUser2 = server.loginUser("user1", "wrongpassword");
        assertNull(loggedInUser2, "密码错误时，用户名登录应该失败并返回 null。");

        User loggedInUser3 = server.loginUserByEmail("user1@example.com", "password123");
        assertNotNull(loggedInUser3, "邮箱登录应该成功并返回用户对象。");
        assertEquals("user1@example.com", loggedInUser3.getEmail(), "登录返回的用户邮箱应该匹配。");

        User loggedInUser4 = server.loginUserByEmail("nonexistent@example.com", "password123");
        assertNull(loggedInUser4, "邮箱不存在时，邮箱登录应该失败并返回 null。");
    }

    /**
     * 测试注销用户。
     */
    @Test
    void testUnregisterUser() {
        User user = new User("user1", "password123", "user1@example.com");
        server.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
        server.unregisterUser(user);
        User loggedInUser = server.loginUser(user.getUsername(), user.getPassword());
        assertNull(loggedInUser, "用户注销后，登录操作应该失败。");
    }

    /**
     * 测试多个用户注册和登录。
     */
    @Test
    void testMultipleUsers() {
        server.registerUser("user1", "password123", "user1@example.com");
        server.registerUser("user2", "password456", "user2@example.com");

        User user1 = server.loginUser("user1", "password123");
        assertNotNull(user1, "用户1登录应该成功。");
        assertEquals("user1", user1.getUsername(), "登录用户1的用户名应该匹配。");

        User user2 = server.loginUser("user2", "password456");
        assertNotNull(user2, "用户2登录应该成功。");
        assertEquals("user2", user2.getUsername(), "登录用户2的用户名应该匹配。");
    }
}
