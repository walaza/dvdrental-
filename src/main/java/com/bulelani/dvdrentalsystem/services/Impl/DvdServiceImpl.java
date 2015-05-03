/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.services.Impl;

import com.bulelani.dvdrentalsystem.domain.DVD;
import com.bulelani.dvdrentalsystem.repository.DvdRepository;
import com.bulelani.dvdrentalsystem.services.DvdService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bulelani
 */
public class DvdServiceImpl implements DvdService{
    @Autowired
    private DvdRepository repo;
    
    @Override
    public List<DVD> getDVDs() {
        List<DVD> dvds = new ArrayList<>();
        
        Iterable<DVD> dvd = repo.findAll();
        for(DVD movie : dvd)
        {
            dvds.add(movie);
        }
        return dvds;
    }
    
}
