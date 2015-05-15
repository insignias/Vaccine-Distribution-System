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
public class PharmaceuticalEnterprise extends Enterprise{

    private ArrayList<ClinicEnterprise> clinicEnterpriseList;
    
    public PharmaceuticalEnterprise(String name, EnterpriseType type) {
        super(name, EnterpriseType.Pharmaceutical);
        clinicEnterpriseList = new ArrayList<>();
    }

    public ArrayList<ClinicEnterprise> getClinicEnterpriseList() {
        return clinicEnterpriseList;
    }

    public void setClinicEnterpriseList(ArrayList<ClinicEnterprise> clinicEnterpriseList) {
        this.clinicEnterpriseList = clinicEnterpriseList;
    }

    

    public ClinicEnterprise createEnterprise(ClinicEnterprise clinicEnterprise){
        clinicEnterpriseList.add(clinicEnterprise);
        return clinicEnterprise;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
