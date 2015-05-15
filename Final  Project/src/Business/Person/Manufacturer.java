/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ShippingRequest;
import java.util.ArrayList;

/**
 *
 * @author insignia
 */
public class Manufacturer extends Person{
    
    private static int count;
    private int manufacturerID;
    private VaccineCatalog vaccineCatalog;

    public Manufacturer() {
        count++;
        manufacturerID = count;
        vaccineCatalog = new VaccineCatalog();
    }
 
    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }
    
}
