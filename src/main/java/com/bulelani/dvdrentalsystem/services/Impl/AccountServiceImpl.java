/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.services.Impl;

import com.bulelani.dvdrentalsystem.domain.Account;
import com.bulelani.dvdrentalsystem.repository.AccountRepository;
import com.bulelani.dvdrentalsystem.services.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulelani
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepo;
    
    @Override
    public List<Account> listAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        
        Iterable<Account> account = accountRepo.findAll();
        for(Account acc : account){
            accounts.add(acc);
        }
        return accounts;
    }
    
   
}
