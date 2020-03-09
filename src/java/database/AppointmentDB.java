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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ps.setInt(1, bAppt.getDogIdNumber());
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
                + "COUNTERSURFING,DIGGING,JUMPING,PULLINGONLEASH,BUILDINGCONDFIDENCE,CHEWING,"
                + "HANDLING,HOUSETRAINING,MOUTHING,SOCIALIZATION,CHILDRENANDDOGS,DISTRACTIONSTRATEGIES,"
                + "EXERCISE,FOCUSSTRATEGIES,LOOSELEASHWALKING,MATWORK,PLAY,STEALINGITEMSCHASEGAME,"
                + "NEWHOUSEHOLDMEMBERS,NEWBABY,NEWCAT,NEWDOG,NEWHOME,NEWSIGNIFICANTOTHER) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tAppt.getDogIdNumber());
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
            ps.setInt(1, dAppt.getDogIdNumber());
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

}
