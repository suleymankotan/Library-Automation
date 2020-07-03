package com.example.library_Automation.controller;

import com.example.library_Automation.model.request.WriterRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.WriterResponse;
import com.example.library_Automation.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/writer")
public class WriterController {
    private final WriterService writerService;
    @GetMapping
    public List<WriterResponse> getAllWriter(){
        return null;
    }

    @GetMapping("/{writerName}")
    public WriterResponse getByWriterName(@PathVariable("writerName") String name){
        return null;
    }

    @PostMapping
    public BaseResponse saveWriter(){
        return null;
    }

    @PutMapping
    public BaseResponse updateWriter(@RequestBody @Valid WriterRequest request){
        return null;
    }

    @DeleteMapping("/{writerName}")
    public BaseResponse deleteWriter(@PathVariable("writerName") String name){
        return null;
    }
}
