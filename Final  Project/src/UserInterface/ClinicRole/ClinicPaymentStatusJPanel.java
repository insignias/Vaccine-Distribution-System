/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Organization.ClinicOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientRequest;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ClinicPaymentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    
    private ClinicOrganization clinicOrganization;
    
    private PatientRequest pr;
    public ClinicPaymentStatusJPanel(JPanel upc,PatientRequest pr, ClinicOrganization clinicOrganization) {
        initComponents();
        userProcessContainer = upc;
//        this.account = account;
//        this.clinicenterprise = clinicenterprise;
        this.clinicOrganization = clinicOrganization;
        this.pr = pr;
//        this.ecoSystem = ecoSystem;
        populatePaymentTable();
    }

    private void populatePaymentTable(){
        DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : clinicOrganization.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                PaymentRequest paymentRequest = (PaymentRequest)workRequest;
                if(pr.getRequestID()==paymentRequest.getRequestID()){
                    Object[] row = new Object[7];
                    row[0] = paymentRequest;
                    row[1] = paymentRequest.getRequestID();
                    row[2] = paymentRequest.getQuantity();
                    row[3] = paymentRequest.getTotalPrice();
                    row[4] = pr.getPatientName();
                    row[5] = paymentRequest.getProcessDate();
                    row[6] = paymentRequest.getPaymentStatus();
                    dtm.addRow(row);
                }
            }
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        paymentjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        paymentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Total Price", "Patient Name", "Payment Date", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(paymentjTable);

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC PAYMENT STATUS");

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(0, 127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable paymentjTable;
    // End of variables declaration//GEN-END:variables
}
