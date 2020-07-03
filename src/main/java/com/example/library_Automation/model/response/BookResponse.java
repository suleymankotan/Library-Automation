package com.example.library_Automation.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    private String name;
    private Long bookSize;
    private LocalDateTime publicDate;
    private WriterResponse writer;
    private CategoryResponse category;
    private PublisherResponse publisher;

}
