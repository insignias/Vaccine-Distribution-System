/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author insignia
 */
public class Admin extends Person{
    
    private static int count;
    private int adminID;

    public Admin() {
        count++;
        adminID = count;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    
    
    
}
