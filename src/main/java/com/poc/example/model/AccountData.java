package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class AccountData {

    @JsonProperty("Account")
    private List<Account> account;
}
