package com.rgi.challengeapi.task.model;

import com.rgi.challengeapi.status.model.Status;
import com.rgi.challengeapi.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
@Indexed
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "task_generator")
    @SequenceGenerator(
            name = "task_generator",
            sequenceName = "task_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "statusid", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(name = "task_user",
            joinColumns = @JoinColumn(name = "taskid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    private List<User> enabledusers;
}
