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
public class SysAdmin extends Person{
    
    private static int count;
    private int sysAdminID;

    public SysAdmin() {
        count++;
        sysAdminID = count;
    }

    public int getSysAdminID() {
        return sysAdminID;
    }

    public void setSysAdminID(int sysAdminID) {
        this.sysAdminID = sysAdminID;
    }
    
    
    
}
