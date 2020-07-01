package com.example.library_Automation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GENERAL_EXCEPTION(4000,"Sistemde bir hata oluştu."),
    REQUIRED_PARAMETERS_CANNOT_BE_NULL(4001,"Zorunlu parametreler boş bırakılamaz.");
    private int number;
    private String message;
}
