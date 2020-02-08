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

    private int idNumber;
    private String name;
    private Date dateOfBirth;
    private double weight;
    private boolean spayedNeutered;
    private ArrayList<String> medications;
    private ArrayList<String> allergies;
    private ArrayList<Vaccine> vaccines;
    private boolean strangerComfortable;
    private boolean largeDogFriendly;
    private boolean smallDogFriendly;
    private boolean puppyFriendly;

    public Dog() {
    }

    public Dog(int idNumber, String name, Date dateOfBirth, double weight, boolean spayedNeutered, ArrayList<String> medications, ArrayList<String> allergies, ArrayList<Vaccine> vaccines, boolean strangerComfortable, boolean largeDogFriendly, boolean smallDogFriendly, boolean puppyFriendly) {
        this.idNumber = idNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.spayedNeutered = spayedNeutered;
        this.medications = medications;
        this.allergies = allergies;
        this.vaccines = vaccines;
        this.strangerComfortable = strangerComfortable;
        this.largeDogFriendly = largeDogFriendly;
        this.smallDogFriendly = smallDogFriendly;
        this.puppyFriendly = puppyFriendly;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public ArrayList<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(ArrayList<Vaccine> vaccines) {
        this.vaccines = vaccines;
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

}
