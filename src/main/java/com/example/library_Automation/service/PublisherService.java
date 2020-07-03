package com.example.library_Automation.service;

import com.example.library_Automation.converter.BookConverter;
import com.example.library_Automation.entity.PublisherEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.model.request.PublisherRequest;
import com.example.library_Automation.model.request.PublisherUpdateRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.PublisherResponse;
import com.example.library_Automation.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final BookConverter bookConverter;
    
    public PublisherEntity saveBookPublisher(String name){
        PublisherEntity publisherEntity =  getByPublisherName(name);
        if (publisherEntity != null)
            return publisherEntity;
        return publisherRepository.save(PublisherEntity.builder().name(name).build());

    }

    private PublisherEntity getByPublisherName(String name){
        return publisherRepository.getByName(name);
    }

    public List<PublisherResponse> getAllPublisher() {
        List<PublisherEntity> entityList = publisherRepository.findAll();
        if (entityList.size()==0)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        return bookConverter.publisherListConverterBookListEntity(entityList);
    }

    public BaseResponse savePublisher(PublisherRequest request) {
        PublisherEntity entity = getByPublisherName(request.getName());
        if (entity!=null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        publisherRepository.save(PublisherEntity.builder().name(request.getName()).build());
        return BaseResponse.success();
    }

    public BaseResponse deletePublisher(String name) {
        PublisherEntity entity=getByPublisherName(name);
        if (entity==null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        publisherRepository.delete(entity);
        return  BaseResponse.success();
    }

    public BaseResponse updatePublisher(PublisherUpdateRequest request) {
        PublisherEntity entity = getByPublisherName(request.getOldPublisher());
        if (entity==null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        if (getByPublisherName(request.getNewPublisher())!= null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        entity.setName(request.getNewPublisher());
        publisherRepository.save(entity);
        return  BaseResponse.success();
    }
}
