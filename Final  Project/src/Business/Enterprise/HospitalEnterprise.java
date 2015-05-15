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
public class HospitalEnterprise extends Enterprise{

    private ArrayList<ClinicEnterprise> clinicEnterpriseList;
    
    public HospitalEnterprise(String name, EnterpriseType type) {
        super(name, EnterpriseType.Hospital);
        clinicEnterpriseList = new ArrayList<>();
    }

    public ArrayList<ClinicEnterprise> getClinicEnterpriseList() {
        return clinicEnterpriseList;
    }

    public void setClinicEnterpriseList(ArrayList<ClinicEnterprise> clinicEnterpriseList) {
        this.clinicEnterpriseList = clinicEnterpriseList;
    }

    
//    public Enterprise createEnterprise(String name, Enterprise.EnterpriseType type){
//        Enterprise enterprise = null;
//        if(type == Enterprise.EnterpriseType.Clinic){
//            enterprise = new ClinicEnterprise(name,type);
//            clinicEnterpriseList.add(enterprise);
//        }
//        return enterprise;
//    }
    
    public ClinicEnterprise createEnterprise(ClinicEnterprise clinicEnterprise){
        clinicEnterpriseList.add(clinicEnterprise);
        return clinicEnterprise;
    }
    
    public boolean checkIfClinicUnique(String name){
        for(ClinicEnterprise e : clinicEnterpriseList){
            if(e.getName().equals(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
