package com.poc.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String message;
    private LocalDate localDate;
    private String detail;
}
