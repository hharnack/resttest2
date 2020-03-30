/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DogDB;
import java.util.ArrayList;
import models.Dog;

/**
 *
 * @author 703174
 */
public class DogService {
    
    private DogDB ddb;
    
    public DogService() {
        ddb = new DogDB();
    }
    
    public Dog getDogByID(int idNumber) {
        return ddb.getDogByID(idNumber);
    }
    
    public boolean insert(String username, Dog dog) {
        return ddb.insert(username, dog) > 0;
    }
    
    public boolean updateDog(Dog dog) {
        return ddb.updateDog(dog) > 0;
    }
    
    public ArrayList<Dog> getDogsByUsername(String username) {
        return ddb.getDogsByUsername(username);
    }
    
    public boolean delete(int petID) {
        return ddb.deleteDog(petID) > 0;
    }

    public ArrayList<Dog> getDogs() {
        return ddb.getAllDogs();
    }
}
