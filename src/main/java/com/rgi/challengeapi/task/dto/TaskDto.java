package com.rgi.challengeapi.task.dto;

import com.rgi.challengeapi.status.dto.StatusDto;
import com.rgi.challengeapi.user.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private StatusDto status;
    private List<UserDto> enabledusers;
}
