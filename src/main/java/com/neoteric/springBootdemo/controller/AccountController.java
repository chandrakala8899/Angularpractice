package com.neoteric.springBootdemo.controller;

import com.neoteric.springBootdemo.model.Account;
import com.neoteric.springBootdemo.model.AccountEntity;
import com.neoteric.springBootdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
  @Autowired
  AccountService accountServiceTest;
  @GetMapping(value = "/api/searchAccount/DataJpa",
          produces = "application/json",
          consumes = "application/json")
  public Account searchAccount(@RequestHeader("accountinput")
                                                         String accountnumber) {
    return accountServiceTest.getAccount(accountnumber);
  }

  @GetMapping(value = "/api/searchAccount/Jpql",
          produces = "application/json",
          consumes = "application/json")
  public Account searchAccountstatus(@RequestHeader("accountinput")
                               String accountnumber ,@RequestHeader("paninput") String pan){
    return accountServiceTest.getAccountandstatus(accountnumber,pan);
  }

  @GetMapping(value = "/api/searchAccountwithPan",
          produces = "application/json",
          consumes = "application/json")

  public Account searchAccountByAccountAndPan(@RequestHeader("accountinput")
                                                        String accountnumber,  @RequestHeader("paninput") String pan){
    return accountServiceTest.searchAccountByAccountnumberAndPan(accountnumber,pan);
  }


  @GetMapping(value = "/api/searchAccount/balance",
          consumes = "application/json",
          produces = "application/json")
  public List<AccountEntity> searchByBalance(@RequestHeader("balanceinput") String balance){
    return accountServiceTest.accountLessThanBalance(balance);
  }

  @GetMapping(value = "/api/searchAccount/balanceGreater",
          consumes = "application/json",
          produces = "application/json")
  public List<AccountEntity> searchByBalanceGreater(@RequestHeader("balanceinput") String balance){
    return accountServiceTest.accountGreaterThanBalance(balance);
  }

  @GetMapping(value = "/api/searchAccount/balanceRange",
          consumes = "application/json",
          produces = "application/json")
  public List<AccountEntity> searchByBalanceRange(@RequestHeader("lowerRangeinput") String lowerRange, @RequestHeader("upperRangeinput") String upperRange){
    return accountServiceTest.accountBetweenBalance(lowerRange, upperRange);
}
}
