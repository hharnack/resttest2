/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author 640195
 */
public class Training extends Appointment{
    boolean barking;
    boolean chewingDestruction;
    boolean counterSurfing;
    boolean digging;
    boolean jumping;
    boolean pullingOnLeash;
    boolean buildingConfidence;
    boolean chewing;
    boolean handling;
    boolean houseTraining;
    boolean mouthing;
    boolean socialization;
    boolean childrenAndDogs;
    boolean distractionStrategies;
    boolean exercise;
    boolean focusStrategies;
    boolean looseLeashWalking;
    boolean matWork;
    boolean play;
    boolean stealingItemsChaseGame;
    boolean additionalHouseholdMembers;
    boolean newBaby;
    boolean newCat;
    boolean newDog;
    boolean newHome;
    boolean newSignificantOther;

    public Training(boolean barking, boolean chewingDestruction, boolean counterSurfing, boolean digging, boolean jumping, boolean pullingOnLeash, boolean buildingConfidence, boolean chewing, boolean handling, boolean houseTraining, boolean mouthing, boolean socialization, boolean childrenAndDogs, boolean distractionStrategies, boolean exercise, boolean focusStrategies, boolean looseLeashWalking, boolean matWork, boolean play, boolean stealingItemsChaseGame, boolean additionalHouseholdMembers, boolean newBaby, boolean newCat, boolean newDog, boolean newHome, boolean newSignificantOther, int idNumber, String username, Date startTime, Date endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String additionalComments) {
        super(idNumber, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, additionalComments);
        this.barking = barking;
        this.chewingDestruction = chewingDestruction;
        this.counterSurfing = counterSurfing;
        this.digging = digging;
        this.jumping = jumping;
        this.pullingOnLeash = pullingOnLeash;
        this.buildingConfidence = buildingConfidence;
        this.chewing = chewing;
        this.handling = handling;
        this.houseTraining = houseTraining;
        this.mouthing = mouthing;
        this.socialization = socialization;
        this.childrenAndDogs = childrenAndDogs;
        this.distractionStrategies = distractionStrategies;
        this.exercise = exercise;
        this.focusStrategies = focusStrategies;
        this.looseLeashWalking = looseLeashWalking;
        this.matWork = matWork;
        this.play = play;
        this.stealingItemsChaseGame = stealingItemsChaseGame;
        this.additionalHouseholdMembers = additionalHouseholdMembers;
        this.newBaby = newBaby;
        this.newCat = newCat;
        this.newDog = newDog;
        this.newHome = newHome;
        this.newSignificantOther = newSignificantOther;
    }

    public Training() {
        super();
    }
    
    public boolean isBarking() {
        return barking;
    }

    public void setBarking(boolean barking) {
        this.barking = barking;
    }

    public boolean isChewingDestruction() {
        return chewingDestruction;
    }

    public void setChewingDestruction(boolean chewingDestruction) {
        this.chewingDestruction = chewingDestruction;
    }

    public boolean isCounterSurfing() {
        return counterSurfing;
    }

    public void setCounterSurfing(boolean counterSurfing) {
        this.counterSurfing = counterSurfing;
    }

    public boolean isDigging() {
        return digging;
    }

    public void setDigging(boolean digging) {
        this.digging = digging;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isPullingOnLeash() {
        return pullingOnLeash;
    }

    public void setPullingOnLeash(boolean pullingOnLeash) {
        this.pullingOnLeash = pullingOnLeash;
    }

    public boolean isBuildingConfidence() {
        return buildingConfidence;
    }

    public void setBuildingConfidence(boolean buildingConfidence) {
        this.buildingConfidence = buildingConfidence;
    }

    public boolean isChewing() {
        return chewing;
    }

    public void setChewing(boolean chewing) {
        this.chewing = chewing;
    }

    public boolean isHandling() {
        return handling;
    }

    public void setHandling(boolean handling) {
        this.handling = handling;
    }

    public boolean isHouseTraining() {
        return houseTraining;
    }

    public void setHouseTraining(boolean houseTraining) {
        this.houseTraining = houseTraining;
    }

    public boolean isMouthing() {
        return mouthing;
    }

    public void setMouthing(boolean mouthing) {
        this.mouthing = mouthing;
    }

    public boolean isSocialization() {
        return socialization;
    }

    public void setSocialization(boolean socialization) {
        this.socialization = socialization;
    }

    public boolean isChildrenAndDogs() {
        return childrenAndDogs;
    }

    public void setChildrenAndDogs(boolean childrenAndDogs) {
        this.childrenAndDogs = childrenAndDogs;
    }

    public boolean isDistractionStrategies() {
        return distractionStrategies;
    }

    public void setDistractionStrategies(boolean distractionStrategies) {
        this.distractionStrategies = distractionStrategies;
    }

    public boolean isExercise() {
        return exercise;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    public boolean isFocusStrategies() {
        return focusStrategies;
    }

    public void setFocusStrategies(boolean focusStrategies) {
        this.focusStrategies = focusStrategies;
    }

    public boolean isLooseLeashWalking() {
        return looseLeashWalking;
    }

    public void setLooseLeashWalking(boolean looseLeashWalking) {
        this.looseLeashWalking = looseLeashWalking;
    }

    public boolean isMatWork() {
        return matWork;
    }

    public void setMatWork(boolean matWork) {
        this.matWork = matWork;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public boolean isStealingItemsChaseGame() {
        return stealingItemsChaseGame;
    }

    public void setStealingItemsChaseGame(boolean stealingItemsChaseGame) {
        this.stealingItemsChaseGame = stealingItemsChaseGame;
    }

    public boolean isAdditionalHouseholdMembers() {
        return additionalHouseholdMembers;
    }

    public void setAdditionalHouseholdMembers(boolean additionalHouseholdMembers) {
        this.additionalHouseholdMembers = additionalHouseholdMembers;
    }

    public boolean isNewBaby() {
        return newBaby;
    }

    public void setNewBaby(boolean newBaby) {
        this.newBaby = newBaby;
    }

    public boolean isNewCat() {
        return newCat;
    }

    public void setNewCat(boolean newCat) {
        this.newCat = newCat;
    }

    public boolean isNewDog() {
        return newDog;
    }

    public void setNewDog(boolean newDog) {
        this.newDog = newDog;
    }

    public boolean isNewHome() {
        return newHome;
    }

    public void setNewHome(boolean newHome) {
        this.newHome = newHome;
    }

    public boolean isNewSignificantOther() {
        return newSignificantOther;
    }

    public void setNewSignificantOther(boolean newSignificantOther) {
        this.newSignificantOther = newSignificantOther;
    }
    
}
