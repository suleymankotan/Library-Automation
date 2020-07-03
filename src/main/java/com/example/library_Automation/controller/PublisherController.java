package com.example.library_Automation.controller;

import com.example.library_Automation.model.request.PublisherRequest;
import com.example.library_Automation.model.request.PublisherUpdateRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.PublisherResponse;
import com.example.library_Automation.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherService publisherService;
    @GetMapping
    public List<PublisherResponse> getAllPublisher(){
        return publisherService.getAllPublisher();
    }

    @PostMapping
    public BaseResponse savePublisher(@RequestBody @Valid PublisherRequest request){
        return publisherService.savePublisher(request);
    }

    @PutMapping
    public BaseResponse updatePublisher(@RequestBody @Valid PublisherUpdateRequest request){
        return publisherService.updatePublisher(request);
    }

    @DeleteMapping("/{publisherName}")
    public BaseResponse deletePublisher(@PathVariable("publisherName") String name){
        return publisherService.deletePublisher(name);
    }
}
