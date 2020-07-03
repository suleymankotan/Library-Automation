package com.example.library_Automation.service;

import com.example.library_Automation.entity.PublisherEntity;
import com.example.library_Automation.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherEntity saveBookPublisher(String name){
        PublisherEntity publisherEntity =  getByPublisherName(name);
        if (publisherEntity != null)
            return publisherEntity;
        return publisherRepository.save(PublisherEntity.builder().name(name).build());

    }

    private PublisherEntity getByPublisherName(String name){
        PublisherEntity publisherEntity = publisherRepository.getByName(name);
        return publisherEntity;

    }

}
