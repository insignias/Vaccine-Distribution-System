/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.CDCOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CDCRole.CDCOrgWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class CDCRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new CDCOrgWorkAreaJPanel(userProcessContainer, (CDCEnterprise)enterprise, account,(CDCOrganization)organization, ecoSystem);
    }
    
}
