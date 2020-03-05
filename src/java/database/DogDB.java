package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Dog;
import models.Vaccine;
import models.Veterinarian;

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

    // SELECT QUERIES
    /**
     *
     * @param idNumber
     * @return
     */
    public Dog getDogByID(int idNumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM dogs WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
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
            dog.setAllergies(getDogAllergies(dog.getIdNumber()));
            dog.setMedications(getDogMedications(dog.getIdNumber()));
            dog.setVaccines(getDogVaccine(dog.getIdNumber()));
            dog.setVeterinarian(getDogVeterinarian(dog.getIdNumber()));
            return dog;
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    public ArrayList<Dog> getDogsByUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Dog> dogs = new ArrayList();
        String query = "SELECT * FROM dogs WHERE owner = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
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
                dog.setAllergies(getDogAllergies(dog.getIdNumber()));
                dog.setMedications(getDogMedications(dog.getIdNumber()));
                dog.setVaccines(getDogVaccine(dog.getIdNumber()));
                dog.setVeterinarian(getDogVeterinarian(dog.getIdNumber()));
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

    private ArrayList<String> getDogAllergies(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT allergy FROM dogs_allergies WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                rs.first();
                return new ArrayList<>(Arrays.asList(rs.getString("allergy").split(",")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ArrayList<String> getDogMedications(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT medication FROM dogs_medication WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                rs.first();
                return new ArrayList<>(Arrays.asList(rs.getString("medication").split(",")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    private ArrayList<Vaccine> getDogVaccine(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM dogs_vaccine WHERE PET_ID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Vaccine> vacs = new ArrayList<>();
            while (rs.next()) {
                vacs.add(new Vaccine(rs.getString("vaccine"), rs.getDate("expiration")));
            }
            return vacs;
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    private Veterinarian getDogVeterinarian(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryVet = "SELECT * FROM veterinarians WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryVet);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                Veterinarian vet = new Veterinarian();
                vet.setIdNumber(rs.getInt("vet_id"));
                vet.setName(rs.getString("name"));
                vet.setClinic(rs.getString("clinic"));
                vet.setPhoneNumber(rs.getString("phone_number"));
                return vet;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    // INSERT QUERIES
    /**
     *
     * @param username
     * @param dog
     * @return
     */
    public int insert(String username, Dog dog) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs (NAME, OWNER, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
            ps.executeUpdate();
            dog.setIdNumber(ps.getGeneratedKeys().getInt(1)); // Get primary key from inserted statement
            if (dog.getAllergies().size() > 0) {
                insertDogAllergies(dog.getIdNumber(), dog.getAllergies());
            }
            if (dog.getMedications().size() > 0) {
                insertDogMedications(dog.getIdNumber(), dog.getMedications());
            }
            if (dog.getVaccines().size() > 0) {
                insertDogVaccines(dog.getIdNumber(), dog.getVaccines());
            }
            insertDogVeterinarian(dog.getIdNumber(), dog.getVeterinarian());
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    private void insertDogAllergies(int petID, ArrayList<String> allergies) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs_allergy VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            StringBuilder sb = new StringBuilder();
            for (String s : allergies) {
                sb.append(s);
                sb.append(",");
            }
            ps.setString(2, sb.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void insertDogMedications(int petID, ArrayList<String> medications) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs_medication VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            StringBuilder sb = new StringBuilder();
            for (String s : medications) {
                sb.append(s);
                sb.append(",");
            }
            ps.setString(2, sb.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void insertDogVaccines(int petID, ArrayList<Vaccine> vaccines) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs_vaccine (PET_ID, VACCINE, EXPIRATION) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            for (Vaccine v : vaccines) {
                ps.setString(2, v.getVaccine());
                ps.setDate(3, v.getExpirationDate());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void insertDogVeterinarian(int petID, Veterinarian vet) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO veterinarians (PET_ID, NAME, CLINIC, PHONE_NUMBER) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ps.setString(2, vet.getName());
            ps.setString(3, vet.getClinic());
            ps.setString(4, vet.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    // UPDATE QUERIES
    /**
     *
     * @param dog
     * @return
     */
    public int updateDog(Dog dog) {
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
            if (dog.getAllergies().size() > 0) {
                updateDogAlgy(dog.getIdNumber(), dog.getAllergies());
            }
            if (dog.getMedications().size() > 0) {
                updateDogMed(dog.getIdNumber(), dog.getMedications());
            }
            if (dog.getVaccines().size() > 0) {
                updateDogVac(dog.getVaccines());
            }
            updateDogVet(dog.getVeterinarian());
            return ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }

        return 0;
    }

    private void updateDogMed(int petID, ArrayList<String> meds) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryMed = "UPDATE dogs_medication SET medication = ? WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryMed);
            ps.setInt(2, petID);
            for (String s : meds) {
                ps.setString(1, s);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void updateDogAlgy(int petID, ArrayList<String> algys) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE dogs_allergy SET allergy = ? WHERE pet_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, petID);
            for (String s : algys) {
                ps.setString(1, s);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void updateDogVac(ArrayList<Vaccine> vacs) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE dogs_vaccine SET vaccine = ?, expiration = ? WHERE vac_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            for (Vaccine vac : vacs) {
                ps.setString(1, vac.getVaccine());
                ps.setDate(2, vac.getExpirationDate());
                ps.setInt(3, vac.getVaccineID());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }
    }

    private void updateDogVet(Veterinarian veterinarian) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE veterinarians SET name = ?, clinic = ?, phone_number = ? WHERE vet_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, veterinarian.getName());
            ps.setString(2, veterinarian.getClinic());
            ps.setString(3, veterinarian.getPhoneNumber());
            ps.setInt(4, veterinarian.getIdNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }
    
    // DELETE QUERIES
    public int deleteDog(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "DELETE FROM dogs WHERE pet_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
}
