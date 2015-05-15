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
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ShippingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManageManufacturerOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ManufacturerOrganization manOrg;
    private UserAccount ua; 
    private ManufacturerEnterprise manEnt;
    public ManageManufacturerOrderRequestJPanel(JPanel upc, ManufacturerEnterprise manEnt, UserAccount ua, ManufacturerOrganization manOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.manOrg = manOrg;
        this.ua = ua;
        this.manEnt = manEnt;
        
        populateReceivedRequestTable();
        populateSentRequestTable();
    }

    private void populateReceivedRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest or = null;
        for(WorkRequest request : manOrg.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
            OrderRequest or = (OrderRequest)request; 
            Object[] row = new Object[7];
            row[0] = or;
            row[1] = or.getRequestID();
            row[2] = or.getQuantity();
            row[3] = or.getSender().getPerson().getName();
            row[4] = or.getReceiver() == null ? null : or.getReceiver().getPerson().getName();
            row[5] = or.getStatus();
            row[6] = or.getOrderResult() == null ? "Waiting" : or.getOrderResult();
            dtm.addRow(row);
             
        }
    }
}
    
        private void populateSentRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)providerOrderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest por = null;
        for(WorkRequest request : ua.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
                ShippingRequest por = (ShippingRequest)request; 
                Object[] row = new Object[6];
                row[0] = por;
                row[1] = por.getRequestID();
                row[2] = por.getQuantity();
                row[3] = por.getSender().getPerson().getName();
                row[4] = por.getStatus();
                row[5] = por.getOrderResult() == null ? "Waiting" : por.getOrderResult();
                dtm.addRow(row);
             
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        providerOrderRequestjTable = new javax.swing.JTable();
        assignjButton = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        paymentStatusjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 400, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER MANAGE ORDER REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        providerOrderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(providerOrderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 283, 432, 99));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 202, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 202, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 202, -1, -1));

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderRequestjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 432, 99));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("INCOMING ORDER REQUEST:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("OUTGOING SHIPMENT:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 249, -1, -1));

        paymentStatusjButton.setText("Payment Status");
        paymentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentStatusjButtonActionPerformed(evt);
            }
        });
        add(paymentStatusjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)orderRequestjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(ua);
            request.setStatus("Pending");
            populateReceivedRequestTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
//            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        OrderRequest request = (OrderRequest)orderRequestjTable.getValueAt(selectedRow, 0);

        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(ua.getPerson().getName())){
                if(!request.getOrderResult().equals("Shipped to Distributor")){
                    request.setStatus("Processing");
                    ProcessManufacturerOrderRequestJPanel pmorjp = new ProcessManufacturerOrderRequestJPanel(userProcessContainer, ua, manEnt, manOrg, request, ecoSystem);
                    userProcessContainer.add("ProcessManufacturerOrderRequestJPanel", pmorjp);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result has already been submitted");
                    return;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Request is assigned to : " +request.getReceiver() );
                return;
            }
        }
        if(request.getReceiver() == null){
            JOptionPane.showMessageDialog(null, "Please assign a receiver ");
            //return;
        }
    }//GEN-LAST:event_processjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateReceivedRequestTable();
        populateSentRequestTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void paymentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentStatusjButtonActionPerformed
        int selectedRow = providerOrderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ShippingRequest request = (ShippingRequest)providerOrderRequestjTable.getValueAt(selectedRow, 0);
        ManufacturerPaymentStatusJPanel mpsjp = new ManufacturerPaymentStatusJPanel(userProcessContainer, ua, request, manOrg, manEnt,  ecoSystem);
        userProcessContainer.add("ManufacturerPaymentStatusJPanel",mpsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_paymentStatusjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JButton paymentStatusjButton;
    private javax.swing.JButton processjButton;
    private javax.swing.JTable providerOrderRequestjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
