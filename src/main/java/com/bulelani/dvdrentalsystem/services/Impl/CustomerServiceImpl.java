/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.services.Impl;

import com.bulelani.dvdrentalsystem.domain.Customer;
import com.bulelani.dvdrentalsystem.repository.CustomerRepository;
import com.bulelani.dvdrentalsystem.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bulelani
 */
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repo;
    
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> customer = repo.findAll();
           for(Customer cust : customer){
            customers.add(cust);
        }
        return customers;
    }

}
