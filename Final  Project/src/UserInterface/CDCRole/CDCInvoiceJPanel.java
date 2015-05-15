/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDCRole;

import UserInterface.InsuranceRole.*;
import UserInterface.HospitalRole.*;
import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.Organization.CDCOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.InsuranceOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
import Business.WorkQueue.PatientRequest;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class CDCInvoiceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private CDCEnterprise cdcEnterprise;
    private UserAccount account;
    private CDCOrganization cdcOrganization;
    public CDCInvoiceJPanel(JPanel userProcessContainer, UserAccount account, CDCEnterprise cdcEnterprise, CDCOrganization cdcOrganization, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.cdcEnterprise = cdcEnterprise;
        this.ecoSystem = ecoSystem;
        this.cdcOrganization = cdcOrganization;
        
        populateInvoiceTable();
        populatePaymentTable();
    
    }

        private void populateInvoiceTable(){
            DefaultTableModel dtm = (DefaultTableModel)invoicejTable.getModel();
            dtm.setRowCount(0);
            
//        InvoiceRequest invRequest = null;
        for(WorkRequest workRequest : cdcOrganization.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PatientRequest){
                PatientRequest patientRequest = (PatientRequest)workRequest;
                Object[] row = new Object[6];
                    row[0] = patientRequest;
                    row[1] = patientRequest.getVaccineName();
                    row[2] = patientRequest.getRequestID();
                    row[3] = patientRequest.getQuantity();
                    row[4] = patientRequest.getTotalPrice();
                    row[5] = patientRequest.getOrderDate();
                    
                    dtm.addRow(row);
                }
            }
        }
        
        private void populatePaymentTable(){
            DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
            dtm.setRowCount(0);
            
//        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                PaymentRequest paymentRequest = (PaymentRequest)workRequest;
                Object[] row = new Object[6];
                    row[0] = paymentRequest;
                    row[1] = paymentRequest.getRequestID();
                    row[2] = paymentRequest.getQuantity();
                    row[3] = paymentRequest.getTotalPrice();
                    row[4] = paymentRequest.getProcessDate();
                    row[5] = paymentRequest.getPaymentStatus();
                    dtm.addRow(row);
                }
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        makePaymentjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentjTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoicejTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("CDC INVOICE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 15, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        makePaymentjButton.setText("Make Payment");
        makePaymentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentjButtonActionPerformed(evt);
            }
        });
        add(makePaymentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        paymentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Total Price", "Payment Date", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(paymentjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 481, 92));

        invoicejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Vaccine Name", "Request ID", "Quantity", "Total Price", "Order Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(invoicejTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 481, 92));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void makePaymentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentjButtonActionPerformed
        int selectedRow = invoicejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        PatientRequest request = (PatientRequest)invoicejTable.getValueAt(selectedRow, 0);
        if(!request.getPaymentStatus().equals("Successful")){
        CDCPaymentJPanel cdcpjp = new CDCPaymentJPanel(userProcessContainer, request, cdcEnterprise, account, cdcOrganization, ecoSystem);
        userProcessContainer.add("CDCPaymentJPanel",cdcpjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Payment already made");
        }
    }//GEN-LAST:event_makePaymentjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateInvoiceTable();
        populatePaymentTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTable invoicejTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makePaymentjButton;
    private javax.swing.JTable paymentjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
