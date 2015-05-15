/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.EnterpriseAdminRole;
import Business.Role.Role;
import UserInterface.EnterpriseAdminRole.EnterpriseAdminWorkAreaJPanel;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class EnterpriseAdminOrganization extends Organization{

    public EnterpriseAdminOrganization() {
        super(Organization.Type.EnterpriseAdmin.getValue());
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new EnterpriseAdminRole());
        return roleList;
    }
    
}
