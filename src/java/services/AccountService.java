/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.User;
/**
 *
 * @author 553185
 */
public class AccountService {

    public AccountService() {
    }
    
    public User login(String username, String password){
        boolean validUser = isUsernameValid(username);
        boolean validPassword = isPasswordValid(password);
        
        if(validUser && validPassword){
            User user = new User(username, null);
            return user;
        }
        else{
            return null;
        }
    }

    private boolean isUsernameValid(String username) {
        boolean valid = false;
        if(username.equals("Adam") || username.equals("Betty")){
            valid = true;
        }
       return valid;
    }
    
    private boolean isPasswordValid(String password) {
        boolean valid = false;
        if(password.equals("password")){
            valid = true;
        }
       return valid;
    }
    
}
