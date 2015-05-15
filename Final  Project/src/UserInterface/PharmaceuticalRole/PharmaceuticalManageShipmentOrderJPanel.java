/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmaceuticalRole;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
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
public class PharmaceuticalManageShipmentOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private PharmaceuticalEnterprise pharmaEnterprise;
    private PharmaceuticalOrganization pharmaOrganization;
    private EcoSystem ecoSystem;
    public PharmaceuticalManageShipmentOrderJPanel(JPanel upc, UserAccount account, PharmaceuticalEnterprise pharmaEnterprise, PharmaceuticalOrganization pharmaOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.pharmaEnterprise = pharmaEnterprise;
        this.pharmaOrganization = pharmaOrganization;
        this.ecoSystem = ecoSystem;
        populateShipmentTable();
        populateShipmentToClinicTable();
    }

    private void populateShipmentTable(){
        DefaultTableModel dtm = (DefaultTableModel)shipmentjTable.getModel();
        dtm.setRowCount(0);
//        ShippingRequest sr = null;
        
            for(WorkRequest request : pharmaOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
              ShippingRequest sr = (ShippingRequest)request;
//              break;
//            }
//          }
//        
//              if(sr!=null){  
              Object[] row = new Object[6];
                row[0] = sr;
                row[1] = sr.getQuantity();
                row[2] = sr.getSender().getPerson().getName();
                row[3] = sr.getReceiver() == null ? null : sr.getReceiver().getPerson().getName();
                row[4] = sr.getStatus();
                row[5] = sr.getOrderResult();
                dtm.addRow(row);
              }
        
            } 
        }
    
    private void populateShipmentToClinicTable(){
        DefaultTableModel dtm = (DefaultTableModel)shipmentToClinicTable.getModel();
        dtm.setRowCount(0);
//        ShippingRequest sr = null;
        
            for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
              ShippingRequest sr = (ShippingRequest)request;
//              break;
//            }
//          }
//        
//              if(sr!=null){  
              Object[] row = new Object[6];
                row[0] = sr;
                row[1] = sr.getQuantity();
                row[2] = sr.getProcessDate();
                row[3] = sr.getSender().getPerson().getName();
                row[4] = sr.getStatus();
                row[5] = sr.getOrderResult() == null ? "Waiting" : sr.getOrderResult();
                dtm.addRow(row);
              }
        
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        shipmentjTable = new javax.swing.JTable();
        assignjButton = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        shipmentToClinicTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shipmentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shipmentjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 104, 480, 86));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 208, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        backJButton1.setText("Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 381, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel1.setText("INCOMING SHIPMENT:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PHARMACEUTICAL MANAGE SHIPMENT ORDER");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("OUTGOING SHIPMENT:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 249, -1, -1));

        shipmentToClinicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Shipping Date", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(shipmentToClinicTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 283, 480, 86));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = shipmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)shipmentjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(account);
            request.setStatus("Pending");
            populateShipmentTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateShipmentTable();
        populateShipmentToClinicTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = shipmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ShippingRequest request = (ShippingRequest)shipmentjTable.getValueAt(selectedRow, 0);

        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(account.getPerson().getName())){
                if(!request.getOrderResult().equals("Received")){
                    request.setStatus("Processing");
                    PharmaceuticalProcessShipmentRequestJPanel dwpsrjp = new PharmaceuticalProcessShipmentRequestJPanel(userProcessContainer, account, pharmaEnterprise, pharmaOrganization, request, ecoSystem);
                    userProcessContainer.add("DistributorWarehouseManageShipmentOrderJPanel", dwpsrjp);
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
            return;
        }
    }//GEN-LAST:event_processjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTable shipmentToClinicTable;
    private javax.swing.JTable shipmentjTable;
    // End of variables declaration//GEN-END:variables
}
