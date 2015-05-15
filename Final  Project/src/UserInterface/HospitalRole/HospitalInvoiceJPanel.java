/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalRole;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalOrganization;
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
public class HospitalInvoiceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private HospitalOrganization hosOrg;
    private EcoSystem ecoSystem;
    private HospitalEnterprise hosEnt;
    public HospitalInvoiceJPanel(JPanel userProcessContainer, HospitalEnterprise hosEnt, UserAccount ua, HospitalOrganization hosOrg, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        this.hosOrg = hosOrg;
        this.ecoSystem = ecoSystem;
        this.hosEnt = hosEnt;
        
        populateInvoiceTable();
        populatePaymentTable();
    
    }

        private void populateInvoiceTable(){
            DefaultTableModel dtm = (DefaultTableModel)invoicejTable.getModel();
            dtm.setRowCount(0);
            
        InvoiceRequest invRequest = null;
        for(WorkRequest workRequest : hosOrg.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof InvoiceRequest){
                invRequest = (InvoiceRequest)workRequest;
                Object[] row = new Object[7];
                    row[0] = invRequest;
                    row[1] = invRequest.getRequestID();
                    row[2] = invRequest.getQuantity();
                    row[3] = invRequest.getPrice();
                    Float totalPrice = invRequest.getQuantity() * invRequest.getPrice();
                    invRequest.setTotalPrice(totalPrice);
                    row[4] = invRequest.getTotalPrice();
                    row[5] = invRequest.getSender().getPerson().getName();
                    row[6] = invRequest.getProcessDate();
                    
                    dtm.addRow(row);
                }
            }
        }
        
        private void populatePaymentTable(){
            DefaultTableModel dtm = (DefaultTableModel)paymentjTable.getModel();
            dtm.setRowCount(0);
            
        PaymentRequest paymentRequest = null;
        for(WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()){
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

        jLabel2 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        makePaymentjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentjTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoicejTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("HOSPITAL INVOICE");

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        makePaymentjButton.setText("Make Payment");
        makePaymentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentjButtonActionPerformed(evt);
            }
        });

        paymentjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(paymentjTable);

        invoicejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Price/Dose", "Total Price", "Manufacturer", "Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(invoicejTable);
        if (invoicejTable.getColumnModel().getColumnCount() > 0) {
            invoicejTable.getColumnModel().getColumn(6).setHeaderValue("Delivery Date");
        }

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel1.setText("OUTGOING PAYMENT:");

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("INCOMING PAYMENT:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addComponent(makePaymentjButton)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backjButton)
                            .addGap(18, 18, 18)
                            .addComponent(refreshjButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makePaymentjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(refreshjButton))
                .addContainerGap())
        );
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
        InvoiceRequest request = (InvoiceRequest)invoicejTable.getValueAt(selectedRow, 0);
        if(!request.getPaymentStatus().equals("Hospital Successful")){
        HospitalPaymentJPanel hpjp = new HospitalPaymentJPanel(userProcessContainer, request, hosEnt, ua, hosOrg, ecoSystem);
        userProcessContainer.add("HospitalPaymentJPanel",hpjp);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makePaymentjButton;
    private javax.swing.JTable paymentjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
