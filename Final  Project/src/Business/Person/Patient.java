/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author insignia
 */
public class Patient extends Person{
    
    private static int count;
    private int patientID;
    private OrderHistory orderHistory;
    private PaymentHistory paymentHistory;
    private InvoiceHistory invoiceHistory;
    private String insuranceStatus;
    private String insuranceCompany;

    public Patient() {
        count++;
        patientID = count;
        orderHistory = new OrderHistory();
        paymentHistory = new PaymentHistory();
        invoiceHistory = new InvoiceHistory();
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public InvoiceHistory getInvoiceHistory() {
        return invoiceHistory;
    }

    public void setInvoiceHistory(InvoiceHistory invoiceHistory) {
        this.invoiceHistory = invoiceHistory;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    
    
    
    
}
