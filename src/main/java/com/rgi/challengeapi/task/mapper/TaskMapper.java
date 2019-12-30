package com.rgi.challengeapi.task.mapper;

import com.rgi.challengeapi.task.dto.TaskDto;
import com.rgi.challengeapi.task.model.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskDto entityToDto(Task task);
    Task dtoToEntity(TaskDto taskDto);
}

