/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrentalsystem.repository;

import com.bulelani.dvdrentalsystem.App;
import com.bulelani.dvdrentalsystem.domain.Customer;
import com.bulelani.dvdrentalsystem.repository.CustomerRepository;
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
public class TestCrudCustomer {
     private Long id;
    public TestCrudCustomer() {
    }

    @Autowired
    CustomerRepository repository;
     @Test
     public void createCustomer() {
        List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer.Builder("901229")
                .name("Bulelani").surname("Walaza").account(null).address(null)
                .contacts(null).rental(null).build();
        repository.save(cust);
        id = cust.getId();
        Assert.assertNotNull(cust.getId());
    }
     
    @Test
    public void testRead() throws Exception{
        Customer cust = repository.findOne(id);
        Assert.assertEquals("901229", cust.getIdNumber());
    }
    
    @Test
    public void testUpdate() throws Exception{
        Customer cust = repository.findOne(id);
        Customer newCustomer = new Customer.Builder("901229")
                .name("Bulelani").surname("Walaza").account(null).address(null)
                .contacts(null).rental(null).build();
        repository.save(newCustomer);
        Assert.assertEquals("9012295", cust.getIdNumber());
    }
    
     @Test
    public void testDelete() throws Exception{
        Customer cust = repository.findOne(id);
        repository.delete(cust);
        Customer newCustomer = repository.findOne(id);
        Assert.assertNull(newCustomer);
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
