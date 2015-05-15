/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorWarehouseRole;

import Business.EcoSystem;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Organization.DistributorWarehouseOrganization;
import Business.Person.DistributorWarehouseAdmin;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
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
public class DistributorWarehouseManageShipmentOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private DistributorWarehouseEnterprise dwEnterprise;
    private DistributorWarehouseOrganization dwOrganization;
    private EcoSystem ecoSystem;
    
    public DistributorWarehouseManageShipmentOrderJPanel(JPanel upc, UserAccount account, DistributorWarehouseEnterprise dwEnterprise, DistributorWarehouseOrganization dwOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.dwEnterprise = dwEnterprise;
        this.dwOrganization = dwOrganization;
        this.ecoSystem = ecoSystem;
        populateShipmentTable();
        populateShipmentToOrgTable();
        
        
    }

    private void populateShipmentTable(){
        DefaultTableModel dtm = (DefaultTableModel)shipmentjTable.getModel();
        dtm.setRowCount(0);
//        ShippingRequest sr = null;
        
            for(WorkRequest request : dwOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
              ShippingRequest sr = (ShippingRequest)request;
             
              Object[] row = new Object[7];
                row[0] = sr;
                row[1] = sr.getQuantity();
                row[2] = sr.getPrice();
                row[3] = sr.getSender().getPerson().getName();
                row[4] = sr.getReceiver() == null ? null : sr.getReceiver().getPerson().getName();
                row[5] = sr.getStatus();
                row[6] = sr.getOrderResult() == null ? "Waiting" : sr.getOrderResult();
                dtm.addRow(row);
              }
            }
            
        }
    
    private void populateShipmentToOrgTable(){
        DefaultTableModel dtm = (DefaultTableModel)shipmentToOrgjTable.getModel();
        dtm.setRowCount(0);
//        ShippingRequest sr = null;
        
            for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
              ShippingRequest sr = (ShippingRequest)request;
              
              Object[] row = new Object[7];
                row[0] = sr;
                row[1] = sr.getQuantity();
                row[2] = sr.getPrice();
                row[3] = sr.getProcessDate();
                row[4] = sr.getSender().getPerson().getName();
                row[5] = sr.getStatus();
                row[6] = sr.getOrderResult() == null ? "Waiting" : sr.getOrderResult();
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
        shipmentToOrgjTable = new javax.swing.JTable();
        generateInvoicejButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shipmentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Price", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shipmentjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 503, 86));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 189, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 362, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 189, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("DISTRIBUTOR WAREHOUSE MANAGE SHIPMENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("INCOMING SHIPMENT:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("OUTGOING SHIPMENT:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 236, -1, -1));

        shipmentToOrgjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Price", "Shipping Date", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(shipmentToOrgjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 270, 503, 86));

        generateInvoicejButton.setText("Generate Invoice");
        generateInvoicejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateInvoicejButtonActionPerformed(evt);
            }
        });
        add(generateInvoicejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 189, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
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
        populateShipmentToOrgTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = shipmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ShippingRequest request = (ShippingRequest)shipmentjTable.getValueAt(selectedRow, 0);

        DistributorWarehouseAdmin dw = (DistributorWarehouseAdmin)account.getPerson();
        Vaccine v = dw.getVaccineCatalog().addVaccine();
        v.setVaccineName(request.getVaccineName());
        v.setQuantity(request.getQuantity());
        v.setDateManufactured(request.getManufactureDate());
        v.setExpiryDate(request.getExpiryDate());
        v.setManufacturer(request.getManufacturer());
        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(account.getPerson().getName())){
                if(!request.getOrderResult().equals("Received")){
                    request.setStatus("Processing");
                    DistributorWarehouseProcessShipmentRequestJPanel dwpsrjp = new DistributorWarehouseProcessShipmentRequestJPanel(userProcessContainer, account, dwEnterprise, dwOrganization, request, ecoSystem);
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

    private void generateInvoicejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateInvoicejButtonActionPerformed
        int selectedRow = shipmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        
        ShippingRequest shipRequest = (ShippingRequest)shipmentjTable.getValueAt(selectedRow, 0);
        InvoiceRequest invRequest = null;
        for(WorkRequest workRequest : dwOrganization.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof InvoiceRequest){
                invRequest = (InvoiceRequest)workRequest;
                if(invRequest.getRequestID() == shipRequest.getRequestID())
                    if(shipRequest.getOrderResult()=="Received"){
                    DistributorWarehouseInvoiceJPanel dwijp = new DistributorWarehouseInvoiceJPanel(userProcessContainer, account, invRequest, dwEnterprise, dwOrganization, ecoSystem);
                    userProcessContainer.add("DistributorWarehouseInvoiceJPanel", dwijp);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Order not received yet");
                return;
            }
            }
        }
    }//GEN-LAST:event_generateInvoicejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton generateInvoicejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTable shipmentToOrgjTable;
    private javax.swing.JTable shipmentjTable;
    // End of variables declaration//GEN-END:variables
}
