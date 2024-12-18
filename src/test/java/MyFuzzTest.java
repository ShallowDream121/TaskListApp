import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.tasklist.taskmanager.Task;
import org.tasklist.taskmanager.TaskManager;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MyFuzzTest {
    @FuzzTest
    void TasksAddTest(FuzzedDataProvider data){
        TaskManager taskManager= new TaskManager();
        int num = data.consumeInt(1,10000);
        for (int i=1;i<=num;i++){
            String title = data.consumeString(20);
            String description = data.consumeString(1000);

            int year = data.consumeInt(2020, 2030);
            int month = data.consumeInt(1, 12);
            int day = data.consumeInt(1, LocalDateTime.of(year, month, 1, 0, 0).toLocalDate().lengthOfMonth());
            int hour = data.consumeInt(0, 23);
            int minute = data.consumeInt(0, 59);
            LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);

            int priority = data.consumeInt(1,3);
            Task newTask = new Task(i,title,description,dateTime,(short) priority);

            taskManager.addTask(newTask);
            assertNotNull(taskManager.getTask(i),"Task 应该在列表中");
        }
        assertEquals(num,taskManager.getTasks().size(),"任务数量错误");
    }
}
