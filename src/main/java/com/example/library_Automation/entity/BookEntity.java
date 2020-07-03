package com.example.library_Automation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;
    private Long bookSize;
    @ManyToOne(fetch = FetchType.EAGER)
    private WriterEntity writer;
    @ManyToOne(fetch = FetchType.EAGER)
    private PublisherEntity publisher;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime publicDate;
}
