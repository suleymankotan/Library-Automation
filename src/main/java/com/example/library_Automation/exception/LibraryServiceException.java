package com.example.library_Automation.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryServiceException extends RuntimeException {
    private Integer code;
    private String message;

    public LibraryServiceException(Integer code,String message,Throwable cause){
        super(cause);
        this.code= code;
        this.message= message;
    }
    public LibraryServiceException(Integer code,String message){
        super();
        this.code= code;
        this.message= message;
    }
    public LibraryServiceException(ErrorCode exceptionEnum){
        super();
        this.code= exceptionEnum.getNumber();
        this.message= exceptionEnum.getMessage();
    }
    public LibraryServiceException(ErrorCode exceptionEnum, Throwable cause){
        super(cause);
        this.code= exceptionEnum.getNumber();
        this.message= exceptionEnum.getMessage();
    }
}
