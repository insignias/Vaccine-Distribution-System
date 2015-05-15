/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author insignia
 */
public class PatientRequest extends WorkRequest{
    
    private String patientName;
    private String patientAddress;
    private String patientContact;
    private String insuranceInfo;
    private float totalPrice;
    private String orderDate;
    private String paymentStatus;
    private static int count;
    private int patientRequestID;

    public PatientRequest() {
        count++;
        patientRequestID = count;
    }
    
    
    
    
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getPatientRequestID() {
        return patientRequestID;
    }

    public void setPatientRequestID(int patientRequestID) {
        this.patientRequestID = patientRequestID;
    }

    @Override
    
    public String toString(){
        return getPatientName();
    }
    
    
    
}
