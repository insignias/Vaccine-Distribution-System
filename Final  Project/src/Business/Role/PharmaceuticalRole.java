/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.PharmaceuticalRole.PharmaceuticalWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class PharmaceuticalRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new PharmaceuticalWorkAreaJPanel(userProcessContainer, (PharmaceuticalEnterprise)enterprise, account,(PharmaceuticalOrganization)organization, ecoSystem);
    }
    
}
