package taskmanager;

import org.junit.jupiter.api.*;
import org.tasklist.label.Category;
import org.tasklist.label.Tag;
import org.tasklist.reminder.Reminder;
import org.tasklist.reminder.ReminderFactory;
import org.tasklist.taskmanager.Task;
import org.tasklist.taskmanager.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 单元测试类，测试 {@link Task} 类的基本功能.
 */
class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        // 初始化一个默认的 Task 对象，用于测试
        task = new Task(1, "Test Task", "This is a test task",
                LocalDateTime.of(2024, 12, 31, 23, 59), (short) 1);
    }

    /**
     * 测试构造函数，确保基本属性正确赋值.
     */
    @Test
    void testTaskConstructor() {
        assertEquals(1, task.getId(), "ID 应该为 1");
        assertEquals("Test Task", task.getTitle(), "标题应该为 'Test Task'");
        assertEquals("This is a test task", task.getDescription(), "描述应该为 'This is a test task'");
        assertEquals(LocalDateTime.of(2024, 12, 31, 23, 59), task.getDueDate(), "截止日期不正确");
        assertEquals(1, task.getPriority(), "优先级应该为 1");
        assertEquals(TaskStatus.TODO, task.getStatus(), "默认状态应该为 TODO");
    }

    /**
     * 测试任务标题的设置与获取.
     */
    @Test
    void testTitle() {
        task.setTitle("Updated Task");
        assertEquals("Updated Task", task.getTitle(), "标题更新失败");
    }

    /**
     * 测试任务描述的设置与获取.
     */
    @Test
    void testDescription() {
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription(), "描述更新失败");
    }

    /**
     * 测试任务状态的设置与获取.
     */
    @Test
    void testStatus() {
        task.setStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus(), "状态更新失败");
    }

    /**
     * 测试任务的截止日期的设置与获取.
     */
    @Test
    void testDueDate() {
        LocalDateTime newDueDate = LocalDateTime.of(2025, 1, 1, 12, 0);
        task.setDueDate(newDueDate);
        assertEquals(newDueDate, task.getDueDate(), "截止日期更新失败");
    }

    /**
     * 测试任务优先级的设置与获取.
     */
    @Test
    void testPriority() {
        task.setPriority((short) 5);
        assertEquals(5, task.getPriority(), "优先级更新失败");
    }

    /**
     * 测试任务标签的添加与移除.
     */
    @Test
    void testTags() {
        Tag tag1 = new Tag(1, "Important", "something important");
        Tag tag2 = new Tag(2, "Urgent","something urgent");

        task.addTag(tag1);
        task.addTag(tag2);

        List<Tag> tags = task.getTags();
        assertTrue(tags.contains(tag1), "标签添加失败: Important");
        assertTrue(tags.contains(tag2), "标签添加失败: Urgent");

        task.removeTag(tag1);
        assertFalse(task.getTags().contains(tag1), "标签移除失败: Important");
    }

    /**
     * 测试任务的类别设置与获取.
     */
    @Test
    void testCategory() {
        Category category = new Category(1, "Work", "Work related tasks");
        task.setCategory(category);
        assertEquals(category, task.getCategory(), "类别设置失败");
    }

    /**
     * 测试子任务的添加、获取与移除.
     */
    @Test
    void testChildTasks() {
        Task childTask1 = new Task(2, "Subtask 1", "First subtask", LocalDateTime.now(), (short) 2);
        Task childTask2 = new Task(3, "Subtask 2", "Second subtask", LocalDateTime.now(), (short) 3);

        task.addChildTask(childTask1);

        List<Task> childTasks = task.getChildTasks();
        assertTrue(childTasks.contains(childTask1), "子任务添加失败: Subtask 1");
        assertNull(task.getChildTask(3), "找到未加入的child task");

        task.addChildTask(childTask2);

        Task fetchedTask = task.getChildTask(2);
        assertEquals(childTask1, fetchedTask, "根据 ID 获取子任务失败");

        task.removeChildTask(childTask1);
        assertFalse(task.getChildTasks().contains(childTask1), "子任务移除失败: Subtask 1");

        task.removeChildTask(3);
        assertFalse(task.getChildTasks().contains(childTask2), "根据 ID 移除子任务失败: Subtask 2");
    }

    /**
     * 测试任务提醒的设置与获取.
     */
    @Test
    void testReminder() {
        Reminder reminder = ReminderFactory.getFactory().createReminder("alarm",LocalDateTime.of(2024,12,20,23,59,55));
        task.setReminder(reminder);
        assertEquals(reminder, task.getReminder(), "提醒设置失败");
    }
}