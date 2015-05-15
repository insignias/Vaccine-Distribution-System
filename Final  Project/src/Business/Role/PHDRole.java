/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PHDEnterprise;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.PHDRole.PHDWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class PHDRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new PHDWorkAreaJPanel(userProcessContainer,account, (PHDEnterprise)enterprise, (PHDOrganization)organization,ecoSystem);
    }
    
}
