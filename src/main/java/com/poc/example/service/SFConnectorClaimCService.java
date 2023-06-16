package com.poc.example.service;

import com.poc.example.model.RequestSFConnectorClaimC;
import com.poc.example.model.SF_Connector__Claim__c;
import com.poc.example.repository.SFConnectorClaimCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SFConnectorClaimCService {

    @Autowired
    private SFConnectorClaimCRepository  sfConnectorClaimCRepository;
    public SF_Connector__Claim__c saveAndUpdateSfConnectorClaim(RequestSFConnectorClaimC requestSFConnectorClaimC) {
        SF_Connector__Claim__c newSFConnectorClaimC = requestSFConnectorClaimC.getData().getSfConnectorClaimC().get(0);
        String claimName = newSFConnectorClaimC.getClaimName();
        SF_Connector__Claim__c response = null;

        if (claimName != null && !claimName.isEmpty()) {
            Optional<SF_Connector__Claim__c> claimC = sfConnectorClaimCRepository.findById(claimName);
            if(claimC != null && claimC.isPresent()) {
                SF_Connector__Claim__c oldClaimC = claimC.get();

                oldClaimC.setClaimName(newSFConnectorClaimC.getClaimName());
                oldClaimC.setClaimStatus(newSFConnectorClaimC.getClaimStatus());
                oldClaimC.setDescription(newSFConnectorClaimC.getDescription());
                oldClaimC.setRegion(newSFConnectorClaimC.getRegion());
                oldClaimC.setAccountName(newSFConnectorClaimC.getAccountName());
                oldClaimC.setAboveAllowedThreshold(newSFConnectorClaimC.getAboveAllowedThreshold());

                 response =   sfConnectorClaimCRepository.save(oldClaimC);
            } else {
                 response = sfConnectorClaimCRepository.save(newSFConnectorClaimC);
            }
        }

        return response;
    }
}
