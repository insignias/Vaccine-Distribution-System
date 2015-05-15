/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderRole;

import Business.EcoSystem;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
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
public class PaymentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InvoiceRequest request;
    private ProviderOrganization providerOrg;
    private EcoSystem ecoSystem;
    private UserAccount account;
    private ProviderEnterprise provEnt;
    public PaymentStatusJPanel(JPanel userProcessContainer, UserAccount account, InvoiceRequest request, ProviderOrganization providerOrg, ProviderEnterprise provEnt, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.providerOrg = providerOrg;
        this.ecoSystem = ecoSystem;
        this.account = account;
        this.provEnt = provEnt;
        populatePaymentTable();
        populatePaymentToDWTable();
    }

    private void populatePaymentTable(){
        DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
        dtm.setRowCount(0);
        
//        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : providerOrg.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                PaymentRequest paymentRequest = (PaymentRequest)workRequest;
                if(paymentRequest.getRequestID() == request.getRequestID()){
                    Object[] row = new Object[6];
                    row[0] = paymentRequest;
                    row[1] = paymentRequest.getRequestID();
                    row[2] = paymentRequest.getQuantity();
                    row[3] = paymentRequest.getTotalPrice();
                    row[4] = request.getSender().getPerson().getName();
                    row[5] = paymentRequest.getPaymentStatus() == null ? "Not Received" : paymentRequest.getPaymentStatus();
                    dtm.addRow(row);
                    
                }
            }
        }
        
    }
    
    private void populatePaymentToDWTable(){
            DefaultTableModel dtm = (DefaultTableModel)paymentToDWjTable.getModel();
            dtm.setRowCount(0);
            
//        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                PaymentRequest paymentRequest = (PaymentRequest)workRequest;
                Object[] row = new Object[7];
                    row[0] = paymentRequest;
                    row[1] = paymentRequest.getRequestID();
                    row[2] = paymentRequest.getQuantity();
                    row[3] = paymentRequest.getTotalPrice();
                    row[4] = paymentRequest.getSender().getPerson().getName();
                    row[5] = paymentRequest.getProcessDate();
                    row[6] = paymentRequest.getPaymentStatus();
                    dtm.addRow(row);
                }
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentjTable = new javax.swing.JTable();
        makePaymentjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        paymentToDWjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PROVIDER PAYMENT STATUS");

        paymentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Total Price", "Manufacturer", "Payment Status"
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

        makePaymentjButton.setText("Make Payment >>");
        makePaymentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentjButtonActionPerformed(evt);
            }
        });

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        paymentToDWjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Total Price", "Manufacturer", "Payment Date", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(paymentToDWjTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makePaymentjButton)
                                .addGap(47, 47, 47)
                                .addComponent(refreshjButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makePaymentjButton)
                    .addComponent(refreshjButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void makePaymentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentjButtonActionPerformed
        int selectedRow = paymentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        PaymentRequest payRequest = (PaymentRequest)paymentjTable.getValueAt(selectedRow, 0);
        if(!payRequest.getPaymentStatus().equals("Provider Successful")){
        ProviderPaymentJPanel ppjp = new ProviderPaymentJPanel(userProcessContainer,payRequest, provEnt,account,providerOrg, ecoSystem);
        userProcessContainer.add("ProviderPaymentJPanel",ppjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Payment already made");
        }
    }//GEN-LAST:event_makePaymentjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populatePaymentTable();
        populatePaymentToDWTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makePaymentjButton;
    private javax.swing.JTable paymentToDWjTable;
    private javax.swing.JTable paymentjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
