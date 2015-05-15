/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null; 
        if(type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.CDC){
            enterprise = new CDCEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.PHD){
            enterprise = new PHDEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Distributor){
            enterprise = new DistributorEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
         if(type == Enterprise.EnterpriseType.DistributorWarehouse){
            enterprise = new DistributorWarehouseEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Clinic){
            enterprise = new ClinicEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Pharmaceutical){
            enterprise = new PharmaceuticalEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Manufacturer){
            enterprise = new ManufacturerEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Insurance){
            enterprise = new InsuranceEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.Provider){
            enterprise = new ProviderEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        return enterprise;
        
    }
    
    public boolean checkIfCDCAndDistributorUnique(Enterprise.EnterpriseType etype){
        for(Enterprise e : enterpriseList){
            System.out.println("eetype: " +etype.getValue());
            System.out.println("e.getEnterprise " +e.getEnterpriseType().getValue());
            if(etype == Enterprise.EnterpriseType.CDC){
            if(etype.getValue().equals(e.getEnterpriseType().getValue())){
                return false;
            }
            }
            if(etype == Enterprise.EnterpriseType.Distributor){
            if(etype.getValue().equals(e.getEnterpriseType().getValue())){
                return false;
            }
            }
        }
        return true;
    }
    
//    public boolean checkIfDistributorUnique(Enterprise.EnterpriseType etype){
//        for(Enterprise e : enterpriseList){
//            if(etype == Enterprise.EnterpriseType.Distributor){
//                return false;
//            }
//        }
//        return true;
//    }
    
    public boolean checkIfClinicUnique(String name){
        for(Enterprise e : enterpriseList){
            if(e.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
    
}
