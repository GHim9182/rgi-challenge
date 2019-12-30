package com.rgi.challengeapi.user.mapper;

import com.rgi.challengeapi.user.dto.UserDto;
import com.rgi.challengeapi.user.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto entityToDto(User user);
    User dtoToEntity(UserDto userDto);
}
