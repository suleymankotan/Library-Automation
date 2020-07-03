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
        return writerService.getAllWriter();
    }


    @PostMapping
    public BaseResponse saveWriter(@RequestBody @Valid WriterRequest request){
        return writerService.saveWriter(request);
    }

    @PutMapping
    public BaseResponse updateWriter(@RequestBody @Valid WriterRequest request){
        return writerService.updateWriter(request);
    }

    @DeleteMapping("/{writerName}")
    public BaseResponse deleteWriter(@PathVariable("writerName") String name){
        return writerService.deleteWriter(name);
    }
}
