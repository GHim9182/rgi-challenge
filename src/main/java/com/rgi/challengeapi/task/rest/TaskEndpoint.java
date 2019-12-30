package com.rgi.challengeapi.task.rest;

import com.rgi.challengeapi.task.dao.TaskDao;
import com.rgi.challengeapi.task.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rgi.challengeapi.task.model.Task;
import com.rgi.challengeapi.task.repository.TaskRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskEndpoint {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskDao taskDao;

    @GetMapping("/{id:[0-9][0-9]*}")
    public Optional<Task> getById(@PathVariable("id") long id) {
        return taskRepository.findById(id);
    }

    @GetMapping("/user/{id:[0-9][0-9]*}")
    public List<Task> getAllOpenTasksByUserId(@PathVariable("id") long id) {
        return taskDao.getAllOpenTasksByUserId(id);
    }

    @PostMapping("/createTask")
    public Task createTask(@Valid @RequestBody TaskDto taskDto) {
        return taskDao.saveTask(taskDto);
    }

    @PutMapping("/closeTask/{id:[0-9][0-9]*}")
    public Task closeTask(@PathVariable("id") long id) {
        if (taskRepository.findById(id).isPresent()) {
            return taskDao.closeTask(id);
        } else {
            return null;
        }
    }
}