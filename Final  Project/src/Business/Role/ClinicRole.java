/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ClinicRole.ClinicWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ClinicRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new ClinicWorkAreaJPanel(userProcessContainer,account,enterprise, (ClinicOrganization)organization, ecoSystem);
    }
    
}
