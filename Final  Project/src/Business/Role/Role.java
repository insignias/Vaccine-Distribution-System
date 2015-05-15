/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public abstract class Role {
    
    public enum RoleType
    {
        EnterpriseAdmin("EnterpriseAdmin"),
        CDC("CDC"),
        Distributor("Distributor"),
        Provider("Provider"),
        Manufacturer("Manufacturer"),
        Clinic("Clinic"),
        Pharmaceutical("Pharmaceutical"),
        Insurance("Insurance"),
        Hospital("Hospital");
        
        private String value;

        private RoleType(String value) {
            this.value = value;
        }
        
        public String getRoleType(){
            return value;
        }
        
        @Override
        public String toString()
        {
            return value;
        }
        }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem);
            
    @Override
    public String toString()
            {
                return this.getClass().getName();
            }
    
    
}
