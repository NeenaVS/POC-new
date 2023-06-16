package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestSFConnectorClaimC {
    @JsonProperty("Object")
    private String object;

    @JsonProperty("req_datetime")
    private String req_datetime;

    @JsonProperty("data")
    private SFConnectorClaimData data;
}
