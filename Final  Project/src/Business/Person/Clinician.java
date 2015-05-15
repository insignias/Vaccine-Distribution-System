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
public class Clinician extends Person{
    
    private VaccineCatalog vaccineCatalog;
    private static int count;
    private int clinicianID;
    
    

    public Clinician() {
        vaccineCatalog = new VaccineCatalog();
        
        count++;
        clinicianID = count;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public int getClinicianID() {
        return clinicianID;
    }

    public void setClinicianID(int clinicianID) {
        this.clinicianID = clinicianID;
    }
    
    
}
