/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person createAndAddPerson(String name, Person.PersonType pt)
    {
        Person person = null;
            if(pt.getValue().equals(Person.PersonType.Manufacturer.getValue())){
                 person = new Manufacturer();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.InsuranceAdmin.getValue())){
                 person = new InsuranceAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.Provider.getValue())){
                 person = new Provider();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.HospitalAdmin.getValue())){
                 person = new HospitalAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.PharmaceuticalAdmin.getValue())){
                 person = new HospitalAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.Clinician.getValue())){
                 person = new Clinician();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.CDCAdmin.getValue())){
                 person = new CDCAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.DistributorWarehouseAdmin.getValue())){
                person = new DistributorWarehouseAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.PHDAdmin.getValue())){
                person = new PHDAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                person = new EnterpriseAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.Patient.getValue())){
                person = new Patient();
                 person.setName(name);
                 personList.add(person);
            }
            if(pt.getValue().equals(Person.PersonType.DistributorAdmin.getValue())){
                person = new DistributorAdmin();
                 person.setName(name);
                 personList.add(person);
            }
            
       // }
        return person;
                
            
//        Person person = new Person();
//        person.setName(name);
//        personList.add(person);
//        return person;
    
    
    }  
}

