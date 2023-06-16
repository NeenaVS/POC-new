package com.poc.example.service;


import com.poc.example.model.Account;
import com.poc.example.model.RequestAccount;
import com.poc.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(RequestAccount requestAccount) {
        Account accOutPut = null;
        Account requestAcc = requestAccount.getData().getAccount().get(0);
        String cardcode = requestAcc.getCardCode();

        if (cardcode != null && !cardcode.isEmpty()) {
            Optional<Account> account = accountRepository.findById(cardcode);
            Account newAccountdata = requestAcc;

            // check if the Account is existed if yes update the existing account
            if (account !=null && account.isPresent()) {
                Account oldAcc = account.get();
                oldAcc.setWebsite(newAccountdata.getWebsite());
                oldAcc.setParentAccountName(newAccountdata.getParentAccountName());
                oldAcc.setType(newAccountdata.getType());
                oldAcc.setName(newAccountdata.getName());
                oldAcc.setBillingCity(newAccountdata.getBillingCity());
                oldAcc.setDescription(newAccountdata.getDescription());

                //BeanUtils.copyProperties(oldAcc, newAccountdata);

                accOutPut = accountRepository.save(oldAcc);

            } else {
                // if account is not exist with the given id then create new.
                accOutPut =  accountRepository.save(requestAcc);
            }
        } else {
            throw new NullPointerException();
        }

     return  accOutPut;
    }
}
