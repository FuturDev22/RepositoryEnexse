package com.example.testtechnique.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Agent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String os;
    private String version;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String ip;
    private LocalDateTime dateAdd;
    private LocalDateTime lastKeepAlive;
}
