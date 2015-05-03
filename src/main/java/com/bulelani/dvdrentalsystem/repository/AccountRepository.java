/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.repository;

import com.bulelani.dvdrentalsystem.domain.Account;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author bulelani
 */
public interface AccountRepository extends CrudRepository<Account,Long>{
    
}
