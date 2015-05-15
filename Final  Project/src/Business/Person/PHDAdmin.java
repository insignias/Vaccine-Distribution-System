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
public class PHDAdmin extends Person{
    
    private static int count;
    private int phdID;

    public PHDAdmin() {
        count++;
        phdID = count;
    }

    public int getPhdID() {
        return phdID;
    }

    public void setPhdID(int phdID) {
        this.phdID = phdID;
    }
    
}
