/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 703174 - Hans Cabrera
 */
public class Dog {

    private String photoPath;
    private int idNumber;
    private String name;
    private String breed;
    private Date dateOfBirth;
    private String gender;
    private double weight;
    private boolean spayedNeutered;
    private ArrayList<String> medications;
    private ArrayList<String> allergies;
    private String physLimit;
    private Veterinarian veterinarian;
    private boolean strangerComfortable;
    private boolean largeDogFriendly;
    private boolean smallDogFriendly;
    private boolean puppyFriendly;
    private Vaccines vaccines;
    private boolean active;
    private boolean trainingDone;
    public boolean isTrainingDone() {
        return trainingDone;
    }
    public void setTrainingDone(boolean trainingDone) {
        this.trainingDone = trainingDone;
    }
    public Dog() {
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSpayedNeutered() {
        return spayedNeutered;
    }

    public void setSpayedNeutered(boolean spayedNeutered) {
        this.spayedNeutered = spayedNeutered;
    }

    public ArrayList<String> getMedications() {
        return medications;
    }

    public void setMedications(ArrayList<String> medications) {
        this.medications = medications;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public String getPhysLimit() {
        return physLimit;
    }

    public void setPhysLimit(String physLimit) {
        this.physLimit = physLimit;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public boolean isStrangerComfortable() {
        return strangerComfortable;
    }

    public void setStrangerComfortable(boolean strangerComfortable) {
        this.strangerComfortable = strangerComfortable;
    }

    public boolean isLargeDogFriendly() {
        return largeDogFriendly;
    }

    public void setLargeDogFriendly(boolean largeDogFriendly) {
        this.largeDogFriendly = largeDogFriendly;
    }

    public boolean isSmallDogFriendly() {
        return smallDogFriendly;
    }

    public void setSmallDogFriendly(boolean smallDogFriendly) {
        this.smallDogFriendly = smallDogFriendly;
    }

    public boolean isPuppyFriendly() {
        return puppyFriendly;
    }

    public void setPuppyFriendly(boolean puppyFriendly) {
        this.puppyFriendly = puppyFriendly;
    }

    public Vaccines getVaccines() {
        return vaccines;
    }

    public void setVaccines(Vaccines vaccines) {
        this.vaccines = vaccines;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
