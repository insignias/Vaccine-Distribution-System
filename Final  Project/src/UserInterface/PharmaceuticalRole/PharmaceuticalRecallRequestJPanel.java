/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmaceuticalRole;

import UserInterface.HospitalRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.RecallRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class PharmaceuticalRecallRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private PharmaceuticalOrganization pharOrg;
    private UserAccount ua;
//    private PharmaceuticalEnterprise phEnterprise;
    public PharmaceuticalRecallRequestJPanel(JPanel upc, UserAccount ua, PharmaceuticalOrganization pharOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.pharOrg = pharOrg;
        this.ua = ua;
//        this.hospitalEnterprise = hospitalEnterprise;
        populatevaccineDistributionTable();
    }

    private void populatevaccineDistributionTable(){
        DefaultTableModel dtm = (DefaultTableModel)recalljTable.getModel();
        dtm.setRowCount(0);
        
        RecallRequest rr = null;
        for(WorkRequest wr : pharOrg.getWorkQueue().getWorkRequestList()){
            if(wr instanceof RecallRequest){
                rr = (RecallRequest)wr;
                Object[] row = new Object[8];
                row[0] = rr;
                row[1] = rr.getLotNumber();
                row[2] = rr.getQuantity();
                row[3] = rr.getMessage();
                row[4] = rr.getSender();
                row[5] = rr.getReceiver() == null ? null : rr.getReceiver();
                row[6] = rr.getStatus();
                row[7] = rr.getRecallResult();
                dtm.addRow(row);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recalljTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        recallRequestjButton = new javax.swing.JButton();
        assignjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHARMACEUTICAL RECALL REQUEST WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        recalljTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Lot Number", "Quantity", "Recall Reason", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recalljTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 580, 88));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        recallRequestjButton.setText("Recall Request");
        recallRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recallRequestjButtonActionPerformed(evt);
            }
        });
        add(recallRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = recalljTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)recalljTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(ua);
            request.setStatus("Pending");
            populatevaccineDistributionTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void recallRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recallRequestjButtonActionPerformed
        int selectedRow = recalljTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        RecallRequest request = (RecallRequest)recalljTable.getValueAt(selectedRow, 0);
        
       if(request.getReceiver()!=null){
           if(!request.getRecallResult().equals("Sent to Clinic")){
        RecallRequest recallRequest = new RecallRequest();
        for(WorkRequest wr : pharOrg.getWorkQueue().getWorkRequestList()){
            if(wr instanceof OrderRequest){
                OrderRequest or = (OrderRequest)wr;
                if(or.getRequestID() == request.getRequestID()){
                    request.setStatus("Complete");
                    request.setRecallResult("Sent to Clinic");
                    
                    recallRequest.setVaccineName(request.getVaccineName());
                    recallRequest.setLotNumber(request.getLotNumber());
                    recallRequest.setQuantity(request.getQuantity());
                    recallRequest.setMessage(request.getMessage());
                    recallRequest.setLocation(or.getLocation());
                    recallRequest.setEnterpriseType(or.getEnterpriseType());
                    recallRequest.setEnterpriseName(or.getEnterpriseName());
                    recallRequest.setSender(ua);
                    recallRequest.setStatus("Sent");
                    recallRequest.setRecallResult("Waiting");
                }
            }
        }
//        if(or!=null){
            Organization org = null;
            for(Network n : ecoSystem.getNetworkList()){
                boolean flag = false;
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(recallRequest.getLocation().equals(e.getLocation())){
                        System.out.println("e.getLocation(): " +e.getLocation());
                        System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                        if(e.getEnterpriseType().getValue().equals(recallRequest.getEnterpriseType())){
                            System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                            System.out.println("e.getName(): " +e.getName());
                            System.out.println("or.getEnterpriseName(): " +recallRequest.getEnterpriseName());
                            if(e.getName().equals(recallRequest.getEnterpriseName())){
                            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                System.out.println("organization: " +o.getName());
                                //if(e.getEnterpriseType().getValue() == "Hospital"){
                                if(o instanceof ClinicOrganization){
                                    System.out.println("instance of Clinic Organization");
                                    org = o;
                                    flag = true;
                                    break;
                                }
                              }
                            }
                        }
                    }
                    if(flag==true)
                    {
                        break;
                    }
                }
                if(org!=null){
                    org.getWorkQueue().getWorkRequestList().add(recallRequest);
                    ua.getWorkQueue().getWorkRequestList().add(recallRequest);
                    System.out.println("order request added to org");
                    populatevaccineDistributionTable();
                }

                JOptionPane.showMessageDialog(null, "Result submitted");
                return;
            }
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Result already submitted");
                return;
           }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Please assign a receiver");
                return;
       }
            
           
        
        
    }//GEN-LAST:event_recallRequestjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populatevaccineDistributionTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton recallRequestjButton;
    private javax.swing.JTable recalljTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
