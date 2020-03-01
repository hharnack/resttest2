/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.UserDB;
import models.Address;
import models.User;

/**
 *
 * @author 553185
 */
public class AccountService {

    UserDB udb;
    
    public AccountService() {
        udb = new UserDB();
    }

    /**
     *
     * @param username
     * @return true if an account with the specified username exists
     */
    public boolean checkUsername(String username) {
        return udb.checkUsername(username);
    }

    public boolean checkEmail(String email) {
        return udb.checkEmail(email);
    }

    public boolean register(User user) {
        return udb.insert(user) > 0;
    }

    public boolean updateUser(User user) {
        return udb.updateUser(user) > 0;
    }

    public boolean changePassword(String username, String password) {
        return udb.changePassword(username, password) > 0;
    }

    public boolean login(String username, String password) {
        return udb.login(username, password);
    }
    
    public User getUser(String username) {
        return udb.getUser(username);
    }
    
    public Address getUserAddress(String username) {
        return udb.getUserAddress(username);
    }

}
