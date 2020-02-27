package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Dog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 703174
 */
public class DogDB {

    public Dog getDogByID(int idNumber) {
        // TODO
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryDog = "SELECT * FROM dogs WHERE pet_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(queryDog);
            ps.setInt(1, idNumber);
            ResultSet rs = ps.executeQuery();
            Dog dog = new Dog();
            dog.setIdNumber(rs.getInt(1));
            dog.setName(rs.getString(2));
            dog.setBreed(rs.getString(3));
            dog.setWeight(rs.getDouble(4));
            dog.setDateOfBirth(rs.getDate(5));
            dog.setGender(rs.getString(6));
            dog.setSpayedNeutered(rs.getBoolean(7));
            dog.setStrangerComfortable(rs.getBoolean(8));
            dog.setLargeDogFriendly(rs.getBoolean(9));
            dog.setSmallDogFriendly(rs.getBoolean(10));
            dog.setPuppyFriendly(rs.getBoolean(11));
            return dog;
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        
        return null;
    }

    public int insert(String username, Dog dog) {
        // TODO
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        // dogs table
        String queryDog = "INSERT INTO dogs (NAME, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // users_dogs bridge table
        String queryDog2 = "INSERT INTO users_dogs VALUES (?, ?)";

        return 0;
    }

    public int updateDog(Dog dog) {
        // TODO need to update vaccines, preferably in another method
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryDog = "UPDATE dogs SET name = ?, "
                + "breed = ?, "
                + "weight = ?, "
                + "birth_date = ?, "
                + "gender = ?, "
                + "spayed_neutered = ?, "
                + "stranger_friendly = ?, "
                + "large_friendly = ?, "
                + "small_friendly = ?, "
                + "puppy_friendly = ? "
                + "WHERE pet_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(queryDog);
            ps.setString(1, dog.getName());
            ps.setString(2, dog.getBreed());
            ps.setDouble(3, dog.getWeight());
            ps.setDate(4, dog.getDateOfBirth());
            ps.setString(5, dog.getGender());
            ps.setBoolean(6, dog.isSpayedNeutered());
            ps.setBoolean(7, dog.isStrangerComfortable());
            ps.setBoolean(8, dog.isLargeDogFriendly());
            ps.setBoolean(9, dog.isSmallDogFriendly());
            ps.setBoolean(10, dog.isPuppyFriendly());
            ps.setInt(11, dog.getIdNumber());
        } catch (SQLException e) {
            
        } finally {
            pool.freeConnection(connection);
        }
        
        return 0;
    }

    public ArrayList<Dog> getDogsByUsername(String username) {
        // TODO
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Dog> dogs = new ArrayList();
        String queryDogs = "SELECT * FROM dogs WHERE pet_id = (SELECT * FROM users_dogs WHERE username = ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(queryDogs);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            
            
            return dogs;
        } catch (SQLException e) {
            
        } finally {
            pool.freeConnection(connection);
        }
        
        return null;
    }
}
