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
public class CDCAdmin extends Person{
    
    private static int count;
    private int cdcID;

    public CDCAdmin() {
        count++;
        cdcID = count;
    }

    public int getCdcID() {
        return cdcID;
    }

    public void setCdcID(int cdcID) {
        this.cdcID = cdcID;
    }
    
    
    
}
