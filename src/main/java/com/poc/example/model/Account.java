package com.poc.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @JsonProperty("Cardcode")
    private String cardCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Parent Account Name")
    @NotBlank(message = "Parent account cant be blank")
    private String parentAccountName;

    @JsonProperty("Billing City")
    private String billingCity;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Website")
    private String website;
}
