/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.HospitalRole.HospitalWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class HospitalRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new HospitalWorkAreaJPanel(userProcessContainer, (HospitalEnterprise)enterprise, account, (HospitalOrganization)organization, ecoSystem);
    }
    
}
