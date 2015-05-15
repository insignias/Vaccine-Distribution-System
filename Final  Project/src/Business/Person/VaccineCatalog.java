/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author relaince
 */
public class VaccineCatalog {
    
    private ArrayList<Vaccine> vaccineCatalog;
    
    public VaccineCatalog() {
        vaccineCatalog = new ArrayList<Vaccine>();
    }

    public ArrayList<Vaccine> getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(ArrayList<Vaccine> vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    
    
    
    public Vaccine addVaccine() {
        Vaccine p = new Vaccine();
        vaccineCatalog.add(p);
        return p;
    }
    
    
    
    public void removeVaccine(Vaccine p) {
        vaccineCatalog.remove(p);
    }
    
    public Vaccine searchVaccine(int id) {
        
        for(Vaccine p : vaccineCatalog) {
            if(p.getModelNumber() == id) {
                
                return p;
                
            }
        }
        JOptionPane.showMessageDialog(null,"ID not present");
        return null;
    }
    
    
    
    public Vaccine bestProduct(VaccineCatalog pc) {
        
        int max_quantity=0;
        Vaccine max_product = null;
        //ArrayList<Product> result = new ArrayList<Product>();
        for(Vaccine p : vaccineCatalog) {
            //System.out.println("product " +p.getProductCata);
            if (max_quantity < p.getProdQuantSold())
            {
                max_quantity = p.getProdQuantSold();
                max_product = p;
                System.out.println("max product 1st: " +p.getProdName());
            }
            System.out.println("max product: " +p.getProdName());
            return p;
        } 
        
        return null;
    }      
    
}
