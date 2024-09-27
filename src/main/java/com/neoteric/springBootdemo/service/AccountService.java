package com.neoteric.springBootdemo.service;

import com.neoteric.springBootdemo.AccountRepository;
import com.neoteric.springBootdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public List<AccountEntity> accountLessThanBalance(String balance){
        return accountRepository.findByBalanceLessThan(balance);
    }

    public List<AccountEntity> accountGreaterThanBalance(String balance){
        return accountRepository.findByBalanceGreaterThan(balance);
    }


    public List<AccountEntity> accountBetweenBalance(String lowerRange, String upperRange) {
        return accountRepository.findByBalanceBetween(lowerRange, upperRange);
    }


    public Account getAccountnumberfromDataJpa(String accountnumber) {
        Account account=null;
        AccountEntity accountEntity =accountRepository.findByAccountnumber(accountnumber);
        if(accountEntity!= null){

            account = Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobilenumber(accountEntity.getMobilenumber())
                   .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountEntityAddress> accountAddressEntityList =
                    accountEntity.getAccountEntityAddressesList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountEntityAddress accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAdd1());
                address.setAdd2(accountAddressEntity.getAdd2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setState(accountAddressEntity.getState());

                account.setAddress(address);
            }

        }
        return account;

    }

    public Account searchAccountByAccountnumberAndPan(String accountnumber,String pan){
        Account account=null;
        AccountEntity accountEntity =accountRepository.findByAccountnumberAndPan(accountnumber, pan);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobilenumber(accountEntity.getMobilenumber())
                   .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountEntityAddress> accountAddressEntityList =
                    accountEntity.getAccountEntityAddressesList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountEntityAddress accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAdd1());
                address.setAdd2(accountAddressEntity.getAdd2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setState(accountAddressEntity.getState());

                account.setAddress(address);
            }
        }
        return account;
    }
    public Account getAccount(String accountnumber){
        Account account=null;
        AccountEntity accountEntity =accountRepository.getAccountEntityJpql(accountnumber);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobilenumber(accountEntity.getMobilenumber())
                    .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountEntityAddress> accountAddressEntityList =
                    accountEntity.getAccountEntityAddressesList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountEntityAddress accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAdd1());
                address.setAdd2(accountAddressEntity.getAdd2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setState(accountAddressEntity.getState());

                account.setAddress(address);
            }
        }
        return account;
    }
    public Account getAccountandstatus(String accountnumber,String pan){
        Account account=null;
        AccountEntity accountEntity =accountRepository.getAccountEntityStatusJpql(accountnumber,1);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobilenumber(accountEntity.getMobilenumber())
                    .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountEntityAddress> accountAddressEntityList =
                    accountEntity.getAccountEntityAddressesList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountEntityAddress accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAdd1());
                address.setAdd2(accountAddressEntity.getAdd2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setState(accountAddressEntity.getState());

                account.setAddress(address);
            }
        }
        return account;
    }
}
