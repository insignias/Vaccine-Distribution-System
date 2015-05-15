/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import java.util.ArrayList;



/**
 *
 * @author relaince
 */
public class UserAccountDirectory {
    
    private  ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccount createAndAddUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        System.out.println("username " +username);
        System.out.println("password " +password);
        System.out.println("person " +person);
        System.out.println("role " +role);
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount authenticateUser(String username, String password){
            
                for(UserAccount ua : userAccountList){
                    System.out.println("loop");
                if(ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                    System.out.println("username and password match");
                    System.out.println("username: " +ua.getUsername());
                    System.out.println("password: " +ua.getPassword());
                    System.out.println("person : " +ua.getPerson());
                    System.out.println("role: " +ua.getRole());
                    return ua;
                    
                }
                
            }
            return null;
        }
    
     public boolean checkIfUsernameUnique(String username){
        for(UserAccount ua : userAccountList){
            if(ua.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
}

