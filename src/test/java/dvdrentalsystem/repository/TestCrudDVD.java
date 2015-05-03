/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrentalsystem.repository;

import com.bulelani.dvdrentalsystem.App;
import com.bulelani.dvdrentalsystem.domain.DVD;
import com.bulelani.dvdrentalsystem.repository.DvdRepository;
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
public class TestCrudDVD {
    private Long id;
    public TestCrudDVD() {
    }
    @Autowired
    DvdRepository repository;
     @Test
     public void createDVD() {
        List<DVD> dvds = new ArrayList<>();
        DVD dvd = new DVD.Builder("Fast n Furios7")
                .noOfCopies(7)
                .genre(null)
                .build();
        repository.save(dvd);
        id = dvd.getId();
        Assert.assertNotNull(dvd.getId());
    }

    @Test
    public void testRead() throws Exception{
        DVD dvd = repository.findOne(id);
        Assert.assertEquals("Fast n Furios7", dvd.getTitle());
    }
    
    @Test
    public void testUpdate() throws Exception{
        DVD dvd = repository.findOne(id);
        DVD newDVD = new DVD.Builder("How to get away with")
                .noOfCopies(7)
                .genre(null)
                .build();
        repository.save(newDVD);
        Assert.assertEquals("How to get away with", dvd.getTitle());
    }
    
    @Test
    public void testDelete() throws Exception{
        DVD dvd = repository.findOne(id);
        repository.delete(dvd);
        DVD newDVD = repository.findOne(id);
        Assert.assertNull(newDVD);
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
