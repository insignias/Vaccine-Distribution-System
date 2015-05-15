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
public class Order {
    
    private ArrayList<OrderItem>orderItemList;
    private int orderNumber;
    //private static int count=0;
    
    public Order()
    {
        //count++;
        //System.out.println("business.order order number :  "  +count);
        //orderNumber = count;
        orderItemList = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public static int getCount() {
//        return count;
//    }

  
    
    public void removeOrderItem(OrderItem o)
    {
        int avail = o.getVaccine().getAvail();
        int newavail = avail + o.getQuantity();
        o.getVaccine().setAvail(newavail);
        
        orderItemList.remove(o);
    }
    
    public OrderItem addOrderItem(Vaccine p, int quantity)
    {
        OrderItem o = new OrderItem();
        o.setVaccine(p);
        o.setQuantity(quantity);
        System.out.println("uqantity :"+quantity);
        orderItemList.add(o);
        return o;
    }
    
      @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
}
