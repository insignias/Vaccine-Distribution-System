/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import UserInterface.HospitalRole.*;
import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.HospitalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManagePatientOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ClinicOrganization clinicOrg;
    private UserAccount ua; 
    private ClinicEnterprise clinicEnterprise;
    public ManagePatientOrderRequestJPanel(JPanel upc, UserAccount ua, ClinicEnterprise clinicEnterprise,  ClinicOrganization clinicOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.clinicOrg = clinicOrg;
        this.ua = ua;
        this.clinicEnterprise = clinicEnterprise;
        populateReceivedRequestTable();
        populateSentRequestTable();
    }

    private void populateReceivedRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest or = null;
//        HospitalEnterprise hosEnt = null;
        for(WorkRequest request : clinicOrg.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
              OrderRequest or = (OrderRequest)request; 
//            }
//            
//            if(or!=null){
                
                //for(Network network : ecoSystem.getNetworkList()){
                    //for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                       // if(e instanceof HospitalEnterprise){
                         //   hosEnt = (HospitalEnterprise)e;
                            //for(ClinicEnterprise clinicEnt : hosEnt.getClinicEnterpriseList()){
                              //  System.out.println("or.getEnterpriseName(): " +or.getEnterpriseName());
                              //  System.out.println("clinicEnt.getName(): " +clinicEnt.getName());
                                //if(or.getEnterpriseName().equals(clinicEnt.getName())){
                                Object[] row = new Object[4];
                                row[0] = or;
                                row[1] = or.getQuantity();
                                row[2] = or.getSender().getPerson().getName();
                                row[3] = or.getReceiver() == null ? null : or.getReceiver().getPerson().getName();
                                dtm.addRow(row);
                         }
                   // }
                //}
           // }
        //}
    }
}
    
        private void populateSentRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)providerOrderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest por = null;
        for(WorkRequest request : ua.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
            OrderRequest  por = (OrderRequest)request; 
//            }
//        }
//            if(por!=null){
            Object[] row = new Object[5];
            row[0] = por;
            row[1] = por.getQuantity();
            row[2] = por.getSender().getPerson().getName();
            row[3] = por.getStatus();
            row[4] = por.getOrderResult() == null ? "Waiting" : por.getOrderResult();
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
        orderRequestjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel1.setText("CLINIC ORDER REQUEST WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 15, -1, -1));

        providerOrderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(providerOrderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 294, 610, 99));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        orderRequestjButton.setText("Order Request");
        orderRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderRequestjButtonActionPerformed(evt);
            }
        });
        add(orderRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestID", "Patient Name", "Vaccine Name", "Quantity", "Total Price", "Sender", "Insurance Info", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderRequestjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 610, 99));

        jLabel2.setText("Order Request ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Sent Invoice Request");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 260, -1, -1));
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
            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void orderRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderRequestjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
                    OrderRequest request = (OrderRequest)orderRequestjTable.getValueAt(selectedRow, 0);
                    ClinicInvoiceJPanel cijp = new ClinicInvoiceJPanel(userProcessContainer, request, clinicEnterprise, clinicOrg, ua , ecoSystem);
                    userProcessContainer.add("ClinicInvoiceJPanel", cijp);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    
    }//GEN-LAST:event_orderRequestjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateReceivedRequestTable();
        populateSentRequestTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderRequestjButton;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JTable providerOrderRequestjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
