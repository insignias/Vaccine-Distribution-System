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
public class EnterpriseAdmin extends Person{
    
    private static int count;
    private int enterpriseAdminID;

    public EnterpriseAdmin() {
        count++;
        enterpriseAdminID = count;
    }

    public int getEnterpriseAdminID() {
        return enterpriseAdminID;
    }

    public void setEnterpriseAdminID(int enterpriseAdminID) {
        this.enterpriseAdminID = enterpriseAdminID;
    }
    
    
    
}
