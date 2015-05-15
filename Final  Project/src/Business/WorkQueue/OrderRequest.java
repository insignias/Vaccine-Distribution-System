/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

/**
 *
 * @author relaince
 */
public class OrderRequest extends WorkRequest{
    
    //private String vaccineName;
    
    private int orderId;
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
    
    
    
    @Override
    
    public String toString(){
        return getVaccineName();
    }
    
}
