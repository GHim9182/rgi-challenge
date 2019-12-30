package com.rgi.challengeapi.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rgi.challengeapi.task.model.Task;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tuser")
@Indexed
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1000
    )
    private Long id;

    private String username;

    private String name;

    private String lastname;

    private String email;

    @ManyToMany(mappedBy = "enabledusers")
    @JsonIgnore
    private List<Task> tasks;
}
