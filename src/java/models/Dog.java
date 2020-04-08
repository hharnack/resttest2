package models;

import java.sql.Date;
import java.util.ArrayList;

/**
 * This class contains information and operations to create a dog object.
 *
 * @author Hans Cabrera
 */
public class Dog {

    private String owner;
    private int idNumber;
    private String name;
    private String breed;
    private Date dateOfBirth;
    private String gender;
    private double weight;
    private boolean spayedNeutered;
    private String medications;
    private String allergies;
    private String physLimit;
    private Veterinarian veterinarian;
    private boolean strangerComfortable;
    private boolean largeDogFriendly;
    private boolean smallDogFriendly;
    private boolean puppyFriendly;
    private Vaccines vaccines;
    private boolean active;
    private String photoPath;
    private boolean trainingDone;

    /**
     * Default constructor.
     */
    public Dog() {
    }

    /**
     * Gets the owner's username.
     *
     * @return The owner's username.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the dog's owner's username.
     *
     * @param owner The owner's username.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the id number.
     *
     * @return The id number.
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the id number.
     *
     * @param idNumber The id number.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the breed.
     *
     * @return The breed.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed.
     *
     * @param breed The breed.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Gets the date of birth.
     *
     * @return The date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth The date of birth.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the gender.
     *
     * @return The gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender The gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the weight.
     *
     * @return The weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight The weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Indicates whether the dog has been spayed or neutered.
     *
     * @return true if the dog is spayed or neutered.
     */
    public boolean isSpayedNeutered() {
        return spayedNeutered;
    }

    /**
     * Sets whether the dog has been spayed or neutered.
     *
     * @param spayedNeutered If the dog has been spayed or neutered.
     */
    public void setSpayedNeutered(boolean spayedNeutered) {
        this.spayedNeutered = spayedNeutered;
    }

    /**
     * Gets the list of medications.
     *
     * @return A list of medications.
     */
    public String getMedications() {
        return medications;
    }

    /**
     * Sets the list of medications.
     *
     * @param medications A list of medications.
     */
    public void setMedications(String medications) {
        this.medications = medications;
    }

    /**
     * Gets the list of allergies.
     *
     * @return A list of allergies.
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * Sets the list of allergies.
     *
     * @param allergies A list of allergies.
     */
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    /**
     * Gets the dog's physical limitations.
     *
     * @return The dog's physical limitations.
     */
    public String getPhysLimit() {
        return physLimit;
    }

    /**
     * Sets the dog's physical limitations.
     *
     * @param physLimit The dog's physical limitations.
     */
    public void setPhysLimit(String physLimit) {
        this.physLimit = physLimit;
    }

    /**
     * Gets the dog's veterinarian.
     *
     * @return The dog's veterinarian.
     */
    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    /**
     * Sets the dog's veterinarian.
     *
     * @param veterinarian The dog's veterinarian.
     */
    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    /**
     * Indicates whether the dog is comfortable around strangers.
     *
     * @return true if the dog is comfortable around strangers.
     */
    public boolean isStrangerComfortable() {
        return strangerComfortable;
    }

    /**
     * Sets whether the dog is comfortable around strangers.
     *
     * @param strangerComfortable If the dog is comfortable around strangers.
     */
    public void setStrangerComfortable(boolean strangerComfortable) {
        this.strangerComfortable = strangerComfortable;
    }

    /**
     * Indicates whether the dog is comfortable around larger dogs.
     *
     * @return true if the dog is comfortable around larger dogs
     */
    public boolean isLargeDogFriendly() {
        return largeDogFriendly;
    }

    /**
     * Sets whether the dog is comfortable around larger dogs
     *
     * @param largeDogFriendly If the dog is comfortable around larger dogs
     */
    public void setLargeDogFriendly(boolean largeDogFriendly) {
        this.largeDogFriendly = largeDogFriendly;
    }

    /**
     * Indicates whether the dog is comfortable around smaller dogs.
     *
     * @return true if the dog is comfortable around smaller dogs.
     */
    public boolean isSmallDogFriendly() {
        return smallDogFriendly;
    }

    /**
     * Sets whether the dog is comfortable around smaller dogs.
     *
     * @param smallDogFriendly If the dog is comfortable around smaller dogs.
     */
    public void setSmallDogFriendly(boolean smallDogFriendly) {
        this.smallDogFriendly = smallDogFriendly;
    }

    /**
     * Indicates whether the dog is comfortable around puppies.
     *
     * @return true if the dog is comfortable around puppies.
     */
    public boolean isPuppyFriendly() {
        return puppyFriendly;
    }

    /**
     * Sets whether the dog is comfortable around puppies.
     *
     * @param puppyFriendly If the dog is comfortable around puppies.
     */
    public void setPuppyFriendly(boolean puppyFriendly) {
        this.puppyFriendly = puppyFriendly;
    }

    /**
     * Gets the vaccines.
     *
     * @return The vaccines.
     */
    public Vaccines getVaccines() {
        return vaccines;
    }

    /**
     * Sets the vaccines.
     *
     * @param vaccines The vaccines.
     */
    public void setVaccines(Vaccines vaccines) {
        this.vaccines = vaccines;
    }

    /**
     * Indicates whether the dog has been soft deleted from the system or not.
     *
     * @return If the dog has been soft deleted from the system or not.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether the dog has been soft deleted from the system or not.
     *
     * @param active If the dog has been soft deleted from the system or not.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the photo path in the file system for the dog.
     *
     * @return The photo path in the file system for the dog.
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * Sets the photo path in the file system for the dog.
     *
     * @param photoPath The photo path in the file system for the dog.
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    /**
     * Indicates whether the dog has received previous training.
     *
     * @return If the dog has received previous training.
     */
    public boolean isTrainingDone() {
        return trainingDone;
    }

    /**
     * Sets whether the dog has received previous training.
     *
     * @param trainingDone If the dog has received previous training.
     */
    public void setTrainingDone(boolean trainingDone) {
        this.trainingDone = trainingDone;
    }
}
