/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

/**
 *
 * @author relaince
 */
public class Person {
    
    private String name;
    private int count;
    private int personID;

    //private VaccineCatalog vaccineCatalog;
    
    public enum PersonType{
        SysAdmin("SysAdmin"),
        Manufacturer("Manufacturer"),
        Clinician("Clinician"),
        EnterpriseAdmin("EnterpriseAdmin"),
        Provider("Provider"),
        DistributorWarehouseAdmin("DistributorWarehouseAdmin"),
        CDCAdmin("CDCAdmin"),
        HospitalAdmin("HospitalAdmin"),
        PHDAdmin("PHDAdmin"),
        Patient("Patient"),
        PharmaceuticalAdmin("PharmaceuticalAdmin"),
        InsuranceAdmin("InsuranceAdmin"),
        DistributorAdmin("DistributorAdmin");
        
        private String value;
        private PersonType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        
    }
    
    
    public Person() {
        count++;
        personID = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    
    @Override
    
    public String toString(){
        return name;
    }
    
}
