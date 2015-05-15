/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorWarehouseRole;

import Business.EcoSystem;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Organization.DistributorWarehouseOrganization;
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
public class DistributorWarehousePaymentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InvoiceRequest request;
    private DistributorWarehouseOrganization dwOrg;
    private EcoSystem ecoSystem;
    private UserAccount account;
    private DistributorWarehouseEnterprise dwEnt;
    public DistributorWarehousePaymentStatusJPanel(JPanel userProcessContainer, UserAccount account, InvoiceRequest request, DistributorWarehouseOrganization dwOrg, DistributorWarehouseEnterprise dwEnt, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.dwOrg = dwOrg;
        this.ecoSystem = ecoSystem;
        this.account = account;
        this.dwEnt = dwEnt;
        populatePaymentTable();
        populatePaymentToManufacturerTable();
        
    }

    private void populatePaymentTable(){
        DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
        dtm.setRowCount(0);
        
        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : dwOrg.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                paymentRequest = (PaymentRequest)workRequest;
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
    
    private void populatePaymentToManufacturerTable(){
            DefaultTableModel dtm = (DefaultTableModel)paymentToManufacturerjTable.getModel();
            dtm.setRowCount(0);
            
        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof PaymentRequest){
                paymentRequest = (PaymentRequest)workRequest;
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
        paymentToManufacturerjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("DISTRIBUTOR WAREHOUSE PAYMENT STATUS");

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

        makePaymentjButton.setText("Make Payment");
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

        paymentToManufacturerjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(paymentToManufacturerjTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("OUTGOING PAYMENT:");

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("INCOMING PAYMENT:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(makePaymentjButton)
                            .addGap(98, 98, 98)
                            .addComponent(refreshjButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(backJButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makePaymentjButton)
                    .addComponent(refreshjButton))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton1)
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void makePaymentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentjButtonActionPerformed
        int selectedRow = paymentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        PaymentRequest payRequest = (PaymentRequest)paymentjTable.getValueAt(selectedRow, 0);
        if(!payRequest.getPaymentStatus().equals("DW Successful")){
        DistributorWarehousePaymentJPanel dwpjp = new DistributorWarehousePaymentJPanel(userProcessContainer,payRequest, dwEnt,account,dwOrg, ecoSystem);
        userProcessContainer.add("DistributorWarehousePaymentJPanel",dwpjp);
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
        populatePaymentToManufacturerTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makePaymentjButton;
    private javax.swing.JTable paymentToManufacturerjTable;
    private javax.swing.JTable paymentjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
