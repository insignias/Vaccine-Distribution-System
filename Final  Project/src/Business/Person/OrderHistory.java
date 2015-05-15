/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author relaince
 */
public class OrderHistory {
    
    private ArrayList<Order> orderHistory;

    public OrderHistory() {
        orderHistory = new ArrayList<Order>();
       
    }
    
    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }
    
    public void setOrderHistory(ArrayList<Order> orderHistory){
        this.orderHistory = orderHistory;
    }
    
    public Order addOrder(Order order){
        
        orderHistory.add(order);
        return order;
    }
    

}
