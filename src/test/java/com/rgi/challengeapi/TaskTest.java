package com.rgi.challengeapi;

import com.rgi.challengeapi.status.dict.StatusDict;
import com.rgi.challengeapi.status.dto.StatusDto;
import com.rgi.challengeapi.task.dto.TaskDto;
import com.rgi.challengeapi.task.model.Task;
import com.rgi.challengeapi.task.rest.TaskEndpoint;
import com.rgi.challengeapi.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskTest {

    @Autowired
    private TaskEndpoint taskEndpoint;

    @Test
    public void closeTaskTest() {
        int TASK_TO_CLOSE = 900;

        Task t = taskEndpoint.closeTask(TASK_TO_CLOSE);
        assertThat(t).isNotNull();
        assertThat(t.getStatus().getId()).isEqualTo(StatusDict.CLOSED);
    }

    @Test
    public void createTaskTest() {
        TaskDto t = new TaskDto();
        UserDto u = new UserDto();
        StatusDto s = new StatusDto();

        List<UserDto> enabledUsers = new ArrayList();

        s.setId(StatusDict.OPEN);
        s.setStatus("OPEN");

        u.setId(Long.valueOf(900));
        u.setName("Luca");
        u.setLastname("Nessi");
        u.setEmail("luca.nessi@gmail.com");
        u.setUsername("LN123");

        enabledUsers.add(u);

        t.setStatus(s);
        t.setEnabledusers(enabledUsers);
        t.setName("Test task");
        t.setDescription("Test task description");

        Task newTask = taskEndpoint.createTask(t);

        assertThat(newTask.getId()).isNotNull();
        assertThat(newTask.getEnabledusers().size()).isEqualTo(1);
        assertThat(newTask.getStatus().getId()).isEqualTo(StatusDict.OPEN);
        assertThat(newTask.getEnabledusers().get(0).getUsername()).isEqualTo("LN123");
    }

}
