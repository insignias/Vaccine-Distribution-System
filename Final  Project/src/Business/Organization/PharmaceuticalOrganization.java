/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.PharmaceuticalRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class PharmaceuticalOrganization extends Organization{

    public PharmaceuticalOrganization() {
        super(Organization.Type.Pharmaceutical.getValue());
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new PharmaceuticalRole());
        return roleList;
    }
    
}
