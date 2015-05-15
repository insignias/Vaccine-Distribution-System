/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Network.Network;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class CDCEnterprise extends Enterprise{
    
    private ArrayList<PHDEnterprise> phdEnterpriseList;

    public CDCEnterprise(String name , EnterpriseType type) {
        super(name, EnterpriseType.CDC);
        phdEnterpriseList = new ArrayList<>();
        }

    public ArrayList<PHDEnterprise> getPhdEnterpriseList() {
        return phdEnterpriseList;
    }

    public void setPhdEnterpriseList(ArrayList<PHDEnterprise> phdEnterpriseList) {
        this.phdEnterpriseList = phdEnterpriseList;
    }

        
    public PHDEnterprise createEnterprise(PHDEnterprise phdEnterprise){
        phdEnterpriseList.add(phdEnterprise);
        return phdEnterprise;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
