/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Appointment;
import models.Boarding;
import models.Daycare;
import models.Training;

/**
 *
 * @author 640195
 */
public class AppointmentDB {

    public boolean insert(Boarding bAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "INSERT INTO appointments(dog_id, username, boarding, training, date_start,date_end,total_cost,amount_paid,isapproved,iscancelled,ispaid,comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        String queryBoarding = "INSERT INTO BOARDING(BOARDING_ID,GROOMING) VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, bAppt.getDogIdNumber());
            ps.setString(2, bAppt.getUsername());
            ps.setBoolean(3, true);
            ps.setBoolean(4, false);
            ps.setDate(5, bAppt.getStartTime());
            ps.setDate(6, bAppt.getEndTime());
            ps.setDouble(7, bAppt.getTotal());
            ps.setDouble(8, bAppt.getAmountPaid());
            ps.setBoolean(9, bAppt.IsApproved());
            ps.setBoolean(10, bAppt.isCancelled());
            ps.setBoolean(11, bAppt.isPaid());
            ps.setString(12, bAppt.getAdditionalComments());
            if (ps.executeUpdate() != 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                bAppt.setIdNumber(rs.getInt(1));
                ps = connection.prepareCall(queryBoarding);
                ps.setInt(1, bAppt.getIdNumber());
                ps.setBoolean(2, bAppt.isGrooming());
                if (ps.executeUpdate() != 0) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    public boolean insert(Training tAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "INSERT INTO appointments(dog_id, username, boarding, training, date_start,date_end,total_cost,amount_paid,isapproved,iscancelled,ispaid,comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        String queryTraining = "INSERT INTO training(TRAINING_ID,BARKING,CHEWINGDESTRUCTION,"
                + "COUNTERSURFING,DIGGING,JUMPING,PULLINGONLEASH,BUILDINGCONFIDENCE,CHEWING,"
                + "HANDLING,HOUSETRAINING,MOUTHING,SOCIALIZATION,CHILDRENANDDOGS,DISTRACTIONSTRATEGIES,"
                + "EXERCISE,FOCUSSTRATEGIES,LOOSELEASHWALKING,MATWORK,PLAY,STEALINGITEMSCHASEGAME,"
                + "NEWHOUSEHOLDMEMBERS,NEWBABY,NEWCAT,NEWDOG,NEWHOME,NEWSIGNIFICANTOTHER) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, tAppt.getDogIdNumber());
            ps.setString(2, tAppt.getUsername());
            ps.setBoolean(3, false);
            ps.setBoolean(4, true);
            ps.setDate(5, tAppt.getStartTime());
            ps.setDate(6, tAppt.getEndTime());
            ps.setDouble(7, tAppt.getTotal());
            ps.setDouble(8, tAppt.getAmountPaid());
            ps.setBoolean(9, tAppt.IsApproved());
            ps.setBoolean(10, tAppt.isCancelled());
            ps.setBoolean(11, tAppt.isPaid());
            ps.setString(12, tAppt.getAdditionalComments());
            if (ps.executeUpdate() != 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                tAppt.setIdNumber(rs.getInt(1));
                ps = connection.prepareCall(queryTraining);
                ps.setInt(1, tAppt.getIdNumber());
                ps.setBoolean(2, tAppt.isBarking());
                ps.setBoolean(3, tAppt.isChewingDestruction());
                ps.setBoolean(4, tAppt.isCounterSurfing());
                ps.setBoolean(5, tAppt.isDigging());
                ps.setBoolean(6, tAppt.isJumping());
                ps.setBoolean(7, tAppt.isPullingOnLeash());
                ps.setBoolean(8, tAppt.isBuildingConfidence());
                ps.setBoolean(9, tAppt.isChewing());
                ps.setBoolean(10, tAppt.isHandling());
                ps.setBoolean(11, tAppt.isHouseTraining());
                ps.setBoolean(12, tAppt.isMouthing());
                ps.setBoolean(13, tAppt.isSocialization());
                ps.setBoolean(14, tAppt.isChildrenAndDogs());
                ps.setBoolean(15, tAppt.isDistractionStrategies());
                ps.setBoolean(16, tAppt.isExercise());
                ps.setBoolean(17, tAppt.isFocusStrategies());
                ps.setBoolean(18, tAppt.isLooseLeashWalking());
                ps.setBoolean(19, tAppt.isMatWork());
                ps.setBoolean(20, tAppt.isPlay());
                ps.setBoolean(21, tAppt.isStealingItemsChaseGame());
                ps.setBoolean(22, tAppt.isAdditionalHouseholdMembers());
                ps.setBoolean(23, tAppt.isNewBaby());
                ps.setBoolean(24, tAppt.isNewCat());
                ps.setBoolean(25, tAppt.isNewDog());
                ps.setBoolean(26, tAppt.isNewHome());
                ps.setBoolean(27, tAppt.isNewSignificantOther());
                if (ps.executeUpdate() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return false;

    }

    public boolean insert(Daycare dAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "INSERT INTO appointments(dog_id, username, boarding, training, date_start,date_end,total_cost,amount_paid,isapproved,iscancelled,ispaid,comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dAppt.getDogIdNumber());
            ps.setString(2, dAppt.getUsername());
            ps.setBoolean(3, false);
            ps.setBoolean(4, false);
            ps.setDate(5, dAppt.getStartTime());
            ps.setDate(6, dAppt.getEndTime());
            ps.setDouble(7, dAppt.getTotal());
            ps.setDouble(8, dAppt.getAmountPaid());
            ps.setBoolean(9, dAppt.IsApproved());
            ps.setBoolean(10, dAppt.isCancelled());
            ps.setBoolean(11, dAppt.isPaid());
            ps.setString(12, dAppt.getAdditionalComments());

            if (ps.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    public ArrayList<Appointment> getAppointmentsByUsername(String username) {
          ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "SELECT * FROM appointments WHERE username = ?";
        ArrayList<Appointment> aList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Appointment appt = new Appointment();
                appt.setIdNumber(rs.getInt("APPT_ID"));
                appt.setDogIdNumber(rs.getString("DOG_ID"));
                appt.setUsername(rs.getString("USERNAME"));
                appt.setIsBoarding(rs.getBoolean("Boarding"));
                appt.setIsTraining(rs.getBoolean("Training"));
                appt.setStartTime(rs.getDate("DATE_START"));
                appt.setEndTime(rs.getDate("DATE_END"));
                appt.setTotal(rs.getDouble("TOTAL_COST"));
                appt.setAmountPaid(rs.getDouble("AMOUNT_PAID"));
                appt.setIsApproved(rs.getBoolean("ISAPPROVED"));
                appt.setIsCancelled(rs.getBoolean("ISCANCELLED"));
                appt.setIsPaid(rs.getBoolean("ISPAID"));
                appt.setAdditionalComments(rs.getString("COMMENTS"));
                if(!appt.isIsTraining() && !appt.isIsBoarding()){
                    aList.add(appt);
                } else if (appt.isIsTraining() && !appt.isIsBoarding()){
  
                   String queryTraining = "SELECT * FROM training WHERE training_id = ?";
                   ps = null; 
                   ps = connection.prepareStatement(queryTraining);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rst = ps.executeQuery();
                    Training train = new Training();
                    train.setIdNumber(appt.getIdNumber());
                    train.setDogIdNumber(appt.getDogIdNumber());
                    train.setUsername(appt.getUsername());
                    train.setIsTraining(true);
                    train.setIsBoarding(false);
                    train.setStartTime(appt.getStartTime());
                    train.setEndTime(appt.getEndTime());
                    train.setTotal(appt.getTotal());
                    train.setAmountPaid(appt.getAmountPaid());
                    train.setIsApproved(appt.IsApproved());
                    train.setIsCancelled(appt.isCancelled());
                    train.setIsPaid(appt.isPaid());
                    train.setAdditionalComments(appt.getAdditionalComments());
                    rst.next();
                    train.setBarking(rst.getBoolean("BARKING"));
                    train.setChewingDestruction(rst.getBoolean("CHEWINGDESTRUCTION"));
                    train.setCounterSurfing(rst.getBoolean("COUNTERSURFING"));
                    train.setDigging(rst.getBoolean("DIGGING"));
                    train.setJumping(rst.getBoolean("DIGGING"));
                    train.setPullingOnLeash(rst.getBoolean("PULLINGONLEASH"));
                    train.setBuildingConfidence(rst.getBoolean("BUILDINGCONFIDENCE"));
                    train.setChewing(rst.getBoolean("CHEWING"));
                    train.setHandling(rst.getBoolean("HANDLING"));
                    train.setHouseTraining(rst.getBoolean("HOUSETRAINING"));
                    train.setMouthing(rst.getBoolean("MOUTHING"));
                    train.setSocialization(rst.getBoolean("SOCIALIZATION"));
                    train.setChildrenAndDogs(rst.getBoolean("CHILDRENANDDOGS"));
                    train.setDistractionStrategies(rst.getBoolean("DISTRACTIONSTRATEGIES"));
                    train.setExercise(rst.getBoolean("EXERCISE"));
                    train.setFocusStrategies(rst.getBoolean("FOCUSSTRATEGIES"));
                    train.setLooseLeashWalking(rst.getBoolean("LOOSELEASHWALKING"));
                    train.setMatWork(rst.getBoolean("MATWORK"));
                    train.setPlay(rst.getBoolean("PLAY"));
                    train.setStealingItemsChaseGame(rst.getBoolean("STEALINGITEMSCHASEGAME"));
                    train.setAdditionalHouseholdMembers(rst.getBoolean("NEWHOUSEHOLDMEMBERS"));
                    train.setNewBaby(rst.getBoolean("NEWBABY"));
                    train.setNewCat(rst.getBoolean("NEWCAT"));
                    train.setNewDog(rst.getBoolean("NEWDOG"));
                    train.setNewHome(rst.getBoolean("NEWHOME"));
                    train.setNewSignificantOther(rst.getBoolean("NEWSIGNIFICANTOTHER"));
                    aList.add(train);
                    System.out.println(train.toString());
                    rst.close();
                } else if(appt.isIsBoarding() && !appt.isIsTraining()){
                    String queryBoarding = "SELECT * FROM boarding WHERE boarding_id = ?";
                    ps = null;
                    ps = connection.prepareStatement(queryBoarding);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rsb = ps.executeQuery();
                    Boarding board = new Boarding();
                    board.setIdNumber(rs.getInt(appt.getIdNumber()));
                    board.setDogIdNumber(appt.getDogIdNumber());
                    board.setUsername(appt.getUsername());
                    board.setIsTraining(true);
                    board.setIsBoarding(false);
                    board.setStartTime(appt.getStartTime());
                    board.setEndTime(appt.getEndTime());
                    board.setTotal(appt.getTotal());
                    board.setAmountPaid(appt.getAmountPaid());
                    board.setIsApproved(appt.IsApproved());
                    board.setIsCancelled(appt.isCancelled());
                    board.setIsPaid(appt.isPaid());
                    board.setAdditionalComments(appt.getAdditionalComments());
                    rsb.next();
                    board.setGrooming(rsb.getBoolean("GROOMING"));
                    aList.add(board);
                    rsb.close();
                }
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
}
