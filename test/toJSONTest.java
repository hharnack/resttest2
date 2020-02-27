/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import models.Address;
import models.User;
import models.Veterinarian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 703174
 */
public class toJSONTest {
    
    public toJSONTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void userToJSON() {
        Address add = new Address();
        add.setBuildingNum("1");
        add.setCity("Calgary");
        add.setHouseNum("2");
        add.setPostal("A1A1A1");
        add.setProvince("Alberta");
        add.setStreetName("16th Ave");
        
        User user = new User();
        user.setUsername("Hawns");
        user.setFirstName("Hans");
        user.setLastName("Cabrera");
        user.setEmail("hans@hans.ca");
        user.setPassword("password");
        user.setPhoneNumber("1234567890");
        user.setEmergencyName("Peepeepoopoo");
        user.setEmergencyPhone("0987654321");
        user.setAddress(add);
        user.setVeterinarian(new Veterinarian());
        
        System.out.println(user.toJSON().toString());
    }
}
