package com.poc.example.repository;

import com.poc.example.model.SF_Connector__Claim__c;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SFConnectorClaimCRepository extends JpaRepository<SF_Connector__Claim__c, String> {
}
