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
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryDog = "INSERT INTO dogs (NAME, OWNER, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(queryDog);
            ps.setString(1, dog.getName());
            ps.setString(2, username);
            ps.setString(3, dog.getBreed());
            ps.setDouble(4, dog.getWeight());
            ps.setDate(5, dog.getDateOfBirth());
            ps.setString(6, dog.getGender());
            ps.setBoolean(7, dog.isSpayedNeutered());
            ps.setBoolean(8, dog.isStrangerComfortable());
            ps.setBoolean(9, dog.isLargeDogFriendly());
            ps.setBoolean(10, dog.isSmallDogFriendly());
            ps.setBoolean(11, dog.isPuppyFriendly());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }

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
            return ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }

        return 0;
    }

    public ArrayList<Dog> getDogsByUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Dog> dogs = new ArrayList();
        String queryDogs = "SELECT * FROM dogs WHERE owner = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryDogs);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Dog dog = new Dog();
                
                dog.setIdNumber(rs.getInt("pet_id"));
                dog.setName(rs.getString("name"));
                dog.setBreed(rs.getString("breed"));
                dog.setWeight(rs.getDouble("weight"));
                dog.setDateOfBirth(rs.getDate("birth_date"));
                dog.setGender(rs.getString("gender"));
                dog.setSpayedNeutered(rs.getBoolean("spayed_neutered"));
                dog.setStrangerComfortable(rs.getBoolean("stranger_friendly"));
                dog.setLargeDogFriendly(rs.getBoolean("large_friendly"));
                dog.setSmallDogFriendly(rs.getBoolean("small_friendly"));
                dog.setPuppyFriendly(rs.getBoolean("puppy_friendly"));
                
                dogs.add(dog);
            }
            
            return dogs;
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }

        return null;
    }
}
