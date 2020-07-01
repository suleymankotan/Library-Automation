package com.example.library_Automation.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private String name;
    private Long bookSize;
    private Date publicDate;
    private String writerName;
    private String writerSurname;
    private String categoryName;

}
