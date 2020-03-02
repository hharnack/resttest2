/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.DogDB;
import java.sql.Date;
import java.util.ArrayList;
import models.Dog;
import models.Vaccine;
import models.Veterinarian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import services.DogService;

/**
 *
 * @author 703174
 */
public class InsertDog {
    
    public InsertDog() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void insert() {
        Dog dog = new Dog();
        dog.setName("Hans");
        dog.setBreed("Husky");
        dog.setWeight(4.20);
        dog.setDateOfBirth(new Date(1996, 4, 4));
        dog.setGender("Male");
        dog.setSpayedNeutered(false);
        dog.setStrangerComfortable(false);
        dog.setLargeDogFriendly(false);
        dog.setSmallDogFriendly(true);
        dog.setPuppyFriendly(true);
        
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("peanuts");
        allergies.add("weed");
        dog.setAllergies(allergies);
        
        ArrayList<String> medications = new ArrayList<>();
        medications.add("Tylenol");
        dog.setMedications(medications);
        
        ArrayList<Vaccine> vaccines = new ArrayList<>();
        vaccines.add(new Vaccine("Ligma", new Date(2020, 6, 6)));
        dog.setVaccines(vaccines);
        
        dog.setVeterinarian(new Veterinarian("Dr. Phil", "Television", "8662738255"));
        
        DogService ds = new DogService();
        ds.insert("admin", dog);
    }
}
