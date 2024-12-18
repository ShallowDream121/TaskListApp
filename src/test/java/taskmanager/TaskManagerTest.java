package taskmanager;

import org.junit.jupiter.api.*;
import org.tasklist.taskmanager.Task;
import org.tasklist.taskmanager.TaskManager;
import org.tasklist.taskmanager.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TaskManager 和 Task 类的集成测试。
 * 验证任务管理器的功能是否正常工作，包括任务的增删改查操作。
 */
class TaskManagerTest {

    private TaskManager taskManager;
    private Task task1;
    private Task task2;

    /**
     * 每个测试用例前初始化 TaskManager 和一些示例任务。
     */
    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        task1 = new Task(1, "Task1", "Description1", LocalDateTime.now().plusDays(1), (short) 1);
        task2 = new Task(2, "Task2", "Description2", LocalDateTime.now().plusDays(2), (short) 2);
    }

    /**
     * 测试添加任务到任务管理器中。
     */
    @Test
    void testAddTask() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size(), "任务列表中应该有 2 个任务。");
        assertTrue(tasks.contains(task1), "任务列表中应该包含 task1。");
        assertTrue(tasks.contains(task2), "任务列表中应该包含 task2。");
    }

    /**
     * 测试根据任务对象移除任务。
     */
    @Test
    void testRemoveTaskByObject() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTask(task1);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size(), "任务列表中应该只剩下 1 个任务。");
        assertFalse(tasks.contains(task1), "任务列表中不应该包含 task1。");
    }

    /**
     * 测试根据任务 ID 移除任务。
     */
    @Test
    void testRemoveTaskById() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTask(2);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size(), "任务列表中应该只剩下 1 个任务。");
        assertFalse(tasks.stream().anyMatch(task -> task.getId() == 2), "任务列表中不应该包含 ID 为 2 的任务。");
    }

    /**
     * 测试更新任务信息。
     */
    @Test
    void testUpdateTask() {
        taskManager.addTask(task1);

        taskManager.updateTask(task1, "Updated Task1", "Updated Description1",
                LocalDateTime.now().plusDays(3), (short) 3, TaskStatus.DONE);

        Task updatedTask = taskManager.getTask(1);
        assertNotNull(updatedTask, "任务应该存在。");
        assertEquals("Updated Task1", updatedTask.getTitle(), "任务标题应该已更新。");
        assertEquals("Updated Description1", updatedTask.getDescription(), "任务描述应该已更新。");
        assertEquals(3, updatedTask.getPriority(), "任务优先级应该已更新为 3。");
        assertEquals(TaskStatus.DONE, updatedTask.getStatus(), "任务状态应该已更新为已完成。");
    }

    /**
     * 测试获取任务。
     */
    @Test
    void testGetTask() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        Task foundTask = taskManager.getTask(2);
        assertNotNull(foundTask, "应该找到 ID 为 2 的任务。");
        assertEquals(task2, foundTask, "找到的任务应该与 task2 相等。");

        Task notFoundTask = taskManager.getTask(3);
        assertNull(notFoundTask, "不存在的任务 ID 应该返回 null。");
    }

    /**
     * 测试获取所有任务。
     */
    @Test
    void testGetTasks() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size(), "任务列表中应该有 2 个任务。");
        assertTrue(tasks.contains(task1), "任务列表中应该包含 task1。");
        assertTrue(tasks.contains(task2), "任务列表中应该包含 task2。");
    }

    /**
     * 测试更新任务时传入 null 值。
     */
    @Test
    void testUpdateTaskWithNullValues() {
        taskManager.addTask(task1);

        // 只更新标题和状态，其他字段保持不变
        taskManager.updateTask(task1, "Partially Updated Task", null, null, (short) -1, TaskStatus.IN_PROGRESS);

        Task updatedTask = taskManager.getTask(1);
        assertNotNull(updatedTask, "任务应该存在。");
        assertEquals("Partially Updated Task", updatedTask.getTitle(), "任务标题应该已更新。");
        assertEquals("Description1", updatedTask.getDescription(), "任务描述不应该发生变化。");
        assertEquals(TaskStatus.IN_PROGRESS, updatedTask.getStatus(), "任务状态应该已更新为进行中。");
    }
}