package com.example.library_Automation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class WriterEntity {
    @Id
    private Long id;
    private String name;
    private String surname;

}
