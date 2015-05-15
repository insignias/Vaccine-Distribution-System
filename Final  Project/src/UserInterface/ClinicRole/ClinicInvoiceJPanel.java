/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Person.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
import Business.WorkQueue.OrderRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ClinicInvoiceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ClinicOrganization clinicOrg;
    private UserAccount account; 
    private ClinicEnterprise clinicEnterprise;
    private OrderRequest request;
    public ClinicInvoiceJPanel(JPanel userProcessContainer, OrderRequest request, ClinicEnterprise clinicEnterprise, ClinicOrganization clinicOrg, UserAccount account, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.ecoSystem = ecoSystem;
        this.account = account;
        this.clinicEnterprise = clinicEnterprise;
        this.clinicOrg = clinicOrg;
        populateInvoiceTable();
        
            
            
    }

    private void populateInvoiceTable(){
        DefaultTableModel dtm = (DefaultTableModel)invoicejTable.getModel();
        dtm.setRowCount(0);
        
        InvoiceRequest invRequest = new InvoiceRequest();
            invRequest.setVaccineName(request.getVaccineName());
            invRequest.setQuantity(request.getQuantity());
            invRequest.setSender(account);
            invRequest.setStatus("sent");
            invRequest.setRequestID(request.getRequestID());
            invRequest.setEnterpriseType(request.getEnterpriseType());
            invRequest.setEnterpriseName(request.getEnterpriseName());
            invRequest.setLocation(request.getLocation());
        Object[] row = new Object[5];
        row[0] = invRequest;
        row[1] = invRequest.getRequestID();
        row[2] = invRequest.getQuantity();
        row[3] = invRequest.getPrice();
        Float totalPrice = invRequest.getQuantity() * invRequest.getPrice();
        invRequest.setTotalPrice(totalPrice);
        row[4] = invRequest.getTotalPrice();
        dtm.addRow(row);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicejTable = new javax.swing.JTable();
        paymentStatusjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("CLINIC INVOICE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        invoicejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Price/Dose", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoicejTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, 120));

        paymentStatusjButton.setText("Send Invoice");
        paymentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentStatusjButtonActionPerformed(evt);
            }
        });
        add(paymentStatusjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void paymentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentStatusjButtonActionPerformed
        int selectedRow = invoicejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        InvoiceRequest invRequest = (InvoiceRequest)invoicejTable.getValueAt(selectedRow, 0);

        Person p = request.getSender().getPerson();
        Patient patient = (Patient)p;
//        if(patient.getInsuranceStatus() == "Not Insured")
    }//GEN-LAST:event_paymentStatusjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTable invoicejTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton paymentStatusjButton;
    // End of variables declaration//GEN-END:variables
}
