/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem ecoSystem;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance(){
        if(ecoSystem == null)
        {
            ecoSystem = new EcoSystem();
        }
        return ecoSystem;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        }

    public static EcoSystem getEcoSystem() {
        return ecoSystem;
    }

    public static void setEcoSystem(EcoSystem ecoSystem) {
        EcoSystem.ecoSystem = ecoSystem;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    

    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public boolean searchNetwork(String name){
        for(Network n : networkList){
            if(n.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    
}

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> rolelist = new ArrayList<>();
        rolelist.add(new SystemAdminRole());
        return rolelist;
    }
     
    
}
