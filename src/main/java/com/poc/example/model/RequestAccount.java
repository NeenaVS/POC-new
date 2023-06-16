package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestAccount {

    @JsonProperty("Object")
    private String object;
    private String req_datetime;
    private AccountData data;
}
