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
    
    DogDB ddb;
    
    public DogService() {
        ddb = new DogDB();
    }
    
    public Dog getDogByID(int idNumber) {
        return ddb.getDogByID(idNumber);
    }
    
    public boolean insert(String username, Dog dog) {
        if (ddb.insert(username, dog) > 0) {
            return true;
        }
        return false;
    }
    
    public boolean updateDog(Dog dog) {
        if (ddb.updateDog(dog) > 0) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Dog> getDogsByUsername(String username) {
        return ddb.getDogsByUsername(username);
    }
}
