package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SF_Connector_Claim_C")
@AllArgsConstructor
@NoArgsConstructor
public class SF_Connector__Claim__c {
    @Id
    @JsonProperty("ClaimName")
    private String claimName;

    @JsonProperty("ClaimStatus")
    private String claimStatus;

    @JsonProperty("Region")
    private String region;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("AboveAllowedThreshold")
    private String aboveAllowedThreshold;

    @JsonProperty("AccountName")
    private String accountName;

}
