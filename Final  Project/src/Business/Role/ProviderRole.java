/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.Organization;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ProviderRole.ProviderWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ProviderRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new ProviderWorkAreaJPanel(userProcessContainer,account,(ProviderEnterprise)enterprise,(ProviderOrganization)organization,ecoSystem);
    }
    
}
