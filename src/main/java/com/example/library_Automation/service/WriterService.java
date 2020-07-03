package com.example.library_Automation.service;


import com.example.library_Automation.entity.WriterEntity;
import com.example.library_Automation.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriterService {
    private final WriterRepository writerRepository;

    public WriterEntity saveBookWriter(String name,String surname){
        WriterEntity writerEntity =  getByPublisherName(name);
        if (writerEntity != null)
            return writerEntity;
        return writerRepository.save(WriterEntity.builder().name(name).surname(surname).build());

    }

    private WriterEntity getByPublisherName(String name){
        WriterEntity writerEntity = writerRepository.getByName(name);
        return writerEntity;

    }
}
