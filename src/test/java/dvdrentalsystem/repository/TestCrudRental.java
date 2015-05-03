/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrentalsystem.repository;

import com.bulelani.dvdrentalsystem.App;
import com.bulelani.dvdrentalsystem.domain.Rental;
import com.bulelani.dvdrentalsystem.repository.RentalRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author bulelani
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudRental {
    private Long id;
    public TestCrudRental() {
    }
    @Autowired
    RentalRepository repository;
     @Test
     public void createRental() {
        List<Rental> rentals = new ArrayList<>();
        Rental rental = new Rental.Builder("03/04/2015")
                .dueDate("10/04/2015")
                .returnDate(null)
                .fine(0.0)
                .build();
        repository.save(rental);
        id = rental.getId();
        Assert.assertNotNull(rental.getId());
    }

    @Test
    public void testRead() throws Exception{
        Rental rental = repository.findOne(id);
        Assert.assertEquals("03/04/2015", rental.getRentalDate());
    }
    
    @Test
    public void testUpdate() throws Exception{
        Rental rental = repository.findOne(id);
        Rental newRental = new Rental.Builder("05/04/2015")
                .dueDate("10/04/2015")
                .returnDate(null)
                .fine(50.00)
                .build();
        repository.save(newRental);
         Assert.assertEquals("03/04/2015", rental.getRentalDate());
    }
    
     @Test
    public void testDelete() throws Exception{
        Rental rental = repository.findOne(id);
        repository.delete(rental);
        Rental newRental = repository.findOne(id);
        Assert.assertNull(newRental);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
