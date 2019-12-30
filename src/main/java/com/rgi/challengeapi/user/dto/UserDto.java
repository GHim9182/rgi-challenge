package com.rgi.challengeapi.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String email;
}
