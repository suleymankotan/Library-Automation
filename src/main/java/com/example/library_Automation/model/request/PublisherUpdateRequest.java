package com.example.library_Automation.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherUpdateRequest {
    public String oldPublisher;
    public String newPublisher;
}
