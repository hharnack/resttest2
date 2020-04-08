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
import models.Vaccines;
import models.Veterinarian;

/**
 * This class is used to perform all queries required by the system to manage
 * all information regarding dogs.
 *
 * @author Hans Cabrera
 */
public class DogDB {

    // SELECT QUERIES
    /**
     * Queries the database to return the information of a dog with the
     * specified ID number.
     *
     * @param petID the ID of the dog.
     * @return a dog with the specified ID number.
     */
    public Dog getDogByID(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM dogs WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            Dog dog = new Dog();
            rs.next();
            dog.setIdNumber(rs.getInt("pet_id"));
            dog.setOwner(rs.getString("owner"));
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
            dog.setPhysLimit(rs.getString("phys_limit"));
            dog.setPhotoPath(rs.getString("photo_path"));
            dog.setActive(rs.getBoolean("isactive"));
            dog.setTrainingDone(rs.getBoolean("training_done"));
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

    /**
     * Queries the database to return the information of all dogs that belong to
     * a specified user.
     *
     * @param username the username of the owner of the dogs.
     * @return a list of dogs that belong to the username specified.
     */
    public ArrayList<Dog> getDogsByUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM dogs WHERE owner = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            ArrayList<Dog> dogs = new ArrayList();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setIdNumber(rs.getInt("pet_id"));
                dog.setOwner(username);
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
                dog.setPhysLimit(rs.getString("phys_limit"));
                dog.setPhotoPath(rs.getString("photo_path"));
                dog.setActive(rs.getBoolean("isactive"));
                dog.setTrainingDone(rs.getBoolean("training_done"));
                dog.setAllergies(getDogAllergies(dog.getIdNumber()));
                dog.setMedications(getDogMedications(dog.getIdNumber()));
                dog.setVaccines(getDogVaccine(dog.getIdNumber()));
                dog.setVeterinarian(getDogVeterinarian(dog.getIdNumber()));
                if (dog.isActive()) {
                    dogs.add(dog);
                }
            }
            return dogs;
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to return all of the dog information.
     *
     * @return a list containing all the dogs that have not been soft deleted in
     * the database.
     */
    public ArrayList<Dog> getAllDogs() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM DOGS WHERE isactive = true";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Dog> dogs = new ArrayList<>();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setIdNumber(rs.getInt("pet_id"));
                dog.setOwner(rs.getString("owner"));
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
                dog.setPhysLimit(rs.getString("phys_limit"));
                dog.setPhotoPath(rs.getString("photo_path"));
                dog.setAllergies(getDogAllergies(dog.getIdNumber()));
                dog.setMedications(getDogMedications(dog.getIdNumber()));
                dog.setVaccines(getDogVaccine(dog.getIdNumber()));
                dog.setVeterinarian(getDogVeterinarian(dog.getIdNumber()));
                dogs.add(dog);
            }
            return dogs;
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to return the allergy information of a dog with the
     * specified ID number.
     *
     * @param petID the ID of the dog.
     * @return a list of allergies that belong to the dog.
     */
    private ArrayList<String> getDogAllergies(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT allergy FROM dogs_allergy WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                return new ArrayList<>(Arrays.asList(rs.getString("allergy").split(",")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to return the medication information of a dog with
     * the specified ID number.
     *
     * @param petID the ID of the dog.
     * @return a list of medications that belong to the dog.
     */
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
                return new ArrayList<>(Arrays.asList(rs.getString("medication").split(",")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to return the vaccine information of a dog with the
     * specified ID number.
     *
     * @param petID the ID of the dog.
     * @return a list of vaccines that belong to the dog.
     */
    private Vaccines getDogVaccine(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT da2pp, rabies, bordetella FROM dogs_vaccines WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Vaccines(rs.getDate("da2pp"), rs.getDate("rabies"), rs.getDate("bordetella"));
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to return the veterinarian information of a dog with
     * the specified ID number.
     *
     * @param petID the ID of the dog.
     * @return a veterinarian object that belong to the dog.
     */
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
                vet.setVetName(rs.getString("name"));
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
     * Queries the database to insert a dog into the system.
     *
     * @param username the username that the dog belongs to.
     * @param dog a dog object to insert into the database.
     * @return the number of row(s) inserted to the database, should always be
     * either 0 or 1.
     */
    public int insert(String username, Dog dog) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs (NAME, OWNER, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY, PHYS_LIMIT, PHOTO_PATH, ISACTIVE, TRAINING_DONE)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
            ps.setString(12, dog.getPhysLimit());
            ps.setString(13, dog.getPhotoPath());
            ps.setBoolean(14, true);
            ps.setBoolean(15, dog.isTrainingDone());
            ps.executeUpdate();
            // Get the primary key
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            dog.setIdNumber(rs.getInt(1));

            if (dog.getAllergies().size() > 0) {
                insertDogAllergies(dog.getIdNumber(), dog.getAllergies());
            }
            if (dog.getMedications().size() > 0) {
                insertDogMedications(dog.getIdNumber(), dog.getMedications());
            }
            insertDogVaccines(dog.getIdNumber(), dog.getVaccines());
            insertDogVeterinarian(dog.getIdNumber(), dog.getVeterinarian());
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    /**
     * Queries the database to insert the allergy information for a dog.
     *
     * @param petID the ID number of the pet that the allergy information
     * belongs to.
     * @param allergies a list of allergies that belong to the dog.
     */
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

    /**
     * Queries the database to insert the medication information for a dog.
     *
     * @param petID the ID number of the pet that the medication information
     * belongs to.
     * @param medications a list of medications that belong to the dog.
     */
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

    /**
     * Queries the database to insert the vaccine information for a dog.
     *
     * @param petID the ID number of the pet that the vaccine information
     * belongs to.
     * @param vaccines the vaccine information that belongs to the dog.
     */
    private void insertDogVaccines(int petID, Vaccines vaccines) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO dogs_vaccines VALUES (?, ?, ? ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ps.setDate(2, vaccines.getDa2pp());
            ps.setDate(3, vaccines.getRabies());
            ps.setDate(4, vaccines.getBordetella());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    /**
     * Queries the database to insert the veterinarian information for a dog.
     *
     * @param petID the ID number of the pet that the veterinarian belongs to.
     * @param vet a veterinarian object that belongs to the dog.
     */
    private void insertDogVeterinarian(int petID, Veterinarian vet) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO veterinarians (PET_ID, NAME, CLINIC, PHONE_NUMBER) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            ps.setString(2, vet.getVetName());
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
     * Queries a database to update a dog based on the pet ID specified.
     *
     * @param dog a dog object with all the dog information.
     * @return the number of rows inserted into the database, should always be
     * either 0 or 1.
     */
    public int updateDog(String username, Dog dog) {
        System.out.println(dog.getIdNumber());
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryDog = "UPDATE dogs SET owner = ?"
                + "name = ?, "
                + "breed = ?, "
                + "weight = ?, "
                + "birth_date = ?, "
                + "gender = ?, "
                + "spayed_neutered = ?, "
                + "stranger_friendly = ?, "
                + "large_friendly = ?, "
                + "small_friendly = ?, "
                + "puppy_friendly = ?, "
                + "phys_limit = ?, "
                + "photo_path = ?, "
                + "training_done = ? "
                + "WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryDog);
            ps.setString(1, username);
            ps.setString(2, dog.getName());
            ps.setString(3, dog.getBreed());
            ps.setDouble(4, dog.getWeight());
            ps.setDate(5, dog.getDateOfBirth());
            ps.setString(6, dog.getGender());
            ps.setBoolean(7, dog.isSpayedNeutered());
            ps.setBoolean(8, dog.isStrangerComfortable());
            ps.setBoolean(9, dog.isLargeDogFriendly());
            ps.setBoolean(10, dog.isSmallDogFriendly());
            ps.setBoolean(11, dog.isPuppyFriendly());
            ps.setString(12, dog.getPhysLimit());
            ps.setString(13, dog.getPhotoPath());
            ps.setBoolean(14, dog.isTrainingDone());
            ps.setInt(15, dog.getIdNumber());
            if (dog.getAllergies().size() > 0) {
                updateDogAlgy(dog.getIdNumber(), dog.getAllergies());
            }
            if (dog.getMedications().size() > 0) {
                updateDogMed(dog.getIdNumber(), dog.getMedications());
            }
            updateDogVac(dog.getIdNumber(), dog.getVaccines());
            updateDogVet(dog.getVeterinarian());
            return ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    /**
     * Queries a database to update a dog's medications based on the pet ID
     * specified.
     *
     * @param petID the ID number of the dog.
     * @param medications the list of medications that belong to the dog.
     */
    private void updateDogMed(int petID, ArrayList<String> medications) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryMed = "UPDATE dogs_medication SET medication = ? WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryMed);
            ps.setInt(2, petID);
            for (String s : medications) {
                ps.setString(1, s);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    /**
     * Queries a database to update a dog's allergies based on the pet ID
     * specified.
     *
     * @param petID the ID number of the dog.
     * @param allergies the list of allergies that belong to the dog.
     */
    private void updateDogAlgy(int petID, ArrayList<String> allergies) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE dogs_allergy SET allergy = ? WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, petID);
            for (String s : allergies) {
                ps.setString(1, s);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    /**
     * Queries a database to update a dog's vaccines based on the pet ID
     * specified.
     *
     * @param petID the ID number of the dog.
     * @param vaccines a vaccine object.
     */
    private void updateDogVac(int petID, Vaccines vaccines) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE dogs_vaccines SET da2pp = ?, "
                + "rabies = ?, "
                + "bordetella = ?"
                + "WHERE pet_id = ?";
        System.out.println("updateDogVac()");
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, vaccines.getDa2pp());
            ps.setDate(2, vaccines.getRabies());
            ps.setDate(3, vaccines.getBordetella());
            ps.setInt(4, petID);
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
    }

    /**
     * Queries a database to update a dog's veterinarian based on the pet ID
     * specified.
     *
     * @param verterinarian a veterinarian object.
     */
    private void updateDogVet(Veterinarian veterinarian) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE veterinarians SET name = ?, clinic = ?, phone_number = ? WHERE vet_id = ?";
        System.out.println("updateDogVet()");
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, veterinarian.getVetName());
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
    /**
     * Queries the database to perform a soft delete on a dog, this method will
     * only set the value of the isactive column to false.
     *
     * @param petID the dog's ID number.
     * @return the number of rows inserted into the database, should always be
     * either 0 or 1.
     */
    public int deleteDog(int petID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE dogs SET isactive = false WHERE pet_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, petID);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DogDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
}
