package com.poc.example.controller;

import com.poc.example.AccountValidator;
import com.poc.example.model.Account;
import com.poc.example.model.AccountData;
import com.poc.example.model.RequestAccount;
import com.poc.example.repository.AccountRepository;
import com.poc.example.service.AccountService;
import com.poc.example.service.ValidatorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

// working
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), LocalDate.now(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PostMapping("/account")
    public ResponseEntity<Account> accountOperation(@Valid @RequestBody RequestAccount requestAccount)  {
        ResponseEntity<Account> response = null;
         try {
             AccountValidator accountValidator = new AccountValidator();
             ValidatorResponse validatorResponse = accountValidator.validateAccount(requestAccount);
             if (validatorResponse.getStatus() == true && validatorResponse.getMessage()== "success") {
                 log.info("Inside accountOperation of AccountController");
                 response = new ResponseEntity<>(accountService.saveAccount(requestAccount), HttpStatus.OK);
             } else {
                 log.error("Unable to create or update Account, invalid Account");
                 response = new ResponseEntity<>( HttpStatus.BAD_REQUEST);
             }

         } catch (Exception ne) {
             log.error("Unable to create or update Account", ne);
             response = new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
         }

        return response;
    }

    @GetMapping("/active")
    public ResponseEntity<List<Account>> getActiveAccount(){
        return new ResponseEntity<>(accountRepository.getByCardCodeAndName("card-code22", "Puja Shingare"), HttpStatus.OK);
    }

    @GetMapping("/active/{card}")
    public ResponseEntity<Account> getActiveAccountById(@PathVariable String card){
        return new ResponseEntity<>(accountRepository.findById(card).get(), HttpStatus.OK);
    }



//    @PostMapping("/update/{id}")
//    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account)  {
//        return null; //new ResponseEntity<>();
//    }

    @GetMapping("/get")
    public RequestAccount getAccount() {
        RequestAccount requestAccount = new RequestAccount();

        AccountData accountData = new AccountData();
        List<Account> data =  new ArrayList<>();
        Account account = new Account();

        account.setName("ssoss");
        account.setParentAccountName("fgf");
        account.setType("Ty");
        account.setWebsite("web");
        account.setCardCode("cardcode-33");
        data.add(account);
        accountData.setAccount(data);

        requestAccount.setObject("something");
        requestAccount.setReq_datetime("somedate");
        requestAccount.setData(accountData);

        return requestAccount;
    }
    
}
