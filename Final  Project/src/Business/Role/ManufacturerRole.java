/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ManufacturerRole.ManufacturerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ManufacturerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new ManufacturerWorkAreaJPanel(userProcessContainer, (ManufacturerEnterprise)enterprise, account, (ManufacturerOrganization)organization, ecoSystem);
    }
    
}
