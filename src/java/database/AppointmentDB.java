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
        //System.out.println(bAppt.getAmountPaid());
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "INSERT INTO appointments(dog_id, username, type, date_start,date_end,total_cost,amount_paid, approved, cancelled, ispaid,comments, deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        String queryBoarding = "INSERT INTO BOARDING(BOARDING_ID,GROOMING) VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, bAppt.getDogIdNumber());
            ps.setString(2, bAppt.getUsername());
            ps.setString(3, bAppt.getType());
            ps.setString(4, bAppt.getStartTime());
            ps.setString(5, bAppt.getEndTime());
            ps.setDouble(6, bAppt.getTotal());
            ps.setDouble(7, bAppt.getAmountPaid());
            ps.setBoolean(8, bAppt.IsApproved());
            ps.setBoolean(9, bAppt.isCancelled());
            ps.setBoolean(10, bAppt.isPaid());
            ps.setString(11, bAppt.getAdditionalComments());
            ps.setBoolean(12, bAppt.isDeleted());
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
        String queryAppointment = "INSERT INTO appointments(dog_id, username, type, date_start,date_end,total_cost,amount_paid,approved,cancelled,ispaid,comments, deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        String queryTraining = "INSERT INTO training(TRAINING_ID,BARKING,CHEWINGDESTRUCTION,"
                + "COUNTERSURFING,DIGGING,JUMPING,PULLINGONLEASH,BUILDINGCONFIDENCE,CHEWING,"
                + "HANDLING,HOUSETRAINING,MOUTHING,SOCIALIZATION,CHILDRENANDDOGS,DISTRACTIONSTRATEGIES,"
                + "EXERCISE,FOCUSSTRATEGIES,LOOSELEASHWALKING,MATWORK,PLAY,STEALINGITEMSCHASEGAME,"
                + "NEWHOUSEHOLDMEMBERS,NEWBABY,NEWCAT,NEWDOG,NEWHOME,NEWSIGNIFICANTOTHER) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, tAppt.getDogIdNumber());
            ps.setString(2, tAppt.getUsername());
            ps.setString(3, tAppt.getType());
            ps.setString(4, tAppt.getStartTime());
            ps.setString(5, tAppt.getEndTime());
            ps.setDouble(6, tAppt.getTotal());
            ps.setDouble(7, tAppt.getAmountPaid());
            ps.setBoolean(8, tAppt.IsApproved());
            ps.setBoolean(9, tAppt.isCancelled());
            ps.setBoolean(10, tAppt.isPaid());
            ps.setString(11, tAppt.getAdditionalComments());
            ps.setBoolean(12, tAppt.isDeleted());
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
        String queryAppointment = "INSERT INTO appointments(dog_id, username, type, date_start,date_end,total_cost,amount_paid,approved,cancelled,ispaid,comments, deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dAppt.getDogIdNumber());
            ps.setString(2, dAppt.getUsername());
            ps.setString(3, dAppt.getType());
            ps.setString(4, dAppt.getStartTime());
            ps.setString(5, dAppt.getEndTime());
            ps.setDouble(6, dAppt.getTotal());
            ps.setDouble(7, dAppt.getAmountPaid());
            ps.setBoolean(8, dAppt.IsApproved());
            ps.setBoolean(9, dAppt.isCancelled());
            ps.setBoolean(10, dAppt.isPaid());
            ps.setString(11, dAppt.getAdditionalComments());
            ps.setBoolean(12, dAppt.isDeleted());
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
        String queryAppointment = "SELECT * FROM appointments WHERE username = ? AND deleted = false";
        ArrayList<Appointment> aList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appointment appt = new Appointment();
                appt.setIdNumber(rs.getInt("APPT_ID"));
                appt.setDogIdNumber(rs.getString("DOG_ID"));
                appt.setUsername(rs.getString("USERNAME"));
                appt.setType(rs.getString("TYPE"));
                appt.setStartTime(rs.getString("DATE_START"));
                appt.setEndTime(rs.getString("DATE_END"));
                appt.setTotal(rs.getDouble("TOTAL_COST"));
                appt.setAmountPaid(rs.getDouble("AMOUNT_PAID"));
                appt.setIsApproved(rs.getBoolean("APPROVED"));
                appt.setIsCancelled(rs.getBoolean("CANCELLED"));
                appt.setIsPaid(rs.getBoolean("ISPAID"));
                appt.setAdditionalComments(rs.getString("COMMENTS"));
                appt.setDeleted(rs.getBoolean("DELETED"));
                if (appt.getType().equals("daycare")) {
                    aList.add(appt);
                } else if (appt.getType().equals("training")) {

                    String queryTraining = "SELECT * FROM training WHERE training_id = ?";
                    ps = null;
                    ps = connection.prepareStatement(queryTraining);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rst = ps.executeQuery();
                    Training train = new Training();
                    train.setIdNumber(appt.getIdNumber());
                    train.setDogIdNumber(appt.getDogIdNumber());
                    train.setUsername(appt.getUsername());
                    train.setType(appt.getType());
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
                    train.setJumping(rst.getBoolean("JUMPING"));
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
                    rst.close();
                } else if (appt.getType().equals("boarding")) {
                    String queryBoarding = "SELECT * FROM boarding WHERE boarding_id = ?";
                    ps = null;
                    ps = connection.prepareStatement(queryBoarding);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rsb = ps.executeQuery();
                    Boarding board = new Boarding();
                    board.setIdNumber(appt.getIdNumber());
                    board.setDogIdNumber(appt.getDogIdNumber());
                    board.setUsername(appt.getUsername());
                    board.setType(appt.getType());
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
        } finally {
            pool.freeConnection(connection);
        }
        return aList;
    }

    public boolean update(Boarding bAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "UPDATE APPOINTMENTS SET DOG_ID = ?, USERNAME = ?, type = ?, date_start = ?, date_end = ?, total_cost = ?, amount_paid = ?, approved = ?, cancelled = ?, ispaid = ?, comments=?, deleted=? WHERE APPT_ID = ?";
        String queryBoarding = "UPDATE BOARDING SET GROOMING=? WHERE BOARDING_ID = ?";
        try {
            PreparedStatement ps = connection.prepareCall(queryAppointment);
            ps.setString(1, bAppt.getDogIdNumber());
            ps.setString(2, bAppt.getUsername());
            ps.setString(3, bAppt.getType());
            ps.setString(4, bAppt.getStartTime());
            ps.setString(5, bAppt.getEndTime());
            ps.setDouble(6, bAppt.getTotal());
            ps.setDouble(7, bAppt.getAmountPaid());
            ps.setBoolean(8, bAppt.IsApproved());
            ps.setBoolean(9, bAppt.isCancelled());
            ps.setBoolean(10, bAppt.isPaid());
            ps.setString(11, bAppt.getAdditionalComments());
            ps.setBoolean(12, bAppt.isDeleted());
            ps.setInt(13, bAppt.getIdNumber());
            
            if (ps.executeUpdate() != 0) {
                ps = connection.prepareCall(queryBoarding);
                ps.setBoolean(1, bAppt.isGrooming());
                ps.setInt(2, bAppt.getIdNumber());
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

    public Boolean update(Training tAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "UPDATE APPOINTMENTS SET DOG_ID = ?, USERNAME = ?, type = ?, date_start = ?, date_end = ?, total_cost = ?, amount_paid = ?, approved = ?, cancelled = ?, ispaid = ?, comments=?, deleted=? WHERE APPT_ID = ?";
        String queryTraining = "UPDATE Training SET barking=?, chewingdestruction=?,countersurfing=?,digging=?,jumping=?,pullingonleash=?,buildingconfidence=?,chewing=?,handling=?,housetraining=?,mouthing=?,socialization=?,childrenanddogs=?,distractionstrategies=?,exercise=?,focusstrategies=?,looseleashwalking=?,matwork=?,play=?,stealingitemschasegame=?,newhouseholdmembers=?,newbaby=?,newcat=?,newdog=?,newhome=?,newsignificantother=? WHERE Training_ID = ?";
        try {
            PreparedStatement ps = connection.prepareCall(queryAppointment);
            ps.setString(1, tAppt.getDogIdNumber());
            ps.setString(2, tAppt.getUsername());
            ps.setString(3, tAppt.getType());
            ps.setString(4, tAppt.getStartTime());
            ps.setString(5, tAppt.getEndTime());
            ps.setDouble(6, tAppt.getTotal());
            ps.setDouble(7, tAppt.getAmountPaid());
            ps.setBoolean(8, tAppt.IsApproved());
            ps.setBoolean(9, tAppt.isCancelled());
            ps.setBoolean(10, tAppt.isPaid());
            ps.setString(11, tAppt.getAdditionalComments());
            ps.setBoolean(12, tAppt.isDeleted());
            ps.setInt(13, tAppt.getIdNumber());
            if (ps.executeUpdate() != 0) {
                ps = connection.prepareCall(queryTraining);
                ps.setBoolean(1, tAppt.isBarking());
                ps.setBoolean(2, tAppt.isChewingDestruction());
                ps.setBoolean(3, tAppt.isCounterSurfing());
                ps.setBoolean(4, tAppt.isDigging());
                ps.setBoolean(5, tAppt.isJumping());
                ps.setBoolean(6, tAppt.isPullingOnLeash());
                ps.setBoolean(7, tAppt.isBuildingConfidence());
                ps.setBoolean(8, tAppt.isChewing());
                ps.setBoolean(9, tAppt.isHandling());
                ps.setBoolean(10, tAppt.isHouseTraining());
                ps.setBoolean(11, tAppt.isMouthing());
                ps.setBoolean(12, tAppt.isSocialization());
                ps.setBoolean(13, tAppt.isChildrenAndDogs());
                ps.setBoolean(14, tAppt.isDistractionStrategies());
                ps.setBoolean(15, tAppt.isExercise());
                ps.setBoolean(16, tAppt.isFocusStrategies());
                ps.setBoolean(17, tAppt.isLooseLeashWalking());
                ps.setBoolean(18, tAppt.isMatWork());
                ps.setBoolean(19, tAppt.isPlay());
                ps.setBoolean(20, tAppt.isStealingItemsChaseGame());
                ps.setBoolean(21, tAppt.isAdditionalHouseholdMembers());
                ps.setBoolean(22, tAppt.isNewBaby());
                ps.setBoolean(23, tAppt.isNewCat());
                ps.setBoolean(24, tAppt.isNewDog());
                ps.setBoolean(25, tAppt.isNewHome());
                ps.setBoolean(26, tAppt.isNewSignificantOther());
                ps.setInt(27, tAppt.getIdNumber());
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

    public ArrayList<Appointment> getAllAppointments() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "SELECT * FROM appointments WHERE deleted = false";
        ArrayList<Appointment> aList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(queryAppointment);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appointment appt = new Appointment();
                appt.setIdNumber(rs.getInt("APPT_ID"));
                appt.setDogIdNumber(rs.getString("DOG_ID"));
                appt.setUsername(rs.getString("USERNAME"));
                appt.setType(rs.getString("TYPE"));
                appt.setStartTime(rs.getString("DATE_START"));
                appt.setEndTime(rs.getString("DATE_END"));
                appt.setTotal(rs.getDouble("TOTAL_COST"));
                appt.setAmountPaid(rs.getDouble("AMOUNT_PAID"));
                appt.setIsApproved(rs.getBoolean("APPROVED"));
                appt.setIsCancelled(rs.getBoolean("CANCELLED"));
                appt.setIsPaid(rs.getBoolean("ISPAID"));
                appt.setAdditionalComments(rs.getString("COMMENTS"));
                appt.setDeleted(rs.getBoolean("deleted"));
                if (appt.getType().equals("daycare")) {
                    aList.add(appt);
                } else if (appt.getType().equals("training")) {

                    String queryTraining = "SELECT * FROM training WHERE training_id = ?";
                    ps = null;
                    ps = connection.prepareStatement(queryTraining);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rst = ps.executeQuery();
                    Training train = new Training();
                    train.setIdNumber(appt.getIdNumber());
                    train.setDogIdNumber(appt.getDogIdNumber());
                    train.setUsername(appt.getUsername());
                    train.setType(appt.getType());
                    train.setStartTime(appt.getStartTime());
                    train.setEndTime(appt.getEndTime());
                    train.setTotal(appt.getTotal());
                    train.setAmountPaid(appt.getAmountPaid());
                    train.setIsApproved(appt.IsApproved());
                    train.setIsCancelled(appt.isCancelled());
                    train.setIsPaid(appt.isPaid());
                    train.setAdditionalComments(appt.getAdditionalComments());
                    train.setDeleted(appt.isDeleted());
                    rst.next();
                    train.setBarking(rst.getBoolean("BARKING"));
                    train.setChewingDestruction(rst.getBoolean("CHEWINGDESTRUCTION"));
                    train.setCounterSurfing(rst.getBoolean("COUNTERSURFING"));
                    train.setDigging(rst.getBoolean("DIGGING"));
                    train.setJumping(rst.getBoolean("JUMPING"));
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
                    rst.close();
                } else if (appt.getType().equals("boarding")) {
                    String queryBoarding = "SELECT * FROM boarding WHERE boarding_id = ?";
                    ps = null;
                    ps = connection.prepareStatement(queryBoarding);
                    ps.setInt(1, appt.getIdNumber());
                    ResultSet rsb = ps.executeQuery();
                    Boarding board = new Boarding();
                    board.setIdNumber(appt.getIdNumber());
                    board.setDogIdNumber(appt.getDogIdNumber());
                    board.setUsername(appt.getUsername());
                    board.setType(appt.getType());
                    board.setStartTime(appt.getStartTime());
                    board.setEndTime(appt.getEndTime());
                    board.setTotal(appt.getTotal());
                    board.setAmountPaid(appt.getAmountPaid());
                    board.setIsApproved(appt.IsApproved());
                    board.setIsCancelled(appt.isCancelled());
                    board.setIsPaid(appt.isPaid());
                    board.setAdditionalComments(appt.getAdditionalComments());
                    board.setDeleted(appt.isDeleted());
                    rsb.next();
                    board.setGrooming(rsb.getBoolean("GROOMING"));
                    aList.add(board);
                    rsb.close();
                }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return aList;
    }

    public boolean update(Daycare dAppt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "UPDATE APPOINTMENTS SET DOG_ID = ?, USERNAME = ?, type = ?, date_start = ?, date_end = ?, total_cost = ?, amount_paid = ?, approved = ?, cancelled = ?, ispaid = ?, comments=?, deleted=? WHERE APPT_ID = ?";
        try {
            PreparedStatement ps = connection.prepareCall(queryAppointment);
            ps.setString(1, dAppt.getDogIdNumber());
            ps.setString(2, dAppt.getUsername());
            ps.setString(3, dAppt.getType());
            ps.setString(4, dAppt.getStartTime());
            ps.setString(5, dAppt.getEndTime());
            ps.setDouble(6, dAppt.getTotal());
            ps.setDouble(7, dAppt.getAmountPaid());
            ps.setBoolean(8, dAppt.IsApproved());
            ps.setBoolean(9, dAppt.isCancelled());
            ps.setBoolean(10, dAppt.isPaid());
            ps.setString(11, dAppt.getAdditionalComments());
            ps.setBoolean(12, dAppt.isDeleted());
            ps.setInt(13, dAppt.getIdNumber());

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

    public boolean delete(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAppointment = "UPDATE APPOINTMENTS SET DELETED = ? WHERE APPT_ID = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(queryAppointment);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            if(ps.executeUpdate() != 0){
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
