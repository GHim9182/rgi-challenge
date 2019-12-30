package com.rgi.challengeapi.task.dao;

import com.rgi.challengeapi.status.dict.StatusDict;
import com.rgi.challengeapi.status.dto.StatusDto;
import com.rgi.challengeapi.status.mapper.StatusMapper;
import com.rgi.challengeapi.status.model.Status;
import com.rgi.challengeapi.task.dto.TaskDto;
import com.rgi.challengeapi.task.mapper.TaskMapper;
import com.rgi.challengeapi.task.model.Task;
import com.rgi.challengeapi.task.repository.TaskRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TaskDao {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    protected EntityManager em;

    public List<Task> getAllOpenTasks() {
        return em.createQuery("SELECT t FROM Task t WHERE t.status.id = :statusId", Task.class)
                .setParameter("statusId", StatusDict.OPEN)
                .getResultList();
    }

    public List<Task> getAllOpenTasksByUserId(long userid) {
        String hql = "SELECT t FROM Task t " +
                " JOIN t.enabledusers u " +
                " WHERE t.status.id = :statusId" +
                " AND u.id = :userId";

        return em.createQuery(hql, Task.class)
                .setParameter("statusId", StatusDict.OPEN)
                .setParameter("userId", userid)
                .getResultList();
    }

    public Task closeTask(long id) {
        Task task = taskRepository.findById(id).get();
        TaskDto taskDto = Mappers.getMapper(TaskMapper.class).entityToDto(task);

        Status status = em.find(Status.class, StatusDict.CLOSED);
        StatusDto statusDto = Mappers.getMapper(StatusMapper.class).entityToDto(status);

        taskDto.setStatus(statusDto);

        taskRepository.save(Mappers.getMapper(TaskMapper.class).dtoToEntity(taskDto));

        return task;
    }

    public Task saveTask(TaskDto taskDto) {
        Task createTask = Mappers.getMapper(TaskMapper.class).dtoToEntity(taskDto);
        em.persist(createTask);
        return createTask;
    }
}
