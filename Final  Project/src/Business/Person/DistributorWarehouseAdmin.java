/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author insignia
 */
public class DistributorWarehouseAdmin extends Person{
    
    private VaccineCatalog vaccineCatalog;
    private InvoiceHistory invoiceHistory;
    private PaymentHistory paymentHistory;
    

    public DistributorWarehouseAdmin() {
        vaccineCatalog = new VaccineCatalog();
        invoiceHistory = new InvoiceHistory();
        paymentHistory = new PaymentHistory();
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public InvoiceHistory getInvoiceHistory() {
        return invoiceHistory;
    }

    public void setInvoiceHistory(InvoiceHistory invoiceHistory) {
        this.invoiceHistory = invoiceHistory;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
    
    
    
    
    
}
