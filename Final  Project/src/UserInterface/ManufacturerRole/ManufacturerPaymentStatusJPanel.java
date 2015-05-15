/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManufacturerRole;

import Business.EcoSystem;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.ManufacturerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.ShippingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManufacturerPaymentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ShippingRequest request;
    private ManufacturerOrganization manOrg;
    private EcoSystem ecoSystem;
    private UserAccount account;
    private ManufacturerEnterprise manEnt;
    public ManufacturerPaymentStatusJPanel(JPanel userProcessContainer, UserAccount account, ShippingRequest request, ManufacturerOrganization manOrg, ManufacturerEnterprise manEnt, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.manOrg = manOrg;
        this.ecoSystem = ecoSystem;
        this.account = account;
        this.manEnt = manEnt;
        populatePaymentTable();
    }

    private void populatePaymentTable(){
        DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
        dtm.setRowCount(0);
        
        
        for(WorkRequest workRequest : manOrg.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                PaymentRequest paymentRequest = (PaymentRequest)workRequest;
                if(paymentRequest.getRequestID() == request.getRequestID()){
                    Object[] row = new Object[6];
                    row[0] = paymentRequest;
                    row[1] = paymentRequest.getRequestID();
                    row[2] = paymentRequest.getQuantity();
                    row[3] = paymentRequest.getTotalPrice();
                    row[4] = paymentRequest.getProcessDate();
                    row[5] = paymentRequest.getPaymentStatus() == null ? "Not Received" : paymentRequest.getPaymentStatus();
                    dtm.addRow(row);
                    
                }
            }
        }
        
    }
    
//    private void populatePaymentToDWTable(){
//            DefaultTableModel dtm = (DefaultTableModel)paymentToDWjTable.getModel();
//            dtm.setRowCount(0);
//            
//        PaymentRequest paymentRequest = null;
//        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
//            if(workRequest instanceof PaymentRequest){
//                paymentRequest = (PaymentRequest)workRequest;
//                Object[] row = new Object[6];
//                    row[0] = paymentRequest;
//                    row[1] = paymentRequest.getRequestID();
//                    row[2] = paymentRequest.getQuantity();
//                    row[3] = paymentRequest.getTotalPrice();
//                    row[4] = paymentRequest.getSender().getPerson().getName();
//                    row[5] = paymentRequest.getProcessDate();
//                    row[6] = paymentRequest.getPaymentStatus();
//                    dtm.addRow(row);
//                }
//            }
//        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentjTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER PAYMENT STATUS");

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

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("RECEIVED PAYMENTS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable paymentjTable;
    // End of variables declaration//GEN-END:variables
}
