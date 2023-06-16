package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class SFConnectorClaimData {
    @JsonProperty("SF_connector__claim__c")
    List<SF_Connector__Claim__c> sfConnectorClaimC;
}
