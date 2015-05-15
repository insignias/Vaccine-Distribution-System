/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.Organization.InsuranceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.InsuranceRole.InsuranceWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author insignia
 */
public class InsuranceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new InsuranceWorkAreaJPanel(userProcessContainer, (InsuranceEnterprise)enterprise, account, (InsuranceOrganization)organization, ecoSystem);
    }
    
}
