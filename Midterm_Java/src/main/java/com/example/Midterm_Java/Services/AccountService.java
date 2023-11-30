package com.example.Midterm_Java.Services;

import com.example.Midterm_Java.Models.Account;
import com.example.Midterm_Java.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public Account findUserAccount(String accountname, String passowrd){
        return accountRepository.findUser(accountname, passowrd);
    }
    public boolean saveAccount(Account account){
        try{
            accountRepository.save(account);
            return true;
        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }
}
