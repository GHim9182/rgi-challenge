package com.rgi.challengeapi.status.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Indexed
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(generator = "status_generator")
    @SequenceGenerator(
            name = "status_generator",
            sequenceName = "status_sequence",
            initialValue = 1000
    )
    private Long id;

    private String status;
}
