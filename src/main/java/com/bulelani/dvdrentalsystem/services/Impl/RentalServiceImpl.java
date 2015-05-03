/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.services.Impl;

import com.bulelani.dvdrentalsystem.domain.Rental;
import com.bulelani.dvdrentalsystem.repository.RentalRepository;
import com.bulelani.dvdrentalsystem.services.RentalService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bulelani
 */
public class RentalServiceImpl implements RentalService{
    @Autowired
    private RentalRepository repo;
    
    @Override
    public List<Rental> getAllRentedDVDS() {
        List<Rental> rentals = new ArrayList<>();
        
        Iterable<Rental> rental = repo.findAll();
        for(Rental rent : rental)
        {
            rentals.add(rent);
        }
        return rentals;
    }
    
}
