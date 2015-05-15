/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
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
public class ShipmentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    public ShipmentStatusJPanel(JPanel upc,UserAccount account, Enterprise enterprise, ClinicOrganization clinicOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.ecoSystem = ecoSystem;
        this.enterprise = enterprise;
        this.clinicOrganization = clinicOrganization;
        populateShipmentTable();
    }

    private void populateShipmentTable(){
        DefaultTableModel dtm = (DefaultTableModel)shipmentStatusjTable.getModel();
        dtm.setRowCount(0);
        ShippingRequest shipReq = null;
        for(WorkRequest request : clinicOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof ShippingRequest){
                shipReq = (ShippingRequest)request;
                Object[] row = new Object[7];
                row[0] = shipReq;
                row[1] = shipReq.getQuantity();
                row[2] = shipReq.getSender().getPerson().getName();
                row[3] = shipReq.getStatus();
                row[4] = shipReq.getProcessDate();
                row[5] = shipReq.getOrderResult() == null ? "Waiting" : shipReq.getOrderResult();
                row[6] = shipReq.getReceiver();
                dtm.addRow(row);
            }
        }
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        shipmentStatusjTable = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        assignjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shipmentStatusjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Status", "Shipment Date", "Result", "Receiver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shipmentStatusjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 90));

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC SHIPMENT STATUS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateShipmentTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = shipmentStatusjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ShippingRequest request = (ShippingRequest)shipmentStatusjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver()!=null){
        if(!request.getOrderResult().equals("Received")){
        ClinicProcessShipmentJPanel cpsjp = new ClinicProcessShipmentJPanel(userProcessContainer, account, request, enterprise, clinicOrganization, ecoSystem);
        userProcessContainer.add("ClinicProcessShipmentJPanel",cpsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request has already beend processed");
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please assign a receiver");
            
        }
        
    }//GEN-LAST:event_processjButtonActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = shipmentStatusjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)shipmentStatusjTable.getValueAt(selectedRow, 0);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTable shipmentStatusjTable;
    // End of variables declaration//GEN-END:variables
}
