package com.poc.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidatorResponse {
    private Boolean status;
    private String message;
}
