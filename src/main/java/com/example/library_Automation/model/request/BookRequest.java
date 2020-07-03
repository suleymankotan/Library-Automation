package com.example.library_Automation.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private String name;
    private Long bookSize;
    private LocalDateTime publicDate;
    private String publisherName;
    private String writerName;
    private String writerSurname;
    private String categoryName;

}
