/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.services;

import com.bulelani.dvdrentalsystem.domain.Rental;
import java.util.List;

/**
 *
 * @author bulelani
 */
public interface RentalService {
    List<Rental> getAllRentedDVDS();
}
