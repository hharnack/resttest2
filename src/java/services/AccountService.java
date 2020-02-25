/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.UserDB;
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
        if (udb.insert(user) > 0) {
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) {
        if (udb.updateUser(user) > 0) {
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String password) {
        if (udb.changePassword(username, password) > 0) {
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) {
        System.out.print(username + " " + password);
        return udb.login(username, password);
    }

}
