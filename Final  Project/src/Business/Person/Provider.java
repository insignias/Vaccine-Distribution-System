/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Enterprise.HospitalEnterprise;
import Business.WorkQueue.OrderRequest;
import java.util.ArrayList;

/**
 *
 * @author insignia
 */
public class Provider extends Person{
    
    private static int count;
    private int providerID;

    public Provider() {
        count++;
        providerID = count;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }
    
    
}
