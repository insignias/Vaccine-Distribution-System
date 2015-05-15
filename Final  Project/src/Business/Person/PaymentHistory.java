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
public class PaymentHistory {
    
    private ArrayList<Payment> paymentList;

    public PaymentHistory() {
        paymentList = new ArrayList<>();
    }

    public ArrayList<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }
    
    public Payment createAndAddPayment(){
        Payment payment = new Payment();
        paymentList.add(payment);
        return payment;
    }
    
    
}
