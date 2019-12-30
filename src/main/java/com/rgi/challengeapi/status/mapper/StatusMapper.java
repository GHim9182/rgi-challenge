package com.rgi.challengeapi.status.mapper;

import com.rgi.challengeapi.status.dto.StatusDto;
import com.rgi.challengeapi.status.model.Status;
import org.mapstruct.Mapper;

@Mapper
public interface StatusMapper {
    StatusDto entityToDto(Status status);
    Status dtoToEntity(StatusDto statusDto);
}
