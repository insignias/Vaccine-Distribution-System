/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.DistributorWarehouseOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DistributorWarehouseRole.DistributorWarehouseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class DistributorWarehouseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organization organization, EcoSystem ecoSystem) {
        return new DistributorWarehouseWorkAreaJPanel(userProcessContainer,account,(DistributorWarehouseEnterprise)enterprise,(DistributorWarehouseOrganization)organization, ecoSystem);
    }
    
}
