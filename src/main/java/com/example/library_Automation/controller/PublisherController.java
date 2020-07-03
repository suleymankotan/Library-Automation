package com.example.library_Automation.controller;

import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.PublisherResponse;
import com.example.library_Automation.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherService publisherService;
    @GetMapping
    public List<PublisherResponse> getAllPublisher(){
        return null;
    }

    @PostMapping
    public BaseResponse savePublisher(){
        return null;
    }

    @PutMapping
    public BaseResponse updatePublisher(){
        return null;
    }

    @DeleteMapping("/{publisherName}")
    public BaseResponse deletePublisher(@PathVariable("publisherName") String name){
        return null;
    }
}
