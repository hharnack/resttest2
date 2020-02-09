/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.UserDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.User;
import models.UserV2;

/**
 *
 * @author 553185
 */
public class AccountService {

    public AccountService() {
    }

    public User login(String username, String password) {
        UserService us = new UserService();
        try {
            User user = us.get(username);

            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception ex) {

            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return null;
    }

    public boolean register(String username, String password, String fname, String lname, String email) {
        UserService us = new UserService();
        try {
            System.out.println("Before UserService.insert");
            int inserted = us.insert(username, password, fname, lname, email);
            System.out.println("After UserService.insert");

            if (inserted > 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return false;
    }

    public boolean checkExisting(String username) {
        UserDB udb = new UserDB();
        try {
            if (udb.getUser(username) != null) {
                return false;
            }
        } catch (Exception e) {
        }

        return true;
    }

    public boolean validatePassword(String parsedPassword, String parsedConfirmPassword) {

        if (parsedPassword.equals(parsedConfirmPassword)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean registerV2(UserV2 user) {
        UserDB udb = new UserDB();
        if (udb.insertV2(user) > 0) {
            return true;
        }
        return false;
    }

}
