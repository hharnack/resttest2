/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
/**
 *
 * @author 553185
 */
public class AccountService {

    public AccountService() {
    }
    
    public User login(String username, String password){
        UserService us = new UserService();
        try {
            User user = us.get(username);
            
            if(user.getPassword().equals(password)){
                return user;
            }
        } catch (Exception ex) {
            return null;
            //Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean register(String username, String password, String fname, String lname, String email){
        UserService us = new UserService();
        try {
            int inserted = us.insert(username, password, fname, lname, email);
            
            if(inserted > 0){
                return true;
            }
        } catch (Exception ex) {
            return false;
            //Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
