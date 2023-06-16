package com.poc.example;

import com.poc.example.model.Account;
import com.poc.example.model.RequestAccount;
import com.poc.example.service.ValidatorResponse;

public class AccountValidator {


    public ValidatorResponse validateAccount(RequestAccount requestAccount) {
        ValidatorResponse response = new ValidatorResponse(true, "success");
        if(requestAccount.getData().getAccount()!= null && requestAccount.getData().getAccount().size() == 0) {
            response = new ValidatorResponse(false, "Invalid account list");
        } else {
            Account account = requestAccount.getData().getAccount().get(0);
            if(account.getCardCode() == "") {
                response = new ValidatorResponse(false, "Cardcode");
            }
        }

        return response;
    }
}
