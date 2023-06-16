package com.poc.example.controller;

import com.poc.example.model.RequestSFConnectorClaimC;
import com.poc.example.model.SFConnectorClaimData;
import com.poc.example.model.SF_Connector__Claim__c;
import com.poc.example.service.SFConnectorClaimCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/app")
public class SFConnectorClaimController {

    @Autowired
    private SFConnectorClaimCService sfConnectorClaimCService;


    @PostMapping("/claim")
    public ResponseEntity<SF_Connector__Claim__c> sFConnectorClaimCOperations(@RequestBody RequestSFConnectorClaimC requestSFConnectorClaimC) {
        ResponseEntity<SF_Connector__Claim__c> response = null;

        try {
            response = new ResponseEntity<>(sfConnectorClaimCService.saveAndUpdateSfConnectorClaim(requestSFConnectorClaimC), HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(sfConnectorClaimCService.saveAndUpdateSfConnectorClaim(requestSFConnectorClaimC), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }




    @GetMapping("/get")
    public ResponseEntity<RequestSFConnectorClaimC> getObject() {
        SF_Connector__Claim__c sfConnectorClaimC = new SF_Connector__Claim__c("ClaimName",
                "Active", "North", "something",
                "aboveAllowedThreshold", "someAccName");

        List<SF_Connector__Claim__c> sFConnectorClaimC = new ArrayList<>();
        sFConnectorClaimC.add(sfConnectorClaimC);

        RequestSFConnectorClaimC requestSFConnectorClaimC = new RequestSFConnectorClaimC();
        SFConnectorClaimData sfConnectorClaimData = new SFConnectorClaimData();
        sfConnectorClaimData.setSfConnectorClaimC(sFConnectorClaimC);

        requestSFConnectorClaimC.setObject("Claim");
        requestSFConnectorClaimC.setReq_datetime("somedate");
        requestSFConnectorClaimC.setData(sfConnectorClaimData);

        return new ResponseEntity<>(requestSFConnectorClaimC, HttpStatus.OK);
    }

}
