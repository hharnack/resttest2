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
 * This class is used to allow the RESTful API classes to access the database
 * and tables that are associated with dog information.
 *
 * @author Hans Cabrera
 */
public class DogService {

    /**
     * An instance of the DogDB class.
     */
    private final DogDB ddb;

    /**
     * Default constructor that instantiates the DogDB object.
     */
    public DogService() {
        ddb = new DogDB();
    }

    /**
     * Gets the information of a dog with the specified id number.
     *
     * @param idNumber The dog's id number.
     * @return A dog object.
     */
    public Dog getDogByID(int idNumber) {
        return ddb.getDogByID(idNumber);
    }

    /**
     * Inserts a new dog into the database.
     *
     * @param username The username that the dog is associated with.
     * @param dog A dog object.
     * @return true if the dog was successfully inserted into the database.
     */
    public boolean insert(String username, Dog dog) {
        return ddb.insert(username, dog) > 0;
    }

    /**
     * Updates the dog's information.
     *
     * @param dog The updated dog object.
     * @return true if the dog information was successfully updated.
     */
    public boolean updateDog(Dog dog) {
        return ddb.updateDog(dog) > 0;
    }

    /**
     * Gets all of the dog information that is associated with the specified
     * username.
     *
     * @param username The user's username.
     * @return A list of dog objects that belong to the specified username.
     */
    public ArrayList<Dog> getDogsByUsername(String username) {
        return ddb.getDogsByUsername(username);
    }

    /**
     * Performs a soft delete on the account associated with the specified id
     * number. A soft delete only sets the isactive column in the database to
     * false.
     *
     * @param petID The id number of the dog to soft delete.
     * @return true if the isactive column was successfully updated.
     */
    public boolean delete(int petID) {
        return ddb.deleteDog(petID) > 0;
    }

    /**
     * Gets all of the dog information within the database.
     *
     * @return A list of all dogs in the system.
     */
    public ArrayList<Dog> getDogs() {
        return ddb.getAllDogs();
    }
}
