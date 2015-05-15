/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
       
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public boolean checkIfOrgUnique(Organization.Type otype){
        for(Organization o : organizationList){
            if(otype.getValue().equals(o.getName())){
                return false;
            }
        }
        return true;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Hospital.getValue())){
            organization = new HospitalOrganization();
            organizationList.add(organization);
            System.out.println("Hospital Org created");
        }
        if (type.getValue().equals(Organization.Type.CDC.getValue())){
            organization = new CDCOrganization();
            organizationList.add(organization);
            System.out.println("CDC Org created");
        }
        if (type.getValue().equals(Organization.Type.PHD.getValue())){
            organization = new PHDOrganization();
            organizationList.add(organization);
            System.out.println("PHD Org created");
        }
        if (type.getValue().equals(Organization.Type.Distributor.getValue())){
            organization = new DistributorOrganization();
            organizationList.add(organization);
            System.out.println("Distributor Org created");
        }
        if (type.getValue().equals(Organization.Type.DistributorWarehouse.getValue())){
            organization = new DistributorWarehouseOrganization();
            organizationList.add(organization);
            System.out.println("DistributorWarehouse Org created");
        }
        if (type.getValue().equals(Organization.Type.Clinic.getValue())){
            organization = new ClinicOrganization();
            organizationList.add(organization);
            System.out.println("Clinic Org created");
        }
        if (type.getValue().equals(Organization.Type.Provider.getValue())){
            organization = new ProviderOrganization();
            organizationList.add(organization);
            System.out.println("Provider Org created");
        }
        if (type.getValue().equals(Organization.Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
            System.out.println("Patient Org created");
        }
        if (type.getValue().equals(Organization.Type.Insurance.getValue())){
            organization = new InsuranceOrganization();
            organizationList.add(organization);
            System.out.println("Insurance Org created");
        }
        if (type.getValue().equals(Organization.Type.Pharmaceutical.getValue())){
            organization = new PharmaceuticalOrganization();
            organizationList.add(organization);
            System.out.println("Pharmaceutical Org created");
        }
        if (type.getValue().equals(Organization.Type.Manufacturer.getValue())){
            organization = new ManufacturerOrganization();
            organizationList.add(organization);
            System.out.println("Manufacturer Org created");
        }
        return organization;
    }
    
}
