package com.example.library_Automation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "writer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WriterEntity {
    @Id
    private Long id;
    private String name;
    private String surname;

}
