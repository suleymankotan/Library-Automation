package com.example.library_Automation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "publisher")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherEntity {
    @Id
    private Long id;
    private String name;
}
