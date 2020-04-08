/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * Training appointment object child class
 * @author 640195 Carsen Johns
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

    /**
     *
     * Constructor for training appointment
     * 
     * @param barking
     * @param chewingDestruction
     * @param counterSurfing
     * @param digging
     * @param jumping
     * @param pullingOnLeash
     * @param buildingConfidence
     * @param chewing
     * @param handling
     * @param houseTraining
     * @param mouthing
     * @param socialization
     * @param childrenAndDogs
     * @param distractionStrategies
     * @param exercise
     * @param focusStrategies
     * @param looseLeashWalking
     * @param matWork
     * @param play
     * @param stealingItemsChaseGame
     * @param additionalHouseholdMembers
     * @param newBaby
     * @param newCat
     * @param newDog
     * @param newHome
     * @param newSignificantOther
     * @param idNumber
     * @param dogid
     * @param username
     * @param startTime
     * @param endTime
     * @param total
     * @param amountPaid
     * @param isApproved
     * @param isCancelled
     * @param isPaid
     * @param type
     * @param additionalComments
     * @param dogNames
     */
    public Training(boolean barking, boolean chewingDestruction, boolean counterSurfing, boolean digging, boolean jumping, boolean pullingOnLeash, boolean buildingConfidence, boolean chewing, boolean handling, boolean houseTraining, boolean mouthing, boolean socialization, boolean childrenAndDogs, boolean distractionStrategies, boolean exercise, boolean focusStrategies, boolean looseLeashWalking, boolean matWork, boolean play, boolean stealingItemsChaseGame, boolean additionalHouseholdMembers, boolean newBaby, boolean newCat, boolean newDog, boolean newHome, boolean newSignificantOther, int idNumber, String dogid, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments, String dogNames) {
        super(idNumber, dogid, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, type, additionalComments, dogNames);
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

    /**
     *Default constructor
     */
    public Training() {
        super();
    }
    
    /**
     * getter for is barking
     * @return
     */
    public boolean isBarking() {
        return barking;
    }

    /**
     *setter for is barking
     * @param barking
     */
    public void setBarking(boolean barking) {
        this.barking = barking;
    }

    /**
     * getter for isChewingDestruction
     * @return
     */
    public boolean isChewingDestruction() {
        return chewingDestruction;
    }

    /**
     *setter for ChewingDistruction
     * @param chewingDestruction
     */
    public void setChewingDestruction(boolean chewingDestruction) {
        this.chewingDestruction = chewingDestruction;
    }

    /**
     *Getter for counterSurfing
     * @return
     */
    public boolean isCounterSurfing() {
        return counterSurfing;
    }

    /**
     *Setter for counterSurfing
     * @param counterSurfing
     */
    public void setCounterSurfing(boolean counterSurfing) {
        this.counterSurfing = counterSurfing;
    }

    /**
     *getting for digging
     * @return
     */
    public boolean isDigging() {
        return digging;
    }

    /**
     *setter for digging
     * @param digging
     */
    public void setDigging(boolean digging) {
        this.digging = digging;
    }

    /**
     *getter for jumping
     * @return
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     *setter for jumping
     * @param jumping
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     *getter for pullingOnLeash
     * @return
     */
    public boolean isPullingOnLeash() {
        return pullingOnLeash;
    }

    /**
     *setter for pullingOnLeash
     * @param pullingOnLeash
     */
    public void setPullingOnLeash(boolean pullingOnLeash) {
        this.pullingOnLeash = pullingOnLeash;
    }

    /**
     *getter for buildingConfidence
     * @return
     */
    public boolean isBuildingConfidence() {
        return buildingConfidence;
    }

    /**
     *Setter for buildingConfidence
     * @param buildingConfidence
     */
    public void setBuildingConfidence(boolean buildingConfidence) {
        this.buildingConfidence = buildingConfidence;
    }

    /**
     *getter for chewing
     * @return
     */
    public boolean isChewing() {
        return chewing;
    }

    /**
     *sets chewing
     * @param chewing
     */
    public void setChewing(boolean chewing) {
        this.chewing = chewing;
    }

    /**
     *getter for handling
     * @return
     */
    public boolean isHandling() {
        return handling;
    }

    /**
     *setter for handling
     * @param handling
     */
    public void setHandling(boolean handling) {
        this.handling = handling;
    }

    /**
     *getter for houseTraining
     * @return
     */
    public boolean isHouseTraining() {
        return houseTraining;
    }

    /**
     *setter for houseTraining
     * @param houseTraining
     */
    public void setHouseTraining(boolean houseTraining) {
        this.houseTraining = houseTraining;
    }

    /**
     *getter for mouthing
     * @return
     */
    public boolean isMouthing() {
        return mouthing;
    }

    /**
     *setter for mouthing
     * @param mouthing
     */
    public void setMouthing(boolean mouthing) {
        this.mouthing = mouthing;
    }

    /**
     *getter for socialization
     * @return
     */
    public boolean isSocialization() {
        return socialization;
    }

    /**
     *setter for socialization
     * @param socialization
     */
    public void setSocialization(boolean socialization) {
        this.socialization = socialization;
    }

    /**
     *getting for childrenAndDogs
     * @return
     */
    public boolean isChildrenAndDogs() {
        return childrenAndDogs;
    }

    /**
     *setter for childrenAndDogs
     * @param childrenAndDogs
     */
    public void setChildrenAndDogs(boolean childrenAndDogs) {
        this.childrenAndDogs = childrenAndDogs;
    }

    /**
     *getter for distractionStrategies
     * @return
     */
    public boolean isDistractionStrategies() {
        return distractionStrategies;
    }

    /**
     *setter for distractionStrategies
     * @param distractionStrategies
     */
    public void setDistractionStrategies(boolean distractionStrategies) {
        this.distractionStrategies = distractionStrategies;
    }

    /**
     *getter for exercise
     * @return
     */
    public boolean isExercise() {
        return exercise;
    }

    /**
     *setter for exercise
     * @param exercise
     */
    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    /**
     *getter for focusStrategies
     * @return
     */
    public boolean isFocusStrategies() {
        return focusStrategies;
    }

    /**
     *setter  for focusStrategies
     * @param focusStrategies
     */
    public void setFocusStrategies(boolean focusStrategies) {
        this.focusStrategies = focusStrategies;
    }

    /**
     *getter for looseLeashWalking
     * @return
     */
    public boolean isLooseLeashWalking() {
        return looseLeashWalking;
    }

    /**
     *setter for looseLeashWalking
     * @param looseLeashWalking
     */
    public void setLooseLeashWalking(boolean looseLeashWalking) {
        this.looseLeashWalking = looseLeashWalking;
    }

    /**
     *getter for matWork
     * @return
     */
    public boolean isMatWork() {
        return matWork;
    }

    /**
     *setter for matWork
     * @param matWork
     */
    public void setMatWork(boolean matWork) {
        this.matWork = matWork;
    }

    /**
     *getter for play
     * @return
     */
    public boolean isPlay() {
        return play;
    }

    /**
     *setter for play
     * @param play
     */
    public void setPlay(boolean play) {
        this.play = play;
    }

    /**
     *getter for stealingItemsChaseGame
     * @return
     */
    public boolean isStealingItemsChaseGame() {
        return stealingItemsChaseGame;
    }

    /**
     *setter for StealingitemsChaseGame
     * @param stealingItemsChaseGame
     */
    public void setStealingItemsChaseGame(boolean stealingItemsChaseGame) {
        this.stealingItemsChaseGame = stealingItemsChaseGame;
    }

    /**
     *getter for additionalHouseholdMembers
     * @return
     */
    public boolean isAdditionalHouseholdMembers() {
        return additionalHouseholdMembers;
    }

    /**
     *setter for additionalHouseholdMembers
     * @param additionalHouseholdMembers
     */
    public void setAdditionalHouseholdMembers(boolean additionalHouseholdMembers) {
        this.additionalHouseholdMembers = additionalHouseholdMembers;
    }

    /**
     *getter for newBaby
     * @return
     */
    public boolean isNewBaby() {
        return newBaby;
    }

    /**
     *setter for newBaby
     * @param newBaby
     */
    public void setNewBaby(boolean newBaby) {
        this.newBaby = newBaby;
    }

    /**
     *getter for newCat
     * @return
     */
    public boolean isNewCat() {
        return newCat;
    }

    /**
     *setter for newCat
     * @param newCat
     */
    public void setNewCat(boolean newCat) {
        this.newCat = newCat;
    }

    /**
     *getter for newDog
     * @return
     */
    public boolean isNewDog() {
        return newDog;
    }

    /**
     *setter for newDog
     * @param newDog
     */
    public void setNewDog(boolean newDog) {
        this.newDog = newDog;
    }

    /**
     *getter for newHome
     * @return
     */
    public boolean isNewHome() {
        return newHome;
    }

    /**
     *setter for newHome
     * @param newHome
     */
    public void setNewHome(boolean newHome) {
        this.newHome = newHome;
    }

    /**
     *getter for newSignificantOther
     * @return
     */
    public boolean isNewSignificantOther() {
        return newSignificantOther;
    }

    /**
     *setter for significantOther
     * @param newSignificantOther
     */
    public void setNewSignificantOther(boolean newSignificantOther) {
        this.newSignificantOther = newSignificantOther;
    }
}
