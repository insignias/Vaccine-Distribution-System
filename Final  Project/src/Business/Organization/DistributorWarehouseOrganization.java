/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.DistributorWarehouseRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class DistributorWarehouseOrganization extends Organization{

    private String location;
    
    public DistributorWarehouseOrganization() {
        super(Organization.Type.DistributorWarehouse.getValue());
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new DistributorWarehouseRole());
        return roleList;
    }
    
}
