/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.CDCRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class CDCOrganization extends Organization{

    public CDCOrganization() {
        super(Organization.Type.CDC.getValue());
    }
       
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new CDCRole());
        return roleList;
    }
    
    
}
