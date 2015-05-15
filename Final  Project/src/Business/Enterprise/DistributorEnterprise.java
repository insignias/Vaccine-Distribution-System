/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class DistributorEnterprise extends Enterprise{

    
    private ArrayList<DistributorWarehouseEnterprise> DistWarehouseEnterpriseList;
    
    public DistributorEnterprise(String name, EnterpriseType type) {
        super(name, EnterpriseType.Distributor);
        DistWarehouseEnterpriseList = new ArrayList<>();
    }

    public ArrayList<DistributorWarehouseEnterprise> getDistWarehouseEnterpriseList() {
        return DistWarehouseEnterpriseList;
    }

    public void setDistWarehouseEnterpriseList(ArrayList<DistributorWarehouseEnterprise> DistWarehouseEnterpriseList) {
        this.DistWarehouseEnterpriseList = DistWarehouseEnterpriseList;
    }

    
    public DistributorWarehouseEnterprise createEnterprise(DistributorWarehouseEnterprise distributorWarehouseEnterprise){
        DistWarehouseEnterpriseList.add(distributorWarehouseEnterprise);
        return distributorWarehouseEnterprise;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
