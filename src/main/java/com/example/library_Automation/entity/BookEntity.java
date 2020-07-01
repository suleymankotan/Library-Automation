package com.example.library_Automation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity categoryId;
    private Long bookSize;
    @ManyToOne(fetch = FetchType.EAGER)
    private WriterEntity writerId;
    @ManyToOne(fetch = FetchType.EAGER)
    private PublisherEntity publisherId;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Temporal(TemporalType.DATE)
    private Date publicDate;
}
