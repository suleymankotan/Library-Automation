package com.example.library_Automation.service;


import com.example.library_Automation.converter.BookConverter;
import com.example.library_Automation.entity.WriterEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.model.request.WriterRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.WriterResponse;
import com.example.library_Automation.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriterService {
    private final WriterRepository writerRepository;
    private final BookConverter bookConverter;

    public WriterEntity saveBookWriter(String name,String surname){
        WriterEntity writerEntity =  getByWriterName(name);
        if (writerEntity != null)
            return writerEntity;
        return writerRepository.save(WriterEntity.builder().name(name).surname(surname).build());
    }

    private WriterEntity getByWriterName(String name){
        return writerRepository.getByName(name);
    }

    public List<WriterResponse> getAllWriter() {
        List<WriterEntity> entityList = writerRepository.findAll();
        if (entityList.size()==0)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        return bookConverter.writerListConverterBookListEntity(entityList);
    }

    public BaseResponse saveWriter(WriterRequest request) {
        WriterEntity categoryEntity= getByWriterName(request.getName());
        if (categoryEntity!= null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        writerRepository.save(WriterEntity.builder().name(request.getName()).surname(request.getSurname()).build());
        return BaseResponse.success();
    }

    public BaseResponse updateWriter(WriterRequest request) {
        WriterEntity entity = getByWriterName(request.getName());
        if (entity == null )
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        entity.setSurname(request.getSurname());
        writerRepository.save(entity);
        return BaseResponse.success();
    }

    public BaseResponse deleteWriter(String name) {
        WriterEntity entity = getByWriterName(name);
        if (entity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        writerRepository.delete(entity);
        return BaseResponse.success();
    }
}
