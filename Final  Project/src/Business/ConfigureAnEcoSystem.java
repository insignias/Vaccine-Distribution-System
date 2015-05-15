/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Person.Person;
import static Business.Person.Person.PersonType.SysAdmin;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author relaince
 */
public class ConfigureAnEcoSystem {

    public static EcoSystem configure(){
    
    
    EcoSystem ecoSystem = EcoSystem.getInstance();
    
    Person person = ecoSystem.getPersonDirectory().createAndAddPerson("Samir",SysAdmin);
    UserAccount userAccount = ecoSystem.getUserAccountDirectory().createAndAddUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
    
    return ecoSystem;
    }
}
